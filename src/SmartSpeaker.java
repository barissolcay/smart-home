/**
 * SmartSpeaker is a subclass of SmartDevice that supports volume control and music playback.
 */
public class SmartSpeaker extends SmartDevice {
    private int volume;

    public SmartSpeaker(String deviceName, double energyLevel) {
        super(deviceName, energyLevel);
        this.volume = 0;
    }

    public void setVolume(int value) {
        if (value < 0 || value > 100) {
            System.out.println("Invalid volume level.");
            return;
        }
        if (hasEnoughEnergy(5)) {
            consumeEnergy(5);
            System.out.println(getDeviceType() + ": " + deviceName + " volume set to " + value + ". The current battery level: " + String.format("%.1f", energyLevel));
        } else {
            System.out.println(getDeviceType() + ": Due to low battery level,the " + deviceName + " device cannot adjust volume.");
        }
    }
    public void playMusic(String song) {
        if (hasEnoughEnergy(15)) {
            consumeEnergy(15);
            System.out.println(getDeviceType() + ": " + deviceName + " is playing " + song + ". The current battery level: " + String.format("%.1f", energyLevel));
        } else {
            System.out.println(getDeviceType() + ": Due to low battery level,the " + deviceName + " device cannot play the track " + song + ".");
        }
    }
    @Override
    protected String getDeviceType() {
        return "Smart Speaker";
    }
}
