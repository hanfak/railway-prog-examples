package examplerunners;

import application.ApplicationUsecase;
import domain.helpers.ApplicationProcessHelper;

public class JobApplicationProcessRunner {
    public static void main(String[] args) {
        ApplicationUsecase jobApplicationProcess = new ApplicationUsecase();
        ApplicationProcessHelper.candidateAccepts = "yes";

        System.out.println("First case - technical failure: magic age causes exception");
        jobApplicationProcess.decidingToInterview("han",8, true, "physics");

        System.out.println("\nSecond case - sad path: under age");
        jobApplicationProcess.decidingToInterview("han",13, true, "physics");

        System.out.println("\nThird case - Happy path");
        jobApplicationProcess.decidingToInterview("han",23, true, "physics");

        System.out.println("\nFourth case - offered job, but rejected");
        ApplicationProcessHelper.candidateAccepts = "no";
        jobApplicationProcess.decidingToInterview("han",18, true, "physics");
    }
}
