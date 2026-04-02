# Personal Portfolio Backend

Backend system powering the **Personal Portfolio platform**.

This project provides REST APIs for managing portfolio data such as:

* Profile
* Experience
* Skills
* Projects
* Achievements

The backend also implements **secure admin authentication using JWT** and exposes public APIs for frontend consumption.

---

# Technology Stack

## Backend

* Java 25
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate ORM

## Security

* Spring Security
* OAuth 2.0 Resource Server
* JWT (JSON Web Token)

## Database

* PostgreSQL

## Development Tools

* Swagger / OpenAPI
* Docker

## Libraries

* Lombok
* MapStruct
* Bean Validation

---

# System Architecture

The application follows a **layered architecture**.

```
controller
service
repository
entity
dto
mapper
exception
config
security
auth
```

### Layer Responsibilities

| Layer      | Purpose                        |
| ---------- | ------------------------------ |
| Controller | REST API endpoints             |
| Service    | Business logic                 |
| Repository | Database interaction           |
| Entity     | Database models                |
| DTO        | Request / response objects     |
| Mapper     | Entity ↔ DTO mapping           |
| Config     | Application configuration      |
| Security   | Authentication & authorization |

---

# API Security Model

The backend uses **JWT based authentication**.

Access rules:

| HTTP Method | Access        |
| ----------- | ------------- |
| GET         | Public        |
| POST        | Authenticated |
| PUT         | Authenticated |
| DELETE      | Authenticated |

Admin authentication is required for modifying portfolio content.

---

# Authentication Flow

```
Admin Login
     |
     v
POST /auth/login
     |
     v
JWT Token Issued
     |
     v
Authorization: Bearer <token>
     |
     v
Access Protected APIs
```

### Example Login Request

```
POST /auth/login
```

```json
{
  "username": "userName",
  "password": "password"
}
```

### Example Response

```json
{
  "accessToken": "eyJhbGciOiJSUzI1NiIsInR5cCI..."
}
```

---

# Available API Modules

## Profile

```
GET /profile
PUT /profile
```

---

## Experience

```
GET /experiences
POST /experiences
PUT /experiences/{id}
DELETE /experiences/{id}
```

---

## Skills

```
GET /skills
POST /skills
PUT /skills/{id}
DELETE /skills/{id}
```

---

## Projects

```
GET /projects
POST /projects
PUT /projects/{id}
DELETE /projects/{id}
```

---

## Achievements

```
GET /achievements
POST /achievements
PUT /achievements/{id}
DELETE /achievements/{id}
```

---

# Running the Project

## Prerequisites

* Java 25
* Gradle
* Docker

---

## Start PostgreSQL

Run PostgreSQL using Docker:

```
docker run --name portfolio-postgres \
-e POSTGRES_DB=portfolio \
-e POSTGRES_USER=userName \
-e POSTGRES_PASSWORD=password \
-p 8080:5432 \
-d postgres:16
```

---

## Run the Application

```
./gradlew bootRun
```

Application will start on:

```
http://localhost:8080
```

---

# API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

Swagger allows:

* API exploration
* request testing
* JWT authentication testing

---

# Database Configuration

Example `application.properties`:

```
spring.datasource.url=jdbc:postgresql://localhost:6472/portfolio
spring.datasource.username=userName
spring.datasource.password=password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Database Tools

You can inspect the database using:

* DBeaver
* pgAdmin
* PostgreSQL CLI

Connection settings:

| Field    | Value    |
| -------- |----------|
| Host     | localhost |
| Port     | 6472     |
| Database | portfolio |
| Username | userName |
| Password | password |

---

# Security Features

* JWT authentication
* Password hashing using BCrypt
* Stateless session management
* HTTP method based authorization
* Global exception handling

---

# Future Improvements

Planned enhancements:

* Refresh token support
* Role based access control
* Cloud deployment
* Media upload support
* CI/CD pipeline
* API versioning

---

# Project Purpose

This backend is designed as part of a **Personal Portfolio Platform** consisting of:

```
Backend API
Android Admin Application
Public Portfolio Website
```

The backend acts as the **central data management service** for both client applications.

---

# Author

## Harsh Patel
**Android Engineer | Backend Enthusiast**
