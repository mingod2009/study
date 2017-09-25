package com.nie.command.impl;

import com.nie.command.Command;
import com.nie.command.entity.Light;

public class LightOffCommand implements Command {
	private Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	@Override
	public void execute() {
		light.off();
	}
	@Override
	public void undo() {
		light.on();
		
	}

}
