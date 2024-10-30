package src2.interfaces;

public interface Living {
    default void live(){
        System.out.println(this.getClass().getSimpleName() + " is living");
    };
}