# Task Manager API

This is a RESTful Task Management system built with **Spring Boot**, **PostgreSQL**, and **Flyway**, designed to run seamlessly in **Docker containers**.

---

## Stack

- **Java 21**
- **Spring Boot 3.5**
- **PostgreSQL 16**
- **Lombok**
- **Flyway (for DB migrations)**
- **Docker**
- **Swagger UI**

---

## Running the App with Docker

### 1. Build the project

Make sure you have generated the JAR file:

```
./mvnw clean package
```

or 

```
mvn clean package
```

### 2. Build and run containers

Run the following command in the project root:

```
docker compose up --build
```

### 3. Access the API

- Swagger UI: [http:/localhost:8080/swagger-ui.html](http:/localhost:8080/swagger-ui.html)
- API base URL: [http://localhost:8080/tasks](http://localhost:8080/tasks)

### Examples of using the API:
![Снимок экрана (4)](https://github.com/user-attachments/assets/d7dd8d6e-11be-4b1f-abe1-c55f60cde4c4)
![Снимок экрана (5)](https://github.com/user-attachments/assets/63fe9c3c-1725-4c0a-ad01-6b45269364ac)
![Снимок экрана (6)](https://github.com/user-attachments/assets/7dfb1211-c3ad-4c61-90d6-5408824c07ff)
![Снимок экрана (7)](https://github.com/user-attachments/assets/e62ec8f9-e241-43d6-9ec8-7313b534d359)
![Снимок экрана (8)](https://github.com/user-attachments/assets/e5974400-8c46-4201-8c34-fcbb07a20dbc)
![Снимок экрана (9)](https://github.com/user-attachments/assets/d7ef2f5c-76fc-415b-9766-c928b4737cf1)
