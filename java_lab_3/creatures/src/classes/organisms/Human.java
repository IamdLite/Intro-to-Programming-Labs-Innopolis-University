package classes.organisms;
import classes.Animal;

public final class Human extends Animal{

    public Human(String name, boolean isAlive){
        super(name, isAlive);
    }
  
    @Override
    public void bear(){
        System.out.println("The " +  this.getClass().getSimpleName() + " " + this.name + " is born");
    }

    @Override
    public void die(){
        System.out.println("The " + this.getClass().getSimpleName() + " " + this.name + " has died");
    }

}
