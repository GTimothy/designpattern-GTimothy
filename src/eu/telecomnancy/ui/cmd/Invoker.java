package eu.telecomnancy.ui.cmd;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	private List<Command> pastCommands = new ArrayList<Command>();

	public Object registerCommandAndExecute(Command c){
		pastCommands.add(c);
		return c.execute();
	}
}
