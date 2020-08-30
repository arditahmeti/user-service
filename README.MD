# User Service With Spring Boot Framework REST API.

## Requirements for building and running the application

- JDK >= 1.8
- Docker

## Application Build and Run

```
mvn clean install
```

Build the user service container: 

```
docker build -t user-service .
```

Run postgres and user service containers as detached:

```
docker-compose up -d
```

## Then finally test the application
Go to [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) to see the documentation.