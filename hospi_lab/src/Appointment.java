public class Appointment {
    private int appointmentId;
    private String patientName;
    private String date;

    public void scheduleAppointment(int appointmentId, String patientName, String date){
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.date = date;
    }

    public void viewDetails(){
        System.out.println("Appointment ID: " + appointmentId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Date: " + date);
    }

    public String getDate(){
        return date;
    }

    public String getPatientName(){
        return patientName;
    }

    public int getAppointmentId(){
        return appointmentId;
    }
}
