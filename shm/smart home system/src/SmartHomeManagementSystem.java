import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * SmartHomeManagementSystem is the main class that controls the others.
 * It is the main file of the program.
 */
public class SmartHomeManagementSystem {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String TURN_ON = "TurnOn";
    private static final String TURN_OFF = "TurnOff";
    private static final String START_CHARGING = "StartCharging";
    private static final String STOP_CHARGING = "StopCharging";
    private static final String START_RECORDING = "StartRecording";
    private static final String STOP_RECORDING = "StopRecording";

    public static void main(String[] args) {
        List<SmartDevice> smartHome = initializeSmartDevices();

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] commandParts = command.split(" ");

            if (commandParts[0].equalsIgnoreCase("DisplayAllStatus")) {
                handleDisplayAllStatus(smartHome);
            } else if (commandParts[0].equalsIgnoreCase(TURN_ON) || commandParts[0].equalsIgnoreCase(TURN_OFF)) {
                handleTurnOnOff(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase(START_CHARGING) || commandParts[0].equalsIgnoreCase(STOP_CHARGING)) {
                handleStartStopCharging(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase("SetTemperature")) {
                handleSetTemperature(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase("SetBrightness")) {
                handleSetBrightness(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase("SetColor")) {
                handleSetColor(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase("SetAngle")) {
                handleSetAngle(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase(START_RECORDING) || commandParts[0].equalsIgnoreCase(STOP_RECORDING)) {
                handleStartStopRecording(commandParts, smartHome);
            } else if (commandParts[0].equalsIgnoreCase("end")) {
                System.out.println("Exiting Smart Home Management System...");
                break;
            } else {
                Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            }
        }
    }

    /**
     * Initializes the smart devices.
     * @return A list of initialized smart devices.
     */
    private static List<SmartDevice> initializeSmartDevices() {
        List<SmartDevice> smartDevices = new ArrayList<>();
        LightColor yellow = LightColor.YELLOW;
    
        // Initialize lights
        for (int i = 0; i < 4; i++) {
            Light light = new Light(Status.ON, false, BrightnessLevel.LOW, yellow);
            light.setDeviceId(i); // Set the device ID using the setter method
            smartDevices.add(light);
            SmartDevice.smartDeviceCount();
            
        }
    
        // Initialize cameras
        for (int i = 4; i < 6; i++) {
            Camera camera = new Camera(Status.ON, false, false, 45);
            camera.setDeviceId(i); // Set the device ID using the setter method
            smartDevices.add(camera);
            SmartDevice.smartDeviceCount();
        }
    
        // Initialize heaters
        for (int i = 6; i < 10; i++) {
            Heater heater = new Heater(Status.ON, 20);
            heater.setDeviceId(i); // Set the device ID using the setter method
            smartDevices.add(heater);
            SmartDevice.smartDeviceCount();
        }
    
        return smartDevices;
    }
    
    /**
     * Displays the status of all devices.
     * @param smartHome The list of smart devices.
     */
    private static void handleDisplayAllStatus(List<SmartDevice> smartHome) {
        for (SmartDevice device : smartHome) {
            System.out.println(device.displayStatus());
        }
    }

    /**
     * Handles turning devices on or off.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleTurnOnOff(String[] commandParts, List<SmartDevice> smartHome) {
        if (commandParts.length < 3) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }

        try {
            int deviceId = Integer.parseInt(commandParts[2]);
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
            if (device == null) {
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }

            if (commandParts[0].equals(TURN_ON)) {
                if (device.turnOn()) {
                    Utils.generateSuccessMessage(device, Utils.successCodes.DEVICETURNEDON);
                } else {
                    Utils.generateErrorMessage(device, Utils.errorCodes.DEVICEALREADYON);
                }
              
            } else if (commandParts[0].equals(TURN_OFF)) {
              if(device.turnOff()){
                Utils.generateSuccessMessage(device, Utils.successCodes.DEVICETURNEDOFF);
              } else {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICEALREADYOFF);
              }
        }
    } catch (NumberFormatException e) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        }
    }

    /**
     * Handles starting or stopping charging for chargeable devices.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleStartStopCharging(String[] commandParts, List<SmartDevice> smartHome) {
        if (commandParts.length < 3) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }

        try {
            int deviceId = Integer.parseInt(commandParts[2]);
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
            if(device == null){
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }
            if (!(device instanceof Chargeable)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTCHARGEABLE);
                return;
            }

            Chargeable chargeableDevice = (Chargeable) device;
            if (commandParts[0].equalsIgnoreCase(START_CHARGING)) {
                chargeableDevice.startCharging();
                if(chargeableDevice.isCharging()){
                    Utils.generateErrorMessage(device, Utils.errorCodes.DEVICEALREADYCHARGING);
                } else {
                    Utils.generateSuccessMessage(device, Utils.successCodes.CHARGINGSTARTED);
                }
            } else if (commandParts[0].equalsIgnoreCase(STOP_CHARGING)) {
               
                if(!chargeableDevice.stopCharging()){
                    Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTCHARGING);
                } else {
                Utils.generateSuccessMessage(device, Utils.successCodes.CHARGINGSTOPPED);
            }}
        } catch (NumberFormatException e) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        }
    }

    /**
     * Handles setting the temperature for heaters.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleSetTemperature(String[] commandParts, List<SmartDevice> smartHome) {
        // Validate command length
        if (commandParts.length != 4) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }
    
        try {
            // Parse the device ID
            int deviceId = Integer.parseInt(commandParts[2]);
    
            // Parse the temperature
            int temperature = Integer.parseInt(commandParts[3]);
    
            // Retrieve the device by ID and name
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
    
            // Check if the device was found
            if (device == null) {
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }

            // Check if device is on or off
            if(!device.checkStatusAccess()){
                Utils.generateErrorMessage(device, Utils.errorCodes.CANNOTCHANGEATTRIBUTE);
                return;
            }
    
            // Check if the device is a heater
            if (!(device instanceof Heater)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTHEATER);
                return;
            }
    
            // Set the temperature for the heater
            Heater heater = (Heater) device;
            if (!heater.setTemperature(temperature)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.TEMPERATUREOUTOFRANGE);
            } else {
                Utils.generateSuccessMessage(device, Utils.successCodes.TEMPERATURESET);
            }
        } catch (NumberFormatException e) {
            // Handle invalid device ID or temperature format
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        }
    }
    

    /**
     * Handles setting the brightness for lights.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleSetBrightness(String[] commandParts, List<SmartDevice> smartHome) {
        // Check if the command length is correct
        if (commandParts.length != 4) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }
    
        try {
            // Parse the device ID
            int deviceId = Integer.parseInt(commandParts[2]);
    
            // Check if the BrightnessLevel exists
            BrightnessLevel brightness = BrightnessLevel.valueOf(commandParts[3].toUpperCase());
    
            // Find the device by ID and name
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
    
            // Check if the device exists
            if (device == null) {
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }
    
            // Check if the device is a Light
            if (!(device instanceof Light)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTLIGHT);
                return;
            }

            // Check if device is on or off
            if(!device.checkStatusAccess()){
                Utils.generateErrorMessage(device, Utils.errorCodes.CANNOTCHANGEATTRIBUTE);
                return;
            }
    
            // Set the brightness level
            Light light = (Light) device;
            light.setBrightnessLevel(brightness);
            Utils.generateSuccessMessage(device, Utils.successCodes.BRIGHTNESSSET);
    
        } catch (NumberFormatException e) {
            // Handle invalid device ID format
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        } catch (IllegalArgumentException e) {
            // Handle invalid BrightnessLevel
            Utils.generateErrorMessage(null, Utils.errorCodes.BRIGHTNESSOUTBOUND);
        }
    }
    

    /**
     * Handles setting the color for lights.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleSetColor(String[] commandParts, List<SmartDevice> smartHome) {
        // Check if the command length is correct
        if (commandParts.length != 4) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }
    
        try {
            // Parse the device ID
            int deviceId = Integer.parseInt(commandParts[2]);
    
            // Validate the LightColor
            LightColor color = LightColor.valueOf(commandParts[3]);
    
            // Find the device by ID and name
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
    
            // Check if the device exists
            if (device == null) {
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }
    
            // Check if the device is a Light
            if (!(device instanceof Light)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTLIGHT);
                return;
            }

            // Check if device is on or off
            if(!device.checkStatusAccess()){
                Utils.generateErrorMessage(device, Utils.errorCodes.CANNOTCHANGEATTRIBUTE);
                return;
            }
    
            // Set the color for the light
            ((Light) device).setLightColor(color);
            Utils.generateSuccessMessage(device, Utils.successCodes.COLORSET);
    
        } catch (NumberFormatException e) {
            // Handle invalid device ID format
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        } catch (IllegalArgumentException e) {
            // Handle invalid LightColor
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOLOR);
        }
    }
    
    /**
     * Handles setting the
     *      * angle for cameras.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleSetAngle(String[] commandParts, List<SmartDevice> smartHome) {
        // Check if the command length is correct
        if (commandParts.length != 4) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }
    
        try {
            // Parse the device ID
            int deviceId = Integer.parseInt(commandParts[2]);
    
            // Parse the angle value
            int angle = Integer.parseInt(commandParts[3]);
    
            // Find the device by ID and name
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
    
            // Check if the device exists
            if (device == null) {
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }
    
            // Check if the device is a Camera
            if (!(device instanceof Camera)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTCAMERA);
                return;
            }

            // Check if device is on or off
            if(!device.checkStatusAccess()){
                Utils.generateErrorMessage(device, Utils.errorCodes.CANNOTCHANGEATTRIBUTE);
                return;
            }
    
            // Set the angle for the camera
            Camera camera = (Camera) device;
            if(camera.setCameraAngle(angle)){
                Utils.generateSuccessMessage(device, Utils.successCodes.ANGLESET);
            } else {
                Utils.generateErrorMessage(device, Utils.errorCodes.CAMERAOUTOFRANGE);
            }
    
        } catch (NumberFormatException e) {
            // Handle invalid device ID or angle format
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        }
    }
    
    
    /**
     * Handles starting or stopping recording for cameras.
     * @param commandParts The command parts.
     * @param smartHome The list of smart devices.
     */
    private static void handleStartStopRecording(String[] commandParts, List<SmartDevice> smartHome) {
        // Check if the command length is correct
        if (commandParts.length != 3) {
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            return;
        }
    
        try {
            // Parse the device ID
            int deviceId = Integer.parseInt(commandParts[2]);
    
            // Find the device by ID and name
            SmartDevice device = getDeviceById(deviceId, commandParts[1], smartHome);
    
            // Check if the device exists
            if (device == null) {
                Utils.generateErrorMessage(null, Utils.errorCodes.DEVICENOTFOUND);
                return;
            }
    
            // Check if the device is a Camera
            if (!(device instanceof Camera)) {
                Utils.generateErrorMessage(device, Utils.errorCodes.DEVICENOTCAMERA);
                return;
            }

            // Check if device is on or off
            if(!device.checkStatusAccess()){
                Utils.generateErrorMessage(device, Utils.errorCodes.CANNOTCHANGEATTRIBUTE);
                return;
            }
    
            // Cast the device to Camera
            Camera camera = (Camera) device;
    
            // Handle start/stop recording based on the command
            if (commandParts[0].equals(START_RECORDING)) {
                if (camera.isRecording()) {
                    Utils.generateErrorMessage(device, Utils.errorCodes.CAMERAALREADYRECORDING);
                } else {
                    camera.startRecording();
                    Utils.generateSuccessMessage(device, Utils.successCodes.RECORDINGSTARTED);
                }
            } else if (commandParts[0].equals(STOP_RECORDING)) {
                if (!camera.isRecording()) {
                    Utils.generateErrorMessage(device, Utils.errorCodes.CAMERANOTRECORDING);
                } else {
                    camera.stopRecording();
                    Utils.generateSuccessMessage(device, Utils.successCodes.RECORDINGSTOPPED);
                }
            } else {
                // Handle invalid commands
                Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
            }
    
        } catch (NumberFormatException e) {
            // Handle invalid device ID format
            Utils.generateErrorMessage(null, Utils.errorCodes.INVALIDCOMMAND);
        }
    }
    

/**
 * Retrieves a device by its ID and checks if the device name matches the type of the device.
 * @param deviceId The ID of the device.
 * @param deviceName The name/type of the device (e.g., "Light", "Camera").
 * @param smartHome The list of smart devices.
 * @return The SmartDevice with the specified ID and name, or null if not found.
 */
private static SmartDevice getDeviceById(int deviceId, String deviceName, List<SmartDevice> smartHome) {
    for (SmartDevice item : smartHome) {
        // Check if the device ID matches
        if (item.getDeviceId() == deviceId && item.getClass().getSimpleName().equals(deviceName)) {
            return item; // Return the matching device
        }
    }
    // Return null if no matching device is found
    // This will trigger an error message in the calling method

    return null;
}

}

