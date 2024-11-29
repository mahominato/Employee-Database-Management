# Employee Management System

The Employee Management System is a JavaFX-based application for managing employee data. It allows users to add, update, delete, and view employee information stored in a MySQL database.

## Features

- Add new employees.
- View a list of employees.
- Edit employee details.
- Delete employee records.

## Technologies Used

- **Java 17**: Programming language.
- **JavaFX**: For building the graphical user interface.
- **MySQL**: For data storage.
- **Maven**: For dependency management.
- **Git**: For version control.

## Installation and Setup

### Prerequisites
- Install Java Development Kit (JDK) 17 or later.
- Install MySQL and create a database named `employee_db`.
- Install a Git client and an IDE like IntelliJ IDEA.

### 1. Clone the Repository
Clone this repository to your local machine using the following command:
```bash
git clone https://github.com/your-username/employee-management-system.git
 ```
### 2. Set Up the Database
Create the employee table in your employee_db database using the following SQL script:
```bash
CREATE TABLE employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(100),
    salary DOUBLE,
    hire_date DATE
);
 ```
Optionally, insert some sample data:
```bash
INSERT INTO employee (name, position, salary, hire_date)
VALUES ('John Doe', 'Software Engineer', 60000.00, '2024-11-29');
 ```
### 3. Configure the Database Connection
Update the database connection details in the EmployeeData class:
```bash
public static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/employee_db";
    String username = "root"; // Your MySQL username
    String password = "your_password"; // Your MySQL password
    return DriverManager.getConnection(url, username, password);
}
 ```
### 4. Build and Run the Application
- Open the project in IntelliJ IDEA.
- Use Maven to clean and build the project:
```bash
mvn clean install
 ```
- Run the JavaFX application:
 ```bash
mvn javafx:run
```
### Usage
Once the application is running, you can:

- Add employees using the provided form.
- View a list of employees in the table.
- Select an employee to update or delete their details.

### Screenshots
![image](https://github.com/user-attachments/assets/b84c1eb6-6cb5-4438-8b5b-35a202e03695)
![image](https://github.com/user-attachments/assets/e6d8e7d2-4447-4c80-be2e-95aeb6112730)
![image](https://github.com/user-attachments/assets/ff5e760b-1ddf-4bad-95dd-6fcab07a6748)
![image](https://github.com/user-attachments/assets/bb2b9cb1-69b8-4396-b9e0-d6cee8505ac8)
![image](https://github.com/user-attachments/assets/8c27aa71-32b7-40eb-bf0e-2df90a3afef4)


