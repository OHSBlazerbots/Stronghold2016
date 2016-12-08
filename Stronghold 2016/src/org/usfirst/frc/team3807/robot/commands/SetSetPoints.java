package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SetSetPoints extends CommandBase {

	public SetSetPoints()
	{
		requires(arm);
		requires(PIDWrist);
	}
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		//arm.setSetpoint(SmartDashboard.getInt("Manual Arm Elbow"));
		PIDWrist.setSetpoint(SmartDashboard.getInt("Manual Wrist Angle"));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
