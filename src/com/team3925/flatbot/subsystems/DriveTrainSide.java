package com.team3925.flatbot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;

class DriveTrainSide {
	private final CANTalon motorA;
	private final CANTalon motorB;

	DriveTrainSide(CANTalon motorA, CANTalon motorB) {
		this.motorA = motorA;
		this.motorB = motorB;
	}
	
	public void setMotorSpeeds(double speed) {
		motorA.set(speed);
		motorB.set(speed);
	}
	
	public void resetEncoder() {
		// no encoders yet
	}
	
	public double getPosition() {
		return 0;
//		return motorA.getPosition();
	}

	public double getVelocity() {
		return 0;
//		return motorA.getSpeed();
	}
	
}
