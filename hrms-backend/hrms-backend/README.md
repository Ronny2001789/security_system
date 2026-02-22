HR Management API
A comprehensive backend system built with Java and Spring Boot to streamline employee management, payroll processing, and leave request workflows for modern enterprises.
📖 Overview
This project is a role-based HR Management System designed for enterprise environments. It enforces strict role-based access control (RBAC), ensuring Admins, HR personnel, Managers, and Employees each operate within clearly defined permissions. The system combines layered security with real-world business logic to provide a robust backend solution for HR operations.
✨ Features

Role-based access control (RBAC) with secure JWT authentication
Employee profile and records management
Leave request submission and approval workflows
Payroll processing and tracking
Performance review system
Attendance monitoring
Method-level security with @PreAuthorize annotations
Row-level security logic to restrict data exposure
Interactive API testing via Swagger UI

🔐 Roles & Permissions

Admin: Full system access and user management
HR: Manage employee records, benefits, and organizational data
Manager: Approve leave requests and view team information
Employee: Access own profile, submit leave requests, view payslips

⚙️ Tech Stack

Java 17+
Spring Boot 3.x
Spring Security 6.x
Spring Data JPA + Hibernate
PostgreSQL + Flyway
JWT (jjwt)


🚀 Live Demo & Resources

🔗 View GitHub Code
▶️ Watch Demo
📄 Project Documentation


🧰 Getting Started
Prerequisites

Java 17 or higher
Docker
PostgreSQL 14+