package comAnimals.myclasses;
import java.util.Arrays;

import comAnimals.myclasses.animals.*;

public class AnimalCreator{

    public static void main(String[] args){
        Animal[] animals = addAnimals();
        System.out.println(Arrays.toString(animals));
    }

    private static Animal[] addAnimals(){
        Animal[] animals = new Animal[4];

        Animal animal = new Animal("animal", 35.5F, 30,  "black");
        animals[0] = animal;

        Animal dog = new Dog("Toby", 28F, 20, "brown");
        animals[1] = dog;

        Animal cat = new Cat("Kitty", 5.5F, 10, "orange");
        animals[2] = cat;

        Animal cow = new Cow("Beeu", 450, 100,  "white");
        animals[3] = cow;

        return animals;
    }
}

