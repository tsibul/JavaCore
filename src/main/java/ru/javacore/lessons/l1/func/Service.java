package main.java.ru.javacore.lessons.l1.func;

import java.util.LinkedList;
import java.util.Random;

public class Service {
    public static LinkedList<String> randomLinList (int len, int range ) {
        Random random = new Random();
        LinkedList<String> arr = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            String element = "";
            int lenRange = random.nextInt(range + 1) + 1;
            for(int j = 1; j < lenRange; j++) {
                boolean isSpace = true;
                while (isSpace) {
                    String tmpStr = Character.toString((char) random.nextInt(30) + 97);
                    if (!tmpStr.equals("") && !tmpStr.equals(" ")) {
                        element = element + tmpStr;
                        isSpace = false;
                    }
                }
            }
            arr.add(element);
        }
        return arr;
    }

    public static void palindromList (LinkedList<String> lList){
        int len = lList.size();
        int range = len / 2;
        for(int i = 0; i < range; i++){
            String tmp = lList.get(i);
            lList.set(i, lList.get(len - i - 1));
            lList.set(len - i - 1, tmp);
        }


    }

}
