package com.nie.command.impl;

import com.nie.command.Command;
import com.nie.command.entity.Stereo;

public class StereoOffWithCDCommand implements Command {

	private Stereo stereo;
	
	public StereoOffWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	@Override
	public void execute() {
		stereo.off();

	}
	@Override
	public void undo() {
		stereo.on();
		
	}

}
