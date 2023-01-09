public class Person {
    private final String name;
    private final String surname;

    private Integer counter;

    private final String id;

    @Override
    public String  toString() {
        return id;
    }

    public Person(String name, String surname, Integer counter) {
        this.name = name;
        this.surname = surname;
        this.counter = counter;
        this.id = generateId();
    }

    private String generateId() {
        return this.name + "_" + this.surname + "_" + this.counter;
    }

}
