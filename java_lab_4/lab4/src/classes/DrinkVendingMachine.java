package classes;

import java.util.Scanner;

import classes.VendingMachine.Drinks;
import classes.VendingMachine.Money;
import abstract_classes.Machine;

public class DrinkVendingMachine extends Machine {

    private final Scanner scanner = new Scanner(System.in);

    private Drinks selectedDrink;

    public void start() {
        selectItem();
    }

    @Override
    public void selectItem() {
        boolean validChoice = false;

        while (!validChoice) {
            Drinks.showMenu();
            System.out.println("Select a drink (COKE, SPRITE, FANTA): ");
            String drinkChoice = scanner.next().toUpperCase();

            // check if drink choice matches menu
            if (!drinkChoice.equals("COKE") && !drinkChoice.equals("SPRITE") && !drinkChoice.equals("FANTA")) {
                System.out.print("\033[H\033[2J"); // clear console (note: works in some consoles only)
                System.out.println("Invalid drink selection. Please try again.");
            } else {
                // insert the money
                insertMoney();
                try {
                    this.selectedDrink = Drinks.valueOf(drinkChoice);
                    double price = selectedDrink.getPrice();
                    if (insertedMoney >= price) {
                        dispenseItem(drinkChoice);
                        returnChange();
                        validChoice = true; // valid selection made
                    } else {
                        System.out.println("Insufficient funds. Please insert more money.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid drink selection. Please try again.");
                }
            }
        }
    }

    @Override
    public void dispenseItem(String drinkChoice) {
        System.out.println("Dispensing " + drinkChoice);
    }

    @Override
    public void returnChange() {
        double change = insertedMoney - selectedDrink.getPrice();
        Money closestDenomination = Money.getClosestDenomination(change);
        System.out.println("Returning change: " + closestDenomination.getDenomination());
        this.insertedMoney = 0;
    }

    @Override
    public void insertMoney() {
        System.out.println("Insert money: ");

        // Check if input is a number
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please insert a valid amount.");
            scanner.next(); // to consume the invalid input
            insertMoney();
            return;
        }

        double moneyToInsert = scanner.nextDouble();

        if (moneyToInsert < 0) {
            System.out.println("Invalid amount. Please insert a positive amount.");
            return;
        } else if (moneyToInsert == 0) {
            System.out.println("No money inserted.");
            return;
        }
        // Check if money inserted is a valid denomination
        else if (moneyToInsert != 1 && moneyToInsert != 5 && moneyToInsert != 10 && moneyToInsert != 20) {
            System.out.println("Invalid denomination. Please insert a valid denomination.");
            return;
        } else {
            this.insertedMoney = moneyToInsert;
        }
    }

    @Override
    public void processPayment(double amount) {
        // Not implemented in the current code, you can add payment processing logic here.
    }

    @Override
    public void refund() {
        System.out.println("Refunding: " + insertedMoney);
        insertedMoney = 0.0;
    }
}
