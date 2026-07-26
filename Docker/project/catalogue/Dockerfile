# --- Stage 1: Build & Dependencies ---
FROM node:20.20.2-alpine3.22 AS builder
WORKDIR /app

# 1. Copy package.json FIRST to preserve layer cache
COPY package.json ./

# 2. Download dependencies (only re-runs if package.json changes)
RUN npm install

# 3. Copy application JavaScript source files AFTER dependencies
COPY *.js ./


# --- Stage 2: Runtime ---
FROM node:20.20.2-alpine3.22
WORKDIR /app

# Environment variables for MongoDB connection
ENV MONGO="true" \
    MONGO_URL="mongodb://mongodb:27017/catalogue"

# Create system group and non-root user
RUN addgroup -S roboshop && adduser -S -G roboshop roboshop

# Copy build artifacts AND set file ownership to 'roboshop' in one step
COPY --chown=roboshop:roboshop --from=builder /app /app

# Switch to non-root user for runtime security
USER roboshop

EXPOSE 8080

# Flexible entrypoint + default execution target
ENTRYPOINT ["node"]
CMD ["server.js"]
