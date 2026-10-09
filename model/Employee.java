package model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate hireDate;
    private Department department;

    public Employee(int id, String name, Gender gender, LocalDate hireDate) {
        setId(id);
        setName(name);
        setGender(gender);
        setHireDate(hireDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Employee id must be positive.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name is required.");
        }
        this.name = name.trim();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = Objects.requireNonNull(gender, "Gender is required.");
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = Objects.requireNonNull(hireDate, "Hire date is required.");
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format(
                "id=%d, name='%s', gender=%s, hireDate=%s, department=%s",
                id,
                name,
                gender,
                hireDate,
                department == null ? "Not assigned" : department.getName()
        );
    }
}