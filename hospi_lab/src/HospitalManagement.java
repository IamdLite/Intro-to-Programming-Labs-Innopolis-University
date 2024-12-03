import java.util.*;

public class HospitalManagement {
    private List<Doctor> doctorList = new ArrayList<Doctor>();
    private List<Patient> patientsList = new ArrayList<Patient>();
    private List<Appointment> appointmentList = new ArrayList<Appointment>();
    private List<Bill> billList = new ArrayList<Bill>();


    public void addDoctor(Doctor doctor){
        this.doctorList.add(doctor);
    }

    public List<Doctor> getDoctorList(){
        return this.doctorList;
    }

    public void addPatient(Patient patient){
        this.patientsList.add(patient);
    }

    public List<Patient> getPatientList(){
        return this.patientsList;
    }
    
    public void manageAppointments(Appointment appointment){
        this.appointmentList.add(appointment);
    }

    public List<Appointment> getAppointmentList(){
        return this.appointmentList;
    }

    public void generateBill(Bill bill){
        this.billList.add(bill);
    }



    
}
