package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private Employee manager;
    private final List<Employee> employees;

    public Department(int id, String name, Employee manager, List<Employee> employees) {
        setId(id);
        setName(name);
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee employee : employees) {
                addEmployee(employee);
            }
        }

        setManager(manager);
    }

    public Department(int id, String name, Employee manager) {
        this(id, name, manager, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Department id must be positive.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name is required.");
        }
        this.name = name.trim();
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;

        if (manager != null && !employees.contains(manager)) {
            addEmployee(manager);
        }
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    public void setEmployees(List<Employee> newEmployees) {
        List<Employee> oldEmployees = new ArrayList<>(employees);

        for (Employee employee : oldEmployees) {
            removeEmployee(employee.getId());
        }

        if (newEmployees != null) {
            for (Employee employee : newEmployees) {
                addEmployee(employee);
            }
        }

        if (manager != null && !employees.contains(manager)) {
            addEmployee(manager);
        }
    }

    public void addEmployee(Employee employee) {
        Objects.requireNonNull(employee, "Employee is required.");

        Employee existingEmployee = findEmployee(employee.getId());

        if (existingEmployee != null && existingEmployee != employee) {
            throw new IllegalArgumentException("An employee with this id already exists.");
        }

        if (employees.contains(employee)) {
            return;
        }

        Department oldDepartment = employee.getDepartment();

        if (oldDepartment != null && oldDepartment != this) {
            oldDepartment.removeEmployee(employee.getId());
        }

        employees.add(employee);
        employee.setDepartment(this);
    }

    public void removeEmployee(int employeeId) {
        Employee employee = findEmployee(employeeId);

        if (employee == null) {
            return;
        }

        employees.remove(employee);

        if (employee.getDepartment() == this) {
            employee.setDepartment(null);
        }

        if (manager == employee) {
            manager = null;
        }
    }

    public Employee findEmployee(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getId() == employeeId) {
                return employee;
            }
        }

        return null;
    }

    public double calculateTotalPayroll() {
        double total = 0;

        for (Employee employee : employees) {
            total += employee.calculateSalary();
        }

        return total;
    }

    public void printAllEmployees() {
        System.out.println("Employees in " + name + ":");

        for (Employee employee : employees) {
            System.out.println("- " + employee);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Department{id=%d, name='%s', manager=%s, employeeCount=%d}",
                id,
                name,
                manager == null ? "Not assigned" : manager.getName(),
                employees.size()
        );
    }
}