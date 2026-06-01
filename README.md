# Food Ordering Microservices System

A Spring Boot Microservices-based Food Ordering System built as a course project.

## Overview

This project demonstrates the implementation of a distributed microservices architecture using Spring Boot, Spring Cloud, Eureka Service Discovery, API Gateway, MySQL, and Docker.

The system consists of multiple independent services that communicate with each other through REST APIs.

## Architecture

```text
┌─────────────────┐
│   API Gateway   │
│     :1919       │
└────────┬────────┘
         │
         ▼
 ┌───────────────┐
 │ Eureka Server │
 │    :8761      │
 └───────┬───────┘
         │
 ┌───────┴────────────┐
 │                    │
 ▼                    ▼

Item Service      Order Service
   :9001             :9002
      │
      └── REST Communication ──►
```

## Technologies Used

- Java 26
- Spring Boot
- Spring Cloud
- Eureka Server
- Spring Cloud Gateway
- Spring Data JPA
- MySQL
- Docker
- Gradle
- REST API

## Microservices

### Eureka Server

Service Discovery Server responsible for registering and discovering services.

**Port:** `8761`

---

### API Gateway

Single entry point for all client requests.

**Port:** `1919`

Routes:

| Service | Route |
|----------|--------|
| food Service | /items/** |
| Order Service | /orders/** |

---

### Item Service

Manages food items.

**Port:** `9001`

Functions:

- Add Item
- Get Item by ID
- Get All Items

---

### Order Service

Manages customer orders.

**Port:** `9002`

Functions:

- Add Order
- Get Order by ID
- Get All Orders
- Retrieve Order with Item Details

---

## Database

### Item Service Database

Database Name:

```sql
items
```

### Order Service Database

Database Name:

```sql
orders_db
```

## Service Discovery Configuration

All services register themselves in Eureka Server:

```yaml
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
```

## API Examples

### Get All Items

```http
GET /items/
```

### Get Item By ID

```http
GET /items/{id}
```

### Add Item

```http
POST /items/add
```

Example Body:

```json
{
  "name": "Burger",
  "price": 120
}
```

---

### Get All Orders

```http
GET /orders/
```

### Add Order

```http
POST /orders/add
```

Example Body:

```json
{
  "customerName": "Mohammed",
  "item_id": 1,
  "quantity": 2
}
```

### Get Order With Item Details

```http
GET /orders/{id}
```

Response:

```json
{
  "order": {
    "id": 1,
    "customerName": "Mohammed",
    "item_id": 1,
    "quantity": 2
  },
  "item": {
    "id": 1,
    "name": "Burger",
    "price": 120
  }
}
```

## Running the Project

### Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/food-ordering-microservices.git
```

### Start MySQL

Create databases:

```sql
CREATE DATABASE items;
CREATE DATABASE orders_db;
```

### Start Eureka Server

```bash
./gradlew bootRun
```

### Start Item Service

```bash
./gradlew bootRun
```

### Start Order Service

```bash
./gradlew bootRun
```

### Start API Gateway

```bash
./gradlew bootRun
```

## Docker Deployment

Build images:

```bash
docker compose build
```

Run containers:

```bash
docker compose up -d
```

Check running containers:

```bash
docker ps
```

## Future Improvements

- Authentication and Authorization (JWT)
- Spring Security
- Circuit Breaker (Resilience4J)
- Config Server
- Distributed Tracing
- Kubernetes Deployment
- CI/CD using GitHub Actions

## Learning Outcomes

Through this project, the following concepts were implemented and practiced:

- Microservices Architecture
- Service Discovery
- API Gateway
- Inter-Service Communication
- REST APIs
- Database Integration
- Docker Containerization
- Spring Cloud Ecosystem


