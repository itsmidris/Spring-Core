# FakeStore API Client (Version 3)

## Phase 3 Overview

Phase 3 focused on implementing write operations and completing the CRUD cycle using the FakeStore API.

The application evolved from a read-only REST client into a service capable of creating, updating, and deleting resources.

---

# Features Added

## Create Product

```http
POST /products
```

Example Request:

```json
{
    "title": "Gaming Mouse",
    "price": 2999,
    "description": "RGB Gaming Mouse",
    "image": "https://test.com/mouse.png",
    "category": "electronics"
}
```

Concepts learned:

* `@RequestBody`
* HTTP POST requests
* JSON to Java Object mapping
* `RestTemplate.postForObject()`

---

## Update Product

```http
PUT /products/{id}
```

Example:

```http
PUT /products/5
```

Request Body:

```json
{
    "title": "Updated Gaming Mouse",
    "price": 3999,
    "description": "Updated RGB Mouse",
    "image": "https://test.com/image.png",
    "category": "electronics"
}
```

Concepts learned:

* HTTP PUT requests
* `RestTemplate.exchange()`
* `HttpMethod.PUT`
* `HttpEntity`
* `ResponseEntity`

---

## Delete Product

```http
DELETE /products/{id}
```

Example:

```http
DELETE /products/5
```

Concepts learned:

* HTTP DELETE requests
* `RestTemplate.delete()`
* `ResponseEntity<Void>`
* HTTP 204 No Content

---

# Understanding @RequestBody

Unlike:

```java
@PathVariable int id
```

which extracts data from:

```http
/products/5
```

and:

```java
@RequestParam int limit
```

which extracts data from:

```http
/products?limit=5
```

`@RequestBody` extracts data from the HTTP request body:

```json
{
    "title": "Gaming Mouse"
}
```

Spring Boot automatically converts the JSON payload into a Java object.

Implementation:

```java
@PostMapping
public Product addProduct(
        @RequestBody Product product) {

    return service.addProduct(product);
}
```

---

# RestTemplate Methods Learned

## POST

```java
template.postForObject(
        URL,
        product,
        Product.class
);
```

Used for:

```text
Creating Resources
```

---

## PUT

```java
template.exchange(
        url,
        HttpMethod.PUT,
        entity,
        Product.class
);
```

Used for:

```text
Updating Resources
```

---

## DELETE

```java
template.delete(url);
```

Used for:

```text
Deleting Resources
```

---

# HttpEntity

The update operation introduced:

```java
HttpEntity<Product>
```

which represents:

```text
HTTP Request

↓

Headers

+

Body
```

Current implementation:

```text
Headers = Empty

Body = Product Object
```

Future implementations can include:

```text
Authorization Tokens

Custom Headers

API Keys
```

---

# ResponseEntity

Phase 3 introduced:

```java
ResponseEntity<T>
```

which contains:

```text
Response Body

Status Code

Headers
```

Examples:

```java
response.getBody();

response.getStatusCode();

response.getHeaders();
```

---

# HTTP Status Codes

The project now uses standard REST status codes:

| Operation | Status Code    | Meaning                         |
| --------- | -------------- | ------------------------------- |
| GET       | 200 OK         | Resource retrieved successfully |
| POST      | 201 Created    | Resource created successfully   |
| PUT       | 200 OK         | Resource updated successfully   |
| DELETE    | 204 No Content | Resource deleted successfully   |

---

# Debugging Lessons Learned

## PATCH vs POST

An issue was encountered during development:

```java
template.patchForObject(...)
```

which resulted in:

```text
Invalid HTTP method: PATCH
```

Root Cause:

Java's default `HttpURLConnection` does not support the PATCH method.

Incorrect implementation:

```java
template.patchForObject(
        URL,
        product,
        Product.class
);
```

Correct implementation:

```java
template.postForObject(
        URL,
        product,
        Product.class
);
```

Lesson learned:

```text
POST

↓

Create Resource

PUT

↓

Replace Resource

PATCH

↓

Partial Update
```

---

# Complete CRUD Operations

The application now supports:

```http
GET    /products

GET    /products/{id}

GET    /products/category/{category}

GET    /products/categories

GET    /products/limit?limit=5

POST   /products

PUT    /products/{id}

DELETE /products/{id}
```

---

# Concepts Added In Version 3

### Spring Boot

* `@RequestBody`
* `ResponseEntity`
* `HttpEntity`
* `HttpMethod`

### REST APIs

* Create Operations
* Update Operations
* Delete Operations
* HTTP Status Codes
* CRUD Principles

### RestTemplate

* `postForObject()`
* `exchange()`
* `delete()`

### Backend Development

* Request Body Mapping
* Resource Lifecycle Management
* Root Cause Analysis
* RESTful API Design

---

# Next Phase

Version 4 will focus on professional backend practices:

```text
Custom Exceptions

@ControllerAdvice

Global Exception Handling

ApiResponse<T>

Logging (SLF4J)

Validation

Professional Controller Design
```

The goal is to move from a working CRUD application to a cleaner, more production-oriented Spring Boot architecture.

---

### Note

This README and learning notes were prepared with the assistance of ChatGPT to support understanding and documentation of the project.
