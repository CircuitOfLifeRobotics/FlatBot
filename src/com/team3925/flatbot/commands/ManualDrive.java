package com.team3925.flatbot.commands;

import com.team3925.flatbot.Robot;
import com.team3925.flatbot.util.CommandPlus;

public class ManualDrive extends CommandPlus {
	
	public ManualDrive() {
		super("ManualDrive");
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.drivetrain.arcadeDrive(Robot.oi.getManualDrive_RotateValue(), Robot.oi.getManualDrive_ForwardValue());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

}
