package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int MEAL_ID = START_SEQ + 4;
    public static final int NOT_FOUND = 5;

    public static final Meal userMeal1 = new Meal(START_SEQ + 3, LocalDateTime.of(2023, 2, 15, 11, 0), "Предыдущий день", 2100);
    public static final Meal userMeal2 = new Meal(MEAL_ID, LocalDateTime.of(2023, 2, 16, 10, 0), "Завтрак", 500);
    public static final Meal userMeal3 = new Meal(START_SEQ + 5, LocalDateTime.of(2023, 2, 16, 13, 0), "Обед", 1000);
    public static final Meal userMeal4 = new Meal(START_SEQ + 6, LocalDateTime.of(2023, 2, 17, 20, 0), "Ужин", 500);
    public static final Meal userMeal5 = new Meal(START_SEQ + 7, LocalDateTime.of(2023, 2, 17, 23, 59), "Еда на граничное значение", 100);
    public static final Meal userMeal6 = new Meal(START_SEQ + 8, LocalDateTime.of(2023, 2, 18, 10, 0), "Завтрак", 1000);
    public static final Meal userMeal7 = new Meal(START_SEQ + 9, LocalDateTime.of(2023, 2, 18, 13, 0), "Обед", 500);
    public static final Meal userMeal8 = new Meal(START_SEQ + 10, LocalDateTime.of(2023, 2, 18, 20, 0), "Ужин", 410);
    public static final Meal userMeal9 = new Meal(START_SEQ + 11, LocalDateTime.of(2023, 2, 19, 20, 0), "Следующий день", 699);

    public static final Meal adminMeal1 = new Meal(START_SEQ + 12, LocalDateTime.of(2023, 2, 17, 9, 35), "Плотный завтрак", 900);
    public static final Meal adminMeal2 = new Meal(START_SEQ + 13, LocalDateTime.of(2023, 2, 17, 10, 0), "Перекус", 120);
    public static final Meal adminMeal3 = new Meal(START_SEQ + 14, LocalDateTime.of(2023, 2, 17, 13, 30), "Обед", 600);
    public static final Meal adminMeal4 = new Meal(START_SEQ + 15, LocalDateTime.of(2023, 2, 17, 19, 0), "Ужин в ресторане", 1200);

    public static final Meal[] mealsForUser = {userMeal9, userMeal8, userMeal7, userMeal6, userMeal5, userMeal4, userMeal3, userMeal2, userMeal1};
    public static final Meal[] mealsForUserFrom17To18 = {userMeal8, userMeal7, userMeal6, userMeal5, userMeal4};

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2023, 2, 21, 9, 35), "Новое описание", 1500);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(userMeal2);
        updated.setDescription("Макароны");
        updated.setCalories(350);
        updated.setDateTime(LocalDateTime.of(2023, 2, 15, 0, 0));
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields().isEqualTo(expected);
    }
}