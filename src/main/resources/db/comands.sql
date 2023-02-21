SELECT *
FROM meals
WHERE user_id = 100000
ORDER BY date_time DESC;
SELECT *
FROM meals
WHERE user_id = 100000
  AND date_time >= '2023-02-17'
  AND date_time < '2023-02-19'
ORDER BY date_time DESC;