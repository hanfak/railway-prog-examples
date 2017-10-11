package domain.helpers;

import domain.Candidate;
import domain.JobOffer;
import domain.JobRejection;
import io.github.theangrydev.businessflows.HappyPath;

import java.time.ZonedDateTime;

import static io.github.theangrydev.businessflows.HappyPath.happyPath;
import static io.github.theangrydev.businessflows.HappyPath.sadPath;
import static java.lang.String.format;

public class ApplicationProcessHelper {
    public static String candidateAccepts;

    public static void reportHappyOutCome(JobOffer jobOffer) {
        System.out.println(format("Job accepted start %s", jobOffer.startDate));
    }

    public static HappyPath<JobOffer, JobRejection> offerJob(Candidate candidate) {
        if ("yes".equals(candidateAccepts)) {
            return happyPath(new JobOffer(ZonedDateTime.now(), 34000));
        }
        return sadPath(new JobRejection(format("%s had turned down the job",candidate.name), candidate.name));
    }

    public static void reportError(Exception e) {
        System.out.println(e.getMessage());
    }


    public static void reportHappyOutCome(Candidate candidate) {
        System.out.println(format("%s has been offered a job", candidate.name));
    }

    public static void checkForBogusCandidate(Candidate candidate) {
        if (candidate.age == 8) {
            throw new IllegalStateException("bad age");
        }
    }

    public static void reportSadOutcome(JobRejection jobRejection) {
        System.out.println(format("%s's outcome was negative because '%s'", jobRejection.name,jobRejection.reason));

    }

    public static HappyPath<Candidate, JobRejection> checkAge(Candidate candidate) {
        if (candidate.age < 18) {
            return sadPath(new JobRejection("Too young, must be over 18, but was " + candidate.age, candidate.name));
        }
        return happyPath(candidate);
    }

    public static HappyPath<Candidate, JobRejection> candidateToConsider(String name, Integer age, Boolean crimalConviction, String degreeType) {
        return happyPath(new Candidate(name,age,crimalConviction,degreeType));
    }
}
