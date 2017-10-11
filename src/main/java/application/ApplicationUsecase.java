package application;

import domain.helpers.ApplicationProcessHelper;

import static domain.helpers.ApplicationProcessHelper.candidateToConsider;

public class ApplicationUsecase {
    public void decidingToInterview(String name, Integer age, Boolean crimalConviction, String degreeType) {
        candidateToConsider(name,age,crimalConviction,degreeType)
                .ifHappy()
                        .peek(ApplicationProcessHelper::checkForBogusCandidate)
                    .then(ApplicationProcessHelper::checkAge)
                        .peek(ApplicationProcessHelper::reportHappyOutCome)
                    .then(ApplicationProcessHelper::offerJob)
                .ifHappy()
                    .peek(ApplicationProcessHelper::reportHappyOutCome)
                .ifSad()
                    .peek(ApplicationProcessHelper::reportSadOutcome)
                .ifTechnicalFailure()
                    .peek(ApplicationProcessHelper::reportError);
    }
}
