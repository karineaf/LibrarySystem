
# 📚 Library System

Library management system built with **Java 21** and **Spring Boot**, initialized from [Spring Initializr](https://start.spring.io/).


## 🚀 How to run the project

### Prerequisites
- **Java 21**
- **Maven**
- **Lombok** (enable annotation processing in your IDE)

### Steps
1. Clone the repository
2. Build: 
  ```bash
mvn clean install
  ```
3. Start the application:

```bash
   mvn spring-boot:run
   ```

---
## 🗄️ Database (H2)

* Driver: org.h2.Driver
* JDBC URL: jdbc:h2:mem:library_db
* User: librarymanager
* Password: 1234
* Embedded Console: http://localhost:8080/h2-console

---


## ⚙️ Technologies

* **Spring Boot** (embedded Tomcat)
* **Spring Data (CrudRepository)**

  > `CrudRepository` is used instead of `JpaRepository` for simplicity.
* **Lombok**
* **Swagger / OpenAPI** for documentation

---

## 🔌 Main Endpoints

* Default server port: **8080**
* Actuator Health Check:

  ```
  http://localhost:8080/actuator/health
  ```
* Swagger UI:

  ```
  http://localhost:8080/swagger-ui/index.html
  ```

---

## 📖 Business Rules

* ✅ A user can only reserve **one book at a time**
* ✅ A comment **cannot be modified** after creation
* ✅ To reserve a book:

  * The book must be **available**
  * The reservation can last a maximum of **30 days**
  * If the user reserves the same book again, they can keep it for another **30 days**
  * After that, they must wait at least **10 days** before reserving it again

---

## 💡 Improvements

* Do unit tests
* Add proper **logging** for debugging and monitoring
* Replace manual mapping with **MapStruct**
* Implement **Publisher** entity
* When deleting a book, also close **active reservations**
* Implement **reservation expiration** (notifications and future penalty rules)
* Validate **reviews** for offensive words
* Fix bug: deleting an **Author** also deletes co-authors of their books

---

## 🛠️ Development

* **IDE**: IntelliJ IDEA
* **Build tool**: Maven

---
## 📌 Usage Examples

* Create an Author: POST /api/authors
  ```
  {
    "name": "Elayne Baeta"
  }
  ```


* Create a Book: POST /api/books
  ```
  {
    "title": "Clean Code",
    "description": "A handbook of agile software craftsmanship",
    "pages_number": 464,
    "release_date": "2008-08-11",
    "genre": "OTHER",
    "target_audience": "ADULT",
    "authors_ids": [1000]
  }
  ```
  
* Create a Reservation: POST /api/reservations
  ```
  {
    "user_id": 1234,
    "book_id": 2000,
    "per_days": 30
  }
  ```

* Create a Review: POST /api/reviews
  ```
  {
    "user_id": 1234,
    "book_id": 2000,
    "rating": 5,
    "comment": "I love it"
  }
  ```
* Create an User: POST /api/user
  ```
  {
    "name": "Willian Mark",
    "email": "willian@example.com",
    "telephoneNumber": "4567654321",
    "address": "Street ABC, 57",
    "birthDate": "2002-02-01"
  }
  ```
