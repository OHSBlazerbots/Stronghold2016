/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team3807.robot;

import org.usfirst.frc.team3807.robot.commands.Auto;
import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.auto.Cheval;
import org.usfirst.frc.team3807.robot.commands.auto.Drawbridge;
import org.usfirst.frc.team3807.robot.commands.auto.DrawbridgeEasy;
import org.usfirst.frc.team3807.robot.commands.auto.LowBar;
import org.usfirst.frc.team3807.robot.commands.auto.Moat;
import org.usfirst.frc.team3807.robot.commands.auto.Portcullis;
import org.usfirst.frc.team3807.robot.commands.auto.Ramparts;
import org.usfirst.frc.team3807.robot.commands.auto.RockWall;
import org.usfirst.frc.team3807.robot.commands.auto.RoughTerrain;
import org.usfirst.frc.team3807.robot.commands.auto.SallyPort;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import edu.wpi.first.wpilibj.templates.commands.ExampleCommand;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Auto auto;

	Command autonomousCommand;
	SendableChooser autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		CommandBase.init();

		//auto = new Auto();

		// auto = new Auto();
		autoChooser = new SendableChooser();

		// add autoCommand options here:
		autoChooser.addDefault("Default", new Auto());

		// autoChooser.addObject(name, object);
		autoChooser.addObject("Low Bar", new LowBar());
		autoChooser.addObject("Rough Terrain", new RoughTerrain());

		// not done yet...
		 autoChooser.addObject("Cheval", new Cheval());
		 autoChooser.addObject("Drawbridge", new Drawbridge());
		 autoChooser.addObject("Moat", new Moat());
		 autoChooser.addObject("Portcullis", new Portcullis());
		 autoChooser.addObject("Ramparts", new Ramparts());
		 autoChooser.addObject("Rock Wall", new RockWall());
		 autoChooser.addObject("Sally Port", new SallyPort());
		 autoChooser.addObject("Drawbridge Easy", new DrawbridgeEasy());

		// puts choices to SmartDashboard
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		//
		CameraServer cams = CameraServer.getInstance();
		// set any cam parameters, then start capture
		//cams.startAutomaticCapture("cam0");
		
		//cams.startAutomaticCapture();
		cams.setQuality(50);
		cams.startAutomaticCapture("cam4");
		
		//CameraServer.getInstance().startAutomaticCapture();
	}

	public void autonomousInit() {
		// sets up the chooser on SmartDashboard
		autonomousCommand = (Command) autoChooser.getSelected();
		//autonomousCommand.start();
		Scheduler.getInstance().add(autonomousCommand);
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		//Scheduler.getInstance().add(autonomousCommand);
		Scheduler.getInstance().run();
	}

	public void cancelAuto() {
		autonomousCommand.cancel();
	}

	public void teleopInit() {
		SmartDashboard.putDouble("Manual Pot Elbow Angle", 45.0);
		CommandBase.chassis.drive.setSafetyEnabled(true);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
