package eu.telecomnancy.ui;

import java.awt.Component;

import javax.swing.JPanel;

import eu.telecomnancy.sensor.SensorNotActivatedException;

abstract class WindowDecorator implements ISensorView {
    protected ISensorView windowToBeDecorated; // the Window being decorated

    public WindowDecorator (ISensorView windowToBeDecorated) {
        this.windowToBeDecorated = windowToBeDecorated;
    }
    
    
	@Override
	public void update(Double d) {
		windowToBeDecorated.update(d);
	}
	
	@Override
	public void addComponent(Component c) {
		windowToBeDecorated.addComponent(c);
	}
	
	public JPanel getPanel() {
		return windowToBeDecorated.getPanel();
	}
	
	public double getValue() {
		
		return windowToBeDecorated.getValue();
		
	}
	
	
}
