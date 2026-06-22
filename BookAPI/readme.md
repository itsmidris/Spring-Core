# RESTful API - BookAPI Notes

## Project Overview

This project is a simple RESTful API built using Spring Boot.

It manages books using CRUD operations:

* Create Book
* Read Book(s)
* Update Book
* Delete Book

Currently, data is stored in a `HashMap` instead of a database.

---

# Project Structure

```text
com.test.BookAPI
│
├── Controller
│   └── BookController
│
├── Service
│   ├── BookService
│   └── BookServiceImpl
│
├── Repo
│   ├── BookRepo
│   └── BookRepoImpl
│
├── Entity
│   └── Book
│
└── BookApiApplication
```

---

# Layer Responsibilities

## Controller Layer

Responsible for:

* Receiving HTTP Requests
* Returning HTTP Responses
* Calling Service Layer

Example:

```java
@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Long id)
```

---

## Service Layer

Responsible for:

* Business Logic
* Validation
* Communication between Controller and Repo

Example:

```java
bookService.getBookById(id);
```

---

## Repository Layer

Responsible for:

* Data Storage
* Database Operations

Current Storage:

```java
private Map<Long, Book> bookDB = new HashMap<>();
```

Future:

```text
HashMap
   ↓
MySQL/PostgreSQL
```

---

## Entity Layer

Represents the object structure.

Example:

```java
public class Book {

    private Long id;
    private String title;
    private String author;
    private Double price;

}
```

---

# Request Flow

```text
Client
   |
   v
Controller
   |
   v
Service
   |
   v
Repository
   |
   v
HashMap
```

Response follows the reverse path.

```text
HashMap
   |
   v
Repository
   |
   v
Service
   |
   v
Controller
   |
   v
Client
```

---

# REST Endpoints

Base URL:

```text
http://localhost:8080/books
```

---

## 1. Create Book

### Request

```http
POST /books
```

### Body

```json
{
  "id": 1,
  "title": "Java",
  "author": "James",
  "price": 500
}
```

### Response

```http
201 CREATED
```

### Output

```json
{
  "id": 1,
  "title": "Java",
  "author": "James",
  "price": 500
}
```

---

## 2. Get All Books

### Request

```http
GET /books
```

### Response

```http
200 OK
```

### Output

```json
[
  {
    "id": 1,
    "title": "Java",
    "author": "James",
    "price": 500
  }
]
```

---

## 3. Get Book By ID

### Request

```http
GET /books/1
```

### Response

```http
200 OK
```

### Output

```json
{
  "id": 1,
  "title": "Java",
  "author": "James",
  "price": 500
}
```

---

## 4. Update Book

### Request

```http
PUT /books/1
```

### Body

```json
{
  "id": 1,
  "title": "Advanced Java",
  "author": "James",
  "price": 700
}
```

### Response

```http
204 NO CONTENT
```

### Updated Data

```json
{
  "id": 1,
  "title": "Advanced Java",
  "author": "James",
  "price": 700
}
```

---

## 5. Update Price

### Request

```http
PATCH /books/1/price
```

### Body

```json
800
```

### Response

```http
200 OK
```

### Output

```json
{
  "id": 1,
  "title": "Advanced Java",
  "author": "James",
  "price": 800
}
```

---

## 6. Delete Book

### Request

```http
DELETE /books/1
```

### Response

```http
204 NO CONTENT
```

---

# HTTP Methods

| Method | Purpose               |
| ------ | --------------------- |
| GET    | Read Data             |
| POST   | Create Data           |
| PUT    | Replace Existing Data |
| PATCH  | Update Partial Data   |
| DELETE | Remove Data           |

---

# HTTP Status Codes

| Status Code | Meaning                   |
| ----------- | ------------------------- |
| 200         | Success                   |
| 201         | Resource Created          |
| 204         | Success, No Response Body |
| 404         | Resource Not Found        |
| 500         | Internal Server Error     |

---

# JSON to Java Object Conversion

Incoming JSON:

```json
{
  "id": 1,
  "title": "Java"
}
```

Automatically becomes:

```java
Book book = new Book();
book.setId(1L);
book.setTitle("Java");
```

This process is called:

```text
Deserialization
```

Performed by Jackson Library.

---

# Key Spring Annotations

## @RestController

Marks class as REST Controller.

```java
@RestController
public class BookController
```

---

## @RequestMapping

Defines Base URL.

```java
@RequestMapping("/books")
```

---

## @GetMapping

Handles GET Requests.

```java
@GetMapping
```

---

## @PostMapping

Handles POST Requests.

```java
@PostMapping
```

---

## @PutMapping

Handles PUT Requests.

```java
@PutMapping("/{id}")
```

---

## @PatchMapping

Handles PATCH Requests.

```java
@PatchMapping("/{id}/price")
```

---

## @DeleteMapping

Handles DELETE Requests.

```java
@DeleteMapping("/{id}")
```

---

## @PathVariable

Reads value from URL.

```java
@GetMapping("/{id}")
public Book getBook(@PathVariable Long id)
```

Example:

```text
/books/1
```

id = 1

---

## @RequestBody

Converts JSON to Java Object.

```java
@PostMapping
public Book createBook(@RequestBody Book book)
```

---

# Interview Answer

Q: Explain the flow of your BookAPI project.

Answer:

1. Client sends HTTP request.
2. Controller receives request.
3. Controller calls Service layer.
4. Service executes business logic.
5. Service calls Repository layer.
6. Repository accesses data store.
7. Data is returned back to Service.
8. Service returns result to Controller.
9. Controller sends HTTP response to client.

Flow:

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database / HashMap
```
