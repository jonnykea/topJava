package ru.javawebinar.topjava.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                MealServiceJdbcTest.class,
                MealServiceJpaTest.class,
                MealServiceDataJpaTest.class,
                UserServiceJdbcTest.class,
                UserServiceJpaTest.class,
                UserServiceDataJpaTest.class
        })
public class AllServiceTest {
}