package classes;

public class Animal extends Creature {

   public  Animal(String name, boolean isAlive) {
        super(name, isAlive);
    }

    public Animal(boolean isAlive) {
        super(isAlive);
    }

    @Override
    public void bear() {
        System.out.println("The " + this.getClass().getSimpleName() + " " + this.name + " is born");
    }

    @Override
    public void die() {
        System.out.println("The " + this.getClass().getSimpleName() + " " + this.name + " has died");
    }

    
}