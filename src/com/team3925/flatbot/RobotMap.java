package com.team3925.flatbot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import static com.team3925.flatbot.Constants.*;

public class RobotMap {
	private RobotMap() {}


	private static CANTalon drivetrainMotorLeftA;
	private static CANTalon drivetrainMotorLeftB;
	private static CANTalon drivetrainMotorRightA;
	private static CANTalon drivetrainMotorRightB;
	public static RobotDrive drivetrain;


	public static void init() {

		drivetrainMotorLeftA = new CANTalon(DRIVETRAIN_MOTOR_LEFT_A);
		drivetrainMotorLeftA.setInverted(false);
		
		drivetrainMotorLeftB = new CANTalon(DRIVETRAIN_MOTOR_LEFT_B);
		drivetrainMotorLeftB.setInverted(false);
		
		drivetrainMotorRightA = new CANTalon(DRIVETRAIN_MOTOR_RIGHT_A);
		drivetrainMotorRightA.setInverted(false);
		
		drivetrainMotorRightB = new CANTalon(DRIVETRAIN_MOTOR_RIGHT_B);
		drivetrainMotorRightB.setInverted(false);

		
		drivetrain = new RobotDrive(
				drivetrainMotorLeftA, drivetrainMotorLeftB,
				drivetrainMotorRightA, drivetrainMotorRightB);
		
		drivetrain.setMaxOutput(DRIVETRAIN_MAX_OUTPUT);
	}

}
