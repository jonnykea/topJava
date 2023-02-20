package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.UserTestData.*;

public class MealTestData {

    public static final Meal MEAL_USER = new Meal(USER_ID, LocalDateTime.of(2023, Month.FEBRUARY, 18, 0, 0, 0, 0), "dinner", 1000);
    public static final Meal MEAL_ADMIN = new Meal(ADMIN_ID, LocalDateTime.of(2023, Month.FEBRUARY, 19, 0, 0, 0, 0), "lunch", 500);
    public static final Meal MEAL_GUEST = new Meal(GUEST_ID, LocalDateTime.of(2023, Month.FEBRUARY, 20, 0, 0, 0, 0), "breakfast", 1500);

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.now(), "supper", 900);
    }

    public static User getUpdated() {
        User updated = new User(user);
        updated.setEmail("update@gmail.com");
        updated.setName("UpdatedName");
        updated.setCaloriesPerDay(330);
        updated.setPassword("newPass");
        updated.setEnabled(false);
        updated.setRoles(Collections.singletonList(Role.ADMIN));
        return updated;
    }

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("registered", "roles").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("registered", "roles").isEqualTo(expected);
    }

}
