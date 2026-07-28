bad practise

FROM maven:3.9.16 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package && \
    mv target/shipping-1.0.jar shipping.jar 

# Java is portable not OS dependent, application built in windows can run in Linux
FROM eclipse-temurin:17-jre-alpine
EXPOSE 8080
WORKDIR /app
RUN addgroup -S roboshop && adduser -S -G roboshop roboshop && \
    chown -R roboshop:roboshop /app
COPY --from=builder /app/shipping.jar .
USER roboshop
CMD ["java", "-jar", "shipping.jar"]

# FROM maven:3.9.16 
# WORKDIR /app
# COPY pom.xml .
# COPY src ./src
# RUN mvn clean package 
# RUN mv target/shipping-1.0.jar shipping.jar 
# EXPOSE 8080
# CMD ["java", "-jar", "shipping.jar"]

------------------------------------------

$ Best Practise

# --- Stage 1: Build Stage ---
FROM maven:3.9.9-eclipse-temurin-17 AS builder
WORKDIR /app

# Step 1: Copy pom.xml and resolve dependencies for layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Step 2: Copy source code and build final JAR
COPY src ./src
RUN mvn package -DskipTests && \
    mv target/shipping-1.0.jar shipping.jar

# --- Stage 2: Runtime Stage ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Create non-root user for security
RUN addgroup -S roboshop && adduser -S roboshop -G roboshop

# Copy compiled artifact with correct ownership directly
COPY --chown=roboshop:roboshop --from=builder /app/shipping.jar /app/shipping.jar

USER roboshop
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "shipping.jar"]