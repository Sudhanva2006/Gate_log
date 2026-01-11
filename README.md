# Gate Log System

## Overview
The Gate Log System is a Java-based console application designed to manage college visitor entries and student exit permissions.  
It replaces the traditional manual register-based system with a digital solution using MySQL.

## Features
- Role-based login for Admin and Faculty
- Faculty can approve student exit requests
- Admin can add visitor entries
- Admin can verify student exit permissions
- Visitor and student data stored permanently in MySQL

## Technologies Used
- Java (Core Java, JDBC)
- MySQL Database
- MySQL Connector/J
- VS Code

## Requirements
- Java JDK 8 or above
- MySQL Server
- MySQL Connector/J (JDBC driver)

## Installation and Setup

1. Install **Java JDK**
   - Download from: https://www.oracle.com/java/
   - Ensure `javac` works in command prompt

2. Install **MySQL Server**
   - Download from: https://dev.mysql.com/downloads/
   - Set root password during installation

3. Create Database
   ```sql
   CREATE DATABASE gatelog_db;
   USE gatelog_db;
4. Add MySQL Connector
    -Download MySQL Connector/J
    -Place the .jar file inside the lib folder

## How to Run

1. Open terminal/PowerShell in project root.
2. Compile Java files with JDBC library: javac -cp ".;lib/mysql-connector-j-9.5.0.jar" gatelog/*.java
3. Run the application: java -cp ".;lib/mysql-connector-j-9.5.0.jar" gatelog.MainApp

   
## Screenshots
<img width="944" height="498" alt="image" src="https://github.com/user-attachments/assets/4d535ece-1279-4698-b977-bc7e11db77e9" />
<img width="900" height="565" alt="image" src="https://github.com/user-attachments/assets/69726efc-fcda-431d-882f-f2ab01baeb79" />



## Database Tables
- `student_exit` – stores student exit requests
- `visitor_log` – stores visitor entries

## Author
Sudhanva2006



