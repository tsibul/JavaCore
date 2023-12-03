package main.java.ru.javacore.lessons.l4.exceptions;

public class InsufficientFundsException extends AccountException{
    private float balance;
    private float withdraw;

    public InsufficientFundsException(float balance, float withdraw ) {
        super("Insufficient Funds for withdrawal + " + Float.toString(withdraw) + " balance ", balance);
        this.balance = balance;
    }
}
