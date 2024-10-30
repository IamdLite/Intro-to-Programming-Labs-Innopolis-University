
import java.util.*;
import classes.organisms.*;
import classes.*;


public class AbstractClassDemonstrationClass {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        for(Creature creature: getCreatures()){
            creature.bear();
            creature.shoutName();
            creature.die();
        }

    }

    private static ArrayList<Creature> getCreatures(){

        ArrayList<Creature> creatures = new ArrayList<Creature>();
        creatures.add(new Dog("Dog", true));
        creatures.add(new Dog("Dog", true));
        creatures.add(new Human("Human1", true));
        creatures.add(new Alien("Alien", true));
        creatures.add(new Alien(true));
        return creatures;
    }

}
