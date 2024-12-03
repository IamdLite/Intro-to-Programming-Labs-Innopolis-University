import java.util.Scanner;
import java.util.List;

public class Doctor extends User{

    private int doctorId;
    private String doctorName;


    public Doctor(int userId, String userName){
        super(userId, userName);
        this.doctorId = userId;
        this.doctorName = userName;
    }

    Scanner sc = new Scanner(System.in);
    public void checkPatients(List<Appointment> appointmentList){
        
        int count = 1;;

        System.out.println("============= Patient List ====================");
        for(Appointment appointment: appointmentList){
            System.out.println("Patient " + count);
            System.out.println("Appointment ID: " + appointment.getAppointmentId());
            System.out.println("Patient Name: " + appointment.getPatientName());
            System.out.println("Date: " + appointment.getDate());
        }

        System.out.println("===============================================");
        System.out.println("Which patient do you want to check?: ");
        int choice = sc.nextInt();
        System.out.println("The patient: " + appointmentList.get(choice-1).getPatientName() + " was checked successfully");
        appointmentList.remove(choice-1);
        System.out.println("Do you to check another patient? (Y/N): ");
        String option = sc.next();
        if (option.equals("Y")){
            checkPatients(appointmentList);
        } else {
            System.out.println("Thank you for checking the patients");
            return;
        }

    } 

    public void viewDetails(){
        System.out.println("============= Doctor Details ====================");
        System.out.println("Doctor ID: " + getUserId());
        System.out.println("Doctor Name: " + getUserName());
        System.out.println("===============================================");
    }

}
