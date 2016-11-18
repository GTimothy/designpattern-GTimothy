package eu.telecomnancy.sensor;

public class StateTemperatureSensorOff implements SensorState {
    StateTemperatureSensor sts;
    double value = 0;

    public StateTemperatureSensorOff(StateTemperatureSensor sts) {
		this.sts=sts;
	}
    @Override
    public void on() {
    	this.sts.stateOn();
    }

    @Override
    public void off() {
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public void update() throws SensorNotActivatedException {
    	throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        throw new SensorNotActivatedException("Sensor must be activated to get its value.");
    }

}
