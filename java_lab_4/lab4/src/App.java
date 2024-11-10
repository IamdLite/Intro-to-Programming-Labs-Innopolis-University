import java.util.*;

import classes.DrinkVendingMachine;
import classes.VendingMachine.Drinks;
import abstract_classes.Machine;


public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello, World!");
        DrinkVendingMachine drinkVendingMachine = new DrinkVendingMachine();
        drinkVendingMachine.start();

    }
}
