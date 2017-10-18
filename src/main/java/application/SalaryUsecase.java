package application;

import domain.Employee;
import domain.SalaryNotPaid;
import domain.SalaryPaid;
import domain.helpers.SalaryHelper;
import io.github.theangrydev.businessflows.HappyPath;
import io.github.theangrydev.businessflows.SadPath;

import java.util.List;

import static domain.helpers.SalaryHelper.payDefaultSalaryVersionZero;

public class SalaryUsecase {
    @SuppressWarnings("ConstantConditions")
    public void querySalaryPaid(List<Employee> employees) {
        employees.stream().map(this::newLine).forEach(this::payEmployeeVersionOne);
    }

    public void querySalaryPaidVersion2(List<Employee> employees) {
        employees.stream().map(this::newLine).forEach(this::payEmployeeVersionTwo);
    }
    public void querySalaryPaidVersion3(List<Employee> employees) {
        employees.stream().map(this::newLine).forEach(this::payEmployeeVersionThree);
    }

    private HappyPath<SalaryPaid, SalaryNotPaid> payEmployeeVersionOne(Employee employee) {
        return SalaryHelper.payEmployee(employee)
                .ifHappy()
                    .peek(this::reportsituation)
                    .peek(x -> System.out.println("Date of payment " + x.dataOfPayment))
                .ifSad()
                    .peek(this::reportNotPaid)
                    .recover(salaryNotPaid -> payDefaultSalaryVersionZero(salaryNotPaid.reasonId));
    }

    private HappyPath<Integer, String> payEmployeeVersionTwo(Employee employee) {
        return SalaryHelper.payEmployee(employee)
                .ifHappy()
                    .peek(this::reportsituation)
                    .map(x -> x.amount)
                    .peek(amount -> System.out.println(amount + " is payed")) // print amount
                .ifSad()
                    .peek(this::reportNotPaid)
                    .map(x -> x.reasonId)
                    .recover(SalaryHelper::payDefaultSalaryVersionOne);
    }

    private SadPath<SalaryPaid, SalaryNotPaid> payEmployeeVersionThree(Employee employee) {
        return SalaryHelper.payEmployee(employee)
                .ifHappy().peek(this::reportsituation)
                .ifSad().peek(this::reportNotPaid);
                //.ifHappy(); //To return HappyPath add this
    }

    private void reportNotPaid(SalaryNotPaid salaryNotPaid) {
        System.out.println("Not paid because " + salaryNotPaid.reasonNotPaid);
    }

    private void reportsituation(SalaryPaid salaryPaid) {
        System.out.println(salaryPaid.amount + " paid on " + salaryPaid.dataOfPayment);
    }

    // For presentation purposes
    private Employee newLine(Employee employee) {
        System.out.println();
        return employee;
    }
}
