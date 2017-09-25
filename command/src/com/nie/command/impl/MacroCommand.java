package com.nie.command.impl;

import com.nie.command.Command;

public class MacroCommand implements Command {

	private Command[] command;
	
	public MacroCommand(Command[] commands) {
		this.command = commands;
	}
	@Override
	public void execute() {
		for (int i = 0; i < command.length; i++) {
			command[i].execute();
		}

	}

	@Override
	public void undo() {
		for (int i = 0; i < command.length; i++) {
			command[i].undo();
		}

	}

}
