# VDF Frontend - React Application

A modern React application for the Venture Debt Fund (VDF) portal built with TypeScript, Redux Toolkit, and shadcn/ui components. This frontend provides a comprehensive interface for managing venture debt fund applications through SIDBI (Small Industries Development Bank of India).

## 🚀 Quick Start

### Prerequisites
- **Node.js 18+** (LTS recommended)
- **npm** or **yarn** package manager

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/tnsurya7/venture.git
   cd venture/RTK-VDF-SIDBI
   ```

2. **Install dependencies:**
   ```bash
   npm install
   # or
   yarn install
   ```

3. **Start development server:**
   ```bash
   npm run dev
   # or
   yarn dev
   ```

4. **Access the application:**
   - Frontend: http://localhost:8080
   - The application will automatically open in your default browser

### Demo Users (Password: "password")
- `applicant@demo.com` - Applicant role
- `sidbi-maker@demo.com` - SIDBI Maker
- `sidbi-checker@demo.com` - SIDBI Checker
- `sidbi-convenor@demo.com` - SIDBI Convenor
- `sidbi-committee@demo.com` - Committee Member
- `sidbi-approving@demo.com` - Approving Authority
- `admin@demo.com` - Admin role

## 🛠️ Tech Stack

### Core Technologies
- **React 18.3.1** - Modern React with hooks and concurrent features
- **TypeScript 5.6.2** - Type-safe JavaScript for better development experience
- **Vite 5.4.19** - Fast build tool and development server

### State Management
- **Redux Toolkit (RTK) 2.3.0** - Predictable state container with modern Redux patterns
- **RTK Query** - Powerful data fetching and caching solution
- **React Hook Form 7.54.0** - Performant forms with easy validation
- **Zod 3.23.8** - TypeScript-first schema validation

### UI Framework & Styling
- **shadcn/ui** - High-quality, accessible component library
- **Tailwind CSS 3.4.17** - Utility-first CSS framework
- **Radix UI** - Unstyled, accessible UI primitives
- **Lucide React 0.468.0** - Beautiful & consistent icon library
- **class-variance-authority** - Component variant management

### Routing & Navigation
- **React Router DOM 6.28.0** - Declarative routing for React applications

### Utilities
- **date-fns 4.1.0** - Date manipulation
- **clsx 2.1.1** - Conditional className utility

### Development Tools
- **ESLint** - Code linting and quality enforcement
- **TypeScript ESLint** - TypeScript-specific linting rules
- **Vitest** - Fast unit testing framework
- **PostCSS** - CSS processing and optimization

## 📁 Project Structure

```
RTK-VDF-SIDBI/
├── public/                     # Static assets
│   ├── application-fields.json # Form field configurations
│   ├── favicon.ico            # Application favicon
│   └── robots.txt             # SEO robots file
├── src/
│   ├── components/            # Reusable UI components
│   │   ├── ui/               # shadcn/ui base components
│   │   ├── layout/           # Layout components (headers, footers)
│   │   ├── dashboard/        # Dashboard-specific components
│   │   ├── detailed-app/     # Detailed application form components
│   │   └── review/           # Application review components
│   ├── pages/                # Page components (routes)
│   │   ├── Login.tsx         # Authentication page
│   │   ├── Register.tsx      # User registration
│   │   ├── ApplicantDashboard.tsx    # Applicant dashboard
│   │   ├── SidbiDashboard.tsx        # SIDBI staff dashboard
│   │   ├── PrelimApplication.tsx     # Preliminary application form
│   │   ├── DetailedApplication.tsx   # Detailed application form
│   │   └── CommitteeMeeting.tsx      # Committee meeting interface
│   ├── store/                # Redux store and API
│   │   ├── index.ts          # Store configuration
│   │   ├── api.ts            # RTK Query API definitions
│   │   └── mockData.ts       # Development mock data
│   ├── lib/                  # Utility libraries and stores
│   │   ├── utils.ts          # General utility functions
│   │   ├── authStore.ts      # Authentication state management
│   │   ├── applicationStore.ts # Application state types
│   │   └── registrationStore.ts # Registration state management
│   ├── hooks/                # Custom React hooks
│   │   ├── use-mobile.tsx    # Mobile detection hook
│   │   └── use-toast.ts      # Toast notification hook
│   └── assets/               # Static assets (images, fonts)
├── package.json              # Dependencies and scripts
├── tailwind.config.ts        # Tailwind CSS configuration
├── tsconfig.json             # TypeScript configuration
├── vite.config.ts            # Vite build configuration
└── vitest.config.ts          # Testing configuration
```

## 🎯 Key Features

### User Management
- **Multi-role Authentication**: Support for applicants, SIDBI staff, and administrators
- **JWT Token Management**: Secure authentication with automatic token refresh
- **Role-based Navigation**: Dynamic navigation based on user permissions
- **Profile Management**: User profile and settings management

### Application Management

#### Preliminary Applications
- Company profile and basic information
- Financial highlights
- Business model description
- Document upload support
- Draft saving functionality

#### Detailed Applications
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

### Workflow Management
- **Multi-stage Approval Process**: Preliminary → Detailed → Committee Review → Final Approval
- **Real-time Status Updates**: Live application status tracking
- **Comment System**: Field-level and global comments for reviewers
- **Audit Trail**: Complete history of all actions and changes
- **Assignment Management**: Assign applications to specific reviewers

### Dashboard Features

#### Applicant Dashboard
- Application status overview
- Document management
- Action items and notifications
- Progress tracking

#### SIDBI Dashboard
- Application queue management
- Role-based filtering and sorting
- Bulk actions support
- Performance metrics
- Assignment management

#### Admin Dashboard
- User registration approvals
- System configuration
- Audit trail management
- Report generation

### Advanced UI Features
- **Responsive Design**: Mobile-first approach with responsive layouts
- **Accessibility**: WCAG compliant components
- **Form Validation**: Real-time validation with user-friendly error messages
- **File Upload**: Drag-and-drop file upload with progress indicators
- **Data Tables**: Sortable, filterable data tables with pagination
- **Search & Filter**: Advanced search and filtering capabilities

## 🔧 Configuration

### Environment Variables
Create a `.env.local` file in the root directory:

```env
# API Configuration
VITE_API_BASE_URL=http://localhost:8081/api
VITE_APP_TITLE=VDF Portal
VITE_APP_VERSION=1.0.0

# Feature Flags
VITE_ENABLE_MOCK_API=false
VITE_ENABLE_DEBUG_MODE=false

# File Upload Configuration
VITE_MAX_FILE_SIZE=26214400  # 25MB in bytes
VITE_ALLOWED_FILE_TYPES=.pdf,.doc,.docx,.xls,.xlsx,.jpg,.jpeg,.png
```

### API Integration
The application uses RTK Query for API communication:

```typescript
// API Base Configuration
const api = createApi({
  reducerPath: 'api',
  baseQuery: fetchBaseQuery({
    baseUrl: '/api',
    prepareHeaders: (headers, { getState }) => {
      const token = selectAuthToken(getState());
      if (token) {
        headers.set('authorization', `Bearer ${token}`);
      }
      return headers;
    },
  }),
  tagTypes: ['Application', 'Registration', 'Meeting', 'User'],
  endpoints: (builder) => ({
    // API endpoints defined here
  }),
});
```

## 📱 Responsive Design

The application is built with a mobile-first approach:

- **Breakpoints**:
  - `sm`: 640px and up
  - `md`: 768px and up
  - `lg`: 1024px and up
  - `xl`: 1280px and up
  - `2xl`: 1536px and up

- **Components**: All components are responsive and adapt to different screen sizes
- **Navigation**: Collapsible navigation for mobile devices
- **Tables**: Horizontal scrolling for data tables on smaller screens
- **Forms**: Optimized form layouts for mobile input

## 🧪 Testing

### Running Tests
```bash
# Run unit tests
npm run test

# Run tests with coverage
npm run test:coverage

# Run tests in watch mode
npm run test:watch

# Run tests in UI mode
npm run test:ui
```

### Testing Strategy
- **Unit Tests**: Component testing with React Testing Library
- **Integration Tests**: API integration testing with MSW
- **E2E Tests**: End-to-end testing with Playwright (planned)
- **Accessibility Tests**: Automated accessibility testing

## 🚀 Build & Deployment

### Development Build
```bash
npm run dev          # Start development server
npm run build        # Create production build
npm run preview      # Preview production build locally
```

### Production Build
```bash
# Create optimized production build
npm run build

# The build artifacts will be stored in the `dist/` directory
# Deploy the contents of `dist/` to your web server
```

### Build Optimization
- **Code Splitting**: Automatic route-based code splitting
- **Tree Shaking**: Unused code elimination
- **Asset Optimization**: Image and CSS optimization
- **Bundle Analysis**: Use `npm run build -- --analyze` to analyze bundle size

### Deployment Options

#### Static Hosting (Recommended)
```bash
# Build for production
npm run build

# Deploy to Netlify, Vercel, or similar
# Upload the `dist/` folder contents
```

#### Docker Deployment
```dockerfile
FROM node:18-alpine as builder
WORKDIR /app
COPY package*.json ./
RUN npm ci --only=production
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

## 🔍 Performance Optimization

### Implemented Optimizations
- **React.memo**: Memoized components to prevent unnecessary re-renders
- **useCallback & useMemo**: Optimized hooks to prevent function recreation
- **Lazy Loading**: Route-based code splitting with React.lazy
- **Image Optimization**: Optimized images with proper formats and sizes
- **Bundle Splitting**: Vendor and app code separation

### Performance Monitoring
```typescript
// Performance monitoring setup
import { getCLS, getFID, getFCP, getLCP, getTTFB } from 'web-vitals';

getCLS(console.log);
getFID(console.log);
getFCP(console.log);
getLCP(console.log);
getTTFB(console.log);
```

## 🛡️ Security Features

### Authentication Security
- **JWT Token Management**: Secure token storage and automatic refresh
- **Route Protection**: Protected routes based on authentication status
- **Role-based Access**: Component-level access control
- **Session Management**: Automatic logout on token expiration

### Input Security
- **Form Validation**: Client-side validation with Zod schemas
- **XSS Prevention**: Sanitized user inputs
- **File Upload Security**: File type and size validation
- **CSRF Protection**: Cross-site request forgery protection

## 🐛 Troubleshooting

### Common Issues

#### Development Server Issues
```bash
# Clear node_modules and reinstall
rm -rf node_modules package-lock.json
npm install

# Clear Vite cache
rm -rf node_modules/.vite
npm run dev
```

#### Build Issues
```bash
# Type checking
npm run type-check

# Linting
npm run lint

# Fix linting issues
npm run lint:fix
```

#### API Connection Issues
1. Ensure backend server is running on port 8081
2. Check CORS configuration in backend
3. Verify API base URL in environment variables
4. Check browser network tab for failed requests

### Debug Mode
Enable debug mode in development:
```env
VITE_ENABLE_DEBUG_MODE=true
```

This will enable:
- Redux DevTools integration
- Detailed error logging
- Performance monitoring
- API request/response logging

## 📚 Additional Resources

### Documentation
- [React Documentation](https://react.dev/)
- [TypeScript Handbook](https://www.typescriptlang.org/docs/)
- [Redux Toolkit Documentation](https://redux-toolkit.js.org/)
- [Tailwind CSS Documentation](https://tailwindcss.com/docs)
- [shadcn/ui Documentation](https://ui.shadcn.com/)

### Development Tools
- [React Developer Tools](https://chrome.google.com/webstore/detail/react-developer-tools/fmkadmapgofadopljbjfkapdkoienihi)
- [Redux DevTools](https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd)
- [Tailwind CSS IntelliSense](https://marketplace.visualstudio.com/items?itemName=bradlc.vscode-tailwindcss)

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines
- Follow TypeScript best practices
- Use ESLint and Prettier for code formatting
- Write unit tests for new components
- Update documentation for new features
- Follow conventional commit messages

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](../LICENSE) file for details.

---

**Frontend Version**: 1.0.0  
**Last Updated**: March 2026  
**Status**: Production Ready ✅