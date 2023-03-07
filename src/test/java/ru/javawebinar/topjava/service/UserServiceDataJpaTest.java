package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.User;

import static ru.javawebinar.topjava.MealTestData.MEAL_MATCHER;
import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles("datajpa")
public class UserServiceDataJpaTest extends AbstractUserServiceTest {

    @Test
    public void getWithMealsQuery() {
        User newUser = service.getWithMeals(USER_ID);
        USER_MATCHER.assertMatch(newUser, user);
        MEAL_MATCHER.assertMatch(newUser.getMeals(), MealTestData.meals);
    }
}