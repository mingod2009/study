package com.nie.command.impl;

import com.nie.command.Command;
import com.nie.command.entity.GarageDoor;

public class GarageDoorOpenCommand implements Command {

	private GarageDoor garageDoor;
	
	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}
	@Override
	public void execute() {
		
		garageDoor.up();
	}
	@Override
	public void undo() {
		garageDoor.down();
		
	}

}
