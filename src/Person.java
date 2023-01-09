import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;

    private Integer counter;

    private final String id;
    private final Boolean isVip;

    @Override
    public String  toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Person(String name, String surname, Integer counter) {
        this(name, surname, counter, false);
    }

    public Person(String name, String surname, Integer counter, Boolean isVip) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.isVip = isVip;
        this.id = generateId();

    }

    private String generateId() {
        return this.isVip
                ? this.name + "_" + this.surname + "_" + this.counter + "_VIP"
                : this.name + "_" + this.surname + "_" + this.counter;
    }

}
