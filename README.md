
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
  http://localhost:8081/actuator/health
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
