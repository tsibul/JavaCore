package main.java.ru.javacore.lessons.l4.checks;

import main.java.ru.javacore.lessons.l4.exceptions.IllegalArgumentException;

public class CheckDeposit {
    public static boolean checkDeposit(String input){
        try{
            float amount = Float.parseFloat(input);
            if(amount < 0) {
                System.out.println("incorrect amount");
                throw new IllegalArgumentException("", amount);
            };
            return true;
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
        return false;
    }
}
