package eu.telecomnancy.ui.cmd;

import eu.telecomnancy.sensor.ISensor;

public class offCommand implements Command {

	
	private ISensor sensor;
	
	public offCommand(ISensor s) {
		sensor=s;
	}
	@Override
	public Object execute() {
		sensor.off();
		return null;
	}

}
