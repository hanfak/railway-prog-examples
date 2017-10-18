package domain;

import java.time.ZonedDateTime;

@SuppressWarnings("ALL")
public class JobOffer extends ValueType {

    public final ZonedDateTime startDate;
    private final Integer salary;

    public JobOffer(ZonedDateTime startDate, Integer salary) {
        this.startDate = startDate;
        this.salary = salary;
    }
}
