package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoToAngleWrist extends CommandBase {
	
	int position;
	
	public GoToAngleWrist(int val)
	{
		position = val;
		requires(PIDWrist);
		
	}
	
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		//arm.goToAngle(Math.PI/2, arm.getWristTalon());
		PIDWrist.setSetpoint(position);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//return Math.abs(CommandBase.PIDElbow.getSetpoint()-CommandBase.PIDElbow.getPosition()) < 0.1;
		
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
