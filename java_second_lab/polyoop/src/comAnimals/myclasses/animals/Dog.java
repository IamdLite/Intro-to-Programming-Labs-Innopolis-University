package comAnimals.myclasses.animals;


public class Dog extends Animal{
    public Dog(String name, float height, float weight, String color){
    super(name, height, weight, color);}

    @Override
    protected void makeSound(){
        System.out.println("Bark");
    }

    @Override
    protected void eat(){
        System.out.println("I am eating meat");
    }

}




