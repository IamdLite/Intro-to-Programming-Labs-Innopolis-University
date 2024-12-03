import java.util.ArrayList;
import java.util.List;


public class Patient extends User{

    private List<Appointment> appointmentList = new ArrayList<Appointment>();
    private List<Bill> bills = new ArrayList<Bill>();

    public Patient(int userId, String userName){
        super(userId, userName);
    }

    public void makeAppointment(Appointment appointment){
        appointmentList.add(appointment);
        System.out.println("Appointment made successfully");
    }

    public void payBill(int billId){
        System.out.println("Bill paid successfully");
    }

    public void viewBills(){
        System.out.println("============= Bills ====================");
        for(Bill bill: bills){
            bill.viewDetails();
        }
        System.out.println("=======================================");
    }

    public void viewDetails(){
        System.out.println("============= Patient Details ====================");
        System.out.println("Patient ID: " + getUserId());
        System.out.println("Patient Name: " + getUserName());
        System.out.println("===============================================");
    }





    
}
