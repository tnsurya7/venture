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
                                    │   PostgreSQL    │
                                    └─────────────────┘
```

## 📁 Project Structure

This repository contains both frontend and backend applications:

```
venture/
├── README.md                    # This overview file
├── RTK-VDF-SIDBI/              # React Frontend Application
│   ├── README.md               # Detailed frontend documentation
│   ├── src/                    # Frontend source code
│   ├── package.json            # Frontend dependencies
│   └── ...
└── vdf-backend/                # Spring Boot Backend Application
    ├── README.md               # Detailed backend documentation
    ├── src/main/java/          # Backend source code
    ├── pom.xml                 # Backend dependencies
    └── ...
```

## 🚀 Quick Start

### Prerequisites
- **Java 21** (for backend)
- **Node.js 18+** (for frontend)
- **Maven 3.8+** (for backend build)
- **PostgreSQL 12+** (for database)

### Running Both Applications

1. **Clone the repository:**
   ```bash
   git clone https://github.com/tnsurya7/venture.git
   cd venture
   ```

2. **Start Backend:**
   ```bash
   cd vdf-backend
   mvn spring-boot:run
   ```
   - Backend runs on: http://localhost:8081
   - API Documentation: http://localhost:8081/swagger-ui.html

3. **Start Frontend:**
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

## 📚 Detailed Documentation

For comprehensive setup, configuration, and development information, please refer to the individual README files:

### 🎨 Frontend Documentation
**[RTK-VDF-SIDBI/README.md](./RTK-VDF-SIDBI/README.md)**

Covers:
- React + TypeScript + Redux Toolkit setup
- Component architecture and UI framework
- State management and API integration
- Build and deployment processes
- Testing strategies
- Performance optimization

### ⚙️ Backend Documentation
**[vdf-backend/README.md](./vdf-backend/README.md)**

Covers:
- Spring Boot + Java 21 setup
- Database configuration (PostgreSQL)
- Security and authentication (JWT)
- API endpoints and documentation
- Testing and deployment
- Performance and monitoring

## 🎯 Key Features

### Application Management
- **Preliminary Applications**: Initial submission with basic company information
- **Detailed Applications**: Comprehensive forms with financial data, capital tables, and document management
- **Multi-stage Workflow**: Complete approval process from submission to sanction

### User Roles & Access Control
- **Applicants**: Submit and track applications
- **SIDBI Staff**: Review, approve, and manage applications (Maker, Checker, Convenor)
- **Committee Members**: Vote on applications in committee meetings
- **Administrators**: Manage users and system configuration

### Advanced Features
- **Document Management**: Secure file upload and storage
- **Audit Trail**: Complete history of all actions and changes
- **Committee Meetings**: ICVD and CCIC meeting management with voting
- **Real-time Updates**: Live status tracking and notifications
- **Responsive Design**: Mobile-friendly interface

## 🛠️ Tech Stack Summary

### Frontend
- **React 18** + **TypeScript** + **Vite**
- **Redux Toolkit** + **RTK Query**
- **shadcn/ui** + **Tailwind CSS**
- **React Hook Form** + **Zod validation**

### Backend
- **Spring Boot 3.2** + **Java 21**
- **Spring Security** + **JWT authentication**
- **Spring Data JPA** + **Hibernate**
- **PostgreSQL** database
- **Maven** build system

## 🚀 Deployment

### Development
Both applications can be run locally for development. See individual README files for detailed setup instructions.

### Production
- **Frontend**: Static hosting (Netlify, Vercel) or containerized deployment
- **Backend**: JAR deployment or Docker containers
- **Database**: PostgreSQL with proper configuration and security

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

Please refer to the individual README files for specific development guidelines for frontend and backend components.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Support

For technical support or questions:
- Check the detailed documentation in individual README files
- Review the API documentation at http://localhost:8081/swagger-ui.html
- Open an issue in the GitHub repository

---

**Version**: 1.0.0  
**Last Updated**: March 2026  
**Status**: Production Ready ✅