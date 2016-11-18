package eu.telecomnancy.sensor;

import java.util.ArrayList;

public class StateTemperatureSensor implements ISensor{
	SensorState on = new StateTemperatureSensorOn(this);
	SensorState off = new StateTemperatureSensorOff(this);
	SensorState sensorState = off;
	boolean state;
    double value = 0;
    ArrayList<Observer> observers = new ArrayList<>();

    public void on() {
       sensorState.on();
    }

    
    public void off() {
        sensorState.off();
    }

    @Override
    public boolean getStatus() {
        return sensorState.getStatus();
    }

    @Override
    public void update() throws SensorNotActivatedException {
    	sensorState.update();
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        return sensorState.getValue();
    }
    
    public void stateOff(){
    	sensorState=off;
    }
    public void stateOn(){	
    	sensorState=on;
    }

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
		
	}

	@Override
	public void unregisterObsever(Observer o) {
		this.observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers)
			o.update(value);
		
	}


	public void setValue(double d) {
		this.value=d;
		
	}

}
