# 📚 Spring Boot Library Management System

## 📌 Overview

This project is a **Library Management System** built with **Spring Boot**, **PostgreSQL**, and **Thymeleaf**.

The primary goal of this project was to gain hands-on experience with backend development and understand how a
real-world Spring Boot application is structured.

During the development process, I focused not only on implementing application features but also on improving the
architecture by applying common backend development practices such as **DTOs**, **Mapper Pattern**, **layered
architecture**, and **Spring Data JPA**.

---

# 🚀 Features

## 📖 Book Management

- View all books
- Add a new book
- Update an existing book
- Delete a book
- Manage book availability

## 🔍 Search & Filtering

- Search by ID
- Search by title
- Search by author
- Filter books by price
- Display available books
- Display unavailable books

---

# 🛠 Technologies Used

## Backend

- Java 25
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate ORM
- Jakarta Validation
- DTO Pattern
- Mapper Pattern

## Database

- PostgreSQL

## Frontend

- Thymeleaf
- HTML5
- CSS3

## Tools

- Maven
- IntelliJ IDEA Community Edition
- Postman
- Git
- GitHub

---

# 🏗 Application Architecture

The application follows a layered architecture based on the Spring MVC design pattern.

```text
                Browser
                   │
                   ▼
             Controller
                   │
                   ▼
               BookDTO
                   │
                   ▼
               Service
                   │
                   ▼
              BookMapper
                   │
                   ▼
              Book Entity
                   │
                   ▼
             Repository
                   │
                   ▼
              PostgreSQL
```

---

## Controller Layer

Responsible for handling HTTP requests and responses.

Responsibilities:

- Receives user requests
- Accepts and returns DTO objects
- Delegates business logic to the Service layer

---

## Service Layer

Contains the application's business logic.

Responsibilities:

- Coordinates communication between application layers
- Processes business operations
- Uses the Mapper to convert between DTOs and Entities

---

## Mapper Layer

Responsible for converting objects between different layers.

Responsibilities:

- Converts **BookDTO → Book Entity**
- Converts **Book Entity → BookDTO**
- Decouples the presentation layer from the persistence layer

---

## Repository Layer

Responsible for database communication using Spring Data JPA.

Responsibilities:

- Create records
- Read records
- Update records
- Delete records

---

## Entity Layer

Represents the database model.

The `Book` entity is used exclusively by the persistence layer and contains the structure of the corresponding database
table.

---

# 🌐 Application Functionality

The application provides:

- Server-side rendered web pages using Thymeleaf
- Complete CRUD operations
- REST API endpoints
- PostgreSQL persistence
- Dynamic searching and filtering
- Input validation using Jakarta Validation

---

# 🔄 DTO & Mapper Refactoring

One of the main improvements of this project was introducing the **DTO (Data Transfer Object)** and **Mapper** patterns.

Instead of exposing JPA entities directly to the presentation layer, the application now communicates using **BookDTO**
objects.

The mapper is responsible for converting between DTOs and entities.

This approach provides:

- Better separation of concerns
- Cleaner architecture
- Reduced coupling between API and database
- Controlled data exposure
- Easier future maintenance
- Improved scalability

---

# 📚 What I Learned

Through this project I gained practical experience with:

- Building a Spring Boot application from scratch
- Understanding Spring MVC architecture
- Implementing layered architecture
- Working with Spring Data JPA and Hibernate
- Integrating PostgreSQL
- Building REST APIs
- Server-side rendering using Thymeleaf
- Applying Jakarta Validation
- Implementing DTO Pattern
- Implementing Mapper Pattern
- Separating presentation and persistence layers
- Writing cleaner and more maintainable backend code
- Managing a Java project with Maven
- Testing REST endpoints using Postman
- Version control using Git and GitHub

---

# ⚙️ Getting Started

Make sure you have installed:

- Java 25
- Maven
- PostgreSQL
- IntelliJ IDEA (or any Java IDE)

---

## Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

Replace:

- `YOUR_USERNAME` with your GitHub username
- `YOUR_REPOSITORY` with your repository name

---

## Configure PostgreSQL

Create a PostgreSQL database.

Example:

```sql
CREATE
DATABASE library_management;
```

---

## Configure application.properties

Open:

```
src/main/resources/application.properties
```

Configure your own PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/library_management
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace:

- `YOUR_USERNAME`
- `YOUR_PASSWORD`

with your local PostgreSQL credentials.

---

## Install Dependencies

Reload the Maven project or execute:

```bash
mvn clean install
```

---

## Run the Application

Run:

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

---

## 💡 Purpose of this Project

This project was developed as a personal learning project to strengthen my Java and Spring Boot skills while building a
solid understanding of backend application architecture and software development best practices.

It represents my continuous learning journey and serves as part of my backend development portfolio.