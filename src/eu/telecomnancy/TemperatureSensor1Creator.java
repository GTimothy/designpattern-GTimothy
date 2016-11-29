package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.TemperatureSensor;

public class TemperatureSensor1Creator extends SensorCreator{

	public ISensor makeSensor() {
		System.out.println("TemperatureSensor1Creator creating sensor");
		return new TemperatureSensor();
	}

}
