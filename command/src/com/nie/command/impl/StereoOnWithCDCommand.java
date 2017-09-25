package com.nie.command.impl;

import com.nie.command.Command;
import com.nie.command.entity.Stereo;

public class StereoOnWithCDCommand implements Command {

	private Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume();
		
	}
	@Override
	public void undo() {
		stereo.off();
		
	}

}
