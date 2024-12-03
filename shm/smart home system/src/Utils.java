import java.util.*;

public class Utils {

    enum successCodes {
        DEVICETURNEDON,
        DEVICETURNEDOFF,
        CHARGINGSTARTED,
        CHARGINGSTOPPED,
        TEMPERATURESET,
        BRIGHTNESSSET,
        COLORSET,
        ANGLESET,
        RECORDINGSTARTED,
        RECORDINGSTOPPED
    }

    enum errorCodes {
        INVALIDCOMMAND,
        DEVICENOTFOUND,
        DEVICENOTCHARGEABLE,
        DEVICENOTHEATER,
        BRIGHTNESSOUTBOUND,
        DEVICENOTLIGHT,
        INVALIDCOLOR,
        DEVICENOTCAMERA,
        DEVICEALREADYOFF,
        DEVICEALREADYON,
        CANNOTCHANGEATTRIBUTE,
        CAMERAOUTOFRANGE,
        CAMERAALREADYRECORDING,
        CAMERANOTRECORDING,
        DEVICEALREADYCHARGING,
        DEVICENOTCHARGING,
        TEMPERATUREOUTOFRANGE
    }

    enum validCommands {
        DISPLAYALLSTATUS,
        TURNONOFF,
        STARTSTOPCHARGING,
        SETTEMPERATURE,
        SETBRIGHTNESS,
        SETCOLOR,
        SETANGLE,
        STARTSTOPRECORDING,
        END
    }

    /**
     * Generates a success message based on the success code.
     * @param device The device for which the operation succeeded.
     * @param successCode The code representing the type of success.
     */
    public static void generateSuccessMessage(SmartDevice device, successCodes successCode) {

        switch (successCode) {

            case DEVICETURNEDON:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is on");
                break;

            case DEVICETURNEDOFF:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is off");
                break;

            case CHARGINGSTARTED:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is charging");
                break;

            case CHARGINGSTOPPED:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " stopped charging");
                break;

            case TEMPERATURESET:
                // Retrieves temperature from the Heater subclass.
                if (device instanceof Heater) {
                    Heater heater = (Heater) device;
                    System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " temperature is set to " + heater.getTemperature());
                }
                break;

            case BRIGHTNESSSET:
                // Retrieves brightness from the Light subclass.
                if (device instanceof Light) {
                    Light light = (Light) device;
                    System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " brightness is set to " + light.getBrightnessLevel());
                }
                break;

            case COLORSET:
                // Retrieves color from the Light subclass.
                if (device instanceof Light) {
                    Light light = (Light) device;
                    System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " color is set to " + light.getLightColor());
                }
                break;

            case ANGLESET:
                // Retrieves angle from the Camera subclass.
                if (device instanceof Camera) {
                    Camera camera = (Camera) device;
                    System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " angle is set to " + camera.getAngle());
                }
                break;

            case RECORDINGSTARTED:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " started recording");
                break;

            case RECORDINGSTOPPED:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " stopped recording");
                break;

            default:
                break;
        }
    }

    /**
     * Generates an error message based on the error code.
     * @param device The device for which the error occurred.
     * @param errorCode The code representing the type of error.
     */
    public static void generateErrorMessage(SmartDevice device, errorCodes errorCode) {

        switch (errorCode) {

            case INVALIDCOMMAND:
                System.out.println("Invalid command");
                break;

            case DEVICENOTFOUND:
                System.out.println("The smart device was not found");
                break;

            case DEVICENOTCHARGEABLE:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is not chargeable");
                break;

            case DEVICENOTHEATER:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is not a heater");
                break;

            case BRIGHTNESSOUTBOUND:
                System.out.println("The brightness can only be one of \"LOW\", \"MEDIUM\", or \"HIGH\"");
                break;

            case DEVICENOTLIGHT:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is not a light");
                break;

            case INVALIDCOLOR:
                System.out.println("The light color can only be \"YELLOW\" or \"WHITE\"");
                break;

            case DEVICENOTCAMERA:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is not a camera");
                break;

            case DEVICEALREADYOFF:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is already off");
                break;

            case DEVICEALREADYON:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is already on");
                break;

            case CANNOTCHANGEATTRIBUTE:
                System.out.println("You can't change the status of the " + device.getClass().getSimpleName() + " " + device.getDeviceId() + " while it is off");
                break;

            case CAMERAOUTOFRANGE:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " angle should be in the range [-60, 60]");
                break;

            case CAMERAALREADYRECORDING:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is already recording");
                break;

            case CAMERANOTRECORDING:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is not recording");
                break;

            case DEVICEALREADYCHARGING:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is already charging");
                break;

            case DEVICENOTCHARGING:
                System.out.println(device.getClass().getSimpleName() + " " + device.getDeviceId() + " is not charging");
                break;

            case TEMPERATUREOUTOFRANGE:
                System.out.println("Heater " + device.getDeviceId() + " temperature should be in the range [15, 30]");
                break;

            default:
                break;
        }
    }
}
