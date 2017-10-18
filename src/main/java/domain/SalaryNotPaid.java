package domain;

public class SalaryNotPaid extends ValueType {
    public final String reasonNotPaid;
    public final String reasonId;

    public SalaryNotPaid(String reasonNotPaid, String reasonId) {
        this.reasonNotPaid = reasonNotPaid;
        this.reasonId = reasonId;
    }
}
