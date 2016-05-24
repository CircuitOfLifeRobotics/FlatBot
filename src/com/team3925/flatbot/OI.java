package com.team3925.flatbot;

import com.team3925.flatbot.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	public Joystick xbox;
	
	public OI() {
		xbox = new Joystick(0);
	}
	public double getManualDrive_ForwardValue(){
		return XboxHelper.getShooterAxis(XboxHelper.AXIS_LEFT_Y);
	}
	public double getManualDrive_RotateValue(){
		return XboxHelper.getShooterAxis(XboxHelper.AXIS_RIGHT_X);
	}
	

}
