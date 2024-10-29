package comAnimals.myclasses.animals;

public class Cat extends Animal{
    public Cat(String name, float height, float weight, String color){
        super(name, height, weight, color);
    }

    @Override
    protected void makeSound(){
        System.out.println("Meow");
    }

    @Override
    protected void eat(){
        System.out.println("I am eating fish");
    }

}


