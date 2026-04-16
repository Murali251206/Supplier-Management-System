# Supplier Management System (JDBC) - Setup Guide

This project is a console-based Supplier Management System built using Java and JDBC. It supports full CRUD operations with features like data validation and soft deletion.

## Prerequisites
1. **Java JDK 25** (already installed in your environment).
2. **MySQL Database Server**.
3. **MySQL JDBC Driver** (`mysql-connector-j-x.x.x.jar`).

## Setup Instructions

### 1. Database Setup
- Open your MySQL command-line client or a tool like MySQL Workbench.
- Execute the script found in `sql/schema.sql`:
  ```sql
  source c:/Users/Muraliprasath B/JavaProgram/Supplier Management System/sql/schema.sql;
  ```
- Important: Update the database credentials (username and password) in [DBConnection.java](file:///c:/Users/Muraliprasath%20B/JavaProgram/Supplier%20Management%20System/src/main/java/com/sys/util/DBConnection.java).

### 2. Compilation
To compile the project from the root directory, use the following command (assuming you have the JDBC driver JAR in a folder named `lib`):
```powershell
javac -d bin -cp ".;lib/*" src/main/java/com/sys/model/*.java src/main/java/com/sys/util/*.java src/main/java/com/sys/dao/*.java src/main/java/com/sys/service/*.java src/main/java/com/sys/App.java
```

### 3. Running the Application
To run the application:
```powershell
java -cp "bin;lib/*" com.sys.App
```

## Features
- **Add Supplier**: Collects name, contact person, email, phone, and address.
- **View All**: Displays all active (non-deleted) suppliers.
- **Search**: Search by ID or Name (partial, case-insensitive).
- **Update**: Edit details of an existing supplier.
- **Delete**: Soft delete (marks records as deleted without removing them from the DB).
- **Validation**: Ensures valid email formats and phone number lengths.

## Project Structure
- `com.sys.model`: Entity class (`Supplier`).
- `com.sys.dao`: Data Access Object layer for SQL operations.
- `com.sys.service`: Business logic and validation.
- `com.sys.util`: Database connection and validation utilities.
- `com.sys.App`: Entry point with terminal menu.
