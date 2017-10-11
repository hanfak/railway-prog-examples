package domain.helpers;

import domain.FiringReason;
import domain.JobAction;
import io.github.theangrydev.businessflows.PotentialFailure;

import static io.github.theangrydev.businessflows.PotentialFailure.failure;
import static io.github.theangrydev.businessflows.PotentialFailure.success;
import static java.lang.String.format;

public class FiringProcessHelper {
    public static PotentialFailure<FiringReason> shouldSack(JobAction action) {
        if (action.shouldFire) {
            return failure(new FiringReason(format("'%s'", action.actionType)));
        }
        return success();
    }
}
