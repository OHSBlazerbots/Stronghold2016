package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;
import org.usfirst.frc.team3807.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author blazerbots
 *
 */
public class DriveArmWithJoystick extends CommandBase {

  
	//requires(...) should always be in the constructor!!!
	public DriveArmWithJoystick()
   {
		//OLD ARM
	  // requires(PIDElbow);
	   requires(PIDWrist);
	   requires(arm);
	   
		//NEW ARM
		//requires(arm);
	   
   }
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		//PIDElbow.driveWithJoystick(OI.getCoDriverJoystick1());
		//PIDWrist.driveWithJoystick(OI.getCoDriverJoystick2());
		
		//OLD ARM
		//PIDWrist.setSetpoint(-SmartDashboard.getInt("Manual Wrist Angle"));
		//PIDElbow.setSetpoint(SmartDashboard.getInt("Manual Elbow Angle"));
		
		//NEW ARM
		//arm.setSetpoint(SmartDashboard.getInt("Manual Angle"));
		
		//arm.driveWithJoystick(OI.getCoDriverJoystick1());
		
		//arm.setSetpoint(SmartDashboard.getInt("Manual Pot Elbow Angle"));
		
		//PIDWrist.driveWithJoystick(OI.getCoDriverJoystick2());
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
