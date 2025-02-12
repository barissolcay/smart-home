/**
 * SmartThermostat is a subclass of SmartDevice that allows temperature adjustment.
 */
public class SmartThermostat extends SmartDevice {
    private double temperature;

    public SmartThermostat(String deviceName, double energyLevel) {
        super(deviceName, energyLevel);
        this.temperature = 20.0;
    }

    public void setTemperature(double value) {
        if (value < 0 || value > 40) {
            if (hasEnoughEnergy(5)) {
                consumeEnergy(5);
            }
            System.out.println(getDeviceType() + ": " + deviceName + " temperature set to " + value + "°C. The current battery level: " + String.format("%.1f", energyLevel));
            return;
        }
        if (hasEnoughEnergy(5)) {
            consumeEnergy(5);
            System.out.println(getDeviceType() + ": " + deviceName + " temperature set to " + value + "°C. The current battery level: " + String.format("%.1f", energyLevel));
        } else {
            System.out.println(getDeviceType() + ": Due to low battery level,the " + deviceName + " device cannot adjust temperature.");
        }
    }





    @Override
    protected String getDeviceType() {
        return "Smart Thermostat";
    }
}
