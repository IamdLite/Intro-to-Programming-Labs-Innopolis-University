
package classes;


public abstract class Creature {

    protected String name = null;
    boolean isAlive = false;

    public Creature(String name, boolean isAlive){
        this.name = name;
        this.isAlive = isAlive;
    }

    public Creature(boolean isAlive){
        this.isAlive = isAlive;
    }
    

    public abstract void bear();
    public abstract void die();

    public void shoutName(){
            if (this.name == null){
                System.out.println(this.getClass().getSimpleName() + " has no name !!");
            } else {
                System.out.println(this.name + " !!");
            }
        }
    
    
}
