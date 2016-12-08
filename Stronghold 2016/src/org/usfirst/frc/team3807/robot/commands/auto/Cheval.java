package org.usfirst.frc.team3807.robot.commands.auto;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.Drive;
import org.usfirst.frc.team3807.robot.commands.GoToAngleWrist;
import org.usfirst.frc.team3807.robot.commands.HaltRobot;
import org.usfirst.frc.team3807.robot.commands.MoveArm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3807.robot.commands.CommandBase;

public class Cheval extends CommandGroup {
	public Cheval()
	{
		addSequential(new MoveArm(0,90));//new CommandBase.PIDWrist()
		//addSequential( have code that has the elbow arm down to 0 i think)
		addSequential(new Drive(.5, 0));
		addSequential(new WaitCommand(RobotValues.DRIVE_FORWARD_CHEVAL1));
		addSequential(new MoveArm(0, 45));
		addSequential(new WaitCommand(RobotValues.DRIVE_FORWARD_CHEVAL2));
		addSequential(new HaltRobot());
		
		//addSequential(new Drive(.5,0));
		//addSequential(new WaitCommand(RobotValues.DRIVE_FORWARD_LOW_BAR));
		//addSequential(new HaltRobot());
		
		//PIDWrist.setSetpoint(SmartDashboard.getInt("Manual Wrist Angle"));
	}

}
