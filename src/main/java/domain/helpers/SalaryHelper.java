package domain.helpers;

import domain.Employee;
import domain.SalaryNotPaid;
import domain.SalaryPaid;
import io.github.theangrydev.businessflows.HappyPath;

import java.time.ZonedDateTime;

import static io.github.theangrydev.businessflows.HappyPath.happyPath;
import static io.github.theangrydev.businessflows.HappyPath.sadPath;

public class SalaryHelper {

    public static HappyPath<SalaryPaid, SalaryNotPaid> payEmployee(Employee employee) {
        if ("dev".equals(employee.position)) {
            System.out.println("You are an employee");
            return sadPath(new SalaryNotPaid("Sorry Id is not recognised, but position recognised, can pay you", "1"));
        }

        return determineLegalityOfEmployeeIdForSalaryPaymenent(employee.id);
    }

    public static SalaryPaid payDefaultSalaryVersionZero(String reasonId) {
        if ("1".equals(reasonId)) {
            System.out.println("Paid default salary of 10000");
            return new SalaryPaid(ZonedDateTime.now(), 10000);
        }
        System.out.println("Not paid a salary");
        return new SalaryPaid(ZonedDateTime.now(), 0);
    }

    public static Integer payDefaultSalaryVersionOne(String reasonId) {
        if ("1".equals(reasonId)) {
            System.out.println("Paid default salary of 10000");
            return 10000;
        }
        System.out.println("Not paid");
        return 0;
    }

    private static HappyPath<SalaryPaid, SalaryNotPaid> determineLegalityOfEmployeeIdForSalaryPaymenent(Integer employeeId) {
        if (0 >= employeeId) {
            System.out.println("You are not an employee");
            return sadPath(new SalaryNotPaid("Id is not recognised, cannot pay you", "0"));
        } else {
            System.out.println("You are an employee");
            return happyPath(new SalaryPaid(ZonedDateTime.now(), 42345));
        }
    }
}
