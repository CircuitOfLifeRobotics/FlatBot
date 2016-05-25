package com.team3925.flatbot;

import com.team3925.flatbot.auto.AutonomousManager;
import com.team3925.flatbot.subsystems.DriveTrain;
import com.team3925.flatbot.util.DriveTrainSignal;
import com.team3925.flatbot.util.Looper;
import com.team3925.flatbot.util.hidhelpers.XboxHelper;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static DriveTrain drivetrain;
	public static OI oi;

	private static AutonomousManager autoManager;

	private static Looper looperDriveTrain;

	
	public Robot() {
		RobotMap.initNavx();
	}

	public void robotInit() {
		// Do not reorder!
		RobotMap.init();
		drivetrain = new DriveTrain(RobotMap.drivetrainMotorLeftA, RobotMap.drivetrainMotorLeftB,
				RobotMap.drivetrainMotorRightA, RobotMap.drivetrainMotorRightB, RobotMap.navx);

		oi = new OI();
		XboxHelper.config(oi.xbox);

		autoManager = AutonomousManager.getInstance();
		looperDriveTrain = new Looper("DriveTrain", drivetrain, Constants.DRIVETRAIN_LOOP_TIME);
		// Order no longer important
	}


	public void autonomousInit() {
		startLoopers();
		autoManager.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void teleopInit() {
		startLoopers();
		autoManager.cancel();
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void disabledInit() {
		autoManager.cancel();
		
		looperDriveTrain.stop();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		drivetrain.setSetpoints(DriveTrainSignal.NEUTRAL);
	}

	@Override
	public void testInit() {
		startLoopers();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
	
	private void startLoopers() {
		looperDriveTrain.start();
	}

}
