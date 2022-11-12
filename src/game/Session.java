package game;

import java.util.Scanner;
import java.util.Random;

public class Session {  // Класс отвечающий за конкретную игровую сессию
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    int attempts;   // Количество доступных попыток
    int maxNum; // Максимальное число
    int num;    // Загаданное число
    int currentAttempt; // Текущая попытка
    boolean isWin;  // флаг победы

    public Session(int maxNum, int attempts) {
        this.maxNum = maxNum;
        this.attempts = attempts;
        currentAttempt = 1;
    }

    public String launch() {    // Запускаем сессию и возвращаем строку с win or lose в Game
        num = rand.nextInt(maxNum) + 1;
        startOfSession();
        gameProcessing();
        if (isWin) return "WIN";
        return "lose";
    }

    private void gameProcessing() { // Обработка игрового процесса
        while (currentAttempt <= attempts) {
            System.out.println("Guess number:");

            int input = getInput();

            switch (checkInput(input)) {
                case "high":
                    currentAttempt++;
                    System.out.println("Guessed number is lower.");
                    break;
                case "low":
                    currentAttempt++;
                    System.out.println("Guessed number is higher.");
                    break;
                case "win":
                    System.out.println("Congrats!");
                    isWin = true;
                    return;
            }
        }
        System.out.println("You have used all of your attempts.\nThe number was: " + num);
    }

    private void startOfSession() {
        System.out.println("Number generated. Starting the game...");
    }

    private int getInput() {
        int result = scanner.nextInt();
        if (result > maxNum) {
            System.out.println("Your number is out of bound. Try another.");
            getInput();
        }
        return result;
    }

    private String checkInput(int input) {  //
        if (input > num) return "high";
        else if (input < num) return "low";
        return "win";
    }
}
