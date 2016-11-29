package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;

public class TemperatureSensor2Creator extends SensorCreator{

	public ISensor makeSensor() {
		System.out.println("TemperatureSensor2Creator creating sensor");
		return new TemperatureSensor();
	}

}
