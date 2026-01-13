# Gate Log System

## Overview
The Gate Log System is a Java-based console application developed to manage college gate activities such as visitor entry and student exit permissions.  
It replaces the traditional manual register-based system with a digital solution using a MySQL database.

## Problem Statement
Our college still uses manual registers and physical permission letters for managing visitor entries and student exits.  
This process is time-consuming, difficult to maintain, and inefficient.

## Features
- Role-based login for Admin and Faculty
- Faculty can approve student exit requests
- Admin can add visitor entries
- Admin can verify student exit permissions using USN
- Visitor and student data stored permanently in MySQL

## Technologies Used
- Java (Core Java, JDBC)
- MySQL Database
- MySQL Connector/J
- Visual Studio Code
- GitHub

## Requirements
- Java JDK 8 or above
- MySQL Server
- MySQL Connector/J (JDBC driver)

## Installation and Setup

### Step 1: Install Java JDK
- Download Java JDK from: https://www.oracle.com/java
- Ensure Java is added to PATH by running: javac -version


### Step 2: Install MySQL Server
- Download MySQL from: https://dev.mysql.com/downloads/mysql
- Set a root password during installation

### Step 3: Create Database
Open MySQL Shell or Command Line and run:
\sql
CREATE DATABASE gatelog_db;
USE gatelog_db;

Step 4: Create Tables

CREATE TABLE student_exit (
    usn VARCHAR(20),
    student_name VARCHAR(50),
    department VARCHAR(30),
    year INT,
    reason VARCHAR(100),
    approved_by VARCHAR(30)
);

CREATE TABLE visitor_log (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    phone VARCHAR(15),
    purpose VARCHAR(100),
    in_time VARCHAR(20),
    out_time VARCHAR(20)
);

Step 5: Add MySQL Connector
   Download MySQL Connector/J
   Place the .jar file inside the lib folder of the project

   How to Run the Project

   Open Command Prompt / PowerShell in the project root directory
   Compile the Java files: javac -cp ".;lib/mysql-connector-j-9.5.0.jar" gatelog/*.java
   Run the application: java -cp ".;lib/mysql-connector-j-9.5.0.jar" gatelog.MainApp

Database Tables
   student_exit – Stores student exit approval details
   visitor_log – Stores visitor entry details

   <img width="1388" height="867" alt="image" src="https://github.com/user-attachments/assets/5a6c2b17-4294-4b61-bbf4-e1a0d7cd2090" />

Screenshots

Screenshots showing admin login, faculty approval, visitor entry, and database output are included in the project report.

<img width="944" height="498" alt="image" src="https://github.com/user-attachments/assets/1d7da1fc-7132-40fe-9b03-84b990cb0e66" />
<img width="900" height="565" alt="image" src="https://github.com/user-attachments/assets/7217981f-7594-4f87-8807-df985d639358" />
<img width="900" height="410" alt="image" src="https://github.com/user-attachments/assets/9700df57-d20b-449f-baa6-f366cf252f27" />

Conclusion

The Gate Log System successfully digitizes college gate management.
It demonstrates the use of Java, object-oriented programming concepts, JDBC, and MySQL in a real-world application.

Author

Sudhanva2006
