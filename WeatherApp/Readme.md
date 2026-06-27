# WeatherApp ☁️🌦️

A simple Spring Boot REST API project that fetches real-time weather and forecast data using the WeatherAPI service.

This project was built to practice Spring Boot fundamentals, REST APIs, DTO mapping, dependency injection, external API consumption, and application configuration.

---

## Features

* Get current weather information by city
* Get weather forecast for multiple days
* Consume third-party REST APIs using RestTemplate
* DTO-based JSON mapping
* Externalized configuration using application.properties
* Layered architecture (Controller → Service → DTO)

---

## Tech Stack

* Java 21
* Spring Boot
* Maven
* REST API
* WeatherAPI
* IntelliJ IDEA

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── com.test.WeatherApp
    │       ├── Controller
    │       │   └── WeatherController.java
    │       │
    │       ├── Service
    │       │   └── WeatherService.java
    │       │
    │       ├── DTO
    │       │   ├── WeatherResponse.java
    │       │   ├── WeatherForeCast.java
    │       │   ├── DayTemp.java
    │       │   ├── Root.java
    │       │   ├── Location.java
    │       │   ├── Current.java
    │       │   ├── Forecast.java
    │       │   ├── Forecastday.java
    │       │   ├── Day.java
    │       │   ├── Hour.java
    │       │   ├── Astro.java
    │       │   └── Condition.java
    │       │
    │       └── WeatherAppApplication.java
    │
    └── resources
        └── application.properties
```

---

## API Endpoints

### Test Endpoint

```http
GET /weather/{city}
```

Example:

```http
GET /weather/mumbai
```

Response:

```text
good
```

---

### Current Weather

```http
GET /weather/my/{city}
```

Example:

```http
GET /weather/my/delhi
```

Sample Response:

```json
{
    "city": "Delhi",
    "region": "Delhi",
    "country": "India",
    "condition": "Sunny",
    "temperature": 36.0
}
```

---

### Weather Forecast

```http
GET /weather/forecast?city=delhi&days=3
```

Sample Response:

```json
{
    "weatherResponse": {
        "city": "Delhi",
        "region": "Delhi",
        "country": "India",
        "condition": "Sunny",
        "temperature": 36.0
    },
    "dayTemp": [
        {
            "date": "2026-06-25",
            "minTemp": 28.0,
            "avgTemp": 33.5,
            "maxTemp": 39.0
        }
    ]
}
```

---

## Configuration

Add the following properties inside:

```properties
src/main/resources/application.properties
```

```properties
spring.application.name=WeatherApp

weather.api.key=YOUR_API_KEY

weather.api.url=http://api.weatherapi.com/v1/current.json

weather.api.forecast.url=http://api.weatherapi.com/v1/forecast.json
```

---

## Concepts Practiced

This project helped me practice:

* Spring Boot Project Structure
* Dependency Injection (@Autowired)
* Service Layer Pattern
* REST Controllers
* Path Variables
* Request Parameters
* DTO Design
* JSON Mapping
* External API Integration
* RestTemplate
* Configuration using @Value
* Maven Dependency Management

---

## Challenges Faced

Some issues encountered during development:

* Import statements not being automatically added by IntelliJ
* DTO type mismatches between Forecast and ForecastDay
* Incorrect return types in controller methods
* JSON mapping errors while consuming external APIs
* Maven dependency synchronization issues

These problems improved understanding of Spring Boot project structure and debugging techniques.

---

## Future Improvements

* Add Exception Handling using @ControllerAdvice
* Implement Global Response Wrapper
* Add Logging using SLF4J
* Use WebClient instead of RestTemplate
* Integrate Swagger/OpenAPI documentation
* Add Unit Testing with JUnit and Mockito
* Secure API keys using Environment Variables

---

## Author

Md Imran Idrishi

Learning Spring Boot through hands-on projects and building practical backend applications.
