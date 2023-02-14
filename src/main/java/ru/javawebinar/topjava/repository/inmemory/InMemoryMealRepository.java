package ru.javawebinar.topjava.repository.inmemory;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryMealRepository implements MealRepository {
    private final Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.meals.forEach(m -> this.save(1, m));
    }

    @Override
    public Meal save(int userId, Meal meal) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
            repository.computeIfAbsent(userId, HashMap::new).put(meal.getId(), meal);
            return meal;
        }
        Map<Integer, Meal> meals;
        if ((meals = repository.get(userId)) != null) {
            // handle case: update, but not present in storage
            return meals.computeIfPresent(meal.getId(), (id, oldMeal) -> meal);
        }
        return null;
    }

    @Override
    public boolean delete(int userId, int id) {
        Map<Integer, Meal> meals;
        if ((meals = repository.get(userId)) != null) {
            return meals.remove(id) != null;
        }
        throw new NotFoundException("Not found entity with " + userId);
    }

    @Override
    public Meal get(int userId, int id) {
        if (repository.containsKey(userId)) {
            Map<Integer, Meal> meals = repository.get(userId);
            return meals.get(id);
        } else {
            return null;
        }
    }

    @Override
    public Collection<Meal> getAll(int userId) {
        if (repository.containsKey(userId)) {
            return new ArrayList<>(repository.get(userId).values()).stream()
                    .sorted(Comparator.comparing(Meal::getDate).reversed())
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<Meal> getFilteredByDates(int userId, LocalDateTime startTime, LocalDateTime endTime) {
        return new ArrayList<>(repository.get(userId).values()).stream()
                .filter(meal -> DateTimeUtil.isBetweenHalfOpen(meal.getDateTime(), startTime, endTime))
                .sorted(Comparator.comparing(Meal::getDate).reversed())
                .collect(Collectors.toList());
    }
}