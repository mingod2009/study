package com.nie.command.impl;

import com.nie.command.Command;
import com.nie.command.entity.CeilingFan;

public class CeilingFanLowCommand implements Command {
	private CeilingFan ceilingFan;
	private int preSpeed;
	
	public CeilingFanLowCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}
	@Override
	public void execute() {
		this.preSpeed = ceilingFan.getSpeed();
		this.ceilingFan.low();
	}

	@Override
	public void undo() {
		if (preSpeed == CeilingFan.HIGH) {
			this.ceilingFan.high();
		} else if (preSpeed == CeilingFan.MEDIUM) {
			this.ceilingFan.medium();
		} else if (preSpeed == CeilingFan.LOW) {
			this.ceilingFan.low();
		} else if (preSpeed == CeilingFan.OFF) {
			this.ceilingFan.off();
		}

	}

}
