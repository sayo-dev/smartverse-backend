# SmartVert Backend

SmartVert Backend is a Java Spring Boot service designed for solar panel, battery capacity, and inverter size load calculations.

---

## Technical Stack

- **Java Version:** 21+ (configured with Java 25 in `pom.xml`)
- **Framework:** Spring Boot 3.x / 4.x (`spring-boot-starter-parent` v4.1.0 in `pom.xml`)
- **Database:** PostgreSQL
- **Build Tool:** Maven

---

## Project Structure

```
smartverse-backend/
├── .env                             # Environment configuration (git-ignored)
├── .env.example                     # Sample environment configuration template
├── docker-compose.yml               # PostgreSQL service definition
├── pom.xml                          # Maven build dependencies
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/smartvert/smartvert/
│   │   │       ├── SmartVertApplication.java   # Application main class
│   │   │       ├── config/                      # Application configuration beans
│   │   │       ├── controller/                  # REST controllers
│   │   │       ├── exception/                   # Global exception handling
│   │   │       ├── mapper/                      # Entity/DTO mappers
│   │   │       ├── model/                       # Data entities & DTOs
│   │   │       ├── repository/                  # JPA repositories
│   │   │       ├── security/                    # Security & auth filters
│   │   │       ├── service/                     # Business logic & sizing engine
│   │   │       └── util/                        # Utility helper functions
│   │   └── resources/
│   │       └── application.yml                  # Spring Boot configuration
│   └── test/                                    # Unit and integration tests
```

---

## Environment Configuration (`.env.example`)

The backend relies on the following environment variables (imported automatically via `application.yml`):

```env
DB_USER=db_user
DB_PASSWORD=db_password
DB_NAME=db_name
DB_PORT=db_port
```

---

## Getting Started

### Prerequisites

- JDK 21+
- Maven 3.9+ (or `./mvnw`)
- Docker & Docker Compose

### Running Locally

1. **Configure Environment Variables:**
   ```bash
   cp .env.example .env
   ```

2. **Start Database Container:**
   ```bash
   docker-compose up -d
   ```

3. **Start Spring Boot Application:**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Verify Application:**
   The backend will start on `http://localhost:8080`.
