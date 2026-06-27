# FakeStore API Client (Version 2)

## Phase 2 Overview

Phase 2 focused on building dynamic REST endpoints using path variables and query parameters. The application evolved from a single static endpoint into a small product API supporting filtering, searching, and category operations.

---

# Features Added

## Get Product By ID

```http
GET /products/{id}
```

Example:

```http
GET /products/5
```

Concepts learned:

* `@PathVariable`
* Dynamic URL construction
* Mapping JSON Objects using `Product.class`

---

## Get Products By Category

```http
GET /products/category/{category}
```

Examples:

```http
GET /products/category/electronics

GET /products/category/jewelery
```

Concepts learned:

* Dynamic path parameters
* Resource filtering
* URL construction using service-layer inputs
* Handling array responses with `Product[].class`

---

## Get All Categories

```http
GET /products/categories
```

Response:

```json
[
    "electronics",
    "jewelery",
    "men's clothing",
    "women's clothing"
]
```

Concepts learned:

* Mapping primitive arrays using `String[].class`
* Returning `List<String>`
* Avoiding unnecessary DTO creation

---

## Get Limited Products

```http
GET /products/limit?limit=5
```

Example:

```http
GET /products/limit?limit=5
```

Concepts learned:

* `@RequestParam`
* Query parameters
* Pagination-style API design
* Dynamic query-string construction

---

# Path Variables vs Request Parameters

## Path Variable

Used for resource identification.

Example:

```http
/products/10
```

Implementation:

```java
@PathVariable int id
```

Typical use cases:

* Users
* Orders
* Products
* Individual resources

---

## Request Parameter

Used for filtering, searching, sorting, and pagination.

Example:

```http
/products?limit=5
```

Implementation:

```java
@RequestParam int limit
```

Typical use cases:

* Filtering
* Pagination
* Sorting
* Search functionality

---

# JSON Mapping Patterns

## JSON Object

```json
{
    "id": 1
}
```

Java Mapping:

```java
Product.class
```

---

## JSON Array

```json
[
    {},
    {}
]
```

Java Mapping:

```java
Product[].class
```

---

## Primitive Array

```json
[
    "electronics",
    "jewelery"
]
```

Java Mapping:

```java
String[].class
```

---

# Dynamic URL Construction

Examples:

```java
String url = URL + "/" + id;

String url = URL + "/category/" + category;

String url = URL + "?limit=" + limit;
```

This pattern is commonly used when integrating with:

* Payment APIs
* Weather APIs
* Microservices
* Internal company services

---

# Debugging Lessons Learned

During development, an issue was encountered where:

```java
String url = URL + "?limit" + limit;
```

generated:

```text
/products?limit5
```

instead of:

```text
/products?limit=5
```

The missing `=` caused the API to return all products instead of applying the limit.

Correct implementation:

```java
String url = URL + "?limit=" + limit;
```

This reinforced the importance of:

* Verifying generated URLs
* Debugging layer by layer
* Performing root cause analysis
* Testing external APIs independently

---

# APIs Available After Phase 2

```http
GET /products

GET /products/{id}

GET /products/category/{category}

GET /products/categories

GET /products/limit?limit=5
```

---

# Concepts Added In Version 2

### Spring Boot

* `@PathVariable`
* `@RequestParam`
* Dynamic Controller Mappings
* Request Parameter Binding

### REST API Design

* Resource Identification
* Filtering
* Pagination
* Dynamic URL Construction

### Java

* `String[]`
* `Product[]`
* `Arrays.asList()`
* Defensive Programming

---

# Next Phase

Version 3 will focus on write operations:

```http
POST   /products

PUT    /products/{id}

DELETE /products/{id}
```

New concepts:

* `@RequestBody`
* `ResponseEntity`
* HTTP Status Codes
* CRUD Operations
* Request DTOs
* Validation

---

### Note

This README and learning notes were prepared with the assistance of ChatGPT to support understanding and documentation of the project.
