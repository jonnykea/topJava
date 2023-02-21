DELETE
FROM user_role;
DELETE
FROM users;
DELETE
FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin'),
       ('Guest', 'guest@gmail.com', 'guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001);

INSERT INTO meals (date_time, description, calories, user_id)
VALUES ('2023-02-15 11:00', 'Предыдущий день', 2100, 100000),
       ('2023-02-16 10:00', 'Завтрак', 500, 100000),
       ('2023-02-16 13:00', 'Обед', 1000, 100000),
       ('2023-02-17 20:00', 'Ужин', 500, 100000),
       ('2023-02-17 00:00', 'Еда на граничное значение', 100, 100000),
       ('2023-02-18 10:00', 'Завтрак', 1000, 100000),
       ('2023-02-18 13:00', 'Обед', 500, 100000),
       ('2023-02-18 20:00', 'Ужин', 410, 100000),
       ('2023-02-19 20:00', 'Следующий день', 699, 100000),
       ('2023-02-17 9:35', 'Плотный завтрак', 900, 100001),
       ('2023-02-17 10:00', 'Перекус', 120, 100001),
       ('2023-02-17 13:30', 'Обед', 600, 100001),
       ('2023-02-17 19:00', 'Ужин в ресторане', 1200, 100001);

