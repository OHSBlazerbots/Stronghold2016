package org.usfirst.frc.team3807.robot.commands.auto;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.Drive;
import org.usfirst.frc.team3807.robot.commands.HaltRobot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RoughTerrain extends CommandGroup {

	public RoughTerrain(){
		
	addSequential(new Drive(.75, 0));
	addSequential(new WaitCommand(RobotValues.DRIVE_FORWARD_ROUGH_TERRAIN));
	addSequential(new HaltRobot());
	}
}
