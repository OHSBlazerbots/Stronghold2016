package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.DriveArmWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {
	
	//the arm is controlled by two talons
	//each of the motors has a built in motor encoder
	private CANTalon elbowArm;
	private CANTalon wristArm;
	
	//these variables calculate the angle based off of values from the motor encoder (see SensorBase)
	double angleElbow, angleWrist;
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//the default command is driving arm with two different axes
		setDefaultCommand(new DriveArmWithJoystick());
	}

	//constructor, two motor IDs required
	public Arm(int elbow, int wrist)
	{
		elbowArm = new CANTalon(elbow);
		angleElbow = CommandBase.sensorBase.getElbowEncoderVal();
		
		wristArm = new CANTalon(wrist);
		angleWrist = CommandBase.sensorBase.getWristEncoderVal();
	}
	
	//runs elbow motor at given speed
	public void runMotor(double speed)
	{
		elbowArm.set(speed);
	}
	
	//updates the ElbowAngle from sensorBase class
	public double updateElbowAngle()
	{
		return CommandBase.sensorBase.getElbowAngle();
	}
	
	//updates the WristAngle from sensorBase class
	public double updateWristAngle()
	{
		return CommandBase.sensorBase.getWristAngle();
	}
	
	/*//checks to see if the arm goes outside of the 15" limit

	 * the same method is in commandBase
	private boolean perimeterChecker(){
		
		//updates the angles continuously *hopefully*
		updateInnerAngle();
		updateOuterAngle();
		
		if(angleInner <= Math.PI/2)
			return false;
		//if greater than 120 degrees
		if(angleInner >= (2*Math.PI/3))
			return true;
		//if outside of perimeter (See math notes)
		else if(30*Math.sin(angleInner-(Math.PI/2)) + (15*Math.cos(angleInner-angleOuter)) > 15)
			return true;
		
		return false;
	}
	*/

	//tests the speed of elbow, if less than constant implements PID to stay in same spot
	public boolean testSpeedElbow()
		{
			return Math.abs(speedElbow) < RobotValues.MIN_SPEED_ARM;
		}
		
	//tests the speed of wrist, if less than constant implements PID to stay in same spot
	public boolean testSpeedWrist()
	{
		return Math.abs(speedWrist) < RobotValues.MIN_SPEED_ARM;
	}
	
	//doesn't really work...needs testing
		public void goToAngle(double angle, CANTalon c){
			int speed=1;
			updateWristAngle();
			updateElbowAngle();
			
			while(updateWristAngle()<=angle){
				c.set(speed);
				if(updateWristAngle()==angle){
					speed=0;
					c.set(speed);

				}
			}
			
			while(updateWristAngle()>= angle)
			{
				c.set(-speed);
				if(updateWristAngle()==angle)
				{
					speed = 0;
					c.set(speed);
				}
			}
		
		}
	
	//returns the talon used for the wrist
	public CANTalon getWristTalon()
	{
		return wristArm;
	}
		
	//returns thte talon used for the elbow
	public CANTalon getElbowTalon()
	{
		return elbowArm;
	}
		
	//runs the innerArm with the given joystick 
	private double speedElbow;
	public void driveElbowWithJoystick(Joystick joystick)
	{
		//uses the y axis
		speedElbow = joystick.getY();
		
		updateElbowAngle();
		updateWristAngle();
		
		//checks the perimeter
		if(CommandBase.sensorBase.perimeterChecker() && speedElbow >0)
			speedElbow = 0; 
		
		
		elbowArm.set(speedElbow);
		SmartDashboard.putDouble("Elbow Speed", speedElbow);
	}
	
	//same as above method, but for XBOX controller
	public void driveElbowWithJoystick(Joystick joystick, GenericHID.Hand hand)
	{
		speedElbow = -joystick.getY(hand);
		
		updateElbowAngle();
		updateWristAngle();
		
		//checks the perimeter
		if(CommandBase.sensorBase.perimeterChecker() && speedElbow >0)
			speedElbow = 0; 
		
		
		elbowArm.set(speedElbow);
		SmartDashboard.putDouble("Elbow Speed", speedElbow);
	}
	
	//drives the outer arm with given joystick
	private double speedWrist;
	public void driveWristWithJoystick(Joystick joystick)
	{
		//gets value from the y axis
		speedWrist = joystick.getY();
		
		updateElbowAngle();
		updateWristAngle();
	
		//checks to see if the arm is outside the perimeter
		if(CommandBase.sensorBase.perimeterChecker() && speedWrist > 0)
		{
			//if so, sets speed to 0
			speedWrist = 0;	
		}

		wristArm.set(speedWrist);
		
		SmartDashboard.putDouble("Wrist Speed", speedWrist);
	}
	
	//same as above method, but for XBOX controller
	public void driveWristWithJoystick(Joystick joystick, GenericHID.Hand hand)
	{
		speedWrist = -joystick.getY(hand);
			
		updateElbowAngle();
		updateWristAngle();
			
		//checks the perimeter
		if(CommandBase.sensorBase.perimeterChecker() && speedWrist > 0)
			speedWrist = 0; 
			
			
		wristArm.set(speedElbow);
		SmartDashboard.putDouble("Wrist Speed", speedWrist);
	}
	
	//implements drive with joystick (both arms) into one method....see DriveArmWithJoystick command
	public void driveArmWithJoystick(Joystick elbow, Joystick wrist)
	{
		driveElbowWithJoystick(elbow);
		driveWristWithJoystick(wrist);
	}
	
	//same method as above, but for XBOX controller
	public void driveArmWithJoystick(Joystick joystick)
	{
		driveElbowWithJoystick(joystick,Hand.kRight);
		driveWristWithJoystick(joystick, Hand.kLeft);
	}

}
