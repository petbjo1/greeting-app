# Greeting App 👋

[![Maven Package](https://github.com/petbjo1/greeting-app/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/petbjo1/greeting-app/actions/workflows/maven-publish.yml)
[![Version](https://img.shields.io/badge/version-0.0.8-blue.svg)](https://github.com/petbjo1/greeting-app)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0--SNAPSHOT-brightgreen.svg)](https://spring.io/projects/spring-boot)

A modern Spring Boot REST API boilerplate project that provides a simple greeting service. Built with Spring Boot 4.0 (snapshot), Java 21, and Spring Modulith for creating modular monolithic applications.

## ✨ Features

- 🚀 RESTful API with Spring Boot 4.0
- 🏗️ Modular monolithic architecture with Spring Modulith
- 📊 Spring Boot Actuator for monitoring and metrics
- 🔄 Auto-incrementing greeting IDs
- 🧪 Comprehensive test coverage (unit and integration tests)
- 📦 GitHub Packages integration
- 🔍 SpotBugs static analysis
- 🔧 DevTools for hot reload during development

## 📦 Prerequisites

- **Java 21** or higher
- **Maven 3.6+** (or use the included Maven Wrapper)
- **Git** (for cloning the repository)

## 🚀 Getting Started

### Clone the Repository
```bash
git clone [https://github.com/petbjo1/greeting-app.git](https://github.com/petbjo1/greeting-app.git) cd greeting-app
``` 

### Run the Application

Using Maven Wrapper (recommended):
```bash
# On Unix/macOS
./mvnw spring-boot:run
# On Windows
mvnw.cmd spring-boot:run
``` 

Using Maven:
```bash 
mvn spring-boot:run
``` 

The application will start on `http://localhost:8080`

## 📖 API Documentation

### Get Greeting

Returns a personalized greeting message with an auto-incrementing ID.

**Endpoint:** `GET /greeting`

**Parameters:**
- `name` (optional, default: "World") - The name to include in the greeting

**Response:**
```json 
{ "id": 1, "content": "Hello, World!" }
``` 

**Examples:**
```bash
# Default greeting
curl [http://localhost:8080/greeting](http://localhost:8080/greeting)
# Response:
# {"id":1,"content":"Hello, World!"}
# Custom greeting
curl [http://localhost:8080/greeting?name=Alice](http://localhost:8080/greeting?name=Alice)
# Response:
# {"id":2,"content":"Hello, Alice!"}
``` 

### Actuator Endpoints

Spring Boot Actuator endpoints are available at `/actuator`:
```bash
# Health check
curl [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
# Application info
curl [http://localhost:8080/actuator/info](http://localhost:8080/actuator/info)
```

## 🔨 Building the Project

### Build JAR
```bash 
./mvnw clean package
``` 

The executable JAR will be created in the `target/` directory:
```bash 
java -jar target/greeting-app-0.0.8.jar
``` 

### Run Tests
```bash
# Run all tests
./mvnw test
# Run only integration tests
./mvnw verify
# Run with coverage
./mvnw clean test jacoco:report
``` 

### Static Analysis

The project uses SpotBugs for static code analysis:
```bash 
./mvnw spotbugs:check
``` 

## 📦 GitHub Packages

This project is configured to publish to GitHub Packages. Packages are automatically published when a new release is created.

## 🛠️ Technologies Used

- **Spring Boot 4.0.0-SNAPSHOT** - Application framework
- **Spring Web MVC** - REST API development
- **Spring Modulith** - Modular monolithic architecture
- **Spring Boot Actuator** - Production-ready features
- **Spring Boot DevTools** - Development-time enhancements
- **Lombok** - Reduce boilerplate code
- **Jackson** - JSON serialization/deserialization
- **JUnit 5** - Testing framework
- **Maven** - Build and dependency management
- **SpotBugs** - Static code analysis
- **Java 21** - Programming language

## 🧪 Testing

The project includes comprehensive test coverage:

- **Unit Tests**: Fast, isolated tests for individual components
- **Integration Tests**: Tests that verify the application works correctly when fully assembled

Test files:
- `ApplicationTests.java` - Context loading tests
- `GreetingRestControllerIT.java` - REST endpoint integration tests

## 🔧 Development

### Hot Reload

The project includes Spring Boot DevTools for automatic restart during development:

```bash
./mvnw spring-boot:run
```

Make changes to your code, and the application will automatically restart.

### Configuration

Application properties can be configured in : `src/main/resources/application.properties`
```properties
# Server port (default: 8080)
server.port=8080

# Actuator endpoints
management.endpoints.web.exposure.include=health,info
```

## 🤝 Contributing
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License
This project is a boilerplate/template project. Use it as you wish, but please don't forget to give credit to the original author.

## 👤 Author
**Bjorklund Labs**
- GitHub: [@petbjo1](https://github.com/petbjo1)

## 🙏 Acknowledgments
- Spring Boot team for the excellent framework
- Spring Modulith for modular architecture support
- The open-source community

**Note**: This project uses Spring Boot 4.0.0-SNAPSHOT, which is a development version. For production use, consider using a stable release version.
