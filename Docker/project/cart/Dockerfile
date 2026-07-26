# --- Stage 1: Build & Dependencies ---
FROM node:20.20.2-alpine3.22 AS builder
WORKDIR /app

# 1. Copy ONLY package.json first
COPY package.json ./

# 2. Download dependencies (cached as long as package.json doesn't change)
RUN npm install

# 3. Copy application JavaScript source code AFTER dependencies
COPY *.js ./


# --- Stage 2: Runtime ---
FROM node:20.20.2-alpine3.22
WORKDIR /app

# 1. Create system group and non-root user
RUN addgroup -S roboshop && adduser -S -G roboshop roboshop

# 2. Copy application files from builder AND set user permissions in one step
COPY --chown=roboshop:roboshop --from=builder /app /app

# 3. Switch to non-root user for security
USER roboshop

EXPOSE 8080

# 4. Entrypoint + CMD combination
ENTRYPOINT ["node"]
CMD ["server.js"]
