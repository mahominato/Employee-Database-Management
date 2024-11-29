package com.example.employeedm;

import javafx.beans.property.*;

import java.sql.Date;

public class Employee {
    private IntegerProperty id;
    private StringProperty name;
    private StringProperty position;
    private DoubleProperty salary;
    private ObjectProperty<Date> hireDate;

    public Employee(int id, String name, String position, double salary, Date hireDate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.position = new SimpleStringProperty(position);
        this.salary = new SimpleDoubleProperty(salary);
        this.hireDate = new SimpleObjectProperty<>(hireDate);
    }

    public Employee(String name, String position, double salary, Date hireDate) {
        this.name = new SimpleStringProperty(name);
        this.position = new SimpleStringProperty(position);
        this.salary = new SimpleDoubleProperty(salary);
        this.hireDate = new SimpleObjectProperty<>(hireDate);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getPosition() {
        return position.get();
    }

    public double getSalary() {
        return salary.get();
    }

    public Date getHireDate() {
        return hireDate.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public void setSalary(double salary) {
        this.salary.set(salary);
    }

    public void setHireDate(Date hireDate) {
        this.hireDate.set(hireDate);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty positionProperty() {
        return position;
    }

    public DoubleProperty salaryProperty() {
        return salary;
    }

    public ObjectProperty<Date> hireDateProperty() {
        return hireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id.get() +
                ", name='" + name.get() + '\'' +
                ", position='" + position.get() + '\'' +
                ", salary=" + salary.get() +
                ", hireDate=" + hireDate.get() +
                '}';
    }
}
