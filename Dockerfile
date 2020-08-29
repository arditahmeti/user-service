FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY /target/userservice.jar userservice.jar
ENTRYPOINT ["java","-jar","/userservice.jar"]