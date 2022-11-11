package game;



public class Menu {
    String name;
    String separator;
    String rules;
    String menu;
    String setting;
    String difficulty;
    String back;

    public Menu(String name) {
        this.name = name;
        separator = "----------------------";
        rules = "RULES OF THE GAME\n" +
                separator + "\n" +
                "Player has to guess a number given in between a range. If the guessed number is right, the player " +
                "wins else, loses. It also has limited attempts where the player has to guess the number " +
                "within the limited attempts given. \n" +
                separator;
        menu = separator + "\n" +
                "Number Guessing Game\n" +
                separator + "\n" +
                "1. Start a game\n" +
                "2. Get statistic\n" +
                "3. Rules\n" +
                "4. Settings\n" +
                "0. Exit\n" +
                separator;
        setting = "SETTINGS\n" +
                separator + "\n" +
                "1. Change difficulty\n" + separator;
        difficulty = "CHOOSE DIFFICULTY\n" +
                separator + "\n" +
                "1. Range: 1-100; Attempts: 10\n" +
                "2. Range: 1-1000; Attempts: 25\n" +
                separator;
        back = "Press 0 to get back";
    }

    public void printStartMessage() {
        System.out.println("Welcome to the game, " + name + "!");
    }

    public void printMenu() {
        System.out.println(menu);
    }

    public void settings() {
        System.out.println(setting);
        System.out.println(back);
    }

    public void changeDifficulty() {
        System.out.println(difficulty);
        System.out.println(back);
    }

    public void printRules() {
        System.out.println(rules);
        System.out.println(back);
    }
}
