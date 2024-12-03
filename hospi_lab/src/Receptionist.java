import java.util.*;

public class Receptionist extends User{
    
    private int receptionistId;
    private String receptionistName;



    public Receptionist(int userId, String userName){
        super(userId, userName);
        this.receptionistId = userId;
        this.receptionistName = userName;
    }

    Scanner sc = new Scanner(System.in);


    public void makeAppointment(){
        Random rand = new Random();

        System.out.println("============= Appointment Booking Wizard ====================");
        System.out.println("Enter Patient Name: ");
        String patientName = sc.nextLine();
        System.out.println("Enter Date: ");
        String date = sc.nextLine();

        Appointment appointment = new Appointment();
        appointment.scheduleAppointment(rand.nextInt(1000), patientName, date);
        System.out.println("Appointment Booked Successfully");

    }

    public void generateBills(int patientId){
        Random rand = new Random();

        System.out.println("============= Bill Generation Wizard ====================");
        System.out.println("Enter Patient Name: ");
        String patientName = sc.nextLine();
        System.out.println("Enter Bill Amount: ");
        int billAmount = sc.nextInt();

        Bill bill = new Bill();
        bill.generateBill(rand.nextInt(1000), patientName, billAmount);
        System.out.println("Bill Generated Successfully");
    }

    public void viewBills(List<Bill> bills){
        System.out.println("============= Bills ====================");
        for(Bill bill: bills){
            bill.viewDetails();
        }
        System.out.println("=======================================");
    }

    public void viewDetails(){
        System.out.println("============= Receptionist Details ====================");
        System.out.println("Receptionist ID: " + getUserId());
        System.out.println("Receptionist Name: " + getUserName());
        System.out.println("===============================================");
    }
}
