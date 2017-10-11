package application;

import domain.Employee;
import domain.SalaryNotPaid;
import domain.SalaryPaid;
import domain.helpers.SalaryHelper;
import io.github.theangrydev.businessflows.BusinessFlow;
import io.github.theangrydev.businessflows.SadPath;
import org.assertj.core.util.Compatibility;

import java.util.List;

public class SalaryUsecase {
    @SuppressWarnings("ConstantConditions")
    public void querySalaryPaid(List<Employee> employees) {
        employees.forEach(this::payEmpl);
    }

    private SadPath<Integer, SalaryNotPaid> payEmpl(Employee employee) {
        return SalaryHelper.payEmployee(employee)
                .ifHappy().peek(this::reportsituation)
                    .map(x -> x.amount)
                    .peek(System.out::println)
                .ifSad().peek(this::reportNotPaid);
    }


    private void reportNotPaid(SalaryNotPaid salaryNotPaid) {
        System.out.println("Not paid because " + salaryNotPaid.reasonNotPaid);
    }

    private void reportsituation(SalaryPaid salaryPaid) {
        System.out.println(salaryPaid.amount + " paid on " + salaryPaid.dataOfPayment);
    }

    // map
}
