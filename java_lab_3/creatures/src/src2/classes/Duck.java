package src2.classes;
import src2.interfaces.*;


public  class Duck implements Swimmable, Flyable, Living {

    @Override
    public void swim(){
        System.out.println("The " + this.getClass().getSimpleName() + " is swimming");
    }

    @Override
    public void stopSwimming(){
        System.out.println("The " + this.getClass().getSimpleName() + " has stopped swimming");
    }

    @Override
    public void fly(){
        System.out.println("The " + this.getClass().getSimpleName() + " is flying");
    }

    @Override
    public void stopFlying(){
        System.out.println("The " + this.getClass().getSimpleName() + " has stopped flying");
    }
    
}
