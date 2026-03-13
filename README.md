# VDF (Venture Debt Fund) - SIDBI Application Portal

A comprehensive web application for managing venture debt fund applications through SIDBI (Small Industries Development Bank of India). The system provides a complete workflow from application submission to approval with role-based access control.

## 🏗️ Architecture Overview

```
┌─────────────────┐    HTTP/REST    ┌─────────────────┐
│   Frontend      │ ◄──────────────►│   Backend       │
│   React + TS    │                 │   Spring Boot   │
│   Port: 8080    │                 │   Port: 8081    │
└─────────────────┘                 └─────────────────┘
                                            │
                                            ▼
                                    ┌─────────────────┐
                                    │   Database      │
                                    │   H2/PostgreSQL │
                                    └─────────────────┘
```

## 🚀 Quick Start

### Prerequisites
- **Java 21** (for backend)
- **Node.js 18+** (for frontend)
- **Maven 3.8+** (for backend build)

### Running the Applications

1. **Clone the repositories:**
   ```bash
   git clone https://github.com/Gururagavendran/RTK-VDF-SIDBI.git
   git clone https://github.com/Gururagavendran/vdf-backend.git
   ```

2. **Start Backend (Spring Boot):**
   ```bash
   cd vdf-backend
   export JAVA_HOME=/path/to/java-21
   mvn spring-boot:run -Dspring-boot.run.profiles=h2
   ```
   - Backend runs on: http://localhost:8081
   - H2 Console: http://localhost:8081/h2-console

3. **Start Frontend (React):**
   ```bash
   cd RTK-VDF-SIDBI
   npm install
   npm run dev
   ```
   - Frontend runs on: http://localhost:8080

### Demo Users (Password: "password")
- `applicant@demo.com` - Applicant role
- `sidbi-maker@demo.com` - SIDBI Maker
- `sidbi-checker@demo.com` - SIDBI Checker
- `sidbi-convenor@demo.com` - SIDBI Convenor
- `sidbi-committee@demo.com` - Committee Member
- `sidbi-approving@demo.com` - Approving Authority
- `admin@demo.com` - Admin role

## 🎯 Features

### 👤 User Management
- **Registration System**: Enterprise registration with validation
- **Authentication**: JWT-based secure login
- **Role-Based Access**: Different dashboards for different user types
- **Profile Management**: User profile and settings

### 📋 Application Management

#### Preliminary Application
- Company profile and basic information
- Financial highlights
- Business model description
- Document upload support
- Draft saving functionality

#### Detailed Application
- **Capital Table**: Shareholder information with validation
- **Financial Performance**: Multi-year financial data entry
- **Revenue Trends**: Monthly revenue tracking
- **Unit Economics**: Detailed unit economics grid
- **Facilities Information**: Current borrowings and facilities
- **Associate Concerns**: Related entity facilities
- **Funding Requirements**: SIDBI funding details
- **Compliance Checks**: Eligibility verification
- **Document Management**: Multiple document uploads
- **Digital Signatures**: Applicant and AIF signatures

### 🔄 Workflow Management

#### Application Stages
1. **Preliminary Review**
   - Maker review and approval
   - Rejection with comments
   - Reversion for corrections

2. **Detailed Review**
   - Maker assessment
   - Checker verification
   - Convenor scheduling
   - Committee review

3. **Committee Meetings**
   - ICVD (Investment Committee for Venture Debt)
   - CCIC (Credit Committee for Investment Committee)
   - Meeting scheduling and management
   - Voting system

4. **Final Approval**
   - Sanction letter generation
   - Final approval workflow
   - Post-sanction management

#### Workflow Actions
- `approve_prelim` - Approve preliminary application
- `reject_prelim` - Reject preliminary application
- `revert_prelim` - Revert to applicant for changes
- `recommend_pursual` - Recommend for further processing
- `recommend_rejection` - Recommend rejection
- `recommend_icvd` - Forward to ICVD committee
- `recommend_ccic` - Forward to CCIC committee
- `approve_sanction` - Final approval and sanction

### 📊 Dashboard Features

#### Applicant Dashboard
- Application status tracking
- Document management
- Communication history
- Action items and notifications

#### SIDBI Dashboard
- Application queue management
- Role-based filtering
- Bulk actions
- Performance metrics
- Assignment management

#### Admin Dashboard
- User registration approvals
- System configuration
- Audit trail management
- Report generation

### 📄 Document Management
- Multiple file format support (PDF, DOC, XLS, Images)
- File size validation (max 25MB)
- Document categorization
- Version control
- Secure file storage

### 🔍 Advanced Features
- **Search & Filter**: Advanced application filtering
- **Audit Trail**: Complete action history
- **Comments System**: Field-level and global comments
- **Notifications**: Real-time status updates
- **Export Functionality**: Data export capabilities
- **Responsive Design**: Mobile-friendly interface

## 🛠️ Tech Stack

### Frontend (RTK-VDF-SIDBI)

#### Core Technologies
- **React 18.3.1** - UI library with hooks and functional components
- **TypeScript 5.6.2** - Type-safe JavaScript
- **Vite 5.4.19** - Fast build tool and dev server

#### State Management
- **Redux Toolkit (RTK) 2.3.0** - Predictable state container
- **RTK Query** - Data fetching and caching
- **React Hook Form 7.54.0** - Form state management
- **Zod 3.23.8** - Schema validation

#### UI Framework
- **shadcn/ui** - Modern component library
- **Tailwind CSS 3.4.17** - Utility-first CSS framework
- **Radix UI** - Headless UI primitives
- **Lucide React 0.468.0** - Icon library

#### Routing & Navigation
- **React Router DOM 6.28.0** - Client-side routing
- **React Router** - Navigation management

#### Utilities
- **date-fns 4.1.0** - Date manipulation
- **clsx 2.1.1** - Conditional className utility
- **class-variance-authority** - Component variants

#### Development Tools
- **ESLint** - Code linting
- **TypeScript ESLint** - TypeScript-specific linting
- **Vite TypeScript** - TypeScript integration

### Backend (vdf-backend)

#### Core Framework
- **Spring Boot 3.2.5** - Java application framework
- **Java 21** - Latest LTS Java version
- **Maven 3.8+** - Build and dependency management

#### Security
- **Spring Security 6.x** - Authentication and authorization
- **JWT (JJWT 0.12.5)** - JSON Web Token implementation
- **BCrypt** - Password hashing

#### Database
- **Spring Data JPA** - Data persistence layer
- **Hibernate** - ORM framework
- **H2 Database** - In-memory database (development)
- **PostgreSQL** - Production database support
- **Flyway** - Database migration (optional)

#### Validation & Documentation
- **Spring Boot Validation** - Input validation
- **SpringDoc OpenAPI 2.5.0** - API documentation
- **Swagger UI** - Interactive API documentation

#### Development Tools
- **Lombok 1.18.30** - Boilerplate code reduction
- **Spring Boot DevTools** - Development utilities
- **Spring Boot Test** - Testing framework

#### Build & Deployment
- **Maven Compiler Plugin 3.13.0** - Java compilation
- **Spring Boot Maven Plugin** - Application packaging

## 🔌 API Endpoints

### Authentication APIs
```
POST /api/auth/login          - User login
POST /api/auth/logout         - User logout
GET  /api/auth/me            - Get current user info
POST /api/auth/refresh       - Refresh JWT token
```

### Registration APIs
```
GET  /api/registrations      - List all registrations (admin)
POST /api/registrations      - Submit new registration
PUT  /api/registrations/{id} - Update registration status
DELETE /api/registrations/{id} - Delete registration
```

### Application APIs
```
GET  /api/applications       - List applications (filtered by role)
GET  /api/applications/{id}  - Get application details
POST /api/applications       - Create preliminary application
PUT  /api/applications/{id}/prelim - Update preliminary data
PUT  /api/applications/{id}/detailed - Submit detailed application
DELETE /api/applications/{id} - Delete application
```

### Workflow APIs
```
POST /api/applications/{id}/actions - Perform workflow action
GET  /api/applications/{id}/audit   - Get audit trail
POST /api/applications/{id}/comments - Add comments
GET  /api/applications/{id}/documents - List documents
POST /api/applications/{id}/documents - Upload document
```

### Committee Meeting APIs
```
GET  /api/meetings           - List committee meetings
POST /api/meetings           - Create new meeting
PUT  /api/meetings/{id}      - Update meeting details
POST /api/meetings/{id}/votes - Submit committee vote
GET  /api/meetings/{id}/agenda - Get meeting agenda
```

### User Management APIs
```
GET  /api/users              - List users (admin)
POST /api/users              - Create new user
PUT  /api/users/{id}         - Update user details
DELETE /api/users/{id}       - Delete user
PUT  /api/users/{id}/status  - Enable/disable user
```

## 📁 Project Structure

### Frontend Structure
```
RTK-VDF-SIDBI/
├── src/
│   ├── components/          # Reusable UI components
│   │   ├── ui/             # shadcn/ui components
│   │   ├── layout/         # Layout components
│   │   ├── dashboard/      # Dashboard-specific components
│   │   ├── detailed-app/   # Detailed application components
│   │   └── review/         # Review workflow components
│   ├── pages/              # Page components
│   │   ├── Login.tsx
│   │   ├── Register.tsx
│   │   ├── ApplicantDashboard.tsx
│   │   ├── SidbiDashboard.tsx
│   │   ├── PrelimApplication.tsx
│   │   ├── DetailedApplication.tsx
│   │   └── CommitteeMeeting.tsx
│   ├── store/              # Redux store and API
│   │   ├── index.ts        # Store configuration
│   │   ├── api.ts          # RTK Query API definitions
│   │   └── mockData.ts     # Mock data for development
│   ├── lib/                # Utility libraries
│   │   ├── utils.ts        # General utilities
│   │   ├── authStore.ts    # Authentication state
│   │   ├── applicationStore.ts # Application state types
│   │   └── registrationStore.ts # Registration state
│   ├── hooks/              # Custom React hooks
│   └── assets/             # Static assets
├── public/                 # Public assets
├── package.json           # Dependencies and scripts
└── tailwind.config.js     # Tailwind configuration
```

### Backend Structure
```
vdf-backend/
├── src/main/java/com/sidbi/vdf/
│   ├── config/             # Configuration classes
│   │   ├── SecurityConfig.java
│   │   ├── JwtConfig.java
│   │   └── DataLoader.java
│   ├── controller/         # REST controllers
│   │   ├── AuthController.java
│   │   ├── ApplicationController.java
│   │   ├── RegistrationController.java
│   │   └── MeetingController.java
│   ├── service/            # Business logic services
│   │   ├── AuthService.java
│   │   ├── ApplicationService.java
│   │   └── WorkflowService.java
│   ├── repository/         # Data access layer
│   │   ├── UserAccountRepository.java
│   │   ├── ApplicationRepository.java
│   │   └── RegistrationRepository.java
│   ├── domain/             # Entity classes
│   │   ├── UserAccount.java
│   │   ├── Application.java
│   │   ├── Registration.java
│   │   └── enums/          # Enumerations
│   ├── dto/                # Data Transfer Objects
│   │   ├── LoginRequest.java
│   │   ├── ApplicationDto.java
│   │   └── WorkflowActionDto.java
│   └── security/           # Security components
│       ├── JwtAuthenticationFilter.java
│       └── JwtTokenProvider.java
├── src/main/resources/
│   ├── application.yml     # Main configuration
│   ├── application-h2.yml # H2 database configuration
│   └── db/migration/       # Database migrations
├── pom.xml                # Maven dependencies
└── docs/                  # Documentation
```

## 🔧 Configuration

### Environment Variables

#### Backend Configuration
```yaml
# Database Configuration
spring.datasource.url=jdbc:h2:mem:vdfdb
spring.datasource.username=sa
spring.datasource.password=

# JWT Configuration
jwt.secret=your-secret-key
jwt.expiration=86400000

# Server Configuration
server.port=8081

# Logging Configuration
logging.level.com.sidbi.vdf=DEBUG
```

#### Frontend Configuration
```typescript
// API Base URL
const API_BASE_URL = 'http://localhost:8081/api'

// Application Configuration
const APP_CONFIG = {
  maxFileSize: 25 * 1024 * 1024, // 25MB
  supportedFormats: ['.pdf', '.doc', '.docx', '.xls', '.xlsx', '.jpg', '.png'],
  autoSaveInterval: 30000, // 30 seconds
}
```

## 🧪 Testing

### Frontend Testing
```bash
cd RTK-VDF-SIDBI
npm run test          # Run unit tests
npm run test:coverage # Run tests with coverage
npm run lint          # Run ESLint
npm run type-check    # TypeScript type checking
```

### Backend Testing
```bash
cd vdf-backend
mvn test              # Run unit tests
mvn integration-test  # Run integration tests
mvn verify            # Run all tests with verification
```

## 🚀 Deployment

### Production Build

#### Frontend
```bash
cd RTK-VDF-SIDBI
npm run build         # Creates dist/ folder
npm run preview       # Preview production build
```

#### Backend
```bash
cd vdf-backend
mvn clean package     # Creates target/vdf-backend-1.0.0-SNAPSHOT.jar
java -jar target/vdf-backend-1.0.0-SNAPSHOT.jar --spring.profiles.active=prod
```

### Docker Deployment
```dockerfile
# Frontend Dockerfile
FROM node:18-alpine
WORKDIR /app
COPY package*.json ./
RUN npm ci --only=production
COPY . .
RUN npm run build
EXPOSE 8080
CMD ["npm", "run", "preview"]

# Backend Dockerfile
FROM openjdk:21-jre-slim
WORKDIR /app
COPY target/vdf-backend-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
```

## 📈 Performance Features

### Frontend Optimizations
- **Code Splitting**: Route-based code splitting
- **Lazy Loading**: Component lazy loading
- **Memoization**: React.memo and useMemo optimizations
- **Bundle Optimization**: Vite's built-in optimizations
- **Image Optimization**: Optimized asset loading

### Backend Optimizations
- **Connection Pooling**: Database connection pooling
- **Caching**: Spring Cache abstraction
- **Pagination**: Efficient data pagination
- **Lazy Loading**: JPA lazy loading strategies
- **Query Optimization**: Optimized database queries

## 🔒 Security Features

### Authentication & Authorization
- **JWT Tokens**: Secure token-based authentication
- **Role-Based Access Control**: Fine-grained permissions
- **Password Hashing**: BCrypt password encryption
- **Session Management**: Secure session handling

### Data Security
- **Input Validation**: Comprehensive input validation
- **SQL Injection Prevention**: Parameterized queries
- **XSS Protection**: Content Security Policy
- **CSRF Protection**: Cross-site request forgery protection
- **File Upload Security**: File type and size validation

## 🐛 Troubleshooting

### Common Issues

#### Backend Issues
1. **Lombok compilation errors**: Ensure annotation processing is enabled
2. **Database connection issues**: Check H2 console at `/h2-console`
3. **JWT token issues**: Verify JWT secret configuration
4. **Port conflicts**: Ensure port 8081 is available

#### Frontend Issues
1. **Input focus loss**: Fixed with useCallback implementations
2. **API connection errors**: Verify backend is running on port 8081
3. **Build errors**: Clear node_modules and reinstall dependencies
4. **Type errors**: Run `npm run type-check` for detailed errors

### Debug Commands
```bash
# Backend debugging
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

# Frontend debugging
npm run dev -- --debug
```

## 📚 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [React Documentation](https://react.dev/)
- [Redux Toolkit Documentation](https://redux-toolkit.js.org/)
- [Tailwind CSS Documentation](https://tailwindcss.com/)
- [shadcn/ui Documentation](https://ui.shadcn.com/)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Team

- **Frontend Development**: React + TypeScript + Redux Toolkit
- **Backend Development**: Spring Boot + Java 21 + JWT Security
- **Database Design**: JPA + Hibernate + H2/PostgreSQL
- **UI/UX Design**: shadcn/ui + Tailwind CSS

---

**Last Updated**: March 2026  
**Version**: 1.0.0  
**Status**: Production Ready ✅
