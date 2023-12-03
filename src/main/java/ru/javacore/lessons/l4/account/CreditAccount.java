package main.java.ru.javacore.lessons.l4.account;

import main.java.ru.javacore.lessons.l4.checks.CheckDeposit;
import main.java.ru.javacore.lessons.l4.exceptions.InsufficientFundsException;

public class CreditAccount extends Account {
    private float creditLimit;

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(String input) throws InsufficientFundsException {
        if (CheckDeposit.checkDeposit(input)) {
            float amount = Float.parseFloat(input);
            if (amount > this.getBalance() + this.creditLimit) {
                throw new InsufficientFundsException(this.getBalance() + this.creditLimit, amount);
            }
            this.setBalance(this.getBalance() - amount);

        }
    }
}
