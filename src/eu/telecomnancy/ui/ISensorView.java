package eu.telecomnancy.ui;

import java.awt.Component;

import javax.swing.JPanel;

import eu.telecomnancy.sensor.SensorNotActivatedException;


public interface ISensorView{

	public void update(Double d);
	public double getValue();
	
	public void addComponent(Component c);

	public JPanel getPanel();

}