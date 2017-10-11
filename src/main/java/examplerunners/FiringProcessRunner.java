package examplerunners;

import application.FiringUsecase;
import domain.EmployerAction;

import static domain.JobAction.DROPED_PRODUCTION_DATABASE;
import static domain.JobAction.REDUCED_SQL_QUERY_SPEEDS;

public class FiringProcessRunner {
    public static void main(String[] args) {
        FiringUsecase firingUsecase = new FiringUsecase();
        EmployerAction employerActionGood = firingUsecase.decideToFireFor(DROPED_PRODUCTION_DATABASE);
        System.out.println("employerActionGood = " + employerActionGood.action);
        System.out.println();
        EmployerAction employerAction2 = firingUsecase.decideToFireFor(REDUCED_SQL_QUERY_SPEEDS);
        System.out.println("employerAction2 = " + employerAction2.action);
    }
}
