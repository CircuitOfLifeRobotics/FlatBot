package com.team3925.flatbot;

import com.team3925.flatbot.commands.ManualDrive;
import com.team3925.flatbot.subsystems.DriveTrain;
import com.team3925.flatbot.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {
	
	public static DriveTrain drivetrain;
	public static OI oi;
    
	public void robotInit() {
		RobotMap.init();
		drivetrain = new DriveTrain(RobotMap.drivetrain);
		
		oi = new OI();
		XboxHelper.config(oi.xbox);
	}
	
    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
    }

    public void teleopPeriodic() {
    	
    }
    
    public void testPeriodic() {
    
    }
    
}
