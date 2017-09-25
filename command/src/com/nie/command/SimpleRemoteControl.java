package com.nie.command;

import com.nie.command.impl.NoCommand;

public class SimpleRemoteControl {

	private Command[] onCommands;
	private Command[] offCommands;
	private Command undoCommand;
	
	public SimpleRemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}
	
	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
		
	}
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
	public void undoButtonWasPushed() {
		undoCommand.execute();
	}
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("\n------ Remote Control ------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuffer.append("[slot " + i + "] " + onCommands[i].getClass().getName() 
					+ " " + offCommands[i].getClass().getName() + "\n");
		}
		return stringBuffer.toString();
	}
}
