package main.java.ru.javacore.lessons.l4.transactions;

import main.java.ru.javacore.lessons.l4.account.Account;
import main.java.ru.javacore.lessons.l4.exceptions.InsufficientFundsException;

import java.util.Scanner;

public class WithDrawFromAccount {
    public static void withdrawFromAccount(Account account) throws InsufficientFundsException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: ");
        String input = scanner.next();
        account.withdraw(input);
        System.out.println("Acc no " + account.getNumber() + " owner " + account.getOwner() + " balance: "
                + account.getBalance());
    }
}
