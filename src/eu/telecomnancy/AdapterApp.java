package eu.telecomnancy;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensor;
import eu.telecomnancy.sensor.LegacyTemperatureSensorAdapter;
import eu.telecomnancy.ui.ConsoleUI;

public class AdapterApp {

    public static void main(String[] args) {
    	LegacyTemperatureSensor lts = new LegacyTemperatureSensor();
        ISensor sensor = new LegacyTemperatureSensorAdapter(lts);
        new ConsoleUI(sensor);
    }

}