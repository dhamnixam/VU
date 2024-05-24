package Exceptions;

public class InvalidIDException extends RuntimeException{
    public  InvalidIDException(String msg){
        super(msg);
    }
}
