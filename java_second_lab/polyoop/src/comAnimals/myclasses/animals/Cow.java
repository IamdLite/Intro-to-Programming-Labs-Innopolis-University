package comAnimals.myclasses.animals;

public class Cow extends Animal{

    public Cow(String name, float height, float weight, String color){
        super(name, height, weight, color);
    }

    @Override
    protected void makeSound(){
        System.out.println("Moo");
    }

    @Override
    protected void eat(){
        System.out.println("I am eating grass");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
