package com.team3925.flatbot;

import static com.team3925.flatbot.Constants.*;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
	private RobotMap() {}
	
	public static AHRS navx;

	public static CANTalon drivetrainMotorLeftA;
	public static CANTalon drivetrainMotorLeftB;
	public static CANTalon drivetrainMotorRightA;
	public static CANTalon drivetrainMotorRightB;

	
	public static void initNavx() {
		try {
			//Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB
			navx = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException e) {
			DriverStation.reportError("There was an error instantiating the NavxMXP!\n" + e.getMessage(), true);
		}
	}
	
	public static void init() {

		drivetrainMotorLeftA = new CANTalon(DRIVETRAIN_MOTOR_LEFT_A);
		drivetrainMotorLeftA.setInverted(false);
		
		drivetrainMotorLeftB = new CANTalon(DRIVETRAIN_MOTOR_LEFT_B);
		drivetrainMotorLeftB.setInverted(false);
		
		drivetrainMotorRightA = new CANTalon(DRIVETRAIN_MOTOR_RIGHT_A);
		drivetrainMotorRightA.setInverted(false);
		
		drivetrainMotorRightB = new CANTalon(DRIVETRAIN_MOTOR_RIGHT_B);
		drivetrainMotorRightB.setInverted(false);

	}

}
