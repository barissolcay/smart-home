import java.util.*;

/**
 * CommandProcessor handles command execution for smart devices.
 */
public class CommandProcessor {
    private Map<String, SmartDevice> devices;

    public CommandProcessor() {
        devices = new HashMap<>();
    }

    public void addDevice(SmartDevice device) {
        devices.put(device.deviceName, device);
    }

    public void processCommand(String commandLine) {
        String[] parts = commandLine.split("\t", 2);
        if (parts.length < 2) {
            System.out.println("Invalid command format.");
            return;
        }

        String deviceName = parts[0].trim();
        String commandPart = parts[1].trim();

        String command;
        String argument = "";

        if (commandPart.contains(":")) {
            String[] cmdParts = commandPart.split(":", 2);
            command = cmdParts[0].trim().toUpperCase();  // "PLAY"
            argument = cmdParts[1].trim();                // "Behind the Blue Eyes"
        } else {
            String[] cmdWords = commandPart.split("\\s+");
            command = cmdWords[0].trim().toUpperCase();
            if (cmdWords.length >= 2) {
                argument = cmdWords[1].trim();
            }
        }

        SmartDevice device = devices.get(deviceName);
        if (device == null) {
            System.out.println("Unknown command for Smart Device.");
            return;
        }

        switch (command) {
            case "TURN_ON":
                device.turnOn();
                break;
            case "TURN_OFF":
                device.turnOff();
                break;
            case "BRIGHTNESS":
                if (device instanceof SmartLight) {
                    try {
                        int brightness = Integer.parseInt(argument);
                        ((SmartLight) device).setBrightness(brightness);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid brightness level format.");
                    }
                } else {
                    System.out.println("Invalid command for " + device.getDeviceType() + ".");
                }
                break;
            case "TEMPERATURE":
                if (device instanceof SmartThermostat) {
                    try {
                        double temperature = Double.parseDouble(argument);
                        ((SmartThermostat) device).setTemperature(temperature);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid temperature level format.");
                    }
                } else {
                    System.out.println("Invalid command for " + device.getDeviceType() + ".");
                }
                break;
            case "VOLUME":
                if (device instanceof SmartSpeaker) {
                    try {
                        int volume = Integer.parseInt(argument);
                        ((SmartSpeaker) device).setVolume(volume);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid volume level format.");
                    }
                } else {
                    System.out.println("Invalid command for " + device.getDeviceType() + ".");
                }
                break;
            case "PLAY":
                if (device instanceof SmartSpeaker) {
                    // Argumentın boş olup olmadığını kontrol edelim
                    if (!argument.isEmpty()) {
                        ((SmartSpeaker) device).playMusic(argument);
                    } else {
                        System.out.println("Invalid command for Smart Speaker.");
                    }
                } else {
                    System.out.println("Invalid command for " + device.getDeviceType() + ".");
                }
                break;
            case "START":
                if (device instanceof SmartCamera) {
                    ((SmartCamera) device).startRecording();
                } else {
                    System.out.println("Invalid command for " + device.getDeviceType() + ".");
                }
                break;
            case "STOP":
                if (device instanceof SmartCamera) {
                    ((SmartCamera) device).stopRecording();
                } else {
                    System.out.println("Invalid command for " + device.getDeviceType() + ".");
                }
                break;
            default:
                System.out.println("Unknown command for " + device.getDeviceType() + ".");
                break;
        }
    }
}
