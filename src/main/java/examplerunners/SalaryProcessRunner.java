package examplerunners;

import application.SalaryUsecase;
import domain.Employee;

import java.util.Arrays;
import java.util.List;

public class SalaryProcessRunner {
    public static void main(String[] args) {
        SalaryUsecase salaryUsecase = new SalaryUsecase();
        List<Employee> employees = Arrays.asList(new Employee("director", -1), new Employee("manager", 2345));
        salaryUsecase.querySalaryPaid(employees);
    }
}
