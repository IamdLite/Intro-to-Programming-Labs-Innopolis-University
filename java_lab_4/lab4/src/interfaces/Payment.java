package interfaces;

public interface Payment {

    void processPayment(double amount);
    void returnChange();
    void refund();

}
