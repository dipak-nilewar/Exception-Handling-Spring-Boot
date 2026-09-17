# Exception Handling Spring Boot

A Spring Boot REST API project demonstrating **professional exception handling**, custom exceptions, global exception handling, request validation, and consistent API error responses.

The project follows a clean and maintainable approach using Spring Boot's `@RestControllerAdvice`, custom exception classes, validation annotations, and structured error responses.

---

## 🚀 Features

* Global exception handling using `@RestControllerAdvice`
* Custom exception classes
* Centralized error handling
* RESTful API development
* Request validation using Jakarta Bean Validation
* Validation error handling
* Meaningful HTTP status codes
* Structured and consistent error responses
* Clean controller-service architecture
* Exception handling for common API errors
* Maven-based Spring Boot project

---

## 🛠️ Technologies Used

| Technology        | Purpose                            |
| ----------------- | ---------------------------------- |
| Java              | Programming Language               |
| Spring Boot       | Backend Framework                  |
| Spring Web        | REST API Development               |
| Spring Validation | Request Validation                 |
| Maven             | Dependency Management & Build Tool |
| REST API          | Client-Server Communication        |
| Git & GitHub      | Version Control                    |

---

## 📂 Project Structure

```text
EXCEPTION-HANDLING/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ...
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── ...
│
├── .gitignore
├── .gitattributes
├── HELP.md
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

---

## 🏗️ Exception Handling Architecture

The application uses a centralized exception-handling mechanism.

```text
Client
  │
  ▼
REST Controller
  │
  ▼
Service Layer
  │
  ├── Successful Request
  │       │
  │       ▼
  │    Response
  │
  └── Exception
          │
          ▼
   Global Exception Handler
   (@RestControllerAdvice)
          │
          ▼
   Structured Error Response
          │
          ▼
        Client
```

This approach prevents exception-handling logic from being duplicated across multiple controllers.

---

## ⚠️ Exception Handling

The application can handle different types of exceptions through a centralized exception handler.

### Custom Exceptions

Custom exceptions can be created for business-specific scenarios.

Example:

```java
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

A service can then throw the exception when a requested resource does not exist:

```java
throw new ResourceNotFoundException("Resource not found");
```

---

## 🌐 Global Exception Handler

The project uses `@RestControllerAdvice` to handle exceptions globally.

Example:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(
            ResourceNotFoundException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
```

Instead of handling the same exception separately in every controller, the global exception handler provides a centralized solution.

---

## ✅ Validation Handling

The project demonstrates request validation using Jakarta Bean Validation.

Example:

```java
@NotBlank(message = "Name is required")
private String name;
```

Other commonly used validation annotations include:

```java
@NotNull
@NotBlank
@NotEmpty
@Size
@Email
@Min
@Max
@Pattern
```

When invalid data is submitted, the application can return an appropriate validation error response.

---

## 📡 REST API Error Response

A consistent error response can contain information such as:

```json
{
  "status": 404,
  "message": "Resource not found",
  "timestamp": "2026-09-17T10:30:00"
}
```

This makes API responses easier for frontend applications and API consumers to understand.

---

## 🔢 HTTP Status Codes

The application follows standard HTTP status codes.

| Status Code                 | Meaning                               |
| --------------------------- | ------------------------------------- |
| `200 OK`                    | Request completed successfully        |
| `201 CREATED`               | Resource successfully created         |
| `400 BAD REQUEST`           | Invalid request or validation failure |
| `401 UNAUTHORIZED`          | Authentication required               |
| `403 FORBIDDEN`             | Access denied                         |
| `404 NOT FOUND`             | Requested resource not found          |
| `409 CONFLICT`              | Resource conflict                     |
| `500 INTERNAL SERVER ERROR` | Unexpected server error               |

---

## 🔄 Example Exception Flow

Suppose a client requests a resource that does not exist.

### Request

```http
GET /api/resource/100
```

### Processing

```text
Controller
    ↓
Service
    ↓
Resource not found
    ↓
ResourceNotFoundException
    ↓
GlobalExceptionHandler
    ↓
HTTP 404 NOT FOUND
```

### Response

```json
{
  "status": 404,
  "message": "Resource not found"
}
```

---

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/dipak-nilewar/Exception-Handling-Spring-Boot.git
```

### 2. Navigate to the Project

```bash
cd Exception-Handling-Spring-Boot
```

### 3. Run Using Maven Wrapper

#### Windows

```bash
mvnw.cmd spring-boot:run
```

#### Linux / macOS

```bash
./mvnw spring-boot:run
```

---

## 🧪 Build the Project

### Windows

```bash
mvnw.cmd clean package
```

### Linux / macOS

```bash
./mvnw clean package
```

---

## 🧪 Testing APIs

You can test the REST APIs using tools such as:

* Postman
* Insomnia
* IntelliJ IDEA HTTP Client
* VS Code REST Client
* Browser for GET requests

Example:

```http
GET http://localhost:8080/api/...
```

> Replace the endpoint with the API available in your application.

---

## 📋 Key Spring Boot Concepts Demonstrated

This project is useful for understanding important Spring Boot interview concepts:

* `@RestController`
* `@RequestMapping`
* `@GetMapping`
* `@PostMapping`
* `@ExceptionHandler`
* `@RestControllerAdvice`
* `ResponseEntity`
* `HttpStatus`
* Jakarta Bean Validation
* Custom Runtime Exceptions
* REST API error handling
* Centralized exception handling
* Controller-Service architecture

---

## 💡 Why Global Exception Handling?

Without global exception handling, controllers may contain repetitive code:

```text
Controller 1 → Exception Handling
Controller 2 → Exception Handling
Controller 3 → Exception Handling
Controller 4 → Exception Handling
```

With `@RestControllerAdvice`:

```text
Controller 1 ─┐
Controller 2 ─┤
Controller 3 ─┼──→ Global Exception Handler
Controller 4 ─┘
```

This improves:

* Code maintainability
* Reusability
* Readability
* Consistency
* Debugging
* API response standardization

---

## 🎯 Learning Objectives

This project was created to understand how exception handling is implemented in a real Spring Boot REST API.

The main objectives are:

1. Understand Java exception handling.
2. Create custom exceptions.
3. Handle exceptions globally.
4. Handle validation errors.
5. Return appropriate HTTP status codes.
6. Create consistent API error responses.
7. Build maintainable REST APIs.

---

## 🔮 Future Enhancements

Possible improvements include:

* Standardized `ErrorResponse` DTO
* Global validation error response
* Database integration
* Spring Data JPA
* MySQL integration
* Logging with SLF4J
* Correlation/request IDs
* Swagger/OpenAPI documentation
* Unit testing with JUnit and Mockito
* Integration testing
* Authentication and authorization
* Production-level error monitoring

---

## 👨‍💻 Author

**Dipak Nilewar**

Java Developer | Spring Boot Developer

GitHub: [dipak-nilewar](https://github.com/dipak-nilewar?utm_source=chatgpt.com)

---

## ⭐ Support

If you find this project useful for learning Spring Boot and exception handling, consider giving the repository a ⭐ on GitHub.

---

## 📄 License

This project is created for learning and development purposes.
