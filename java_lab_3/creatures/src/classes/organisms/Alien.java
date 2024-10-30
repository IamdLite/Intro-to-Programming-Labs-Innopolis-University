package classes.organisms;

import classes.Creature;

public class Alien extends Creature{

    public Alien(String name, boolean isAlive){
        super(name, isAlive);
    }

    public Alien(boolean isAlive){
        super( isAlive);
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
