package exceptions;

public class MaxValueExceededException extends RuntimeException{
    public MaxValueExceededException(String message){
        super(message);
    }
}
