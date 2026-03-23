# 🎓 Student Registration App

A web-based **Student Registration System** built with **Java Servlets** and deployed on **Apache Tomcat** via **Smart Tomcat** plugin in IntelliJ IDEA.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Features](#features)
- [Screenshots](#screenshots)
- [Getting Started](#getting-started)
- [How It Works](#how-it-works)

---

## Overview

This application allows users to register students with their details (name, roll number, course, and marks) and view all registered students in a clean, responsive UI. Student data is stored in-memory using the Servlet context (application scope).

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Backend logic |
| Java Servlets (Jakarta EE) | HTTP request handling |
| Apache Tomcat 11 | Web server & servlet container |
| Smart Tomcat (IntelliJ Plugin) | Local development & hot deploy |
| HTML + CSS | Frontend UI (generated via `PrintWriter`) |
| Maven | Build & dependency management |

---

## Project Structure

```
Student-Registration-app/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/cfs/web/
│       │       ├── Course.java
│       │       ├── Student.java
│       │       ├── StudentListServlet.java    # GET /students
│       │       └── StudentRegServlet.java     # POST /student-registration
│       ├── resources/
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           └── index.html                     # Registration form
├── pom.xml
└── .gitignore
```

---

## Features

- ✅ Register a new student with name, roll number, course, and marks
- ✅ View all registered students in a formatted table
- ✅ In-memory list stored in servlet application context
- ✅ Redirect after form submission (POST → Redirect → GET pattern)
- ✅ Responsive and styled UI using inline CSS
- ✅ Student count badge displayed on the list page

---

## Screenshots

### 📝 Student Registration Form

> Register a student by filling in their full name, roll number, course, and total marks.

![Student Registration Form](Screenshot%202026-03-23%20103546.png)

---

### 📊 Registered Students List

> View all registered students with their details in a clean table layout.

![Registered Students List](Screenshot%202026-03-23%20103600.png)

---

## Getting Started

### Prerequisites

- Java 17+
- IntelliJ IDEA with **Smart Tomcat** plugin installed
- Apache Tomcat 10+ (configured in Smart Tomcat)
- Maven

### Run the App

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/Student-Registration-app.git
   cd Student-Registration-app
   ```

2. **Open in IntelliJ IDEA**

3. **Configure Smart Tomcat**
   - Go to `Run > Edit Configurations`
   - Add a new **Smart Tomcat** configuration
   - Set the Tomcat server and deployment context path (e.g., `/Student-Registration-app`)

4. **Run the project**
   - Click the Run button or press `Shift + F10`
   - App will be available at: `http://localhost:8080/Student-Registration-app/`

---

## How It Works

### Servlet Endpoints

| URL | Method | Servlet | Description |
|---|---|---|---|
| `/Student-Registration-app/` | GET | `index.html` | Shows the registration form |
| `/student-registration` | POST | `StudentRegServlet` | Handles form submission, adds student to list |
| `/students` | GET | `StudentListServlet` | Displays all registered students |

### Data Flow

```
User fills form (index.html)
        ↓
POST /student-registration  →  StudentRegServlet
        ↓
  Parses form params (name, roll, course, marks)
        ↓
  Creates Student object & adds to shared List
        ↓
  Redirects to /students
        ↓
GET /students  →  StudentListServlet
        ↓
  Retrieves list from application context
        ↓
  Renders HTML table with all students
```

---

## Author

**Rushikesh Sahane**  
Built as a Java Servlet practice project.
