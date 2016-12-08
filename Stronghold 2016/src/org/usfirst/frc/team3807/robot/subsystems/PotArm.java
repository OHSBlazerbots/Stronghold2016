package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.RobotMap;
import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.DriveArmWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//Pot arm is the arm that uses the potentiometer 
/**
 * Controls the arm using values from the potentiometer and PID, then returns them to SmartDashboard.
 * @author blazerbots
 *
 */
public class PotArm extends PIDSubsystem {

	CANTalon armTalon = RobotMap.ARM_POT;
	//Encoder encoder = RobotMap.armEncoder;
	//Contructs POTArm for robot
	public PotArm(double p, double i, double d) {
		super(p, i, d);
		// TODO Auto-generated constructor stub
		this.setOutputRange(-0.75, 0.75);
//		this.setSetpoint(CommandBase.sensorBase.getElbowAngle());
		//armTalon.setFeedbackDevice(FeedbackDevice.AnalogPot);
		 //Puts analog value of the String Potentiometer onto SmartDashboard for testing(FOR NOW... DUN DUN DUUUUN!)
	}
	
	@Override
	public void setSetpoint(double point){
		if(point > 9.5 && point < 95){
			super.setSetpoint(point);
		}
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveArmWithJoystick());
	}

	
	//Returns PID inputs
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		SmartDashboard.putDouble("String Potentiometer", armTalon.getAnalogInRaw() );
		SmartDashboard.putDouble("Pot Arm Angle", CommandBase.sensorBase.getElbowAngle());
		return CommandBase.sensorBase.getElbowAngle();
	}

	//Uses PID Outputs at the given values
	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		SmartDashboard.putDouble("Pot PID Output", output);
		armTalon.set(-output);
	}
	
	
	//Returns the Angle
//	public double calcAngle(double encoderVal)
//	{
//		//1023 ticks is 360 degrees
//		//We are given number of ticks
//		return (encoderVal)*(360/2048);
//		
//	}
	
	public void driveWithJoystick(Joystick joystick)
	{
//		double speed = joystick.getY();
//		if(speed > 0 && !RobotMap.HE.get())
//		{
//			armTalon.set(0);
//		}
//		else
//			armTalon.set(speed);
//		
	}
}
