package com.team3925.flatbot.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousManager {

	private CommandGroup auto;
	private SendableChooser chooser;

	// Prevents need for synchornization keywords
	private static class SingletonHolder { 
		private static final AutonomousManager INSTANCE = new AutonomousManager();
	}

	private AutonomousManager() {
		chooser = new SendableChooser();
		chooser.addDefault("Do Nothing", new DoNothingAuto());
		SmartDashboard.putData("AutoChooser", chooser);
	}

	public static AutonomousManager getInstance() {
		return SingletonHolder.INSTANCE;
	}


	public void start() {
		auto = loadAutonomous();
		System.out.println("Starting Autonomous Routine: " + auto.getName());
		auto.start();
	}
	
	public void cancel() {
		auto.cancel();
		DriverStation.reportError("Autonomous Routine Cancelled Early!", false);
	}
	
	private CommandGroup loadAutonomous() {
		Object selected = chooser.getSelected();
		
		if (selected instanceof CommandGroup) {
			return (CommandGroup) selected;
		} else {
			DriverStation.reportError("Autonomous Routine Chooser Defaulted! Running \"Do Nothing Autonomous\"", false);
			return new DoNothingAuto();
		}
	}

}
