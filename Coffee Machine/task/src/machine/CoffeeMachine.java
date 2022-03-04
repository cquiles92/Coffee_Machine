package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Machine javaMaker = new Machine();
        javaMaker.menu();
    }
}

class Machine {
    private final Scanner scanner;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    Machine() {
        scanner = new Scanner(System.in);
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        cups = 9;
        money = 550;
    }

    public void menu() {
        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String input = scanner.nextLine().trim().toLowerCase();
            switch (input) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillCoffee();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    machineState();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error: Invalid input entered");
                    break;
            }
        }
    }

    public void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String input = scanner.nextLine().trim().toLowerCase();
        if(!input.equals("back")) {
            int choice = Integer.parseInt(input);
            calculate(choice);
        }
    }

    private void calculate(int choice) {
        int waterNeeded;
        int milkNeeded;
        int beansNeeded;
        int cupsNeeded = 1;
        int price;

        switch (choice) {
            case 1://espresso
                waterNeeded = 250;
                milkNeeded = 0;
                beansNeeded = 16;
                price = 4;
                break;
            case 2://latte
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                price = 7;
                break;
            case 3://cappuccino
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                price = 6;
                break;
            default:
                System.out.println("Invalid selection.");
                return;
        }

        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if (coffeeBeans < beansNeeded){
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        if(cups < cupsNeeded){
            System.out.println("Sorry, not enough cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= waterNeeded;
        milk -= milkNeeded;
        coffeeBeans -= beansNeeded;
        cups -= cupsNeeded;
        money += price;

    }

    public void fillCoffee(){
        System.out.println("Write how many ml of water do you want to add:");
        water += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk do you want to add:");
        milk += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeans += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += Integer.parseInt(scanner.nextLine());
    }

    public void takeMoney(){
        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    private void machineState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", coffeeBeans);
        System.out.printf("%d of disposable cups\n", cups);
        System.out.printf("%d of money\n\n", money);
    }
}
