# Team Collaboration API

A Spring Boot REST API for team collaboration with user authentication, team management, and project tracking.

## Tech Stack

- Spring Boot 3.5.4
- Java 21
- PostgreSQL
- Redis
- JWT Authentication
- Maven

## Quick Start

1. **Clone the repository**
```bash
git clone <repository-url>
cd team-collaboration-api
```

2. **Configure database**
Create `application-dev.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/team_collab
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the application**
```bash
./mvnw spring-boot:run
```

4. **Access the API**
- Base URL: `http://localhost:8080`
- Health Check: `http://localhost:8080/actuator/health`

## Features

- User registration and authentication
- Team creation and management
- Project and task tracking
- Role-based access control

## Author

Michael Ackerman 