# Student Management System

A Java Swing-based desktop application for managing student records with a MySQL database backend. This application provides a user-friendly graphical interface for performing CRUD (Create, Read, Update, Delete) operations on student data.

## Features

- **Add Students**: Insert new student records with validation
- **Display Records**: View student information by ID
- **Update Records**: Modify existing student data
- **Delete Records**: Remove student records from the database
- **User-Friendly GUI**: Intuitive Java Swing interface
- **Input Validation**: Ensures data integrity with validation checks

## Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher
- **MySQL Server**: Version 8.0 or higher
- **MySQL JDBC Driver**: Connector/J driver for database connectivity

## Database Setup

1. **Create the Database**:
   ```sql
   CREATE DATABASE sms;
   USE sms;
   ```

2. **Import the Database Schema**:
   - Execute the `sms_student.sql` file to create the `student` table
   - The SQL file includes the table structure and sample data

3. **Database Configuration**:
   - **Database Name**: `sms`
   - **Table Name**: `student`
   - **Table Structure**:
     - `id` (INT, PRIMARY KEY, UNIQUE)
     - `name` (VARCHAR(45))
     - `class` (VARCHAR(10))
     - `marks` (INT)
     - `gender` (VARCHAR(10))

4. **Update Database Connection**:
   - If your MySQL credentials differ, update the connection string in `StudentManagementSystem.java`
   - Default connection: `jdbc:mysql://localhost:3306/sms`
   - Update username and password as needed

## Project Structure

```
sms/
├── README.md                          # Project documentation
├── sms_student.sql                    # Database schema and data
├── StudentManagementSystem.jar        # Executable JAR file
└── StudentManagementSystem/
    ├── src/                           # Source code
    │   ├── StudentManagementSystem.java  # Database operations class
    │   ├── home.java                  # Main menu window
    │   ├── add.java                   # Add student window
    │   ├── read.java                  # Display student window
    │   ├── update.java                # Update student window
    │   └── remove.java                # Delete student window
    └── bin/                           # Compiled class files
```

## How to Run

### Option 1: Using the JAR File (Recommended)

1. Ensure MySQL server is running and the database is set up
2. Double-click `StudentManagementSystem.jar` or run:
   ```bash
   java -jar StudentManagementSystem.jar
   ```
3. If you get a "no main manifest" error, compile and run from source instead

### Option 2: Compile and Run from Source

1. **Compile the Java files**:
   ```bash
   cd StudentManagementSystem/src
   javac -cp "path/to/mysql-connector-java.jar" *.java
   ```

2. **Run the application**:
   ```bash
   java -cp "path/to/mysql-connector-java.jar:." home
   ```

   Or on Windows:
   ```bash
   java -cp "path\to\mysql-connector-java.jar;." home
   ```

## Usage

1. **Launch the Application**: Run the `home.java` class to open the main menu
2. **Main Menu Options**:
   - **Insert Record**: Add a new student to the database
   - **Display Record**: View student details by ID
   - **Update Record**: Modify existing student information
   - **Delete Record**: Remove a student from the database

3. **Input Validation**:
   - ID: Must be a valid integer
   - Name: Must contain only alphabets
   - Class: Must be a single letter (A-Z or a-z)
   - Marks: Must be a valid integer
   - Gender: Must contain only alphabets

## Technology Stack

- **Programming Language**: Java
- **GUI Framework**: Java Swing
- **Database**: MySQL 8.0
- **JDBC Driver**: MySQL Connector/J

## Notes

- Make sure MySQL server is running before launching the application
- Ensure the MySQL JDBC driver is included in the classpath when compiling/running
- The application connects to `localhost:3306` by default
- Update database credentials in `StudentManagementSystem.java` if needed

## Repository Contents

This repository contains:
1. **Source Code**: All Java source files in the `src/` directory
2. **Executable JAR File**: Pre-compiled application (if available)
3. **MySQL Database Schema**: SQL dump file for database setup

## Support

For issues or questions, please check:
- Database connection settings
- MySQL server status
- JDBC driver availability
- Input validation requirements
