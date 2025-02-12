public class SmartCamera extends SmartDevice {
    private boolean isRecording;

    public SmartCamera(String deviceName, double energyLevel) {
        super(deviceName, energyLevel);
        this.isRecording = false;
    }

    public void startRecording() {
        if (isRecording) {
            System.out.println(getDeviceType() + ": Device is recording. Please, first stop the current record!");
            return;
        }
        if (hasEnoughEnergy(20)) {
            consumeEnergy(20);
            isRecording = true;
            System.out.println(getDeviceType() + ": " + deviceName + " recording started. The current battery level:" + String.format("%.1f", energyLevel));
        } else {
            System.out.println(getDeviceType() + ": Due to low battery level, the " + deviceName + " device cannot start recording.");
        }
    }

    public void stopRecording() {
        if (isRecording) {
            isRecording = false;
            System.out.println(getDeviceType() + ": " + deviceName + " recording stopped. The current battery level:" + String.format("%.1f", energyLevel));
        } else {
            System.out.println(getDeviceType() + ": No active recording to stop.");
        }
    }

    @Override
    protected String getDeviceType() {
        return "Smart Camera";
    }
}
