package academy.mindswap.exercise.exercise.exception;

public class BadRequestException extends PersonExceptions{
    public BadRequestException() {
        super("Bad request, please try again");
    }
}
