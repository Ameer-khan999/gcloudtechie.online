FROM almalinux:9

# 1. Combine installation and setup to save layer space
RUN dnf install nginx -y && \
    mkdir /app && \
    useradd ameer && \
    rm -rf /usr/share/nginx/html/*

LABEL Author="Ameer Khan"

# 2. Fixed variable names (no hyphens)
ARG course="docker-tutorials for NOOBS"
ENV course_name=${course}

# 3. Copy files (Assumes index.html and sample-1.tar are in your build context)
COPY index.html /usr/share/nginx/html/

# 4. Fixed GitHub link to pull the RAW file, not the webpage UI
ADD https://raw.githubusercontent.com/Ameer-khan999/gcloudtechie.online/main/Docker/docker.md /tmp/
ADD sample-1.tar /tmp/

ONBUILD COPY src/ /usr/share/nginx/html/

EXPOSE 80

# 5. Kept Nginx running as root so it can bind to Port 80 seamlessly
# (Removed ENTRYPOINT ping so Nginx can actually boot)
CMD ["nginx", "-g", "daemon off;"]
