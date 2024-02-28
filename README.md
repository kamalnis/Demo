# Go to demo1 using: cd demo1
# run using command: ./mvnw spring-boot:run
# API's are as follows:

1. Create user
   
curl --location --request POST '127.0.0.1:8080/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Nishant Kamal"
}'

2. Get User:
    curl --location --request GET '127.0.0.1:8080/user/722478133'

3: Create Budget:

   curl --location --request POST '127.0.0.1:8080/budget' \
--header 'Content-Type: application/json' \
--data-raw '{
    "budgetAmount": 5000,
    "users" : [123,124],

    "startDate": "2024-01-01",
    "endDate": "2024-01-30"
}'

4. Get Budget using userId:

    curl --location --request GET '127.0.0.1:8080/user/budget/123'

5. Get Budget using budgetId:
    curl --location --request GET '127.0.0.1:8080/budget/123'

6. Add transaction:
      curl --location --request POST '127.0.0.1:8080/transaction/{budgetId}' \
--header 'Content-Type: application/json' \
--data-raw '{
    "category": "Food",
    "addedBy": 123

}'

7. Get total Expenditure:
   curl --location --request POST '127.0.0.1:8080/user/expenditure/{userId}'
   
