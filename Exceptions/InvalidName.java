package Exceptions;

public class InvalidName extends RuntimeException{
    public InvalidName(String msg){
        super(msg);
    }
}
