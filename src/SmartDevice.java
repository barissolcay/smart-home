import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SmartDevice is the abstract base class for all smart home devices.
 * It handles common attributes such as device name, energy level, and power state.
 */
public abstract class SmartDevice {
    protected String deviceName;
    protected double energyLevel;
    protected boolean isOn;

    public SmartDevice(String deviceName, double energyLevel) {
        this.deviceName = deviceName;
        this.energyLevel = energyLevel;
        this.isOn = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(getDeviceType() + ": " + deviceName + " is turned on at " + getFormattedTime(false) + " with battery level " + String.format("%.2f", energyLevel));
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println(getDeviceType() + ": " + deviceName + " is turned off at " + getFormattedTime(true) + " with battery level " + String.format("%.2f", energyLevel));
        }
    }

    protected boolean hasEnoughEnergy(double requiredEnergy) {
        return energyLevel >= requiredEnergy;
    }

    protected void consumeEnergy(double amount) {
        if (energyLevel >= amount) {
            energyLevel -= amount;
        } else {
            energyLevel = 0;
        }
    }

    protected String getFormattedTime(boolean forTurnOff) {
        if (forTurnOff) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH/mm/ss");
            return formatter.format(new Date());
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            return formatter.format(new Date());
        }
    }

    protected abstract String getDeviceType();
}
