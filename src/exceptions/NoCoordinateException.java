package exceptions;

public class NoCoordinateException extends RuntimeException{
    public NoCoordinateException(String message){
        super(message);
    }
}
