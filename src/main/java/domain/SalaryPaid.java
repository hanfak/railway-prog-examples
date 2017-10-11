package domain;

import java.time.ZonedDateTime;

public class SalaryPaid extends ValueType {
    public final ZonedDateTime dataOfPayment;
    public final Integer amount;

    public SalaryPaid(ZonedDateTime dataOfPayment, Integer amount) {
        this.dataOfPayment = dataOfPayment;
        this.amount = amount;
    }
}
