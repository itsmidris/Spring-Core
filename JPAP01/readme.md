# Spring Boot + JPA CRUD Project Notes

## Project Structure

```text
JPAP01
│
├── Controller
│   └── StudentController
│
├── Service
│   └── StudentService
│
├── Repo
│   └── StudentRepo
│
├── Entity
│   └── Student
│
├── Jpap01Application
│
└── application.properties
```

---

# Application Flow

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
Database
```

Example:

1. User sends request
2. Controller receives request
3. Controller calls Service
4. Service performs business logic
5. Service calls Repository
6. Repository interacts with Database
7. Response returns back to Client

---

# @SpringBootApplication

```java
@SpringBootApplication
public class Jpap01Application {
    public static void main(String[] args) {
        SpringApplication.run(Jpap01Application.class, args);
    }
}
```

## Interview

### What is @SpringBootApplication?

It is a combination of:

```java
@Configuration
@EnableAutoConfiguration
@ComponentScan
```

### @Configuration

Used to define Spring Beans.

### @EnableAutoConfiguration

Automatically configures Spring Boot based on dependencies.

Example:

If MySQL dependency exists, Spring Boot automatically configures DataSource.

### @ComponentScan

Scans packages and registers beans automatically.

---

# IOC Container

## What is IOC?

Inversion Of Control.

Normally:

```java
StudentRepo repo = new StudentRepo();
```

Developer creates object.

In Spring:

```java
@Autowired
StudentRepo repo;
```

Spring creates object.

Control shifts from developer to Spring.

Hence called Inversion Of Control.

---

# Dependency Injection

## What is Dependency?

If class A uses class B:

```java
class StudentService {
    StudentRepo repo;
}
```

StudentService depends on StudentRepo.

---

## What is Dependency Injection?

Providing dependency from outside.

Instead of:

```java
StudentRepo repo = new StudentRepo();
```

Spring injects it automatically.

---

# Constructor Injection

```java
private final StudentService studentService;

public StudentController(StudentService studentService){
    this.studentService = studentService;
}
```

---

## Why Constructor Injection?

Advantages:

1. Recommended by Spring
2. Easier testing
3. Dependencies become mandatory
4. Supports immutability
5. Avoids NullPointerException

---

## Do We Need @Autowired?

No.

Since Spring 4.3:

If class has only one constructor,

Spring automatically injects dependency.

Example:

```java
public StudentController(StudentService service){
    this.service = service;
}
```

No @Autowired required.

---

# Controller Layer

```java
@RestController
@RequestMapping("/students")
```

---

## What is Controller?

Controller handles HTTP requests.

Example:

```java
@GetMapping
@PostMapping
@PutMapping
@DeleteMapping
```

---

## @RestController

Combination of:

```java
@Controller
@ResponseBody
```

Returns JSON directly.

Example:

```json
{
  "id":1,
  "name":"Imran"
}
```

---

## Difference

### @Controller

Returns View

Example:

```java
return "home.jsp";
```

---

### @RestController

Returns JSON

Example:

```java
return student;
```

---

# Service Layer

```java
@Service
public class StudentService {
}
```

---

## Why Service Layer?

Business logic belongs here.

Bad:

```java
Controller -> Repository
```

Good:

```java
Controller -> Service -> Repository
```

Benefits:

1. Clean architecture
2. Reusable logic
3. Easy testing
4. Maintainability

---

# Repository Layer

```java
@Repository
public interface StudentRepo extends JpaRepository<Student, Long>
```

---

## What is Repository?

Responsible for database operations.

Example:

```java
save()
findAll()
findById()
deleteById()
```

---

## JpaRepository vs CrudRepository

### CrudRepository

Basic methods:

```java
save()
findById()
findAll()
delete()
```

---

### JpaRepository

Contains all CrudRepository methods plus:

```java
flush()
saveAndFlush()
findAll(Pageable)
```

More powerful.

Hence preferred.

---

# Entity

```java
@Entity
public class Student
```

---

## What is Entity?

Represents a database table.

Example:

```java
@Entity
class Student
```

Student table created automatically.

---

## @Id

Marks Primary Key.

```java
@Id
private Long id;
```

---

## @GeneratedValue

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

Database automatically generates ID.

Example:

```text
1
2
3
4
```

---

## Why Default Constructor?

JPA creates object using Reflection.

Reflection requires default constructor.

```java
public Student(){
}
```

Mandatory.

---

# Reflection API

## What is Reflection?

Allows Java to inspect classes at runtime.

Example:

```java
Class<?> cls = Student.class;
```

Can access:

1. Fields
2. Methods
3. Constructors
4. Annotations

Spring heavily uses Reflection.

---

## Where Spring Uses Reflection?

1. Creating Beans
2. Dependency Injection
3. Reading Annotations
4. JPA Entity Creation

---

# HTTP Methods

---

## GET

Retrieve data.

```http
GET /students
```

---

## POST

Create data.

```http
POST /students
```

---

## PUT

Update complete object.

Example:

Before:

```json
{
 "name":"Imran",
 "email":"old@gmail.com"
}
```

After PUT:

```json
{
 "name":"New",
 "email":"new@gmail.com"
}
```

Entire object updated.

---

## PATCH

Partial update.

Example:

Only update name.

```http
PATCH /students?id=1&name=Ali
```

Only name changes.

---

## PUT vs PATCH

PUT:

Complete update.

PATCH:

Partial update.

---

# JPA

## What is JPA?

Java Persistence API.

Specification.

Defines rules for ORM.

---

# Hibernate

## What is Hibernate?

Implementation of JPA.

Flow:

```text
Application
    |
    v
JPA
    |
    v
Hibernate
    |
    v
Database
```

---

# ORM

## What is ORM?

Object Relational Mapping.

Maps:

```java
Student
```

to

```sql
student
```

table.

Java Object ↔ Database Table

---

# application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=1234
```

Database connection properties.

---

## spring.jpa.hibernate.ddl-auto=update

Automatically updates schema.

Options:

```text
create
create-drop
update
validate
none
```

Most common:

```properties
update
```

---

## spring.jpa.show-sql=true

Prints SQL queries in console.

Example:

```sql
select * from student;
```

---

# What Happens When save() Is Called?

Example:

```java
studentRepo.save(student);
```

Flow:

```text
Controller
   |
Service
   |
Repository
   |
Hibernate
   |
SQL Query
   |
Database
```

Hibernate generates SQL:

```sql
insert into student(name,email)
values('Imran','abc@gmail.com');
```

Database stores record.

---

# Most Important Interview Questions

1. What is Spring Boot?
2. What is IOC?
3. What is Dependency Injection?
4. Why Constructor Injection?
5. Why no @Autowired?
6. What is @RestController?
7. Difference between Controller and RestController?
8. What is Service Layer?
9. What is Repository?
10. What is Entity?
11. What is JPA?
12. What is Hibernate?
13. What is ORM?
14. What is Reflection API?
15. Why default constructor required?
16. Difference between PUT and PATCH?
17. Difference between JpaRepository and CrudRepository?
18. What is @GeneratedValue?
19. What is @SpringBootApplication?
20. What happens internally when save() is called?

---

# One Line Revision

IOC = Spring creates objects.

DI = Spring injects objects.

Controller = Handles requests.

Service = Business logic.

Repository = Database operations.

Entity = Database table.

JPA = Specification.

Hibernate = JPA implementation.

ORM = Object ↔ Table mapping.

PUT = Full update.

PATCH = Partial update.

Reflection = Runtime inspection of classes.
