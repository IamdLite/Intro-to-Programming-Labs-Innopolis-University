import java.util.*;

/**
 * Camera represents a smart device class for video recording at given angles.
 */
public class Camera extends SmartDevice implements Chargeable {

    /**
     * These variables represent the status of the camera and its angle.
     * The camera can be charging, recording, and have an angle between -60 and 60.
     */
    private final int MAX_CAMERA_ANGLE = 60;
    private final int MIN_CAMERA_ANGLE = -60;
    private boolean charging;
    private boolean recording;
    private int angle;

    /**
     * Constructor for the Camera class.
     * 
     * @param status    The initial status of the camera.
     * @param charging  The charging state of the camera.
     * @param recording The recording state of the camera.
     * @param angle     The angle of the camera.
     */
    public Camera(Status status, boolean charging, boolean recording, int angle) {
        super(status);
        this.charging = charging;
        this.recording = recording;
        this.angle = angle;
        System.out.println("Camera is created");
    }

    /**
     * Returns the current camera angle.
     * 
     * @return The angle of the camera.
     */
    public int getAngle() {
        return this.angle;
    }

    /**
     * Changes the camera angle if within valid range.
     * 
     * @param angle The new angle to set.
     * @return True if the angle is successfully set, false otherwise.
     */
    public boolean setCameraAngle(int angle) {
        if (angle > MIN_CAMERA_ANGLE && angle < MAX_CAMERA_ANGLE) {
            this.angle = angle;
            return true;
        }
        return false;
    }

    /**
     * Starts recording if the camera is not already recording and is ON.
     * 
     * @return True if recording starts successfully, false otherwise.
     */
    public boolean startRecording() {
        if (!this.recording && this.getStatus() == Status.ON) {
            this.recording = true;
            return true;
        }
        return false;
    }

    /**
     * Stops recording if the camera is currently recording.
     * 
     * @return True if recording stops successfully, false otherwise.
     */
    public boolean stopRecording() {
        if (this.recording) {
            this.recording = false;
            return true;
        }
        return false;
    }

    /**
     * Checks if the camera is currently recording.
     * 
     * @return True if the camera is recording, false otherwise.
     */
    public boolean isRecording() {
        return this.recording == true;
    }

    /**
     * Checks if the camera is currently charging.
     * 
     * @return True if the camera is charging, false otherwise.
     */
    public boolean isCharging() {
        return this.charging == true;
    }

    /**
     * Starts charging the camera if it is not already charging.
     * 
     * @return True if charging starts successfully, false otherwise.
     */
    public boolean startCharging() {
        if (!this.charging) {
            this.charging = true;
            return true;
        }
        return false;
    }

    /**
     * Stops charging the camera if it is currently charging.
     * 
     * @return True if charging stops successfully, false otherwise.
     */
    public boolean stopCharging() {
        if (this.charging) {
            this.charging = false;
            return true;
        }
        return false;
    }

    /**
     * Displays the current status of the camera.
     * 
     * @return A string representation of the camera's status.
     */
    @Override
    public String displayStatus() {
        return "Camera " + this.getDeviceId() + " is " + this.getStatus() +
               ", the angle is " + this.getAngle() +
               ", the charging status is " + this.isCharging() +
               ", and the recording status is " + this.isRecording() + ".";
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
