# VDF SIDBI API Documentation 📚

Complete RTK Query API reference for the Venture Debt Fund SIDBI application management system. Features comprehensive endpoint documentation, Swagger/OpenAPI specification, and workflow automation guides.

![API Documentation](https://img.shields.io/badge/API-Documentation-FF6B35?style=for-the-badge&logo=swagger)
![RTK Query](https://img.shields.io/badge/RTK-Query-764ABC?style=flat-square&logo=redux)
![OpenAPI](https://img.shields.io/badge/OpenAPI-3.0.3-6BA539?style=flat-square&logo=openapi-initiative)
![Swagger](https://img.shields.io/badge/Swagger-UI-85EA2D?style=flat-square&logo=swagger)
![TypeScript](https://img.shields.io/badge/TypeScript-5.8.3-3178C6?style=flat-square&logo=typescript)
![Mock Backend](https://img.shields.io/badge/Mock-Backend-FF6B6B?style=flat-square&logo=json)

## Overview
This document describes the RTK Query API endpoints for the Venture Debt Fund (VDF) SIDBI application management system. The API uses a mock backend with `fakeBaseQuery` for testing and development purposes.

## Base Configuration
- **API Slice**: `api`
- **Base Query**: `fakeBaseQuery` (mock backend)
- **Tag Types**: `Auth`, `Applications`, `Registrations`, `Meetings`
- **Base URL**: Mock in-memory backend (no actual HTTP calls)

## OpenAPI/Swagger Specification

```yaml
openapi: 3.0.3
info:
  title: VDF SIDBI Application API
  description: Mock API for Venture Debt Fund SIDBI application management
  version: 1.0.0
  contact:
    name: VDF Development Team
    email: dev@vdf-sidbi.com
servers:
  - url: http://localhost:5173
    description: Development server (mock backend)
paths:
  /auth/login:
    post:
      tags:
        - Authentication
      summary: User login
      description: Authenticate user with email and password
      operationId: login
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - email
                - password
              properties:
                email:
                  type: string
                  format: email
                  example: "applicant@demo.com"
                password:
                  type: string
                  example: "password"
      responses:
        '200':
          description: Successful authentication
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/AuthSession'
        '401':
          description: Invalid credentials
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'
```
## Demo Accounts
The system includes pre-configured demo accounts for testing:

| Email | User Type | SIDBI Role |
|-------|-----------|------------|
| applicant@demo.com | applicant | - |
| alpha@techcorp.in | applicant | - |
| gamma@manufacturing.in | applicant | - |
| sidbi-maker@demo.com | sidbi | maker |
| sidbi-checker@demo.com | sidbi | checker |
| sidbi-convenor@demo.com | sidbi | convenor |
| sidbi-committee@demo.com | sidbi | committee_member |
| sidbi-approving@demo.com | sidbi | approving_authority |
| admin@demo.com | admin | - |

---

## Authentication Endpoints

### 1. Login
**Endpoint**: `login`  
**Type**: Mutation  
**Description**: Authenticate user with email and password

**Request**:
```typescript
{
  email: string;
  password: string;
}
```

**Response**:
```typescript
{
  email: string;
  userType: "applicant" | "sidbi" | "admin";
  sidbiRole?: "maker" | "checker" | "convenor" | "committee_member" | "approving_authority";
}
```

**Usage**:
```typescript
const [login] = useLoginMutation();
const result = await login({ 
  email: "applicant@demo.com", 
  password: "any" 
});
```

---

### 2. Login As Demo
**Endpoint**: `loginAsDemo`  
**Type**: Mutation  
**Description**: Quick login for demo accounts without password

**Request**:
```typescript
{
  email: string;
  userType: "applicant" | "sidbi" | "admin";
  sidbiRole?: "maker" | "checker" | "convenor" | "committee_member" | "approving_authority";
}
```

**Response**: Same as login

**Usage**:
```typescript
const [loginAsDemo] = useLoginAsDemoMutation();
await loginAsDemo({
  email: "sidbi-maker@demo.com",
  userType: "sidbi",
  sidbiRole: "maker"
});
```
### 3. Logout
**Endpoint**: `logout`  
**Type**: Mutation  
**Description**: Clear current session

**Request**: `void`  
**Response**: `void`

**Usage**:
```typescript
const [logout] = useLogoutMutation();
await logout();
```

---

### 4. Get Session
**Endpoint**: `getSession`  
**Type**: Query  
**Description**: Retrieve current authentication session

**Request**: `void`  
**Response**: `AuthSession | null`

**Usage**:
```typescript
const { data: session } = useGetSessionQuery();
```

---

## Registration Endpoints

### 5. Get Registrations
**Endpoint**: `getRegistrations`  
**Type**: Query  
**Description**: Fetch all registration requests

**Request**: `void`  
**Response**: `Registration[]`

**Registration Type**:
```typescript
{
  id: string;
  email: string;
  nameOfApplicant: string;
  registeredOffice: string;
  locationOfFacilities: string;
  dateOfIncorporation: string;
  dateOfCommencement: string;
  panNo: string;
  gstNo: string;
  msmeStatus: "micro" | "small" | "medium";
  status: "pending" | "approved" | "rejected";
  submittedAt: string;
}
```

**Usage**:
```typescript
const { data: registrations } = useGetRegistrationsQuery();
```

---

### 6. Add Registration
**Endpoint**: `addRegistration`  
**Type**: Mutation  
**Description**: Submit a new registration request

**Request**:
```typescript
{
  email: string;
  nameOfApplicant: string;
  registeredOffice: string;
  locationOfFacilities: string;
  dateOfIncorporation: string;
  dateOfCommencement: string;
  panNo: string;
  gstNo: string;
  msmeStatus: "micro" | "small" | "medium";
}
```

**Response**: `Registration`

**Usage**:
```typescript
const [addRegistration] = useAddRegistrationMutation();
await addRegistration({
  email: "company@example.com",
  nameOfApplicant: "Tech Corp",
  // ... other fields
});
```
### 7. Update Registration Status
**Endpoint**: `updateRegistrationStatus`  
**Type**: Mutation  
**Description**: Approve or reject a registration (admin only)

**Request**:
```typescript
{
  id: string;
  status: "approved" | "rejected";
}
```

**Response**: `void`

**Usage**:
```typescript
const [updateStatus] = useUpdateRegistrationStatusMutation();
await updateStatus({ id: "reg-123", status: "approved" });
```

---

## Application Endpoints

### 8. Get Applications
**Endpoint**: `getApplications`  
**Type**: Query  
**Description**: Fetch applications with optional filtering

**Request**:
```typescript
{
  email?: string;      // Filter by applicant email
  role?: SidbiRole;    // Filter by SIDBI role
}
```

**Response**: `Application[]`

**Application Type**:
```typescript
{
  id: string;
  applicantEmail: string;
  status: AppStatus;
  stage: "prelim" | "detailed" | "icvd" | "ccic" | "final" | "post_sanction";
  workflowStep: WorkflowStep;
  assignedMaker?: string;
  assignedChecker?: string;
  assignedConvenor?: string;
  assignedApprover?: string;
  recommendedOutcome?: "rejection" | "pursual";
  prelimData: any | null;
  detailedData: any | null;
  icvdNote?: any | null;
  ccicNote?: any | null;
  icvdMeetingId?: string;
  ccicMeetingId?: string;
  comments: Record<string, FieldComment>;
  auditTrail: AuditEntry[];
  submittedAt: string;
  updatedAt: string;
}
```

**Usage**:
```typescript
// Get all applications
const { data: allApps } = useGetApplicationsQuery();

// Get applications for specific user
const { data: userApps } = useGetApplicationsQuery({ 
  email: "user@example.com" 
});

// Get applications for checker role
const { data: checkerApps } = useGetApplicationsQuery({ 
  role: "checker" 
});
```
### 9. Get Application By ID
**Endpoint**: `getApplicationById`  
**Type**: Query  
**Description**: Fetch a single application by ID

**Request**: `string` (application ID)  
**Response**: `Application`

**Usage**:
```typescript
const { data: application } = useGetApplicationByIdQuery("app-123");
```

---

### 10. Create Preliminary Application
**Endpoint**: `createPrelimApplication`  
**Type**: Mutation  
**Description**: Submit a new preliminary application

**Request**:
```typescript
{
  email: string;
  prelimData: any;  // Form data object
}
```

**Response**: `Application`

**Usage**:
```typescript
const [createPrelim] = useCreatePrelimApplicationMutation();
await createPrelim({
  email: "applicant@example.com",
  prelimData: { /* form fields */ }
});
```

---

### 11. Update Preliminary Data
**Endpoint**: `updatePrelimData`  
**Type**: Mutation  
**Description**: Update preliminary application data (resubmission after revert)

**Request**:
```typescript
{
  id: string;
  prelimData: any;
}
```

**Response**: `void`

**Usage**:
```typescript
const [updatePrelim] = useUpdatePrelimDataMutation();
await updatePrelim({
  id: "app-123",
  prelimData: { /* updated form fields */ }
});
```

---

### 12. Submit Detailed Application
**Endpoint**: `submitDetailedApplication`  
**Type**: Mutation  
**Description**: Submit detailed application data after preliminary approval

**Request**:
```typescript
{
  appId: string;
  detailedData: any;
}
```

**Response**: `void`

**Usage**:
```typescript
const [submitDetailed] = useSubmitDetailedApplicationMutation();
await submitDetailed({
  appId: "app-123",
  detailedData: { /* detailed form fields */ }
});
```
### 13. Apply Workflow Action
**Endpoint**: `applyWorkflowAction`  
**Type**: Mutation  
**Description**: Execute a workflow action on an application

**Request**:
```typescript
{
  id: string;
  action: WorkflowAction;
  actor: {
    role: string;
    id: string;
  };
  comment?: string;
  assignedChecker?: string;
  assignedConvenor?: string;
  assignedApprover?: string;
  recommendedOutcome?: "rejection" | "pursual";
  meetingId?: string;
}
```

**Workflow Actions**:
- **Preliminary**: `revert_prelim`, `reject_prelim`, `approve_prelim`
- **Detailed**: `revert_detailed`, `recommend_rejection`, `recommend_pursual`, `reject_final`, `recommend_icvd`, `recommend_ccic`
- **ICVD**: `icvd_maker_forward`, `icvd_checker_assign_convenor`, `icvd_schedule_meeting`, `icvd_committee_refer`
- **CCIC**: `ccic_maker_upload`, `ccic_checker_assign_convenor`, `ccic_schedule_meeting`, `ccic_committee_refer`
- **Final**: `approve_sanction`, `reject_sanction`

**Response**:
```typescript
{
  success: boolean;
  error?: string;
}
```

**Usage**:
```typescript
const [applyAction] = useApplyWorkflowActionMutation();
await applyAction({
  id: "app-123",
  action: "approve_prelim",
  actor: { role: "maker", id: "sidbi-maker@demo.com" },
  comment: "Application meets all criteria"
});
```

---

### 14. Delete Application
**Endpoint**: `deleteApplication`  
**Type**: Mutation  
**Description**: Delete an application

**Request**: `string` (application ID)  
**Response**: `void`

**Usage**:
```typescript
const [deleteApp] = useDeleteApplicationMutation();
await deleteApp("app-123");
```

---

## Meeting Endpoints

### 15. Get Meetings
**Endpoint**: `getMeetings`  
**Type**: Query  
**Description**: Fetch committee meetings with optional type filter

**Request**:
```typescript
{
  type?: "icvd" | "ccic";
}
```

**Response**: `CommitteeMeeting[]`
**CommitteeMeeting Type**:
```typescript
{
  id: string;
  type: "icvd" | "ccic";
  subject: string;
  meetingNumber: number;
  dateTime: string;
  totalMembers: CommitteeMember[];
  selectedMembers: CommitteeMember[];
  makerEmail: string;
  checkerEmail: string;
  convenorEmail: string;
  approverEmail?: string;
  applicationIds: string[];
  status: "draft" | "scheduled" | "in_progress" | "completed";
  votes: MeetingVote[];
  outcome?: "referred" | "rejected";
  createdAt: string;
  updatedAt: string;
}
```

**Usage**:
```typescript
// Get all meetings
const { data: allMeetings } = useGetMeetingsQuery();

// Get ICVD meetings only
const { data: icvdMeetings } = useGetMeetingsQuery({ type: "icvd" });
```

---

### 16. Get Meeting By ID
**Endpoint**: `getMeetingById`  
**Type**: Query  
**Description**: Fetch a single meeting by ID

**Request**: `string` (meeting ID)  
**Response**: `CommitteeMeeting`

**Usage**:
```typescript
const { data: meeting } = useGetMeetingByIdQuery("meeting-123");
```

---

### 17. Create Meeting
**Endpoint**: `createMeeting`  
**Type**: Mutation  
**Description**: Schedule a new committee meeting

**Request**:
```typescript
{
  type: "icvd" | "ccic";
  subject: string;
  meetingNumber: number;
  dateTime: string;
  totalMembers: CommitteeMember[];
  selectedMembers: CommitteeMember[];
  makerEmail: string;
  checkerEmail: string;
  convenorEmail: string;
  approverEmail?: string;
  applicationIds: string[];
  status: "draft" | "scheduled" | "in_progress" | "completed";
}
```

**Response**: `CommitteeMeeting`

**Usage**:
```typescript
const [createMeeting] = useCreateMeetingMutation();
await createMeeting({
  type: "icvd",
  subject: "ICVD Meeting #5",
  meetingNumber: 5,
  dateTime: "2024-03-15T10:00:00Z",
  // ... other fields
});
```
### 18. Update Meeting Status
**Endpoint**: `updateMeetingStatus`  
**Type**: Mutation  
**Description**: Update meeting status and outcome

**Request**:
```typescript
{
  id: string;
  status: "draft" | "scheduled" | "in_progress" | "completed";
  outcome?: "referred" | "rejected";
}
```

**Response**: `void`

**Usage**:
```typescript
const [updateMeetingStatus] = useUpdateMeetingStatusMutation();
await updateMeetingStatus({
  id: "meeting-123",
  status: "completed",
  outcome: "referred"
});
```

---

### 19. Add Vote
**Endpoint**: `addVote`  
**Type**: Mutation  
**Description**: Record a committee member's vote

**Request**:
```typescript
{
  meetingId: string;
  vote: {
    memberId: string;
    vote: "approve" | "reject" | "abstain";
    comment: string;
    timestamp: string;
  };
}
```

**Response**: `void`

**Usage**:
```typescript
const [addVote] = useAddVoteMutation();
await addVote({
  meetingId: "meeting-123",
  vote: {
    memberId: "cm1",
    vote: "approve",
    comment: "Meets all requirements",
    timestamp: new Date().toISOString()
  }
});
```

---

## Workflow State Machine

### Application Stages
1. **prelim** - Preliminary application stage
2. **detailed** - Detailed application stage
3. **icvd** - Investment Committee for Venture Debt
4. **ccic** - Credit Committee for Investment Committee
5. **final** - Final approval stage
6. **post_sanction** - After sanction

### Workflow Steps and Transitions
```
prelim_submitted → [approve_prelim] → detailed_form_open
                → [reject_prelim] → prelim_rejected
                → [revert_prelim] → prelim_revision

detailed_maker_review → [recommend_pursual] → detailed_checker_review
                     → [recommend_rejection] → detailed_checker_review
                     → [revert_detailed] → detailed_revision

detailed_checker_review → [recommend_icvd] → icvd_maker_review
                       → [recommend_ccic] → ccic_maker_refine
                       → [reject_final] → detailed_rejected

icvd_maker_review → [icvd_maker_forward] → icvd_checker_review

icvd_checker_review → [icvd_checker_assign_convenor] → icvd_convenor_scheduling

icvd_convenor_scheduling → [icvd_schedule_meeting] → icvd_committee_review

icvd_committee_review → [icvd_committee_refer] → ccic_maker_refine

ccic_maker_refine → [ccic_maker_upload] → ccic_checker_review

ccic_checker_review → [ccic_checker_assign_convenor] → ccic_convenor_scheduling

ccic_convenor_scheduling → [ccic_schedule_meeting] → ccic_committee_review

ccic_committee_review → [ccic_committee_refer] → final_approval

final_approval → [approve_sanction] → sanctioned
              → [reject_sanction] → final_rejected
```
---

## Complete OpenAPI/Swagger Specification

```yaml
openapi: 3.0.3
info:
  title: VDF SIDBI Application API
  description: Mock API for Venture Debt Fund SIDBI application management system
  version: 1.0.0
  contact:
    name: VDF Development Team
    email: dev@vdf-sidbi.com
  license:
    name: MIT
    url: https://opensource.org/licenses/MIT

servers:
  - url: http://localhost:5173
    description: Development server (mock backend)

tags:
  - name: Authentication
    description: User authentication and session management
  - name: Registrations
    description: Company registration management
  - name: Applications
    description: Application lifecycle management
  - name: Meetings
    description: Committee meeting management

paths:
  /auth/login:
    post:
      tags:
        - Authentication
      summary: User login
      description: Authenticate user with email and password
      operationId: login
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - email
                - password
              properties:
                email:
                  type: string
                  format: email
                  example: "applicant@demo.com"
                password:
                  type: string
                  example: "password"
      responses:
        '200':
          description: Successful authentication
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/AuthSession'
        '401':
          description: Invalid credentials
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Error'

  /auth/login-demo:
    post:
      tags:
        - Authentication
      summary: Demo login
      description: Quick login for demo accounts without password
      operationId: loginAsDemo
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - email
                - userType
              properties:
                email:
                  type: string
                  format: email
                  example: "sidbi-maker@demo.com"
                userType:
                  $ref: '#/components/schemas/UserType'
                sidbiRole:
                  $ref: '#/components/schemas/SidbiRole'
      responses:
        '200':
          description: Successful authentication
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/AuthSession'

  /auth/logout:
    post:
      tags:
        - Authentication
      summary: Logout
      description: Clear current session
      operationId: logout
      responses:
        '200':
          description: Successfully logged out

  /auth/session:
    get:
      tags:
        - Authentication
      summary: Get current session
      description: Retrieve current authentication session
      operationId: getSession
      responses:
        '200':
          description: Current session
          content:
            application/json:
              schema:
                oneOf:
                  - $ref: '#/components/schemas/AuthSession'
                  - type: 'null'
  /registrations:
    get:
      tags:
        - Registrations
      summary: Get all registrations
      description: Fetch all registration requests
      operationId: getRegistrations
      responses:
        '200':
          description: List of registrations
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Registration'
    post:
      tags:
        - Registrations
      summary: Add registration
      description: Submit a new registration request
      operationId: addRegistration
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/RegistrationRequest'
      responses:
        '200':
          description: Registration created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Registration'

  /registrations/{id}/status:
    patch:
      tags:
        - Registrations
      summary: Update registration status
      description: Approve or reject a registration (admin only)
      operationId: updateRegistrationStatus
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - status
              properties:
                status:
                  type: string
                  enum: [approved, rejected]
      responses:
        '200':
          description: Status updated successfully
        '404':
          description: Registration not found

  /applications:
    get:
      tags:
        - Applications
      summary: Get applications
      description: Fetch applications with optional filtering
      operationId: getApplications
      parameters:
        - name: email
          in: query
          description: Filter by applicant email
          schema:
            type: string
            format: email
        - name: role
          in: query
          description: Filter by SIDBI role
          schema:
            $ref: '#/components/schemas/SidbiRole'
      responses:
        '200':
          description: List of applications
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Application'

  /applications/{id}:
    get:
      tags:
        - Applications
      summary: Get application by ID
      description: Fetch a single application by ID
      operationId: getApplicationById
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Application details
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Application'
        '404':
          description: Application not found
    delete:
      tags:
        - Applications
      summary: Delete application
      description: Delete an application
      operationId: deleteApplication
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Application deleted successfully
        '404':
          description: Application not found
  /applications/prelim:
    post:
      tags:
        - Applications
      summary: Create preliminary application
      description: Submit a new preliminary application
      operationId: createPrelimApplication
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - email
                - prelimData
              properties:
                email:
                  type: string
                  format: email
                prelimData:
                  type: object
                  description: Form data object
      responses:
        '200':
          description: Application created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/Application'

  /applications/{id}/prelim:
    patch:
      tags:
        - Applications
      summary: Update preliminary data
      description: Update preliminary application data (resubmission after revert)
      operationId: updatePrelimData
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - prelimData
              properties:
                prelimData:
                  type: object
                  description: Updated form fields
      responses:
        '200':
          description: Preliminary data updated
        '404':
          description: Application not found

  /applications/{id}/detailed:
    post:
      tags:
        - Applications
      summary: Submit detailed application
      description: Submit detailed application data after preliminary approval
      operationId: submitDetailedApplication
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - detailedData
              properties:
                detailedData:
                  type: object
                  description: Detailed form fields
      responses:
        '200':
          description: Detailed application submitted
        '404':
          description: Application not found

  /applications/{id}/workflow:
    post:
      tags:
        - Applications
      summary: Apply workflow action
      description: Execute a workflow action on an application
      operationId: applyWorkflowAction
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/WorkflowActionRequest'
      responses:
        '200':
          description: Workflow action applied
          content:
            application/json:
              schema:
                type: object
                properties:
                  success:
                    type: boolean
                  error:
                    type: string
        '404':
          description: Application not found
  /meetings:
    get:
      tags:
        - Meetings
      summary: Get meetings
      description: Fetch committee meetings with optional type filter
      operationId: getMeetings
      parameters:
        - name: type
          in: query
          description: Filter by meeting type
          schema:
            type: string
            enum: [icvd, ccic]
      responses:
        '200':
          description: List of meetings
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/CommitteeMeeting'
    post:
      tags:
        - Meetings
      summary: Create meeting
      description: Schedule a new committee meeting
      operationId: createMeeting
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/MeetingRequest'
      responses:
        '200':
          description: Meeting created
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CommitteeMeeting'

  /meetings/{id}:
    get:
      tags:
        - Meetings
      summary: Get meeting by ID
      description: Fetch a single meeting by ID
      operationId: getMeetingById
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          description: Meeting details
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CommitteeMeeting'
        '404':
          description: Meeting not found

  /meetings/{id}/status:
    patch:
      tags:
        - Meetings
      summary: Update meeting status
      description: Update meeting status and outcome
      operationId: updateMeetingStatus
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              type: object
              required:
                - status
              properties:
                status:
                  type: string
                  enum: [draft, scheduled, in_progress, completed]
                outcome:
                  type: string
                  enum: [referred, rejected]
      responses:
        '200':
          description: Meeting status updated
        '404':
          description: Meeting not found

  /meetings/{id}/votes:
    post:
      tags:
        - Meetings
      summary: Add vote
      description: Record a committee member's vote
      operationId: addVote
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      requestBody:
        required: true
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/MeetingVote'
      responses:
        '200':
          description: Vote recorded
        '404':
          description: Meeting not found
components:
  schemas:
    UserType:
      type: string
      enum: [applicant, sidbi, admin]
      description: Type of user in the system

    SidbiRole:
      type: string
      enum: [maker, checker, convenor, committee_member, approving_authority]
      description: Role within SIDBI organization

    AuthSession:
      type: object
      required:
        - email
        - userType
      properties:
        email:
          type: string
          format: email
          example: "applicant@demo.com"
        userType:
          $ref: '#/components/schemas/UserType'
        sidbiRole:
          $ref: '#/components/schemas/SidbiRole'

    Registration:
      type: object
      required:
        - id
        - email
        - nameOfApplicant
        - registeredOffice
        - locationOfFacilities
        - dateOfIncorporation
        - dateOfCommencement
        - panNo
        - gstNo
        - msmeStatus
        - status
        - submittedAt
      properties:
        id:
          type: string
          example: "reg-123"
        email:
          type: string
          format: email
        nameOfApplicant:
          type: string
        registeredOffice:
          type: string
        locationOfFacilities:
          type: string
        dateOfIncorporation:
          type: string
          format: date
        dateOfCommencement:
          type: string
          format: date
        panNo:
          type: string
        gstNo:
          type: string
        msmeStatus:
          type: string
          enum: [micro, small, medium]
        status:
          type: string
          enum: [pending, approved, rejected]
        submittedAt:
          type: string
          format: date-time

    RegistrationRequest:
      type: object
      required:
        - email
        - nameOfApplicant
        - registeredOffice
        - locationOfFacilities
        - dateOfIncorporation
        - dateOfCommencement
        - panNo
        - gstNo
        - msmeStatus
      properties:
        email:
          type: string
          format: email
        nameOfApplicant:
          type: string
        registeredOffice:
          type: string
        locationOfFacilities:
          type: string
        dateOfIncorporation:
          type: string
          format: date
        dateOfCommencement:
          type: string
          format: date
        panNo:
          type: string
        gstNo:
          type: string
        msmeStatus:
          type: string
          enum: [micro, small, medium]

    AppStatus:
      type: string
      enum: [submitted, approved, rejected, reverted, sanctioned, recommend_pursual, recommend_rejection]
      description: Current status of the application

    WorkflowStep:
      type: string
      enum: [
        prelim_submitted, prelim_rejected, prelim_revision, detailed_form_open,
        detailed_maker_review, detailed_checker_review, detailed_revision, detailed_rejected,
        icvd_maker_review, icvd_checker_review, icvd_convenor_scheduling, icvd_committee_review, icvd_referred,
        ccic_maker_refine, ccic_checker_review, ccic_convenor_scheduling, ccic_committee_review,
        final_approval, sanctioned, final_rejected
      ]
      description: Current workflow step of the application
    Application:
      type: object
      required:
        - id
        - applicantEmail
        - status
        - stage
        - workflowStep
        - comments
        - auditTrail
        - submittedAt
        - updatedAt
      properties:
        id:
          type: string
          example: "app-123"
        applicantEmail:
          type: string
          format: email
        status:
          $ref: '#/components/schemas/AppStatus'
        stage:
          type: string
          enum: [prelim, detailed, icvd, ccic, final, post_sanction]
        workflowStep:
          $ref: '#/components/schemas/WorkflowStep'
        assignedMaker:
          type: string
        assignedChecker:
          type: string
        assignedConvenor:
          type: string
        assignedApprover:
          type: string
        recommendedOutcome:
          type: string
          enum: [rejection, pursual]
        prelimData:
          type: object
          nullable: true
        detailedData:
          type: object
          nullable: true
        icvdNote:
          type: object
          nullable: true
        ccicNote:
          type: object
          nullable: true
        icvdMeetingId:
          type: string
        ccicMeetingId:
          type: string
        comments:
          type: object
          additionalProperties:
            $ref: '#/components/schemas/FieldComment'
        auditTrail:
          type: array
          items:
            $ref: '#/components/schemas/AuditEntry'
        submittedAt:
          type: string
          format: date-time
        updatedAt:
          type: string
          format: date-time

    FieldComment:
      type: object
      required:
        - needsChange
        - comment
      properties:
        needsChange:
          type: boolean
        comment:
          type: string

    AuditEntry:
      type: object
      required:
        - actorRole
        - actorId
        - actionType
        - remark
        - timestamp
      properties:
        actorRole:
          type: string
        actorId:
          type: string
        actionType:
          type: string
        remark:
          type: string
        timestamp:
          type: string
          format: date-time

    WorkflowAction:
      type: string
      enum: [
        revert_prelim, reject_prelim, approve_prelim,
        revert_detailed, recommend_rejection, recommend_pursual, reject_final, recommend_icvd, recommend_ccic,
        icvd_maker_forward, icvd_checker_assign_convenor, icvd_schedule_meeting, icvd_committee_refer,
        submit_icvd_note, revert_icvd, approve_icvd, record_committee_decision,
        ccic_maker_upload, ccic_checker_assign_convenor, ccic_schedule_meeting, ccic_committee_refer,
        submit_ccic_note, revert_ccic, approve_ccic,
        approve_sanction, reject_sanction
      ]
      description: Available workflow actions

    WorkflowActionRequest:
      type: object
      required:
        - action
        - actor
      properties:
        action:
          $ref: '#/components/schemas/WorkflowAction'
        actor:
          type: object
          required:
            - role
            - id
          properties:
            role:
              type: string
            id:
              type: string
        comment:
          type: string
        assignedChecker:
          type: string
        assignedConvenor:
          type: string
        assignedApprover:
          type: string
        recommendedOutcome:
          type: string
          enum: [rejection, pursual]
        meetingId:
          type: string
    CommitteeMember:
      type: object
      required:
        - id
        - name
        - email
        - role
      properties:
        id:
          type: string
        name:
          type: string
        email:
          type: string
          format: email
        role:
          type: string

    CommitteeMeeting:
      type: object
      required:
        - id
        - type
        - subject
        - meetingNumber
        - dateTime
        - totalMembers
        - selectedMembers
        - makerEmail
        - checkerEmail
        - convenorEmail
        - applicationIds
        - status
        - votes
        - createdAt
        - updatedAt
      properties:
        id:
          type: string
        type:
          type: string
          enum: [icvd, ccic]
        subject:
          type: string
        meetingNumber:
          type: integer
        dateTime:
          type: string
          format: date-time
        totalMembers:
          type: array
          items:
            $ref: '#/components/schemas/CommitteeMember'
        selectedMembers:
          type: array
          items:
            $ref: '#/components/schemas/CommitteeMember'
        makerEmail:
          type: string
          format: email
        checkerEmail:
          type: string
          format: email
        convenorEmail:
          type: string
          format: email
        approverEmail:
          type: string
          format: email
        applicationIds:
          type: array
          items:
            type: string
        status:
          type: string
          enum: [draft, scheduled, in_progress, completed]
        votes:
          type: array
          items:
            $ref: '#/components/schemas/MeetingVote'
        outcome:
          type: string
          enum: [referred, rejected]
        createdAt:
          type: string
          format: date-time
        updatedAt:
          type: string
          format: date-time

    MeetingRequest:
      type: object
      required:
        - type
        - subject
        - meetingNumber
        - dateTime
        - totalMembers
        - selectedMembers
        - makerEmail
        - checkerEmail
        - convenorEmail
        - applicationIds
        - status
      properties:
        type:
          type: string
          enum: [icvd, ccic]
        subject:
          type: string
        meetingNumber:
          type: integer
        dateTime:
          type: string
          format: date-time
        totalMembers:
          type: array
          items:
            $ref: '#/components/schemas/CommitteeMember'
        selectedMembers:
          type: array
          items:
            $ref: '#/components/schemas/CommitteeMember'
        makerEmail:
          type: string
          format: email
        checkerEmail:
          type: string
          format: email
        convenorEmail:
          type: string
          format: email
        approverEmail:
          type: string
          format: email
        applicationIds:
          type: array
          items:
            type: string
        status:
          type: string
          enum: [draft, scheduled, in_progress, completed]

    MeetingVote:
      type: object
      required:
        - memberId
        - vote
        - comment
        - timestamp
      properties:
        memberId:
          type: string
        vote:
          type: string
          enum: [approve, reject, abstain]
        comment:
          type: string
        timestamp:
          type: string
          format: date-time

    Error:
      type: object
      required:
        - status
        - data
      properties:
        status:
          type: integer
        data:
          type: string
```
---

## Error Handling
All endpoints return errors in the following format:
```typescript
{
  error: {
    status: number;
    data: string;
  }
}
```

Common error codes:
- `401` - Unauthorized (invalid credentials)
- `404` - Resource not found
- `400` - Invalid workflow transition

---

## Data Persistence
The mock API uses in-memory storage with the following "database tables":
- `DB_REGISTRATIONS` - Registration requests
- `DB_APPLICATIONS` - Applications
- `DB_MEETINGS` - Committee meetings
- `DB_SESSION` - Current authentication session

All mutations modify these arrays in place and include simulated async delays (100-300ms) to mimic real API behavior.

---

## Example: Complete Application Flow

```typescript
// 1. Login as applicant
const [login] = useLoginMutation();
await login({ email: "applicant@demo.com", password: "any" });

// 2. Create preliminary application
const [createPrelim] = useCreatePrelimApplicationMutation();
const { data: app } = await createPrelim({
  email: "applicant@demo.com",
  prelimData: { /* form data */ }
});

// 3. SIDBI maker reviews and approves
const [applyAction] = useApplyWorkflowActionMutation();
await applyAction({
  id: app.id,
  action: "approve_prelim",
  actor: { role: "maker", id: "sidbi-maker@demo.com" },
  comment: "Approved"
});

// 4. Applicant submits detailed application
const [submitDetailed] = useSubmitDetailedApplicationMutation();
await submitDetailed({
  appId: app.id,
  detailedData: { /* detailed form data */ }
});

// 5. Continue through workflow...
```

---

## Testing with Swagger UI

To test the API endpoints using Swagger UI:

1. **Copy the OpenAPI specification** from the YAML section above
2. **Paste it into Swagger Editor** at https://editor.swagger.io/
3. **Use the "Try it out" feature** to test endpoints
4. **Note**: Since this is a mock API, actual HTTP calls won't work, but you can use the specification for documentation and client generation

---

## Client Code Generation

You can generate client code from the OpenAPI specification using tools like:

- **OpenAPI Generator**: https://openapi-generator.tech/
- **Swagger Codegen**: https://swagger.io/tools/swagger-codegen/
- **TypeScript**: Use `openapi-typescript` for type generation

Example command:
```bash
npx openapi-typescript api-spec.yaml --output types/api.ts
```

---

## Notes

1. **Demo Authentication**: All demo accounts accept any password for login
2. **Legacy Support**: The API includes automatic backfilling for legacy records without `workflowStep` or `auditTrail`
3. **Workflow Validation**: Workflow transitions are validated against the state machine before execution
4. **Timestamps**: All timestamps are in ISO 8601 format
5. **Console Logging**: The API logs all operations to the console for debugging
6. **Immutability**: Uses deep copying to handle RTK Query's frozen objects

---

## Support

For questions or issues:
- **Source Code**: `src/store/api.ts`
- **Mock Data**: `src/store/mockData.ts`
- **Type Definitions**: `src/lib/` directory
- **Contact**: VDF Development Team

---

**API Documentation Version**: 1.0.0  
**Last Updated**: March 2026  
**Status**: Development Ready ✅