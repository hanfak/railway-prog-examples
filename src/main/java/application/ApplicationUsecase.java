package application;

import domain.helpers.ApplicationProcessHelper;

import static domain.helpers.ApplicationProcessHelper.candidateToConsider;

public class ApplicationUsecase {

    @SuppressWarnings("SameParameterValue")
    public void decidingToInterview(String name, Integer age, Boolean criminalConviction, String degreeType) {
        candidateToConsider(name, age, criminalConviction, degreeType)
                    .peek(ApplicationProcessHelper::checkForBogusCandidate)
                    .then(ApplicationProcessHelper::checkAge)
                    .peek(ApplicationProcessHelper::reportHappyOutCome)
                    .then(ApplicationProcessHelper::offerJob) // Returns HappyPath which is dealt with below
                .ifHappy()
                    .peek(ApplicationProcessHelper::reportHappyOutCome)
                .ifSad()
                    .peek(ApplicationProcessHelper::reportSadOutcome)
                .ifTechnicalFailure()
                    .peek(ApplicationProcessHelper::reportError);
    }
}
