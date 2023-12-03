package main.java.ru.javacore.lessons.l4.account;

import main.java.ru.javacore.lessons.l4.checks.CheckDeposit;
import main.java.ru.javacore.lessons.l4.exceptions.IllegalArgumentException;
import main.java.ru.javacore.lessons.l4.exceptions.InsufficientFundsException;

public abstract class Account {
    private float balance;
    private String number;
    private String owner;

    public float getBalance() {
        return balance;
    }

    public void deposit (float input){
        this.balance = this.balance + input;
    }

    public void withdraw(String input) throws InsufficientFundsException {
        if(CheckDeposit.checkDeposit(input)){
            float amount = Float.parseFloat(input);
            if(amount > this.balance){
                throw new InsufficientFundsException(this.balance, amount);
            }
            this.balance = this.balance - amount;
        }


    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
