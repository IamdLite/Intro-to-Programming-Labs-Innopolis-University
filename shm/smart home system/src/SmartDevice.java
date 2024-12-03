import java.util.*;

/**
 * This is the abstract class for all smart devices.
 */
public abstract class SmartDevice implements Controllable {

    /**
     * The status of the device (ON or OFF).
     */
    private Status status;

    /**
     * The ID of the device.
     */
    private int deviceId;

    /**
     * The number of devices.
     */
    private static int numberOfDevices;

    /**
     * Constructor to initialize the device with a given status.
     * @param status The initial status of the device.
     */
    public SmartDevice(Status status) {
        this.status = status;
        System.out.println("SmartDevice is created");
    }

    /**
     * Abstract method to display the device's status.
     * Must be implemented by all subclasses.
     * @return A string representation of the device's status.
     */
    public abstract String displayStatus();

    /**
     * Retrieves the unique ID of the device.
     * @return The device ID.
     */
    public int getDeviceId() {
        return this.deviceId;
    }

    /**
     * Sets the unique ID of the device.
     * @param deviceId The device ID to set.
     */
    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * Retrieves the current status of the device.
     * @return The device's status (ON or OFF).
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Sets the current status of the device.
     * @param status The new status to set (ON or OFF).
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Turns the device OFF if it is currently ON.
     * @return True if the device was successfully turned OFF, false if it was already OFF.
     */
    public boolean turnOff() {
        if (this.getStatus() == Status.OFF) {
            return false;
        } else {
            this.setStatus(Status.OFF);
            return true;
        }
    }

    /**
     * Turns the device ON if it is currently OFF.
     * @return True if the device was successfully turned ON, false if it was already ON.
     */
    public boolean turnOn() {
        if (this.getStatus() == Status.ON) {
            return false;
        } else {
            this.setStatus(Status.ON);
            return true;
        }
    }

    /**
     * Checks if the device is currently ON.
     * @return True if the device is ON, false otherwise.
     */
    public boolean isOn() {
        return this.status == Status.ON;
    }

    /**
     * Checks the status access of the device.
     * @return True if the status is ON, false otherwise.
     */
    public boolean checkStatusAccess() {
        return this.status == Status.ON;
    }

        /**
     * Retrieves the total number of devices created.
     * @return The total number of devices.
     */
    public static int getNumberOfDevices() {
        return numberOfDevices;
    }

        /**
     * Increments number of devices created.
     */
    public static void smartDeviceCount() {
        numberOfDevices += 1;
    }


}
