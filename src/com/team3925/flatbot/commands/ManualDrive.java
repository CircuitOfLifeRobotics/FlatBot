package com.team3925.flatbot.commands;

import com.team3925.flatbot.OI;
import com.team3925.flatbot.Robot;
import com.team3925.flatbot.RobotMap;
import com.team3925.flatbot.subsystems.DriveTrain;
import com.team3925.flatbot.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.command.Command;

public class ManualDrive extends Command{
	private final DriveTrain drivetrain = Robot.drivetrain;
	private final OI oi = new OI();
	
	@Override
	protected void initialize() {
		
	}
	public ManualDrive() {
		requires(drivetrain);
	}

	@Override
	protected void execute() {
		drivetrain.arcadeDriveVal(oi.getManualDrive_RotateValue(), oi.getManualDrive_ForwardValue());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
