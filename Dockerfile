FROM maven:3.9.10-eclipse-temurin-17-alpine

RUN addgroup -g 1000 -S maven && \
    adduser -u 1000 -S maven -G maven -h /home/maven -s /bin/sh

USER maven