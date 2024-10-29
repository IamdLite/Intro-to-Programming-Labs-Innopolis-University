package comAnimals.myclasses.animals;

public class Animal{

    protected String name;
    protected float height;
    protected float weigth;
    protected String color;


    public Animal(String name, float height, float weigth, String color){
        this.name = name;
        this.height = height;
        this.weigth = weigth;
        this.color = color;
    }

    protected  void eat(){
        System.out.println("I am eating");
    }

    protected void sleep(){
        System.out.println("I am sleeping");
    }

    protected void makeSound(){
        
        System.out.println("I am making animal sound");
    }


    @Override
    public String toString(){
        return "{ Name: " + name + "\nHeight: " + height + "\nWeight: " + weigth + "\nColor: " + color + "}";
    }

}
