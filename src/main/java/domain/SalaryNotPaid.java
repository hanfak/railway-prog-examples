package domain;

public class SalaryNotPaid extends ValueType {
    public final String reasonNotPaid;

    public SalaryNotPaid(String reasonNotPaid) {
        this.reasonNotPaid = reasonNotPaid;
    }
}
