package src2;
import src2.classes.*;
import src2.interfaces.*;

public class InterfaceDemonstration {

    public static void main(String[] args){






        Living livingObjects[] = {new Duck(), new Penguin()};

        for(Living livingObject : livingObjects){
            livingObject.live();
        }

        // Submarine submarine = new Submarine();
        // submarine.swim();
        // submarine.stopSwimming();


        // Duck duck = new Duck();
        // duck.swim();
        // duck.stopSwimming();
        // duck.fly();

        // Penguin penguin = new Penguin();
        // penguin.swim();
        // penguin.stopSwimming();

    }
    
}
