package main.java.ru.javacore.lessons.l4.exceptions;

public abstract class AccountException extends Exception{

    private final float balance;

    public float getBalance() {
        return balance;
    }

    public AccountException (String message, float balance){
        super(message);
        this.balance = balance;
    }
}
