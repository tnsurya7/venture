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
   - Frontend: http://localhost:5173 (Vite default port)
   - The application will automatically open in your default browser

### Demo Users
The application includes mock authentication for testing:
- `applicant@demo.com` - Applicant role
- `alpha@techcorp.in` - Applicant (TechCorp)
- `gamma@manufacturing.in` - Applicant (Manufacturing)
- `sidbi-maker@demo.com` - SIDBI Maker
- `sidbi-checker@demo.com` - SIDBI Checker
- `sidbi-convenor@demo.com` - SIDBI Convenor
- `sidbi-committee@demo.com` - Committee Member
- `sidbi-approving@demo.com` - Approving Authority
- `admin@demo.com` - Admin role

## 🛠️ Tech Stack

### Core Technologies
- **React 18.3.1** - Modern React with hooks and concurrent features
- **TypeScript 5.8.3** - Type-safe JavaScript for better development experience
- **Vite 5.4.19** - Fast build tool and development server with HMR

### State Management
- **Redux Toolkit (RTK) 2.11.2** - Predictable state container with modern Redux patterns
- **RTK Query** - Powerful data fetching and caching solution with automatic cache invalidation
- **React Redux 9.2.0** - Official React bindings for Redux
- **React Hook Form 7.61.1** - Performant forms with easy validation
- **Zod 3.25.76** - TypeScript-first schema validation

### UI Framework & Styling
- **shadcn/ui** - High-quality, accessible component library built on Radix UI
- **Tailwind CSS 3.4.17** - Utility-first CSS framework
- **Radix UI** - Unstyled, accessible UI primitives (40+ components)
- **Lucide React 0.462.0** - Beautiful & consistent icon library (1000+ icons)
- **class-variance-authority 0.7.1** - Component variant management
- **tailwind-merge 2.6.0** - Merge Tailwind CSS classes without conflicts
- **tailwindcss-animate 1.0.7** - Animation utilities for Tailwind

### Routing & Navigation
- **React Router DOM 6.30.1** - Declarative routing for React applications

### UI Components & Utilities
- **date-fns 3.6.0** - Modern date manipulation library
- **clsx 2.1.1** - Conditional className utility
- **cmdk 1.1.1** - Command menu component
- **sonner 1.7.4** - Toast notifications
- **recharts 2.15.4** - Composable charting library
- **embla-carousel-react 8.6.0** - Carousel component
- **react-day-picker 8.10.1** - Date picker component
- **vaul 0.9.9** - Drawer component
- **next-themes 0.3.0** - Theme management

### Development Tools
- **ESLint 9.32.0** - Code linting and quality enforcement
- **TypeScript ESLint 8.38.0** - TypeScript-specific linting rules
- **Vitest 3.2.4** - Fast unit testing framework
- **@testing-library/react 16.0.0** - React component testing utilities
- **@testing-library/jest-dom 6.6.0** - Custom Jest matchers for DOM
- **PostCSS 8.5.6** - CSS processing and optimization
- **Autoprefixer 10.4.21** - Automatic vendor prefixing

## 📁 Complete Project Structure

```
RTK-VDF-SIDBI/
├── .lovable/                   # Lovable platform configuration
│   └── plan.md                # Project plan and specifications
├── public/                     # Static assets served directly
│   ├── application-fields.json # Dynamic form field configurations
│   ├── favicon.ico            # Application favicon
│   ├── placeholder.svg        # Placeholder image
│   └── robots.txt             # SEO robots file
├── src/                       # Source code
│   ├── assets/                # Static assets (images, fonts)
│   │   └── sidbi-logo.png    # SIDBI logo image
│   ├── components/            # Reusable UI components
│   │   ├── ui/               # shadcn/ui base components (60+ files)
│   │   │   ├── accordion.tsx
│   │   │   ├── alert-dialog.tsx
│   │   │   ├── alert.tsx
│   │   │   ├── aspect-ratio.tsx
│   │   │   ├── avatar.tsx
│   │   │   ├── badge.tsx
│   │   │   ├── breadcrumb.tsx
│   │   │   ├── button.tsx
│   │   │   ├── calendar.tsx
│   │   │   ├── card.tsx
│   │   │   ├── carousel.tsx
│   │   │   ├── chart.tsx
│   │   │   ├── checkbox.tsx
│   │   │   ├── collapsible.tsx
│   │   │   ├── command.tsx
│   │   │   ├── context-menu.tsx
│   │   │   ├── dialog.tsx
│   │   │   ├── drawer.tsx
│   │   │   ├── dropdown-menu.tsx
│   │   │   ├── form.tsx
│   │   │   ├── hover-card.tsx
│   │   │   ├── input-otp.tsx
│   │   │   ├── input.tsx
│   │   │   ├── label.tsx
│   │   │   ├── menubar.tsx
│   │   │   ├── navigation-menu.tsx
│   │   │   ├── pagination.tsx
│   │   │   ├── popover.tsx
│   │   │   ├── progress.tsx
│   │   │   ├── radio-group.tsx
│   │   │   ├── resizable.tsx
│   │   │   ├── scroll-area.tsx
│   │   │   ├── select.tsx
│   │   │   ├── separator.tsx
│   │   │   ├── sheet.tsx
│   │   │   ├── sidebar.tsx
│   │   │   ├── skeleton.tsx
│   │   │   ├── slider.tsx
│   │   │   ├── sonner.tsx
│   │   │   ├── switch.tsx
│   │   │   ├── table.tsx
│   │   │   ├── tabs.tsx
│   │   │   ├── textarea.tsx
│   │   │   ├── toast.tsx
│   │   │   ├── toaster.tsx
│   │   │   ├── toggle-group.tsx
│   │   │   ├── toggle.tsx
│   │   │   ├── tooltip.tsx
│   │   │   └── use-toast.ts
│   │   ├── layout/           # Layout components
│   │   │   ├── AppLayout.tsx      # Main application layout wrapper
│   │   │   ├── GovFooter.tsx      # Government-style footer
│   │   │   ├── GovHeader.tsx      # Government-style header
│   │   │   ├── GovInternal.tsx    # Internal government layout
│   │   │   └── PublicLayout.tsx   # Public-facing layout
│   │   ├── dashboard/        # Dashboard-specific components
│   │   │   └── ConsentsRequiredSection.tsx  # Consent management section
│   │   ├── detailed-app/     # Detailed application form components
│   │   │   ├── DetailedDataView.tsx        # View detailed application data
│   │   │   ├── DocumentUploadSection.tsx   # Document upload interface
│   │   │   ├── EligibilityCheck.tsx        # Eligibility verification
│   │   │   ├── FacilitiesApplicant.tsx     # Applicant facilities form
│   │   │   ├── FacilitiesAssociate.tsx     # Associate facilities form
│   │   │   ├── SupportingDocuments.tsx     # Supporting documents upload
│   │   │   └── UnitEconomicsGrid.tsx       # Unit economics data grid
│   │   ├── review/           # Application review components
│   │   │   ├── DetailedReviewActions.tsx   # Detailed review action buttons
│   │   │   ├── PrelimReviewActions.tsx     # Preliminary review actions
│   │   │   └── StageComments.tsx           # Stage-specific comments
│   │   ├── GovStatusBadge.tsx    # Government status badge component
│   │   └── NavLink.tsx           # Navigation link component
│   ├── pages/                # Page components (routes)
│   │   ├── Index.tsx                    # Landing/home page
│   │   ├── Login.tsx                    # Authentication page
│   │   ├── Register.tsx                 # User registration
│   │   ├── ApplicantDashboard.tsx       # Applicant dashboard
│   │   ├── SidbiDashboard.tsx           # SIDBI staff dashboard
│   │   ├── AdminRegistrations.tsx       # Admin registration management
│   │   ├── PrelimApplication.tsx        # Preliminary application form
│   │   ├── DetailedApplication.tsx      # Detailed application form
│   │   ├── ApplicationView.tsx          # View application details
│   │   ├── SidbiApplicationReview.tsx   # SIDBI review interface
│   │   ├── CommitteeMeeting.tsx         # Committee meeting interface
│   │   ├── CommitteeMeetingsList.tsx    # List of committee meetings
│   │   ├── CommitteeReview.tsx          # Committee review page
│   │   ├── PublicData.tsx               # Public data display
│   │   └── NotFound.tsx                 # 404 error page
│   ├── store/                # Redux store and API
│   │   ├── index.ts          # Store configuration and setup
│   │   ├── api.ts            # RTK Query API definitions with mock backend
│   │   └── mockData.ts       # Development mock data
│   ├── lib/                  # Utility libraries and type definitions
│   │   ├── utils.ts                # General utility functions (cn, etc.)
│   │   ├── authStore.ts            # Authentication types and interfaces
│   │   ├── applicationStore.ts     # Application state types and workflow
│   │   ├── registrationStore.ts    # Registration state types
│   │   ├── meetingStore.ts         # Committee meeting types
│   │   └── prelimConfig.ts         # Preliminary form configuration
│   ├── hooks/                # Custom React hooks
│   │   ├── use-mobile.tsx    # Mobile device detection hook
│   │   └── use-toast.ts      # Toast notification hook
│   ├── test/                 # Test files
│   │   ├── setup.ts          # Test environment setup
│   │   └── example.test.ts   # Example test file
│   ├── App.tsx               # Root application component
│   ├── App.css               # Application-level styles
│   ├── main.tsx              # Application entry point
│   ├── index.css             # Global styles and Tailwind imports
│   └── vite-env.d.ts         # Vite environment type definitions
├── .gitignore                # Git ignore rules
├── bun.lockb                 # Bun lock file
├── components.json           # shadcn/ui components configuration
├── eslint.config.js          # ESLint configuration
├── index.html                # HTML entry point
├── package.json              # Dependencies and scripts
├── package-lock.json         # npm lock file
├── postcss.config.js         # PostCSS configuration
├── tailwind.config.ts        # Tailwind CSS configuration
├── tsconfig.json             # TypeScript configuration
├── tsconfig.app.json         # TypeScript app configuration
├── tsconfig.node.json        # TypeScript Node configuration
├── vite.config.ts            # Vite build configuration
└── vitest.config.ts          # Vitest testing configuration
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
Create a `.env.local` file in the root directory (optional):

```env
# Application Configuration
VITE_APP_TITLE=VDF Portal
VITE_APP_VERSION=1.0.0

# Feature Flags
VITE_ENABLE_DEBUG_MODE=false

# File Upload Configuration (for future use)
VITE_MAX_FILE_SIZE=26214400  # 25MB in bytes
VITE_ALLOWED_FILE_TYPES=.pdf,.doc,.docx,.xls,.xlsx,.jpg,.jpeg,.png
```

### Mock Data Architecture
The application currently uses RTK Query with `fakeBaseQuery` for a fully functional mock backend:

```typescript
// Mock Backend Configuration (src/store/api.ts)
const api = createApi({
  reducerPath: 'api',
  baseQuery: fakeBaseQuery(),  // Mock backend - no real API calls
  tagTypes: ['Auth', 'Applications', 'Registrations', 'Meetings'],
  endpoints: (builder) => ({
    // All endpoints use in-memory mock data
    // Simulates real API with delays and validation
  }),
});
```

The mock backend provides:
- In-memory data storage (resets on page refresh)
- Simulated async delays (200-300ms)
- Full CRUD operations
- Workflow state management
- Authentication simulation
- Automatic cache invalidation

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
npm run dev          # Start development server with HMR
npm run build        # Create production build
npm run preview      # Preview production build locally
```

### Production Build
```bash
# Create optimized production build
npm run build

# The build artifacts will be stored in the `dist/` directory
# Deploy the contents of `dist/` to your web server or CDN
```

### Build Optimization
- **Code Splitting**: Automatic route-based code splitting with React.lazy
- **Tree Shaking**: Unused code elimination via Vite
- **Asset Optimization**: Image and CSS optimization
- **Minification**: JavaScript and CSS minification
- **Compression**: Gzip/Brotli compression support

### Deployment Options

#### Static Hosting (Recommended)
The application is a static SPA that can be deployed to any static hosting service:

```bash
# Build for production
npm run build

# Deploy to Netlify, Vercel, GitHub Pages, or similar
# Upload the `dist/` folder contents
```

**Netlify Deployment:**
```toml
# netlify.toml
[build]
  command = "npm run build"
  publish = "dist"

[[redirects]]
  from = "/*"
  to = "/index.html"
  status = 200
```

**Vercel Deployment:**
```json
{
  "buildCommand": "npm run build",
  "outputDirectory": "dist",
  "framework": "vite"
}
```

#### Docker Deployment
```dockerfile
# Multi-stage build for optimized image
FROM node:18-alpine as builder
WORKDIR /app
COPY package*.json ./
RUN npm ci
COPY . .
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx.conf /etc/nginx/nginx.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
```

**nginx.conf for SPA routing:**
```nginx
server {
    listen 80;
    server_name localhost;
    root /usr/share/nginx/html;
    index index.html;

    location / {
        try_files $uri $uri/ /index.html;
    }

    # Cache static assets
    location ~* \.(js|css|png|jpg|jpeg|gif|ico|svg)$ {
        expires 1y;
        add_header Cache-Control "public, immutable";
    }
}
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
- **Mock Authentication**: Demo authentication system for development
- **Session Management**: In-memory session storage
- **Route Protection**: Protected routes based on authentication status
- **Role-based Access**: Component-level access control based on user roles

### Input Security
- **Form Validation**: Client-side validation with Zod schemas
- **XSS Prevention**: React's built-in XSS protection
- **File Upload Validation**: File type and size validation (UI only)
- **Input Sanitization**: Sanitized user inputs before display

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
# Linting
npm run lint

# Build for production
npm run build

# Preview production build
npm run preview
```

#### Mock Data Issues
The application uses in-memory mock data that resets on page refresh. This is expected behavior for the current implementation. All data is stored in `src/store/mockData.ts` and managed by RTK Query's `fakeBaseQuery`.

### Debug Mode
Enable debug mode in development:
```env
VITE_ENABLE_DEBUG_MODE=true
```

This will enable:
- Redux DevTools integration
- Detailed console logging
- Performance monitoring
- Mock API request/response logging

## 📚 Additional Resources

### Project Documentation
- **[API Documentation](./API_DOCUMENTATION.md)** - Complete RTK Query API reference with Swagger/OpenAPI specification
- **[Mock Data Structure](./src/store/mockData.ts)** - Sample data used in development

### External Documentation
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