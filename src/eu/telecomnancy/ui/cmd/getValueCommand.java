package eu.telecomnancy.ui.cmd;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class getValueCommand implements Command {

	
	private ISensor sensor;
	
	public getValueCommand(ISensor s) {
		sensor=s;
	}
	
	@Override
	public Object execute() {
		try {
			return sensor.getValue();
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
		return null;

	}

}
