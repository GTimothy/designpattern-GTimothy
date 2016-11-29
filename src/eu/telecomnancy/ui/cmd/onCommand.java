package eu.telecomnancy.ui.cmd;

import eu.telecomnancy.sensor.ISensor;

public class onCommand implements Command {

	
	private ISensor sensor;
	
	public onCommand(ISensor s) {
		sensor=s;
	}
	@Override
	public Object execute() {
		sensor.on();
		return null;
	}

}
