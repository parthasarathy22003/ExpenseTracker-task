
# Expense Manager – Spring Boot + MongoDB

A production-style backend REST API built with Spring Boot and MongoDB for managing personal expenses and income.

---

## 📌 Overview

This project is a backend REST API used to manage user expenses and income.

It allows users to:
- Create, update, delete expenses
- Filter expenses with pagination
- View monthly expense summaries
- Analyze expenses by category and payment mode
- Track daily and monthly expense trends
- Compare total income vs total expenses

The project follows a clean layered architecture using Spring Boot best practices.

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Data MongoDB
- MongoDB
- REST APIs
- Maven

---

## 🧱 Project Architecture

```

controller  → Handles REST API requests
service     → Contains business logic
repository  → MongoDB database access
model       → MongoDB document models
dto         → Data transfer objects for reports
exception   → Global exception handling

```

---

## ✨ Features

- Expense CRUD operations
- Pagination and filtering
- Monthly expense reports
- Category-wise expense summary
- Payment-mode based summary
- Daily and monthly expense trends
- Income vs Expense analytics
- Centralized exception handling

---

## 🔗 API Endpoints (Sample)

### Create Expense
```

POST /api/expenses

````

```json
{
  "userId": "u1",
  "category": "FOOD",
  "amount": 250,
  "date": "2026-01-01",
  "paymentMode": "CASH",
  "description": "Lunch"
}
````

---

### Income vs Expense

```
GET /api/analytics/income-vs-expense?userId=u1
```

```json
{
  "totalIncome": 50000,
  "totalExpense": 18000,
  "balance": 32000
}
```

---

## 🗄 Database Design (MongoDB)

### Expense Collection

* id
* userId
* category
* amount
* date
* paymentMode
* description

### Income Collection

* id
* userId
* amount

---

## ▶️ How to Run the Project

1. Start MongoDB on `localhost:27017`
2. Clone this repository
3. Configure `application.yml` if required
4. Run `ExpenseManagerApplication`
5. Test APIs using Postman

---

## 📚 What I Learned

* Spring Boot layered architecture
* REST API design principles
* MongoDB integration using Spring Data
* DTO usage for reporting and analytics
* Java Streams for data processing
* Global exception handling

---

## 🚀 Future Improvements

* JWT-based authentication
* User login and registration
* Swagger API documentation
* MongoDB aggregation pipelines
* Unit testing with JUnit and Mockito

---

## 🏷 GitHub Tags

spring-boot
mongodb
rest-api
backend
java
expense-tracker

```

---

## ✅ END HERE ⬆️

---
 
❓ **Did you revise Java today?**
```
