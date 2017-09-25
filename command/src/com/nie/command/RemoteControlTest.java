package com.nie.command;

import com.nie.command.entity.CeilingFan;
import com.nie.command.entity.GarageDoor;
import com.nie.command.entity.Light;
import com.nie.command.entity.Stereo;
import com.nie.command.impl.CeilingFanHighCommand;
import com.nie.command.impl.CeilingFanLowCommand;
import com.nie.command.impl.CeilingFanMediumCommand;
import com.nie.command.impl.CeilingFanOffCommand;
import com.nie.command.impl.GarageDoorDownCommand;
import com.nie.command.impl.GarageDoorOpenCommand;
import com.nie.command.impl.LightOffCommand;
import com.nie.command.impl.LightOnCommand;
import com.nie.command.impl.MacroCommand;
import com.nie.command.impl.StereoOffWithCDCommand;
import com.nie.command.impl.StereoOnWithCDCommand;

public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		
		Light light = new Light();
		Command onLightCmd = new LightOnCommand(light);
		Command offLightCmd = new LightOffCommand(light);
		
		GarageDoor garageDoor = new GarageDoor();
		Command upGarageDoorCmd = new GarageDoorOpenCommand(garageDoor);
		Command downGarageDoorCmd = new GarageDoorDownCommand(garageDoor);
		
		Stereo stereo = new Stereo();
		StereoOnWithCDCommand stereoOnCd = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOffCd = new StereoOffWithCDCommand(stereo);
		
		
		CeilingFan ceilingFan = new CeilingFan("high");
		CeilingFanHighCommand ceilingFanHighCmd = new CeilingFanHighCommand(ceilingFan);
		CeilingFanMediumCommand ceilingFanMediCmd = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanLowCommand ceilingFanLowCmd = new CeilingFanLowCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOffCmd = new CeilingFanOffCommand(ceilingFan);
		
		Command[] onCommands = new Command[]{onLightCmd, upGarageDoorCmd, stereoOnCd, ceilingFanHighCmd, ceilingFanMediCmd, ceilingFanLowCmd};
		MacroCommand onMacroCommand = new MacroCommand(onCommands);
		
		Command[] offCommands = new Command[]{offLightCmd, downGarageDoorCmd, stereoOffCd, ceilingFanOffCmd};
		MacroCommand offMacroCommand = new MacroCommand(offCommands);
		
		remote.setCommand(0, onMacroCommand, offMacroCommand);
		
		remote.onButtonWasPushed(0);
		remote.undoButtonWasPushed();
		remote.offButtonWasPushed(0);
		remote.undoButtonWasPushed();
		
		remote.onButtonWasPushed(1);
		remote.undoButtonWasPushed();
		remote.offButtonWasPushed(1);
		remote.undoButtonWasPushed();
		
		remote.onButtonWasPushed(2);
		remote.undoButtonWasPushed();
		remote.offButtonWasPushed(2);
		remote.undoButtonWasPushed();
		
		remote.onButtonWasPushed(3);
		remote.undoButtonWasPushed();
		remote.offButtonWasPushed(3);
		remote.undoButtonWasPushed();
		
		remote.onButtonWasPushed(4);
		remote.undoButtonWasPushed();
		remote.offButtonWasPushed(4);
		remote.undoButtonWasPushed();
		
		System.out.println(remote.toString());
	}

}
