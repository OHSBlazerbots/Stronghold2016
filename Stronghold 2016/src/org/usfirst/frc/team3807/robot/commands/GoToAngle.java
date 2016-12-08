package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.commands.CommandBase;

public class GoToAngle extends CommandBase {

	double angle;
	
	public GoToAngle(double a)
	{
		requires(CommandBase.arm);
		angle = a;
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		arm.setSetpoint(angle);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
