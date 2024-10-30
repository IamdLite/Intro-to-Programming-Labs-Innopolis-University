package src2.classes;
import src2.interfaces.*;

public  class Penguin implements Swimmable, Living {

    @Override
    public void swim(){
        System.out.println("The " + this.getClass().getSimpleName() + " is swimming");
    }

    @Override
    public void stopSwimming(){
        System.out.println("The " + this.getClass().getSimpleName() + " has stopped swimming");
    }
    
    
}
