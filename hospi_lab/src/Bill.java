public class Bill {
    private int billId;
    private String patientName;
    private double amount;

    public void generateBill(int billId, String patientName, double amount){
        this.billId = billId;
        this.patientName = patientName;
        this.amount = amount;
    }

    public void viewDetails(){
        System.out.println("Bill ID: " + billId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Amount: " + amount);
    }
}
