package main.java.ru.javacore.lessons.l4.transactions;

import main.java.ru.javacore.lessons.l4.account.Account;
import main.java.ru.javacore.lessons.l4.account.CreditAccount;
import main.java.ru.javacore.lessons.l4.account.DebitAccount;
import main.java.ru.javacore.lessons.l4.checks.CheckDeposit;

import java.util.Random;
import java.util.Scanner;

public class CreateAccount {
    public static Account createAccount() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter your name: ");
        String name = scanner.next();
        String accNo = "407028101000" + Integer.toString(random.nextInt(100, 1000));
        System.out.print("Enter amount: ");
        String amount = scanner.next();
        if (CheckDeposit.checkDeposit(amount)) {
            DebitAccount debitAccount = new DebitAccount();
            debitAccount.setOwner(name);
            debitAccount.setNumber(accNo);
            debitAccount.deposit(Float.parseFloat(amount));
            System.out.println("Acc no " + accNo + " owner " + name + " created, balance: " + amount);
            return debitAccount;
        }
        return null;
    }

    public static Account createCreditAccount() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter your name: ");
        String name = scanner.next();
        String accNo = "407028101000" + Integer.toString(random.nextInt(100, 1000));
        System.out.print("Enter amount: ");
        String amount = scanner.next();
        System.out.print("Enter limit: ");
        String limit = scanner.next();
        if (CheckDeposit.checkDeposit(amount) && CheckDeposit.checkDeposit(limit)) {
            CreditAccount creditAccount = new CreditAccount();
            creditAccount.setOwner(name);
            creditAccount.setNumber(accNo);
            creditAccount.deposit(Float.parseFloat(amount));
            creditAccount.setCreditLimit(Float.parseFloat(limit));
            System.out.println("Acc no " + accNo + " owner " + name + " created, balance: " + amount + " limit "
                    + limit);
            return creditAccount;
        }
        return null;
    }
}
