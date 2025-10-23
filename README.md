# Greeting App 👋

[![Maven Package](https://github.com/petbjo1/greeting-app/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/petbjo1/greeting-app/actions/workflows/maven-publish.yml)
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

- **\*Tests**: Fast, isolated tests for individual components
- **\*IntegrationTests**: Tests that verify the application works correctly when fully assembled

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

## 🚀 CI/CD Pipeline

This project uses **GitHub Actions** for continuous integration and deployment. The CI/CD pipeline is fully automated and consists of three main workflows:

### 📋 Workflows

#### 1. **Maven Package** (`maven-publish.yml`)
[![Maven Package](https://github.com/petbjo1/greeting-app/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/petbjo1/greeting-app/actions/workflows/maven-publish.yml)

Triggered on: **Release creation**

This workflow:
- Builds the project with Maven
- Runs all tests
- Publishes the Maven package to **GitHub Packages**

#### 2. **Auto Bump Maven Version** (`maven-version.yml`)
Triggered on: **Git tags** matching pattern `v*.*.*`

This workflow:
- Extracts the version from the git tag (e.g., `v0.0.8` → `0.0.8`)
- Updates the Maven `pom.xml` version automatically
- Commits the version change back to the default branch

#### 3. **Build & Push Docker Image** (`docker-push.yml`)
Triggered on: **Release creation**

This workflow:
- Builds a Docker image using the multi-stage Dockerfile
- Pushes the image to **GitHub Container Registry** (ghcr.io)
- Tags the image as `latest`

### 🌐 Deployment

The Docker image is **automatically deployed** to [Render](https://render.com) whenever a new release is created.

**Live Application**: [https://greeting-app-22fn.onrender.com/greeting](https://greeting-app-22fn.onrender.com/greeting)

#### Try it out:
```bash
curl https://peters-greeting-app.onrender.com/greeting
```
# Get custom greeting
```bash
curl https://peters-greeting-app.onrender.com/greeting?name=YourName
```
# Health check

```bash
curl https://peters-greeting-app.onrender.com/health
```
### 🔄 Release Process
To create a new release and trigger the full CI/CD pipeline:
1. **Create and push a version tag:**

```bash
   git tag v0.0.9
   git push origin v0.0.9
```
1. **Create a GitHub Release:**
    - Go to the [Releases](https://github.com/petbjo1/greeting-app/releases) page
    - Click "Create a new release"
    - Select the tag you just created
    - Add release notes
    - Publish the release

2. **Automated steps that follow:**
    - ✅ Maven version is updated in `pom.xml`
    - ✅ Project is built and tested
    - ✅ Maven package is published to GitHub Packages
    - ✅ Docker image is built and pushed to GitHub Container Registry
    - ✅ Application is automatically deployed to Render

### 🐳 Docker Image
The Docker image is available at:
```bash
ghcr.io/petbjo1/greeting-app:latest
```
Pull and run locally:
```bash
docker pull ghcr.io/petbjo1/greeting-app:latest
docker run -p 8080:8080 ghcr.io/petbjo1/greeting-app:latest
```

## 👤 Author
**Björklund Labs**
- GitHub: [@petbjo1](https://github.com/petbjo1)

## 🙏 Acknowledgments
- Spring Boot team for the excellent framework
- Spring Modulith for modular architecture support
- The open-source community

**Note**: This project uses Spring Boot 4.0.0-SNAPSHOT, which is a development version. For production use, consider using a stable release version.
