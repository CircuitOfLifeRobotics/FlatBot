package com.team3925.flatbot.subsystems;

import com.team3925.flatbot.RobotMap;
import com.team3925.flatbot.commands.ManualDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	RobotDrive driveTrain;

	public DriveTrain(RobotDrive driveTrain) {
		this.driveTrain = driveTrain;
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}
	
	public void setMotorSpeeds(double left, double right){
		driveTrain.setLeftRightMotorOutputs(left, right);
	}
	public void arcadeDriveVal(double xValue, double yValue){
		driveTrain.arcadeDrive(yValue, xValue, true);
	}
	
}
