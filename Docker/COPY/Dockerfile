# Stage 1: Prep files
FROM nginx:alpine AS builder
WORKDIR /app
COPY index.html .

# Stage 2: Runtime Image
FROM nginx:alpine
# Chaining RUN commands prevents cached files from persisting in earlier layers
RUN rm -rf /usr/share/nginx/html/*

COPY --from=builder /app/index.html /usr/share/nginx/html/

EXPOSE 80

#CMD ["nginx", "-g", "daemon off;"]
