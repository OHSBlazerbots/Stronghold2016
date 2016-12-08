package org.usfirst.frc.team3807.robot.commands.auto;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.Drive;
import org.usfirst.frc.team3807.robot.commands.HaltRobot;
import org.usfirst.frc.team3807.robot.commands.MoveArm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Drawbridge extends CommandGroup {
	public Drawbridge()
	{
		//go to angle for elbow arm and wrist arm 
		addSequential(new Drive(-.5,0));
		addSequential(new WaitCommand(RobotValues.DRIVE_BACKWARDS_DRAWBRIDGE));
		//go to the proper angle to hold down the drawbridge
		addSequential(new HaltRobot());
		addSequential(new MoveArm(0, 90));
		addSequential(new MoveArm(0, 45));
		addSequential(new MoveArm(0, 90));
		addSequential(new Drive(0.5,0));
		addSequential(new WaitCommand(RobotValues.DRIVE_FORWARD_DRAWBRIDGE));
		addParallel(new MoveArm(0, 0));
		addSequential(new HaltRobot());
		
	}

}
