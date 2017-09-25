package com.nie.command.impl;

import com.nie.command.Command;
import com.nie.command.entity.Light;

public class LightOnCommand implements Command {

	Light light;
	public LightOnCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		
		light.on();
		
	}
	@Override
	public void undo() {
		light.off();
		
	}

	
}
