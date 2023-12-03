package main.java.ru.javacore.lessons.l4;

import main.java.ru.javacore.lessons.l4.account.Account;
import main.java.ru.javacore.lessons.l4.exceptions.InsufficientFundsException;
import main.java.ru.javacore.lessons.l4.transactions.CreateAccount;
import main.java.ru.javacore.lessons.l4.transactions.DepositToAccount;
import main.java.ru.javacore.lessons.l4.transactions.Transaction;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        Account credAcc = CreateAccount.createCreditAccount();
        DepositToAccount.depositToAccount(credAcc);
        Account debAcc = CreateAccount.createAccount();
        DepositToAccount.depositToAccount(debAcc);
        Transaction.transaction(debAcc, credAcc);
    }
}