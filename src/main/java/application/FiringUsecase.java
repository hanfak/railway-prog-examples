package application;

import domain.EmployerAction;
import domain.helpers.FiringProcessHelper;
import domain.FiringReason;
import domain.JobAction;
import io.github.theangrydev.businessflows.HappyPath;

import static java.lang.String.format;

public class FiringUsecase {
    public EmployerAction decideToFireFor(JobAction action) {
         return HappyPath.<JobAction, FiringReason>happyPath(checkJob(action))
                .attempt(FiringProcessHelper::shouldSack)
                .join(this::promote, this::fire);
    }

    private JobAction checkJob(JobAction action) {
        return action;
    }

    private EmployerAction promote(JobAction jobAction) {
        System.out.println(format("Good work on %s, carry on and you will get promotoed", jobAction.actionType));
        return new EmployerAction("nothing");
    }

    private EmployerAction fire(FiringReason firingReason) {
        System.out.println("You have been fired because " + firingReason.reasonForFiring);
        return new EmployerAction("Sack");
    }



}
