package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoToAngleElbow extends CommandBase{

	double ang;
	public GoToAngleElbow(double angle)
	{
		ang = angle;
		requires(arm);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		arm.setSetpoint(ang);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		
		//SmartDashboard.putBoolean("Elbow finished", arm.onTarget());
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
