package main.java.ru.javacore.lessons.l4.transactions;

import main.java.ru.javacore.lessons.l4.account.Account;
import main.java.ru.javacore.lessons.l4.exceptions.InsufficientFundsException;

import java.util.Scanner;

public class Transaction {
    public static void transaction (Account debAcc, Account credAcc) throws InsufficientFundsException {
        System.out.print("Enter transaction amount: ");
        Scanner scanner = new Scanner(System.in);
        String amount = scanner.next();
        credAcc.withdraw(amount);
        debAcc.deposit(Float.parseFloat(amount));
        System.out.println("Acc no " + debAcc.getNumber() + " owner " + debAcc.getOwner() + " balance: "
                + debAcc.getBalance());
        System.out.println("Acc no " + credAcc.getNumber() + " owner " + credAcc.getOwner() + " balance: "
                + credAcc.getBalance());
    }
}
