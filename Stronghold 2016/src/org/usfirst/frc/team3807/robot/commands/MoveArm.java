package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class MoveArm extends CommandGroup {

	public MoveArm(int elbowAngle, int wristAngle)
	{
		addSequential(new GoToAngleElbow(elbowAngle));
		addSequential(new WaitCommand(1));
		addSequential(new GoToAngleWrist(wristAngle));
	}
}
