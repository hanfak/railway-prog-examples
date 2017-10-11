package domain;

public class Candidate extends ValueType {

    public final String name;
    public final Integer age;
    public final Boolean crimalConviction;
    public final String degreeType;

    public Candidate(String name, Integer age, Boolean crimalConviction, String degreeType) {
        this.name = name;
        this.age = age;
        this.crimalConviction = crimalConviction;
        this.degreeType = degreeType;
    }

}
