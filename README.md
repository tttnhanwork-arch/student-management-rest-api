# User Management REST API (Spring Boot)

A backend RESTful API project built with Spring Boot, Spring Data JPA, and Spring Security.  

## Overview

This project provides a REST API for managing users, including:

- CRUD operations (Create, Read, Update, Delete)
- Authentication & Authorization with Spring Security
- Exception handling with global handler
- Layered architecture (Controller → Service → Repository)

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- Spring Security
- MySQL
- Maven

## Project Architecture

The project follows a **layered architecture**:

src/main/java/com/example/student_mn
- entity/ # JPA Entities
- dao/ # Repository (extends JpaRepository)
- service/ # Business logic
- rest/ # REST Controllers
- security/ # Authentication & Authorization
- handle/ # Global Exception Handling

## Security Features

- Authentication using `JdbcUserDetailsManager`
- Password encryption with **BCrypt**
- Custom `SecurityFilterChain`
- Role-based authorization

## Features

- ✅ RESTful API design
- ✅ CRUD operations
- ✅ Global Exception Handling (`@ControllerAdvice`)
- ✅ Secure endpoints with Spring Security

### API Endpoints (Example some of endpoints in this project)

| Method | Endpoint        | Description       |
|--------|----------------|-------------------|
| GET    | /api/subject     | Get all subjects     |
| GET    | /api/subject/{id}| Get subject by ID    |
| POST   | /api/subject     | Create new subject   |
| PUT    | /api/subject/{id}| Update subject       |
| DELETE | /api/subject/{id}| Delete subject       |


### API Endpoints (Auto-generated in students, employees, parents Repository)

Spring Data REST automatically exposes endpoints:

| Method | Endpoint          | Description       |
|--------|-------------------|--------------------|
| GET    | /students         | Get all students   |
| GET    | /students/{id}    | Get by ID          |
| POST   | /students         | Create new         |
| PUT    | /students/{id}    | Update             |
| DELETE | /students/{id}    | Delete             |

## Database Setup

Create database: CREATE DATABASE student_management;
Import file: database/student_management.sql

## Testing

You can test APIs using: Postman

## Run

git clone https://github.com/tttnhanwork-arch/user-management-rest-api.git
## Screenshots

[GET : /api/subject]

<img width="1139" height="775" alt="image" src="https://github.com/user-attachments/assets/281536af-fb50-416b-88c0-c8a2c4d8ca74" />

[GET : /api/subject/{id}]

<img width="1124" height="747" alt="image" src="https://github.com/user-attachments/assets/6071ed39-6079-48ab-b239-b92162dab1e0" />

[POST : /api/subject]

<img width="1091" height="700" alt="image" src="https://github.com/user-attachments/assets/5610daf3-2aa5-4ffc-ae4f-5c07115c53cf" />

[PUT : /api/subject/{id}]

<img width="1124" height="693" alt="image" src="https://github.com/user-attachments/assets/2e0e7d04-eb4f-40f5-9c74-157408ae957b" />

[DELETE : /api/subject/{id}]

<img width="1140" height="647" alt="image" src="https://github.com/user-attachments/assets/22c67ad1-93b2-461f-a147-7faad05d3e99" />

## Author
Trần Thị Thanh Nhàn Github: https://github.com/tttnhanwork-arch Email: tttnhan.work@gmail.com
