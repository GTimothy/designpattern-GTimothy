package eu.telecomnancy;

import javax.swing.JOptionPane;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.ui.MainWindow;

public class SwingApp {

    public static void main(String[] args) {
    	JOptionPane jop = new JOptionPane();
    	SensorCreator sensorCreator = null;
    	String[] sensors = {"TemperatureSensor1", "TemperatureSensor2"};
    	
    	String nom = (String)jop.showInputDialog(null,
    		      "Please choose a sensor",
    		      "Sensor Choice",
    		      JOptionPane.QUESTION_MESSAGE,
    		      null,
    		      sensors,
    		      sensors[0]);
    	
    	switch (nom){
    	case "TemperatureSensor1": sensorCreator = new TemperatureSensor1Creator();break;
    	case "TemperatureSensor2": sensorCreator = new TemperatureSensor2Creator();break;

    	}
    	
    	

        ISensor sensor = sensorCreator.makeSensor();
        new MainWindow(sensor);
    }

}
