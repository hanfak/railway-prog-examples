package domain;

public class FiringReason extends ValueType {
    public final String reasonForFiring;

    public FiringReason(String reasonForFiring) {
        this.reasonForFiring = reasonForFiring;
    }
}
