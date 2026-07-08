# 📚 Spring Boot Library Management System

## 📌 Overview

This project is a Library Management System built with **Spring Boot**, **PostgreSQL**, and **Thymeleaf**.

The goal of this project was to gain practical experience with backend development and understand how a real Spring Boot application is structured.

Through this project, I practiced:

- Spring MVC architecture
- Layered application design
- Database integration with PostgreSQL
- Spring Data JPA and Hibernate
- REST API development
- Server-side rendering with Thymeleaf

---

# ✨ Features

## 📖 Book Management

- View all books
- Add new books
- Update existing books by ID
- Delete books by ID
- Manage book availability status

## 🔍 Search & Filtering

- Search books by ID
- Search books by title and author
- Filter books by price
- Display available and unavailable books

---

# 🛠 Technologies Used

## Backend
- Java 25
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate ORM
- Jakarta Validation

## Database
- PostgreSQL

## Frontend
- Thymeleaf
- HTML5
- CSS3

## Tools
- Maven
- IntelliJ IDEA
- Postman


---

# 🏗 Architecture

The project follows a layered architecture using the MVC pattern.


- **Controller Layer:** Handles user requests and communicates with the application logic.
- **Service Layer:** Contains the main business logic of the application.
- **Repository Layer:** Manages communication with the database using Spring Data JPA.
- **Entity Layer:** Represents the database models, such as the `Book` entity.

---

# 🌐 Application Functionality

The application provides:

- Web interface using Thymeleaf
- CRUD operations for books
- REST API endpoints
- Data persistence with PostgreSQL
- Searching and filtering functionality

---

# 📚 What I Learned

Through this project, I gained practical experience with:

- Building a Spring Boot application from scratch
- Understanding MVC and layered architecture
- Working with PostgreSQL and JPA/Hibernate
- Creating REST APIs
- Connecting frontend views with backend logic
- Structuring a maintainable backend project

---

# ⚙️ Getting Started

Follow the steps below to run the project on your local machine.


Make sure you have the following installed:

- Java 25
- Maven
- PostgreSQL
- IntelliJ IDEA (or another Java IDE)

---

## Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

Replace:

- `YOUR_USERNAME` with your GitHub username.
- `YOUR_REPOSITORY` with the repository name.

---

## Configure PostgreSQL

Create a PostgreSQL database (for example):

```sql
CREATE DATABASE library_management;
```

---

## Configure `application.properties`

Open the file:

```
src/main/resources/application.properties
```

Update the database configuration with your own PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_management
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace:

- `YOUR_USERNAME` with your PostgreSQL username.
- `YOUR_PASSWORD` with your PostgreSQL password.

---

## Install Dependencies

This project uses Maven for dependency management.

Reload the Maven project in your IDE or run:

```bash
mvn clean install
```

---

## Run the Application

Start the application by running:

```
LibraryManagementApplication.java
```

or execute:

```bash
mvn spring-boot:run
```

Once the application starts successfully, open:

```
http://localhost:8080
```

to access the Library Management System.

