import java.util.Scanner;

public class Utils {

    Scanner scanner = new Scanner(System.in);

    public void init(){

            

               // Start program
               HospitalManagement hospitalManagement = new HospitalManagement();
               


               // Create 3 doctors
               Doctor doctor1 = new Doctor(6, "Dr. Smith");
               hospitalManagement.addDoctor(doctor1);
               Doctor doctor2 = new Doctor(7, "Dr. Brown");
               hospitalManagement.addDoctor(doctor2);
               Doctor doctor3 = new Doctor(8, "Dr. Johnson");
               hospitalManagement.addDoctor(doctor3);
       
               System.out.println("================= MENU =================");
               System.out.println("I am a \n1. Doctor\n2. Patient\n3. Receptionist");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter your ID: ");
                        int doctorId = scanner.nextInt();

                        // Check if the doctor exists
                        for(Doctor doctor: hospitalManagement.getDoctorList()){
                            if(doctor.getUserId() == doctorId){
                                System.out.println("Welcome Dr. " + doctor.getUserName());
                                doctor.checkPatients(hospitalManagement.getAppointmentList());
                                break;
                            }
                        }
                    case 2:
                        System.out.println("Enter your name: ");
                        String patientName = scanner.next();
                        Patient patient = new Patient(10, patientName);
                        hospitalManagement.addPatient(patient);
                        System.out.println("Welcome " + patientName);
                        patientMenu(patient);
                        break;
                
                    default:
                        break;
                }
               Receptionist receptionist = new Receptionist(9, "Receptionist");


    }


    public void patientMenu(Patient patient){

        System.out.println("============== PATIENT MENU =================");
        System.out.println("1. View Details \n2. View Bills \n3. Pay Bills \n4. Make appointment");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                patient.viewDetails();
                patientMenu(patient);
                break;
            
            case 2:
            patient.viewBills();
            patientMenu(patient);
            break;

            case 3:
            //
        
            default:
                break;
        }

    }
    
}
