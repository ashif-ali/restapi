package in.ashifali.restapi.exception;

public class ResourseNotFoundException extends RuntimeException{

    public ResourseNotFoundException(String message) {
        super(message);
    }
}
