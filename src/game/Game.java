package game;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    Scanner scanner;
    String name;
    int gameSession;
    HashMap<Integer, String> sessionHistory; // Инт отвечает за номер сессии, а стринг содержит win or lose
    Menu menu;
    int attempts;
    int maxNum;
    boolean isRunning;
    public Game() {
        scanner = new Scanner(System.in);
        gameSession = 0;
        sessionHistory = new HashMap<>();
        name = getName();
        menu = new Menu(name);
        isRunning = true;
        attempts = 10;
        maxNum = 100;
        startApp();
    }

    private void startApp() {
        menu.printStartMessage();
        loop: while (isRunning) {
            menu.printMenu();

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    startGame();
                    break;
                case 2:
                    getStat();
                    break;
                case 3:
                    printRules();
                    break;
                case 4:
                    openSettings();
                    break;
                case 0:
                    endGame();
                    break loop;
            }
        }
    }

    private String getName() {
        System.out.println("Please, enter your name:");
        String name = scanner.nextLine();
        if (name.equals("")) return "Stranger";
        return name;
    }

    private void startGame() {
        gameSession++;
        Session session = new Session(maxNum, attempts);
        sessionHistory.put(gameSession, session.launch());
    }

    private void getStat() {
        System.out.println("Your statistic:");
        System.out.println("Total number of games: " + gameSession);
        for (int session :
                sessionHistory.keySet()) {
            System.out.println(session + " - " + sessionHistory.get(session) + "!");
        }
    }

    private void openSettings() {
        menu.settings();
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                changeDifficulty();
                break;
            case 0:
                break;
        }
    }

    private void changeDifficulty() {
        menu.changeDifficulty();
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                maxNum = 100;
                attempts = 10;
                System.out.println("Difficulty changed.");
                break;
            case 2:
                maxNum = 1000;
                attempts = 25;
                System.out.println("Difficulty changed.");
                break;
            case 0:
                break;
        }
    }

    private void printRules() {
        menu.printRules();
        scanner.nextInt();
    }

    private void endGame() {
        getStat();
        System.out.println("Goodbye!");
    }
}
