package interfaces;

public interface InventoryManagement {

        boolean checkStock();
        void updateStock(String item, int quantity); 
    
}