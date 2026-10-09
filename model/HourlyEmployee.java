package model;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {
    private static final double REGULAR_HOURS_LIMIT = 40.0;
    private double hourlyRate;
    private double hoursWorked;
    private double overtimeRate;

    public HourlyEmployee(int id, String name, Gender gender, LocalDate hireDate, double hourlyRate, double hoursWorked, double overtimeRate) {
        super(id, name, gender, hireDate);
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
        setOvertimeRate(overtimeRate);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate < 0) {
            throw new IllegalArgumentException("Hourly rate cannot be negative.");
        }
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }
        this.hoursWorked = hoursWorked;
    }

    public double getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(double overtimeRate) {
        if (overtimeRate < 0) {
            throw new IllegalArgumentException("Overtime rate cannot be negative.");
        }
        this.overtimeRate = overtimeRate;
    }

    @Override
    public double calculateSalary() {
        double regularHours = Math.min(hoursWorked, REGULAR_HOURS_LIMIT);
        double overtimeHours = Math.max(0, hoursWorked - REGULAR_HOURS_LIMIT);

        return regularHours * hourlyRate + overtimeHours * overtimeRate;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" + super.toString()
                + String.format(
                ", hourlyRate=%.2f, hoursWorked=%.2f, "
                + "overtimeRate=%.2f, salary=%.2f}",
                hourlyRate,
                hoursWorked,
                overtimeRate,
                calculateSalary()
        );
    }
}