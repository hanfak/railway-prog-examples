package domain;

public class Employee extends ValueType {
    public final String position;
    public final Integer id;

    public Employee(String position, Integer id) {
        this.position = position;
        this.id = id;
    }
}
