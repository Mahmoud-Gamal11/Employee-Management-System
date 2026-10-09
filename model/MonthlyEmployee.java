package model;

import java.time.LocalDate;
import java.time.Period;

public class MonthlyEmployee extends Employee {
    private double monthlySalary;
    private int vacationDays;
    private double bonusPercentage;
    private boolean hasHealthInsurance;

    public MonthlyEmployee(int id, String name, Gender gender, LocalDate hireDate, double monthlySalary, int vacationDays, double bonusPercentage, boolean hasHealthInsurance) {
        super(id, name, gender, hireDate);
        setMonthlySalary(monthlySalary);
        setVacationDays(vacationDays);
        setBonusPercentage(bonusPercentage);
        setHasHealthInsurance(hasHealthInsurance);
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        if (monthlySalary < 0) {
            throw new IllegalArgumentException("Monthly salary cannot be negative.");
        }
        this.monthlySalary = monthlySalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        if (vacationDays < 0) {
            throw new IllegalArgumentException("Vacation days cannot be negative.");
        }
        this.vacationDays = vacationDays;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        if (bonusPercentage < 0 || bonusPercentage > 100) {
            throw new IllegalArgumentException("Bonus percentage must be between 0 and 100.");
        }
        this.bonusPercentage = bonusPercentage;
    }

    public boolean hasHealthInsurance() {
        return hasHealthInsurance;
    }

    public void setHasHealthInsurance(boolean hasHealthInsurance) {
        this.hasHealthInsurance = hasHealthInsurance;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary * (1 + bonusPercentage / 100.0);
    }

    public int calculateAdditionalVacation() {
        int yearsOfService = Period.between(getHireDate(), LocalDate.now()).getYears();
        return Math.max(0, yearsOfService / 5);
    }

    @Override
    public String toString() {
        return "MonthlyEmployee{" + super.toString()
                + String.format(
                ", monthlySalary=%.2f, vacationDays=%d, "
                + "additionalVacation=%d, bonusPercentage=%.2f%%, "
                + "healthInsurance=%s, salary=%.2f}",
                monthlySalary,
                vacationDays,
                calculateAdditionalVacation(),
                bonusPercentage,
                hasHealthInsurance,
                calculateSalary()
        );
    }
}