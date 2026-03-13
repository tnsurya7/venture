# VDF Backend - Spring Boot API

A robust Spring Boot backend application for the Venture Debt Fund (VDF) portal providing comprehensive REST APIs for managing venture debt fund applications through SIDBI (Small Industries Development Bank of India).

## 🚀 Quick Start

### Prerequisites
- **Java 21** (LTS recommended)
- **Maven 3.8+** for build management
- **PostgreSQL 12+** for production database

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/tnsurya7/venture.git
   cd venture/vdf-backend
   ```

2. **Configure Database:**
   ```bash
   # For development with PostgreSQL
   createdb vdfdb
   ```

3. **Build the application:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   # Development mode
   mvn spring-boot:run

   # Or with specific profile
   mvn spring-boot:run -Dspring-boot.run.profiles=dev
   ```

5. **Access the application:**
   - Backend API: http://localhost:8081
   - Swagger UI: http://localhost:8081/swagger-ui.html
   - API Docs: http://localhost:8081/v3/api-docs

### Demo Users (Password: "password")
- `applicant@demo.com` - Applicant role
- `sidbi-maker@demo.com` - SIDBI Maker
- `sidbi-checker@demo.com` - SIDBI Checker
- `sidbi-convenor@demo.com` - SIDBI Convenor
- `sidbi-committee@demo.com` - Committee Member
- `sidbi-approving@demo.com` - Approving Authority
- `admin@demo.com` - Admin role

## 🛠️ Tech Stack

### Core Framework
- **Spring Boot 3.2.5** - Java application framework with auto-configuration
- **Java 21** - Latest LTS Java version with modern language features
- **Maven 3.8+** - Build and dependency management

### Security & Authentication
- **Spring Security 6.x** - Comprehensive security framework
- **JWT (JJWT 0.12.5)** - JSON Web Token implementation for stateless authentication
- **BCrypt** - Password hashing algorithm

### Database & Persistence
- **Spring Data JPA** - Data persistence layer with repository pattern
- **Hibernate** - Object-relational mapping (ORM) framework
- **PostgreSQL** - Production-grade relational database
- **Flyway** - Database migration and versioning (optional)

### Validation & Documentation
- **Spring Boot Validation** - Bean validation with Hibernate Validator
- **SpringDoc OpenAPI 2.5.0** - OpenAPI 3 specification generation
- **Swagger UI** - Interactive API documentation interface

### Development & Testing
- **Lombok 1.18.30** - Boilerplate code reduction through annotations
- **Spring Boot DevTools** - Development-time utilities for hot reloading
- **Spring Boot Test** - Comprehensive testing framework
- **JUnit 5** - Unit testing framework

### Build & Deployment
- **Maven Compiler Plugin 3.13.0** - Java compilation with annotation processing
- **Spring Boot Maven Plugin** - Application packaging and execution

## 📁 Project Structure

```
vdf-backend/
├── src/main/java/com/sidbi/vdf/
│   ├── config/                 # Configuration classes
│   │   ├── SecurityConfig.java     # Spring Security configuration
│   │   ├── JwtProperties.java      # JWT configuration properties
│   │   ├── CorsConfig.java         # CORS configuration
│   │   ├── OpenApiConfig.java      # API documentation configuration
│   │   └── DataLoader.java         # Demo data seeding
│   ├── domain/                 # Entity classes (JPA entities)
│   │   ├── UserAccount.java        # User entity
│   │   ├── Application.java        # Application entity
│   │   ├── Registration.java       # Registration entity
│   │   ├── CommitteeMeeting.java   # Meeting entity
│   │   └── enums/                  # Enumeration classes
│   │       ├── UserType.java
│   │       ├── SidbiRole.java
│   │       ├── WorkflowStep.java
│   │       └── WorkflowAction.java
│   ├── repository/             # Data access layer (Spring Data JPA)
│   │   ├── UserAccountRepository.java
│   │   ├── ApplicationRepository.java
│   │   ├── RegistrationRepository.java
│   │   └── CommitteeMeetingRepository.java
│   ├── service/                # Business logic services
│   │   ├── AuthService.java        # Authentication service
│   │   ├── ApplicationService.java # Application management
│   │   ├── RegistrationService.java # Registration management
│   │   ├── WorkflowEngine.java     # Workflow state management
│   │   └── FileStorageService.java # File upload/download
│   ├── web/                    # REST controllers
│   │   ├── ApplicationController.java
│   │   ├── RegistrationController.java
│   │   ├── CommitteeMeetingController.java
│   │   └── dto/                    # Data Transfer Objects
│   │       ├── WorkflowActionRequest.java
│   │       └── WorkflowActionResponse.java
│   ├── security/               # Security components
│   │   ├── AuthController.java     # Authentication endpoints
│   │   ├── AuthService.java        # Authentication logic
│   │   ├── JwtTokenProvider.java   # JWT token management
│   │   ├── JwtAuthenticationFilter.java # JWT filter
│   │   └── dto/                    # Security DTOs
│   │       ├── LoginRequest.java
│   │       ├── LoginResponse.java
│   │       └── AuthSessionDto.java
│   └── exception/              # Exception handling
│       ├── GlobalExceptionHandler.java
│       └── ApiError.java
├── src/main/resources/
│   ├── application.yml         # Main configuration
│   ├── application-dev.yml     # Development configuration
│   └── db/migration/           # Database migration scripts
│       ├── V1__schema.sql
│       ├── V2__seed_users.sql
│       └── V3__application_file.sql
├── src/test/                   # Test classes
├── pom.xml                     # Maven dependencies and build configuration
└── docs/                       # Documentation
    ├── APPROACH_REVIEW.md
    └── workflow-state-machine.md
```

## 🎯 Key Features

### Authentication & Authorization
- **JWT-based Authentication**: Stateless authentication using JSON Web Tokens
- **Role-based Access Control**: Fine-grained permissions based on user roles
- **Password Security**: BCrypt hashing with salt for secure password storage
- **Token Management**: Automatic token refresh and expiration handling

### Application Management
- **Preliminary Applications**: Initial application submission and review
- **Detailed Applications**: Comprehensive application processing with:
  - Capital table validation
  - Financial data management
  - Document upload and storage
  - Multi-stage approval workflow
- **Application Lifecycle**: Complete workflow from submission to approval
- **Audit Trail**: Comprehensive logging of all application changes

### Workflow Engine
- **State Machine**: Robust workflow state management
- **Workflow Actions**: Predefined actions for application processing:
  - `approve_prelim` - Approve preliminary application
  - `reject_prelim` - Reject preliminary application
  - `revert_prelim` - Revert to applicant for changes
  - `recommend_pursual` - Recommend for further processing
  - `recommend_rejection` - Recommend rejection
  - `recommend_icvd` - Forward to ICVD committee
  - `recommend_ccic` - Forward to CCIC committee
  - `approve_sanction` - Final approval and sanction
- **Assignment Management**: Assign applications to specific reviewers
- **Comment System**: Field-level and global comments

### Committee Management
- **Meeting Scheduling**: ICVD and CCIC committee meeting management
- **Voting System**: Committee member voting on applications
- **Meeting Minutes**: Comprehensive meeting documentation
- **Agenda Management**: Meeting agenda creation and management

### Document Management
- **File Upload**: Secure file upload with validation
- **File Storage**: Organized file storage with metadata
- **Document Types**: Support for multiple document categories
- **File Security**: Access control for uploaded documents

### User Management
- **Registration System**: Enterprise registration with admin approval
- **User Roles**: Multiple user types (applicant, SIDBI staff, admin)
- **Profile Management**: User profile and settings management
- **Account Management**: Enable/disable user accounts

## 🔌 API Endpoints

### Authentication APIs
```http
POST /api/auth/login          # User login
POST /api/auth/logout         # User logout
GET  /api/auth/me            # Get current user info
POST /api/auth/refresh       # Refresh JWT token
```

### Registration APIs
```http
GET  /api/registrations      # List all registrations (admin)
POST /api/registrations      # Submit new registration
PUT  /api/registrations/{id} # Update registration status
DELETE /api/registrations/{id} # Delete registration
```

### Application APIs
```http
GET  /api/applications       # List applications (filtered by role)
GET  /api/applications/{id}  # Get application details
POST /api/applications       # Create preliminary application
PUT  /api/applications/{id}/prelim # Update preliminary data
PUT  /api/applications/{id}/detailed # Submit detailed application
DELETE /api/applications/{id} # Delete application
```

### Workflow APIs
```http
POST /api/applications/{id}/actions # Perform workflow action
GET  /api/applications/{id}/audit   # Get audit trail
POST /api/applications/{id}/comments # Add comments
```

### Document APIs
```http
GET  /api/applications/{id}/documents # List documents
POST /api/applications/{id}/documents # Upload document
GET  /api/documents/{id}/download     # Download document
DELETE /api/documents/{id}            # Delete document
```

### Committee Meeting APIs
```http
GET  /api/meetings           # List committee meetings
POST /api/meetings           # Create new meeting
PUT  /api/meetings/{id}      # Update meeting details
POST /api/meetings/{id}/votes # Submit committee vote
GET  /api/meetings/{id}/agenda # Get meeting agenda
```

### User Management APIs
```http
GET  /api/users              # List users (admin)
POST /api/users              # Create new user
PUT  /api/users/{id}         # Update user details
DELETE /api/users/{id}       # Delete user
PUT  /api/users/{id}/status  # Enable/disable user
```

## 🔧 Configuration

### Database Configuration

#### PostgreSQL (Production)
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/vdfdb
    username: ${DB_USERNAME:vdfuser}
    password: ${DB_PASSWORD:vdfpassword}
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: validate
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    properties:
      hibernate:
        default_schema: public
```

#### Development Configuration
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/vdfdb_dev
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:password}
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

### JWT Configuration
```yaml
jwt:
  secret: ${JWT_SECRET:your-256-bit-secret-key-here}
  expiration: ${JWT_EXPIRATION:86400000} # 24 hours
  refresh-expiration: ${JWT_REFRESH_EXPIRATION:604800000} # 7 days
```

### Server Configuration
```yaml
server:
  port: ${SERVER_PORT:8081}
  servlet:
    context-path: /api

logging:
  level:
    com.sidbi.vdf: ${LOG_LEVEL:INFO}
    org.springframework.security: WARN
    org.hibernate.SQL: ${SQL_LOG_LEVEL:WARN}
```

### File Upload Configuration
```yaml
spring:
  servlet:
    multipart:
      max-file-size: 25MB
      max-request-size: 25MB

app:
  file-storage:
    upload-dir: ${FILE_UPLOAD_DIR:./uploads}
    allowed-types: pdf,doc,docx,xls,xlsx,jpg,jpeg,png
```

## 🔒 Security Features

### Authentication Security
- **JWT Tokens**: Stateless authentication with configurable expiration
- **Password Hashing**: BCrypt with configurable strength
- **Token Refresh**: Automatic token refresh mechanism
- **Session Management**: Stateless session management

### Authorization
- **Role-based Access Control**: Method-level security with role checks
- **Resource Protection**: Endpoint protection based on user roles
- **Data Filtering**: Role-based data filtering in repositories

### Data Security
- **Input Validation**: Comprehensive input validation with Bean Validation
- **SQL Injection Prevention**: Parameterized queries with JPA
- **XSS Protection**: Input sanitization and output encoding
- **CORS Configuration**: Configurable CORS policies

### File Security
- **File Type Validation**: Whitelist-based file type checking
- **File Size Limits**: Configurable file size restrictions
- **Secure File Storage**: Organized file storage with access controls
- **Virus Scanning**: Integration points for virus scanning (configurable)

## 🧪 Testing

### Running Tests
```bash
# Run all tests
mvn test

# Run tests with coverage
mvn test jacoco:report

# Run integration tests
mvn integration-test

# Run specific test class
mvn test -Dtest=ApplicationServiceTest

# Run tests with specific profile
mvn test -Dspring.profiles.active=test
```

### Test Configuration
```yaml
# application-test.yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
  jpa:
    hibernate:
      ddl-auto: create-drop
  test:
    database:
      replace: none
```

### Testing Strategy
- **Unit Tests**: Service layer testing with mocked dependencies
- **Integration Tests**: Repository layer testing with test database
- **Web Layer Tests**: Controller testing with MockMvc
- **Security Tests**: Authentication and authorization testing

## 🚀 Build & Deployment

### Development Build
```bash
mvn clean compile          # Compile source code
mvn clean package         # Create JAR file
mvn spring-boot:run       # Run application
```

### Production Build
```bash
# Create production JAR
mvn clean package -Dmaven.test.skip=true

# Run production JAR
java -jar target/vdf-backend-1.0.0-SNAPSHOT.jar --spring.profiles.active=prod
```

### Docker Deployment
```dockerfile
# Multi-stage Dockerfile
FROM maven:3.9-openjdk-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/vdf-backend-1.0.0-SNAPSHOT.jar app.jar

# Create non-root user
RUN addgroup --system spring && adduser --system spring --ingroup spring
USER spring:spring

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### Docker Compose
```yaml
version: '3.8'
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: vdfdb
      POSTGRES_USER: vdfuser
      POSTGRES_PASSWORD: vdfpassword
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  vdf-backend:
    build: .
    ports:
      - "8081:8081"
    environment:
      DB_USERNAME: vdfuser
      DB_PASSWORD: vdfpassword
      JWT_SECRET: your-production-secret-key
    depends_on:
      - postgres

volumes:
  postgres_data:
```

## 🔍 Performance Optimization

### Database Optimization
- **Connection Pooling**: HikariCP connection pool configuration
- **Query Optimization**: Optimized JPA queries with proper indexing
- **Lazy Loading**: Strategic lazy loading for entity relationships
- **Pagination**: Efficient pagination for large datasets

### Caching Strategy
```java
@Configuration
@EnableCaching
public class CacheConfig {
    
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.MINUTES));
        return cacheManager;
    }
}
```

### Application Performance
- **Async Processing**: Asynchronous processing for heavy operations
- **Batch Operations**: Batch processing for bulk operations
- **Resource Management**: Proper resource cleanup and management

## 🐛 Troubleshooting

### Common Issues

#### Database Connection Issues
```bash
# Check PostgreSQL status
sudo systemctl status postgresql

# Test database connection
psql -h localhost -U vdfuser -d vdfdb

# Check application logs
tail -f logs/application.log
```

#### JWT Token Issues
```bash
# Verify JWT secret configuration
echo $JWT_SECRET

# Check token expiration in logs
grep "JWT" logs/application.log
```

#### Build Issues
```bash
# Clean and rebuild
mvn clean install -U

# Skip tests if needed
mvn clean install -DskipTests

# Check Java version
java -version
mvn -version
```

### Debug Configuration
```yaml
# application-debug.yml
logging:
  level:
    com.sidbi.vdf: DEBUG
    org.springframework.security: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

spring:
  jpa:
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        use_sql_comments: true
```

## 📊 Monitoring & Observability

### Health Checks
```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      show-details: always
```

### Metrics Collection
```java
@Component
public class ApplicationMetrics {
    
    private final MeterRegistry meterRegistry;
    private final Counter applicationSubmissions;
    
    public ApplicationMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        this.applicationSubmissions = Counter.builder("applications.submitted")
            .description("Number of applications submitted")
            .register(meterRegistry);
    }
}
```

## 📚 Additional Resources

### Documentation
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)

### Development Tools
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) - Recommended IDE
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.devtools)
- [Postman](https://www.postman.com/) - API testing
- [DBeaver](https://dbeaver.io/) - Database management

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines
- Follow Java coding standards and best practices
- Write comprehensive unit and integration tests
- Update documentation for new features
- Use conventional commit messages
- Ensure all tests pass before submitting PR

### Code Style
- Use Google Java Style Guide
- Configure IDE with provided code style settings
- Run `mvn spotless:apply` to format code
- Use meaningful variable and method names

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](../LICENSE) file for details.

---

**Backend Version**: 1.0.0  
**Last Updated**: March 2026  
**Status**: Production Ready ✅