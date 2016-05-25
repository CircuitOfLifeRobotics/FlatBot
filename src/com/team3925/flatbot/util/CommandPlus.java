package com.team3925.flatbot.util;

import com.team3925.flatbot.OI;
import com.team3925.flatbot.Robot;
import com.team3925.flatbot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Stores pointer to subsystems in advanced and calls end() in interrupted();
 */
public abstract class CommandPlus extends Command {
	protected final DriveTrain drivetrain = Robot.drivetrain;
	protected final OI oi = Robot.oi;
	
	protected CommandPlus(String name) {
		super(name);
	}
	
	protected CommandPlus(String name, double timeout) {
		super(name, timeout);
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
