package com.team3925.flatbot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.team3925.flatbot.commands.ManualDrive;
import com.team3925.flatbot.util.DriveTrainPose;
import com.team3925.flatbot.util.DriveTrainSignal;
import com.team3925.flatbot.util.Loopable;
import com.team3925.flatbot.util.MiscUtil;
import com.team3925.flatbot.util.SmartdashBoardLoggable;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem implements SmartdashBoardLoggable, Loopable {

	private final DriveTrainSide left, right;
	private final AHRS navx;

	private DriveTrainSignal setpoints;
	private DriveTrainPose cachedPose;


	public DriveTrain(CANTalon motorLeftA, CANTalon motorLeftB, CANTalon motorRightA, CANTalon motorRightB, AHRS navx) {
		left = new DriveTrainSide(motorLeftA, motorLeftB);
		right = new DriveTrainSide(motorRightA, motorRightB);
		this.navx = navx;
	}

	@Override
	public void update() {
		setMotorSpeeds(setpoints);
		
		logData();
	}

	public void setSetpoints(DriveTrainSignal signal) {
		setpoints = signal;
	}

	@Override
	public void logData() {
		putNumberSD("LeftPos", left.getPosition());
		putNumberSD("RightPos", right.getPosition());

		putNumberSD("LeftVel", left.getVelocity());
		putNumberSD("RightVel", right.getVelocity());

		putNumberSD("NavxHeading", navx.getFusedHeading());
	}

	private void setMotorSpeeds(DriveTrainSignal signal) {
		left.setMotorSpeeds(signal.left);
		right.setMotorSpeeds(signal.right);
	}

	public DriveTrainPose getPhysicalPose() {
		cachedPose.reset(left.getPosition(), right.getPosition(),
				left.getVelocity(), right.getVelocity(),
				navx.getFusedHeading(), 0); // no heading velocity

		return cachedPose;
	}

	@Override
	public String getFormattedName() {
		return "DriveTrain_";
	}

	public void arcadeDrive(double moveValue, double rotateValue) {
		double leftMotorSpeed;
		double rightMotorSpeed;

		moveValue = -MiscUtil.limit(moveValue);
		rotateValue = MiscUtil.limit(rotateValue);

		// square the inputs (while preserving the sign) to increase fine control
		// while permitting full power (always enabled)
		if (moveValue >= 0.0) {
			moveValue = (moveValue * moveValue);
		} else {
			moveValue = -(moveValue * moveValue);
		}
		if (rotateValue >= 0.0) {
			rotateValue = (rotateValue * rotateValue);
		} else {
			rotateValue = -(rotateValue * rotateValue);
		}

		if (moveValue > 0.0) {
			if (rotateValue > 0.0) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {
			if (rotateValue > 0.0) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}

		setMotorSpeeds(new DriveTrainSignal(leftMotorSpeed, rightMotorSpeed));
	}	

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}

}
