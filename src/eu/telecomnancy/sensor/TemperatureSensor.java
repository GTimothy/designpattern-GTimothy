package eu.telecomnancy.sensor;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor implements ISensor {
    boolean state;
    double value = 0;
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public boolean getStatus() {
        return state;
    }

    @Override
    public void update() throws SensorNotActivatedException {
        if (state){
            value = (new Random()).nextDouble() * 100;
            this.notifyObservers();
        }
        else throw new SensorNotActivatedException("Sensor must be activated before acquiring new values.");
    }

    @Override
    public double getValue() throws SensorNotActivatedException {
        if (state)
            return value;
        else throw new SensorNotActivatedException("Sensor must be activated to get its value.");
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



}
