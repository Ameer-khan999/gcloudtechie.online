FROM almalinux:9

# 1. Combine installation and setup to save layer space
RUN dnf install nginx -y && \
    mkdir /app && \
    useradd ameer && \
    rm -rf /usr/share/nginx/html/*

LABEL Author="Ameer Khan"

# Giving Aruguments
ARG course="docker-tutorials for NOOBS"

#Assigning aruguments ENV
ENV course_name=${course}

# Copying html file
COPY index.html /usr/share/nginx/html

ADD https://raw.githubusercontent.com/Ameer-khan999/gcloudtechie.online/main/Docker/docker.md /tmp/
ADD sample-1.tar /tmp/

#someone can use this image as their base image but they need to keep files in src folder
ONBUILD COPY src/ /usr/share/nginx/html/

# This is just let to know others that nginx is runnung on port 80
EXPOSE 80

# to enable and start nginx service
CMD ["nginx", "-g", "daemon off;"]
