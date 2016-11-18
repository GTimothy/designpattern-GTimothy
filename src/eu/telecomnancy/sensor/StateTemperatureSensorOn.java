package eu.telecomnancy.sensor;

import java.util.Random;

public class StateTemperatureSensorOn implements SensorState {
    StateTemperatureSensor sts;
    double value = 0;
    
    public StateTemperatureSensorOn(StateTemperatureSensor sts) {
		this.sts=sts;
	}
    @Override
    public void on() {
    }

    @Override
    public void off() {
        sts.stateOff();
    }

    @Override
    public boolean getStatus() {
        return true;
    }

    @Override
    public void update() throws SensorNotActivatedException {
            sts.setValue((new Random()).nextDouble() * 100);
            sts.notifyObservers();            
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
            return value;
    }

}
