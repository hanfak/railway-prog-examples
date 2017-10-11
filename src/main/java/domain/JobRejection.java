package domain;

public class JobRejection extends ValueType {

    public final String reason;
    public final String name;

    public JobRejection(String reason, String name) {
        this.reason = reason;
        this.name = name;
    }
}
