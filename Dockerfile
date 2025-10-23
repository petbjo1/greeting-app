# Dockerfile (minimal working)
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package
FROM eclipse-temurin:21-jre

# Install curl (and clean up to keep image small)
RUN apt-get update && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

HEALTHCHECK CMD curl --fail http://localhost:8080/health
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]