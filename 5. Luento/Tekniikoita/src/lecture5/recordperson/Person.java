package lecture5.recordperson;

public record Person(String name, Integer age) {
    public Person { // record konstruktoriin ei parametrisulkeita
        if (age < 18) {
            name = "Error";
            age = -1;
        }

    }
}
