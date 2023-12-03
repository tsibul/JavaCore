package main.java.ru.javacore.lessons.l4.transactions;

import main.java.ru.javacore.lessons.l4.account.Account;
import main.java.ru.javacore.lessons.l4.checks.CheckDeposit;

import java.util.Scanner;

public class DepositToAccount {
    public static void depositToAccount(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        String amount = scanner.next();
        if (CheckDeposit.checkDeposit(amount)) {
            account.deposit(Float.parseFloat(amount));
        }
        System.out.println("Acc no " + account.getNumber() + " owner " + account.getOwner() + " balance: "
                + account.getBalance());
    }
}
