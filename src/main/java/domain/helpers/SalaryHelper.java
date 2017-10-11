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
        if (employee.id < 0) {
            System.out.println("You are not an employee");
            return sadPath(new SalaryNotPaid("Id is not recognised, cannot pay you"));
        }
        return happyPath(new SalaryPaid(ZonedDateTime.now(), 42345));
    }
}
