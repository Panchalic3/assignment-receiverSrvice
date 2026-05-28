# Receiver Service

## 📌 Overview

Receiver Service is a Spring Boot application responsible for receiving event data from the Consumer and retry Service via REST
API and persisting it into the database. It acts as the final processing layer in the event-driven system.

---

## 🚀 Tech Stack

- Java 21
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- JUnit 5 & Mockito

---

## 📂 Project Structure
```
src/main/java/com/assignment/receiver/
│
├── controller
├── service
├── repo
├── model
├── util
└── ReceiverServiceApplication.java
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository
```
git clone https://github.com/Panchalic3/assignment-receiverSrvice
cd assignment-receiverSrvice
```
### 2. Build the project
```
mvn clean install
```
### 3. Run the application
```
mvn spring-boot:run
```
---

## 📡 API Endpoint

### ➤ Process Event

**POST** `/api/process`

#### ✅ Request Body

```json
{
  "userName": "Panchali",
  "eventId": "123",
  "data": "Sample event",
  "timestamp": "2026-01-01T10:00:00"
}
```

## ✅ Success Response
```
Processed successfully
```
### 🔄 Processing Flow

- Consumer Service sends event to /api/process
- Controller receives request
- Data is passed to service layer
- Event is mapped to ReceivedEvent entity
- Entity is saved to PostgreSQL database - received_events

---

### 🗄️ Database
```
received_events Table Fields:
userName
eventId
data
timestamp
```
---

## 🧪 Testing

Run all tests:
```
mvn test
```
# ✔ Coverage Includes:

- Controller layer
- Service layer
- Mapper

---

# 💡 Features

- REST API for receiving events
- Database persistence using JPA
- Clean layered architecture
- Unit and integration testing

---

### 👩‍💻 Author

Panchali