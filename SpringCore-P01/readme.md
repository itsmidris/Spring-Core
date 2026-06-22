# Spring Core Setup (Maven + XML Configuration)

## Step 1: Add Spring Context Dependency

Search:

```text
Spring Context Maven Dependency
```

Add the dependency in:

```text
pom.xml
```

Example:

```xml
<!-- Source: https://mvnrepository.com/artifact/org.springframework/spring-context -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>7.0.8</version>
    <scope>compile</scope>
</dependency>
```

### Purpose

The `spring-context` module provides:

* IoC Container
* Dependency Injection (DI)
* ApplicationContext
* Bean Management
* Resource Loading

Without this dependency, Spring XML configuration and bean creation will not work.

---

## Step 2: Create XML Bean Configuration File

Create the file:

```text
src/main/resources/Beans.xml
```

Add the following configuration:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Bean Definitions -->

</beans>
```

### Purpose

The `Beans.xml` file is used to:

* Define Spring Beans
* Configure Dependency Injection
* Manage Object Lifecycle
* Centralize Application Configuration

---

## Project Structure

```text
SpringCoreProject
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.example
│   │   │       └── Car.java
│   │   │
│   │   └── resources
│   │       └── Beans.xml
│
├── pom.xml
│
└── target
```

---

## Spring Bean Example

### Car.java

```java
public class Car {

    public void drive() {
        System.out.println("Car is running...");
    }
}
```

### Beans.xml

```xml
<bean id="car" class="com.example.Car"/>
```

### Test.java

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        Car car = context.getBean("car", Car.class);

        car.drive();
    }
}
```

### Output

```text
Car is running...
```

---

## Revision Points

1. Add `spring-context` dependency in `pom.xml`.
2. Create `Beans.xml` inside `src/main/resources`.
3. Define beans using `<bean>` tag.
4. Load configuration using `ClassPathXmlApplicationContext`.
5. Retrieve bean using `getBean()`.
6. Spring IoC Container creates and manages objects.
