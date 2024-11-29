package com.example.employeedm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;

public class HelloController {

    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> idColumn;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, String> positionColumn;
    @FXML
    private TableColumn<Employee, Double> salaryColumn;
    @FXML
    private TableColumn<Employee, Date> hireDateColumn;

    @FXML
    private TextField nameField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField salaryField;
    @FXML
    private DatePicker hireDateField;

    @FXML
    private Label messageLabel;

    private final EmployeeData employeeData = new EmployeeData();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        hireDateColumn.setCellValueFactory(new PropertyValueFactory<>("hireDate"));

        refreshTable();
    }

    @FXML
    private void loadEmployees() {
        refreshTable();
        messageLabel.setText("Employee list loaded!");
    }

    @FXML
    private void addEmployee() {
        String name = nameField.getText();
        String position = positionField.getText();
        String salaryText = salaryField.getText();
        if (hireDateField.getValue() == null) {
            showMessage("Please select a hire date!");
            return;
        }
        Date hireDate = Date.valueOf(hireDateField.getValue());

        if (name.isEmpty() || position.isEmpty() || salaryText.isEmpty()) {
            showMessage("All fields are required!");
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            showMessage("Invalid salary format!");
            return;
        }

        Employee newEmployee = new Employee(name, position, salary, hireDate);
        employeeData.createEmployee(newEmployee);
        refreshTable();
        showMessage("Employee added successfully!");
        clearFields();
    }

    @FXML
    private void updateEmployee() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null) {
            showMessage("Please select an employee to update!");
            return;
        }

        String name = nameField.getText();
        String position = positionField.getText();
        String salaryText = salaryField.getText();
        if (hireDateField.getValue() == null) {
            showMessage("Please select a hire date!");
            return;
        }
        Date hireDate = Date.valueOf(hireDateField.getValue());

        if (name.isEmpty() || position.isEmpty() || salaryText.isEmpty()) {
            showMessage("All fields are required!");
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            showMessage("Invalid salary format!");
            return;
        }

        selectedEmployee.setName(name);
        selectedEmployee.setPosition(position);
        selectedEmployee.setSalary(salary);
        selectedEmployee.setHireDate(hireDate);

        employeeData.updateEmployee(selectedEmployee);
        refreshTable();
        showMessage("Employee updated successfully!");
        clearFields();
    }

    @FXML
    private void deleteEmployee() {
        Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null) {
            showMessage("Please select an employee to delete!");
            return;
        }

        employeeData.deleteEmployee(selectedEmployee.getId());
        refreshTable();
        showMessage("Employee deleted successfully!");
    }

    private void refreshTable() {
        ObservableList<Employee> observableList = FXCollections.observableArrayList(employeeData.getAllEmployees());
        employeeTable.setItems(observableList);
    }

    private void showMessage(String message) {
        messageLabel.setText(message);
    }

    private void clearFields() {
        nameField.clear();
        positionField.clear();
        salaryField.clear();
        hireDateField.setValue(null);
    }
}
