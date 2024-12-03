/**
 * Light represents a smart light that can adjust brightness level  and color
 * @param status : Status 
 * @param charging : Boolean
 * @param brightnessLevel : BrightnessLevel
 * @param lightColor : LightColor
 */
public class Light extends SmartDevice implements Chargeable {

    /**
     * Class attributes
     */
    private boolean charging;
    private BrightnessLevel brightnessLevel;
    private LightColor lightColor;

    /**
     * Constructor for Light objects
     */
    public Light(Status status, boolean charging, BrightnessLevel brightnessLevel, LightColor lightColor){
        super(status);
        this.charging = charging;
        this.brightnessLevel = brightnessLevel;
        this.lightColor = lightColor;
    }

        /**
         * The method getLightColor returns the Light's color
         */
        public LightColor getLightColor(){
            return this.lightColor;
        }

        /**
         * The method setLightColor obviously returns it
         */
        public void setLightColor(LightColor lightColor){
            this.lightColor = lightColor;
        }

        /**
         * The method getBrightnessLevel obviously returns it
         */
        public BrightnessLevel getBrightnessLevel(){
            return this.brightnessLevel;
        }

         /**
         * The method setBrightnessLevel obviously sets it
         */
        public void setBrightnessLevel(BrightnessLevel brightnessLevel){
        
             this.brightnessLevel = brightnessLevel;

        }

        @Override
        /**
         * The method isCharging returns the charge state
         */
        public boolean isCharging(){
            return this.charging == true;
        }

        @Override
        /**
         * The method startCharging  activates charging state
         */
        public boolean startCharging(){
            if(this.charging == true){
                return false;
            } else {
                this.charging = true;
                return true;
            }
        }

        @Override
        /**
         * The method stopCharging  activates charging state
         */
        public boolean stopCharging() {
            this.charging = false;
            return false;
        }

         /**
         * The method displayStatus returns current Light status
         */
        @Override
        public String displayStatus(){
                return "Light " + this.getDeviceId() + " is " + this.getStatus() + ", the color is " + this.getLightColor() + ", the charging status is " + this.charging + ", and the brightness level is " + this.brightnessLevel + "."; 
        }

            /**
     * Turns the device OFF if it is currently ON.
     * @return True if the device was successfully turned OFF, false if it was already OFF.
     */
    @Override
    public boolean turnOff() {
        if (this.getStatus() == Status.OFF) {
            return false;
        } else {
            this.setStatus(Status.OFF);
            this.charging = false;
            return true;
        }
    }
        
        

    }

    

