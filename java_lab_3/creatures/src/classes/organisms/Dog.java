package classes.organisms;
import classes.Animal;

public final class Dog extends Animal{
    
    public Dog(String name, boolean isAlive){
        super(name, isAlive);
    }

    @Override
    public void  bear(){
        System.out.println("The " +  this.getClass().getSimpleName() + " " + this.name + " is born");
    }

    @Override
    public void die(){
        System.out.println("The " + this.getClass().getSimpleName() + " " + this.name + " has died");
    }

    public void bark(){
        System.out.println("The " + this.getClass().getSimpleName() + " " + this.name + " is barking");
    }
    
}
