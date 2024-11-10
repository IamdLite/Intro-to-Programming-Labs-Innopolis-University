package classes;
import java.util.Scanner;

public class VendingMachine {

    public enum Drinks{
        COKE("Coke cola", 2.5),
        SPRITE("Sprite", 2.0),
        FANTA("Fanta", 2.0);

        private final String name;
        private final double price;

        Drinks(String name, double price){
            this.name = name;
            this.price = price;
        }

        public double getPrice(){
            return this.price;
        }

        public String getName(){
            return this.name;
        }

        public static void showMenu(){
            System.out.println("Available drinks:");
            for (Drinks drink : Drinks.values()){
                System.out.println(drink.name + " - " + drink.price);
            }
        }
    }

    public enum Money{
        ONE(1),
        FIVE(5),
        TEN(10),
        TWENTY(20);


        private final int denomination;

        Money(int denomination){
            this.denomination = denomination;
        }

        public int getDenomination(){
            return this.denomination;
        }   

        public static Money getClosestDenomination(double amount){
            Money closest = ONE;
            for (Money money : Money.values()){
                if(money.getDenomination() <= amount){

                    closest = money;

                }
            }
            return closest;

        }
    }

}


