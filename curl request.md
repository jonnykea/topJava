Запросы для MealRestController:

- GET:
1. GET all meals - curl --location 'http://localhost:8080/topjava/rest/meals'
2. GET meal - curl --location 'http://localhost:8080/topjava/rest/meals/100006'
3. GET meals with filter - curl --location 'http://localhost:8080/topjava/rest/meals/filter?startDateTime=2020-01-30T10%3A00%3A00&endDateTime=2020-01-30T21%3A00%3A00'
4. GET meals with filter (nullable) - curl --location 'http://localhost:8080/topjava/rest/meals/filter?startDate=2020-01-30&endDate=2020-01-30'

- PUT:
1. UPDATE meal - curl --location --request PUT 'http://localhost:8080/topjava/rest/meals/100009' \
   --header 'Content-Type: application/json' \
   --data '{
   "id": 100009,
   "dateTime": "2020-01-31T20:00:00",
   "description": "Ужин",
   "calories": 2000
   }'

- POST:
1. SAVE meal - curl --location 'http://localhost:8080/topjava/rest/meals' \
   --header 'Content-Type: application/json' \
   --data '  {
   "id": null,
   "dateTime": "2022-01-30T10:00:00",
   "description": "Ужин",
   "calories": 5000
   }'

- DELETE:
1. DELETE meal - curl --location --request DELETE 'http://localhost:8080/topjava/rest/meals/100009'