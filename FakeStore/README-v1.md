# FakeStore API Client (Version 1)

## Project Overview

This project is a Spring Boot application that consumes the FakeStore API and exposes custom REST endpoints.

Version 1 focuses on understanding Spring Boot architecture, DTO mapping, external API consumption, and layered application design.

---

# Tech Stack

* Java 25
* Spring Boot 3.5.x
* Maven
* Spring Web
* RestTemplate
* Jackson JSON Mapper

---

# Project Structure

```text
src/main/java/com/Test/FakeStore

├── controller
│   └── ProductController.java
│
├── dto
│   ├── Product.java
│   └── Rating.java
│
├── service
│   └── ProductService.java
│
└── FakeStoreApplication.java
```

---

# Features Implemented (V1)

## Get All Products

```http
GET /products
```

Example:

```http
http://localhost:8080/products
```

Returns:

```json
[
    {
        "id": 1,
        "title": "Fjallraven Backpack",
        "price": 109.95,
        "category": "men's clothing",
        "rating": {
            "rate": 3.9,
            "count": 120
        }
    }
]
```

---

# DTO Design

## Product DTO

Represents:

```json
{
    "id": 1,
    "title": "...",
    "price": 109.95,
    "description": "...",
    "category": "...",
    "image": "...",
    "rating": { }
}
```

Fields:

```java
int id;
String title;
double price;
String description;
String category;
String image;
Rating rating;
```

---

## Rating DTO

Represents:

```json
{
    "rate": 3.9,
    "count": 120
}
```

Fields:

```java
double rate;
int count;
```

---

# Object Composition

This project uses composition:

```java
class Product {

    private Rating rating;

}
```

Meaning:

```text
Product HAS-A Rating
```

Similar to:

```java
class Car {

    private Engine engine;

}
```

---

# RestTemplate Implementation

The service layer consumes:

```http
https://fakestoreapi.com/products
```

Implementation:

```java
Product[] products =
        restTemplate.getForObject(
                URL,
                Product[].class
        );
```

---

# Why Product[] Instead of List<Product>?

The API returns:

```json
[
    { },
    { },
    { }
]
```

which is a JSON Array.

Spring can directly map:

```java
Product[].class
```

but cannot directly determine:

```java
List<Product>
```

because of Java Type Erasure.

Therefore:

```java
Product[] products =
        restTemplate.getForObject(
                url,
                Product[].class
        );

return Arrays.asList(products);
```

---

# Request Flow

```text
Client

↓

ProductController

↓

ProductService

↓

RestTemplate

↓

FakeStore API

↓

JSON Array

↓

Jackson ObjectMapper

↓

Product[]

↓

List<Product>

↓

Spring Boot Response

↓

Client
```

---

# Concepts Learned

## Spring Boot

* Spring Initializr
* Maven Project Structure
* Component Scanning
* @RestController
* @Service
* Dependency Injection
* Request Mapping

---

## REST APIs

* External API Consumption
* HTTP GET Requests
* JSON Response Handling
* REST Endpoint Design

---

## DTO Design

* Nested DTO Mapping
* Default Constructors
* Getters and Setters
* Object Composition

---

## Java Concepts

* Arrays vs Lists
* Arrays.asList()
* Type Erasure
* HAS-A Relationship
* Encapsulation

---

# Future Phases

Version 2 will implement:

```http
GET /products/{id}

GET /products/category/{category}

GET /categories

GET /products?limit=5
```

New concepts:

* Path Variables
* Query Parameters
* Dynamic URLs
* Business Logic
* Exception Handling
* Custom Exceptions
* Global Exception Handlers
* Response Wrappers

---

# Author

Md Imran Idrishi

Learning Spring Boot through practical backend projects and real-world API integrations.

---
### Note
This README and learning notes were prepared with the assistance of ChatGPT to support understanding and documentation of the project.