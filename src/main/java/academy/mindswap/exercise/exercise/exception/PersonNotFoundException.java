package academy.mindswap.exercise.exercise.exception;

public class PersonNotFoundException extends PersonExceptions {
    public PersonNotFoundException() {
        super("Nonexistent person");
    }
}
