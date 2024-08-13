## SAMPLE JAVA PROJECT 

# Java Database Connection Example

This repository contains a Java application that demonstrates how to connect to a MySQL database, execute queries, and handle results. It uses the provided SQL script to set up a sample database and tables.

## Prerequisites

Before running the application, ensure you have the following:

- **Java Development Kit (JDK)**: Version 8 or above.
- **MySQL Server**: Ensure MySQL server is installed and running.
- **MySQL JDBC Driver**: This should be included in your project's classpath. You can download it from [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/).

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/java-database-connection-example.git
cd java-database-connection-example
```

###  2. Create and Populate the Database
Run the provided SQL script to set up the database and tables:
```bash
CREATE DATABASE IF NOT EXISTS JAVA_APP;
USE JAVA_APP;

CREATE TABLE USERS(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(30) NOT NULL,
password VARCHAR(50) NOT NULL
);

CREATE TABLE employees (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100),
address VARCHAR(255),
phoneNumber VARCHAR(20),
birthDate VARCHAR(50),
email VARCHAR(100),
gender VARCHAR(10)
);

-- EXAMPLE DATA

INSERT INTO USERS(username, password) VALUES ("alexis", "password");

INSERT INTO employees (name, address, phoneNumber, birthDate, email, gender)
VALUES
('John Doe', '123 Main St', '555-1212', '1980-01-01', 'johndoe@example.com', 'Male'),
('Jane Smith', '456 Oak Ave', '555-1213', '1985-05-15', 'janesmith@example.com', 'Female'),
('Michael Johnson', '789 Elm St', '555-1214', '1978-11-20', 'michaeljohnson@example.com', 'Male'),
('Emily Brown', '321 Pine Rd', '555-1215', '1990-03-08', 'emilybrown@example.com', 'Female'),
('David Lee', '654 Cedar Ln', '555-1216', '1975-07-12', 'davidlee@example.com', 'Male'),
('Olivia Miller', '987 Maple Dr', '555-1217', '1982-09-25', 'oliviamiller@example.com', 'Female'),
('William Taylor', '246 Birch Ave', '555-1218', '1979-04-15', 'williamtaylor@example.com', 'Male'),
('Sophia Anderson', '864 Willow St', '555-1219', '1988-12-03', 'sophiaanderson@example.com', 'Female'),
('Benjamin Thomas', '510 Oak Ln', '555-1220', '1977-06-22', 'benjaminthemas@example.com', 'Male'),
('Charlotte Clark', '135 Pine Rd', '555-1221', '1992-01-18', 'charlottecclark@example.com', 'Female');
```

### 3. Configure Environment Variables

Set up the following environment variables for the Java application to connect to the MySQL database:

 - **DATABASE_NAME** – The name of the database (e.g., JAVA_APP).
 - **HOST** – The hostname or IP address of your MySQL server (e.g., localhost).
 - **PORT** – The port number on which MySQL is running (default is 3306).
 - **USERNAME** – The MySQL username.
 - **PASSWORD** – The MySQL password.

### 4. Compile and Run the Java Application
