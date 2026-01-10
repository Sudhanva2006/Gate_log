# Gate Log System

## Overview
The Gate Log System is a Java-based mini project developed to digitize campus gate operations.  
It replaces manual register entries by providing a secure and persistent system for managing visitor entries and student exit permissions.

## Problem Statement
Our college still relies on manual registers and physical permission letters for visitor logging and student exit approvals, which is time-consuming and inefficient.

## Solution
This project provides a role-based digital system where:
- Faculty can approve student exit requests.
- Security/Admin can verify student exits and manage visitor entries.
- All data is stored permanently using a MySQL database.

## Key Features
- Role-based login (Admin / Faculty)
- Student exit approval using USN
- Visitor entry and visitor log management
- MySQL database integration using JDBC
- Data persistence across application restarts

## Technologies Used
- Java
- MySQL
- JDBC
- Git & GitHub

## Project Structure
- `MainApp.java` – Controls application flow and menus
- `User.java` – Base class for authentication
- `Admin.java`, `Faculty.java` – Role-based access using inheritance
- `StudentExit.java` – Model for student exit data
- `Visitor.java` – Model for visitor data
- `StudentExitDAO.java` – Database operations for student exits
- `VisitorDAO.java` – Database operations for visitors
- `DBConnection.java` – Handles MySQL connectivity

## How It Works
1. Faculty logs in and approves a student exit request.
2. The exit details are stored in the MySQL database.
3. Admin logs in and verifies student exit using USN.
4. Admin can add and view visitor entries.
5. All records remain available even after restarting the application.

## Future Enhancements
- User interface using Java Swing or JavaFX
- Separate applications for Admin and Faculty
- Web-based version

## Conclusion
The Gate Log System provides an efficient and secure way to manage campus gate activities and demonstrates the use of Java, OOP concepts, and database integration in a real-world scenario.
