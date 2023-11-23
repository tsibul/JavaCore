package main.java.ru.javacore.lessons.l2;

import com.sun.tools.javac.Main;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';

    private static final int WIN_COUNT = 4;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;


    public static void main(String[] args) {
        while (true) {
            int[] turn = new int[2];
            initialize();
            printField();
            while (true) {
                turn = humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!", turn))
                    break;
                turn = aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!", turn))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    static void initialize() {
        fieldSizeY = 5;
        fieldSizeX = 5;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    private static void printField() {
        String divider = "--";
        for (int i = 0; i < fieldSizeX; i++) {
            divider = divider + "----";
        }

        System.out.print("+-");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1) + "-+");
        }
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                char printChar = field[y][x] == DOT_EMPTY ? ' ' : field[y][x];
                System.out.print(" " + printChar + " |");
            }
            System.out.println();
            System.out.println(divider);
        }
    }

    /**
     * Ход игрока (человека)
     */
    static int[] humanTurn() {
        int x;
        int y;

        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3)\nчерез пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
        return new int[]{x, y};
    }

    /**
     * Ход игрока (компьютера)
     */
    static int[] aiTurn() {
        int x;
        int y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));

        field[y][x] = DOT_AI;
        return new int[]{x, y};
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка доступности ячейки игрового поля
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }


    /**
     * Метод проверки состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return результат проверки состояния игры
     */
    static boolean checkGameState(char dot, String s, int[] turn) {
        if (checkWin(dot, turn)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * Проверка победы игрока
     *
     * @param dot фишка игрока
     * @return признак победы
     */
    static boolean checkWin(char dot, int[] turn) {
//        // Проверка по трем горизонталям
//        if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
//        if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
//        if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
//
//        // Проверка по трем вертикалям
//        if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
//        if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
//        if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
//
//        // Проверка по диагоналям
//        if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
//        if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;
        if (checkHorizontal(turn, dot, WIN_COUNT)) return true;
        else if (checkVertical(turn, dot, WIN_COUNT)) return true;
        else if (checkMainDiag(turn, dot, WIN_COUNT)) return true;
        else if (checkSideDiag(turn, dot, WIN_COUNT)) return true;
        else return false;
    }

    /**
     * проверка выигрыша по горизонтали
     * @param turn последний ход
     */
    static boolean checkHorizontal(int[] turn, char dot, int winCount) {
        int y = turn[1];
        int x = turn[0];
        int count = 1;
        for (int i = 1; i <= x; i++) {
            if (field[y][x - i] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        for (int i = 1; i < fieldSizeX - x; i++) {
            if (field[y][x + i] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        return false;
    }
/**
 * проверка выигрыша по вертикали
 * @param turn последний ход
 */
    static boolean checkVertical(int[] turn, char dot, int winCount) {
        int y = turn[1];
        int x = turn[0];
        int count = 1;
        for (int i = 1; i <= y; i++) {
            if (field[y - i][x] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        for (int i = 1; i < fieldSizeY - y; i++) {
            if (field[y + i][x] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        return false;
    }

    /**
     * проверка выигрыша по главной диагонали
     * @param turn последний ход
     */
    static boolean checkMainDiag(int[] turn, char dot, int winCount) {
        int y = turn[1];
        int x = turn[0];
        int count = 1;
        int leftCoord = Math.min(x, y);
        int rightCoord = Math.min(fieldSizeX - x, fieldSizeY - y);
        for (int i = 1; i <= leftCoord; i++) {
            if (field[y - i][x - i] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        for (int i = 1; i < rightCoord; i++) {
            if (field[y + i][x + i] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        return false;
    }

    /**
     * проверка выигрыша по побочной диагонали
     * @param turn последний ход
     */
    static boolean checkSideDiag(int[] turn, char dot, int winCount) {
        int y = turn[1];
        int x = turn[0];
        int count = 1;
        int leftCoord = Math.min(x, fieldSizeY - y - 1);
        int rightCoord = Math.min(fieldSizeX - x - 1, y);
        for (int i = 1; i <= leftCoord; i++) {
            if (field[y + i][x - i] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        for (int i = 1; i <= rightCoord; i++) {
            if (field[y - i][x + i] == dot) {
                count++;
                if (count == winCount) return true;
            } else break;
        }
        return false;
    }


}