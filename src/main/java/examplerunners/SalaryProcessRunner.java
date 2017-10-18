package examplerunners;

import application.SalaryUsecase;
import domain.Employee;

import java.util.List;

import static java.util.Arrays.asList;

public class SalaryProcessRunner {
    public static void main(String[] args) {
        SalaryUsecase salaryUsecase = new SalaryUsecase();
        List<Employee> employees = asList(new Employee("director", -1), new Employee("manager", 2345), new Employee("dev", -1));

        System.out.println("First example: If not payed due to bad id, recover and pay if correct job position. Return type HappyPath");
        salaryUsecase.querySalaryPaid(employees);

        System.out.println("\nSecond example: Using mappings, returns HappyPath, where happy path returns Integer(amount)" +
                "If not payed due to bad id, recover and pay if correct job position.");
        salaryUsecase.querySalaryPaidVersion2(employees);

        System.out.println("\nThird example: Using mappings, returns SadPath, where happy path returns SalaryPaid" +
                "If not payed due to bad id, return sad path SalaryNotPaid. No recovery");
        salaryUsecase.querySalaryPaidVersion3(employees);


    }
}
