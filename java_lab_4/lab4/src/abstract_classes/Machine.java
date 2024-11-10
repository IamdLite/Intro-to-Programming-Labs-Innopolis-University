package abstract_classes;

import java.util.*;

import interfaces.InventoryManagement;
import interfaces.Payment;

public abstract class Machine implements Payment, InventoryManagement {

    protected double insertedMoney = 0.0;


    public void insertMoney(){

    }

    public boolean checkStock(){
        return true;
    }

    public void updateStock(String item, int quantity){
    }
    
    public abstract void dispenseItem(String drinkChoice);
    public abstract void selectItem();
    public abstract void returnChange();
    
}
