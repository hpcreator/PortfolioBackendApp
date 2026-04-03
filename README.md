# Personal Portfolio Backend

Backend service for managing and serving data for a **Personal Portfolio Platform**.

This project provides a secure and scalable backend that powers both the **admin management application** and the **public portfolio website**.

The backend allows administrators to manage portfolio content such as profile information, projects, skills, professional experience, and achievements.

---

# Overview

The system is designed to support two types of clients:

**Admin Application** :
Used to manage and update portfolio content securely.

**Public Portfolio Website** :
Displays portfolio information for visitors.

The backend exposes public APIs for retrieving portfolio data while restricting modification operations to authenticated administrators.

---

# Technology Stack

### Backend

* Java
* Spring Boot
* Hibernate / JPA

### Security

* Spring Security
* OAuth2 Resource Server
* JWT Authentication

### Database

* PostgreSQL

### Development Tools

* Swagger / OpenAPI
* Docker

---

# Key Features

* Secure administrator authentication
* JWT based authorization
* Public access to portfolio data
* Protected admin operations
* Scalable backend architecture
* RESTful API design
* Database persistence with PostgreSQL

---

# Running the Project

## Prerequisites

Make sure the following are installed:

* Java
* Gradle
* Docker

---

## Start the Database

Start PostgreSQL using Docker:

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

Start the backend server:

```
./gradlew bootRun
```

The application will start on:

```
http://localhost:8080
```

---

# API Documentation

Interactive API documentation is available through Swagger.

```
http://localhost:8080/swagger-ui/index.html
```

Swagger allows testing and exploring the backend APIs.

---

# Project Purpose

This backend is part of a larger **Personal Portfolio System** that consists of :

* Backend API
* Android Admin Application
* Public Portfolio Website

The backend acts as the **central service responsible for storing and delivering portfolio data** to client applications.

---

# Author
## Harsh Patel
**Android Engineer | Java Enthusiast**
