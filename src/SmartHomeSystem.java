import java.util.List;

/**
 * SmartHomeSystem initializes and runs the smart home application.
 */
public class SmartHomeSystem {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SmartHomeSystem devices.txt commands.txt");
            return;
        }

        String devicesFile = args[0];
        String commandsFile = args[1];

        CommandProcessor processor = new CommandProcessor();
        List<String> deviceLines = FileManager.readFile(devicesFile);
        List<String> commandLines = FileManager.readFile(commandsFile);

        // Cihazları oluştur ve CommandProcessor'a ekle
        for (String line : deviceLines) {
            String[] parts = line.split("\t");
            if (parts.length != 3) {
                System.out.println("Invalid device format in devices.txt.");
                continue;
            }

            String type = parts[0];
            String name = parts[1];
            double energy = Double.parseDouble(parts[2]);

            switch (type) {
                case "SmartLight":
                    processor.addDevice(new SmartLight(name, energy));
                    break;
                case "SmartThermostat":
                    processor.addDevice(new SmartThermostat(name, energy));
                    break;
                case "SmartSpeaker":
                    processor.addDevice(new SmartSpeaker(name, energy));
                    break;
                case "SmartCamera":
                    processor.addDevice(new SmartCamera(name, energy));
                    break;
                default:
                    System.out.println("Unknown device type: " + type);
            }
        }

        for (String command : commandLines) {
            processor.processCommand(command);
        }
    }
}
