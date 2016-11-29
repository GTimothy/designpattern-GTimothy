package eu.telecomnancy.ui.cmd;

import eu.telecomnancy.sensor.ISensor;
import eu.telecomnancy.sensor.SensorNotActivatedException;

public class updateCommand implements Command {

	
	private ISensor sensor;
	
	public updateCommand(ISensor s) {
		sensor=s;
	}
	@Override
	public Object execute() {
		try {
			sensor.update();
		} catch (SensorNotActivatedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
