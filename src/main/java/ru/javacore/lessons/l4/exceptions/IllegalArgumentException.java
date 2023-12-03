package main.java.ru.javacore.lessons.l4.exceptions;

public class IllegalArgumentException extends AccountException {

    public IllegalArgumentException(String message, float balance){
        super("Invalid Input", balance);
    }
}
