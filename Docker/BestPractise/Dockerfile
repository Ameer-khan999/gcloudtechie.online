# STAGE 1: Build Stage (Uses heavy JDK + Maven to build the .jar file)
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /app

# Copy dependency configs first to utilize Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code and build the executable JAR
COPY src ./src
RUN mvn clean package -DskipTests

# -------------------------------------------------------------------

# STAGE 2: Runtime Stage (Switches to a lightweight JRE image)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy ONLY the compiled .jar file from Stage 1
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
