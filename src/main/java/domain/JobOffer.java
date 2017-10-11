package domain;

import java.time.ZonedDateTime;

public class JobOffer extends ValueType {

    public final ZonedDateTime startDate;
    public final Integer salary;

    public JobOffer(ZonedDateTime startDate, Integer salary) {
        this.startDate = startDate;
        this.salary = salary;
    }
}
