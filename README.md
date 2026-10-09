# Employee Management System

**Student Name:** Mahmoud Gamal Hussien AboBakr 

**Student ID:** 2301644  

## Project Description

This project is a Java implementation of an Employee Management System based on an Object-Oriented Programming (OOP) UML diagram.

The project demonstrates:

- Abstract classes
- Inheritance
- Polymorphism
- Encapsulation
- Enum usage
- Department and employee relationships
- Salary calculations

## Employee Types

- **MonthlyEmployee:** Receives a monthly salary and a bonus percentage.
- **CommissionEmployee:** Receives a base salary plus commission based on sales.
- **HourlyEmployee:** Receives payment based on worked hours and overtime rate.

## Project Structure

```text
src/
├── Main.java
├── model/
│   ├── Employee.java
│   ├── CommissionEmployee.java
│   ├── MonthlyEmployee.java
│   ├── HourlyEmployee.java
│   ├── Department.java
│   └── Gender.java
└── test/
    └── MainTest.java
```

## Features

- Add employees to a department.
- Remove employees from a department.
- Find an employee by ID.
- Calculate employee salaries.
- Calculate commission for commission employees.
- Calculate additional vacation days for monthly employees.
- Calculate the total payroll of a department.
- Print all employees in a department.

## How to Run

1. Open the project using IntelliJ IDEA, Eclipse, NetBeans, or VS Code.
2. Make sure that Java JDK is installed.
3. Run the `Main.java` file.

Or run it from the terminal:

```powershell
javac -d out src/Main.java src/model/*.java src/test/MainTest.java
java -cp out Main
```
