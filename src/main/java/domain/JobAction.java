package domain;

import java.time.ZonedDateTime;

import static java.time.ZonedDateTime.now;

public class JobAction extends ValueType {
    public static final JobAction DROPED_PRODUCTION_DATABASE = jobAction(now().minusDays(1), "Dropped the database", true);
    public static final JobAction REDUCED_SQL_QUERY_SPEEDS = jobAction(now().minusHours(2), "Increased SQL efficiency", false);

    public final ZonedDateTime timeOfAction;
    public final String actionType;
    public final Boolean shouldFire;

    private JobAction(ZonedDateTime timeOfAction, String actionType, Boolean shouldFire) {
        this.timeOfAction = timeOfAction;
        this.actionType = actionType;
        this.shouldFire = shouldFire;
    }

    private static JobAction jobAction(ZonedDateTime timeOfAction, String actionType, Boolean shouldFire) {
        return new JobAction(timeOfAction, actionType, shouldFire);
    }

}
