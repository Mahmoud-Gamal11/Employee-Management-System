package test;

import model.CommissionEmployee;
import model.Department;
import model.Employee;
import model.Gender;
import model.HourlyEmployee;
import model.MonthlyEmployee;

import java.time.LocalDate;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        MonthlyEmployee manager = new MonthlyEmployee(101, "Mona Ali", Gender.FEMALE, LocalDate.of(2015, 3, 15), 18000, 21, 10, true);
        CommissionEmployee salesEmployee = new CommissionEmployee(102, "Omar Hassan", Gender.MALE, LocalDate.of(2021, 7, 1), 8000, 8, 50000);
        HourlyEmployee supportEmployee = new HourlyEmployee(103, "Sara Ahmed", Gender.FEMALE, LocalDate.of(2023, 1, 10), 120, 45, 180);
        Department salesDepartment = new Department(10, "Sales", manager, List.of(manager, salesEmployee));
        salesDepartment.addEmployee(supportEmployee);

        System.out.println();

        System.out.println(salesDepartment);

        System.out.println();

        salesDepartment.printAllEmployees();
        System.out.printf("%nCommission for %s: %.2f%n", salesEmployee.getName(), salesEmployee.calculateCommission());

        System.out.println();

        System.out.printf("Additional vacation for %s: %d day(s)%n", manager.getName(), manager.calculateAdditionalVacation());

        System.out.printf("Total payroll: %.2f%n", salesDepartment.calculateTotalPayroll());

        Employee foundEmployee = salesDepartment.findEmployee(103);

        System.out.println("Found employee: " + foundEmployee);

        salesDepartment.removeEmployee(103);

        System.out.printf("Payroll after removing %s: %.2f%n", supportEmployee.getName(), salesDepartment.calculateTotalPayroll());
    }
}