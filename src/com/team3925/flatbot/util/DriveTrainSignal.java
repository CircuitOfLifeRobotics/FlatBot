package com.team3925.flatbot.util;

/**
 *	Holds two DriveTrain values
 */
public class DriveTrainSignal {
	public double left;
	public double right;
	
	public DriveTrainSignal(double left, double right) {
		this.left = left;
		this.right = right;
	}
	
	/**
	 * A DriveTrainSignal with motor speeds of 0.0
	 */
	public static DriveTrainSignal NEUTRAL = new DriveTrainSignal(0.0, 0.0);
	/**
	 * A DriveTrainSignal with motor speeds of 1.0
	 */
	public static DriveTrainSignal FORWARD = new DriveTrainSignal(1.0, 1.0);
	/**
	 * A DriveTrainSignal with motor speeds of 0.0
	 */
	public static DriveTrainSignal BACKWARD = new DriveTrainSignal(-1.0, -1.0);
	
}
