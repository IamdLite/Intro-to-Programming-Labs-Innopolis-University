
/**
 * Heater
 * 
 * This class represents a heater that can be turned on and off and can increase or decrease its temperature.
 * @params temperature : int
 * @params MAX_TEMP : int
 * @params MIN_TEMP : int 
 */

public class Heater extends SmartDevice {

    /**
     * These variables represent the status of the heater and its temperature.
     */
    private int temperature;
    static final int MAX_TEMP = 30;
    static final int MIN_TEMP = 15;

    /**
     * This is the constructor for the Heater class.
     * @params status
     * @params temperature
     */

    public Heater(Status status, int temperature){
        super(status);
        this.temperature = temperature;
        System.out.println("Heater is created");
    }


    /**
     * This method increases the temperature of the heater by 1.
     * @noparams
     */
    public int getTemperature(){
        return this.temperature;
    }


    /**
     * This method increases the temperature of the heater by value of the parameter.
     * @param temperature
     * @return
     * 
     */
    public boolean setTemperature(int temperature){
        if(temperature > MAX_TEMP || temperature < MIN_TEMP){
            return false;
        }
        this.temperature = temperature;
        return true;
    }


    /**
     * This method displays current state of heater
     * @noparams
     */
    @Override
    public String displayStatus(){
        return "Heater " + this.getDeviceId() + " is " + this.getStatus() + " and the temperature is " + this.getTemperature()  + "."; 

    }





    
}
