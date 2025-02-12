/**
 * SmartLight is a subclass of SmartDevice that allows brightness adjustment.
 */
public class SmartLight extends SmartDevice {
    private int brightness;

    public SmartLight(String deviceName, double energyLevel) {
        super(deviceName, energyLevel);
        this.brightness = 0;
    }

    public void setBrightness(int value) {
        if (value < 0 || value > 100) {
            System.out.println("Invalid brightness level.");
            return;
        }
        if (hasEnoughEnergy(5)) {
            consumeEnergy(5);
            brightness = value;
            System.out.println(getDeviceType() + ": " + deviceName + " brightness set to " + brightness + ". The current battery level: " + String.format("%.1f", energyLevel));
        } else {
            System.out.println(getDeviceType() + ": Due to low battery level, the " + deviceName + " device cannot adjust brightness.");
        }
    }

    @Override
    protected String getDeviceType() {
        return "Smart Light";
    }
}
