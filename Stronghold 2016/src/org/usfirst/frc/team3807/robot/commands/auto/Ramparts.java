package org.usfirst.frc.team3807.robot.commands.auto;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.Drive;
import org.usfirst.frc.team3807.robot.commands.HaltRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Ramparts extends CommandGroup {
	public Ramparts()
	{
		addSequential(new Drive(1, 0));
		addSequential(new WaitCommand(RobotValues.DRIVE_FORWARD_RAMPARTS));
		addSequential(new HaltRobot());
	}

}
