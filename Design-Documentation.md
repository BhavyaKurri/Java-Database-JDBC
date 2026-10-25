
# Design Documentation

## 1. Project Overview
The Student Management System is a command-line Java application
that stores student information in a MySQL database.

## 2. Architecture
User → Main.java → StudentDAO.java → JDBC → MySQL

## 3. Class Responsibilities
- Main: Displays the menu and reads user input.
- Student: Represents a student record.
- StudentDAO: Performs database CRUD operations.
- DatabaseConnection: Creates the JDBC connection.

## 4. Database Design
Table: students

| Column | Type | Constraint |
|---|---|---|
| id | INT | Primary key, auto increment |
| name | VARCHAR(100) | Not null |
| email | VARCHAR(120) | Unique, not null |
| course | VARCHAR(100) | Not null |
| age | INT | Not null |

## 5. CRUD Operations
- Create: INSERT
- Read: SELECT
- Update: UPDATE
- Delete: DELETE

## 6. Security and Transactions
PreparedStatement binds user input as parameters.
Database transactions use commit and rollback to maintain
consistency when a transaction fails.

## 7. Testing
Test adding, viewing, updating and deleting students.
Also test invalid IDs, duplicate email addresses and database
connection failures.
