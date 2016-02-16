package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.RobotMap;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SensorBase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private BuiltInAccelerometer bia;
	private PowerDistributionPanel pdp;
	private Encoder elbowEncoder, wristEncoder;
	double elbowAngle, wristAngle;
	
	public SensorBase()
	{
		bia = new BuiltInAccelerometer();
		pdp = new PowerDistributionPanel();
		
		//creates encoder
		if(RobotMap.ELBOW_ENCODER_A != -1 && RobotMap.ELBOW_ENCODER_B != -1 &&
				RobotMap.WRIST_ENCODER_A != -1 && RobotMap.WRIST_ENCODER_B != -1)
		{
			elbowEncoder = new Encoder(RobotMap.ELBOW_ENCODER_A,RobotMap.ELBOW_ENCODER_B);
			wristEncoder = new Encoder(RobotMap.WRIST_ENCODER_A,RobotMap.WRIST_ENCODER_B);
			elbowAngle = elbowEncoder.get();
			wristAngle = wristEncoder.get();
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
    //returns the acceleration of the RoboRIO along the x axis in g-forces
    public double getAccelerometerX()
    {
    	return bia.getX();
    }
    
  //returns the acceleration of the RoboRIO along the Y axis in g-forces
    public double getAccelerometerY()
    {
    	return bia.getY();
    }
    
  //returns the acceleration of the RoboRIO along the z axis in g-forces
    public double getAccelerometerZ()
    {
    	return bia.getZ();
    }
    
/*//    //returns pdp current
//    public double getTotalPDPCurrent()
//    {
//    	return pdp.getTotalCurrent();
//    }
//
//    //returns specific channels
//    public double getMotorCurrentRightFront()
//    {
//    	return pdp.getCurrent(13);
//    }
//    
//     public double getMotorCurrentLeftFront()
//     {
//    	 return pdp.getCurrent(0);
//     }
//     
//    public double getMotorCurrentRightBack()
//    {
//    	return pdp.getCurrent(12);
//    }
//    
//    public double getMotorCurrentLeftBack()
//    {
//    	return pdp.getCurrent(2);
//    }
*/    
   
    public Encoder getElbowEncoder()
    {
    	return elbowEncoder;
    }
    
    public Encoder getWristEncoder()
    {
    	return wristEncoder;
    }
    
    //"elbow" angle
    public double getElbowEncoderVal()
    {
    	if(elbowEncoder == null)
    		return 0; 
    	return -elbowEncoder.get();
    }
    
    //"wrist" angle
    public double getWristEncoderVal()
    {
    	if(wristEncoder == null)
    		return 0;
    	return -wristEncoder.get();
    }
    
     //Must be in radians!!!! (*(PI/180))
    public double getElbowAngle()
    {
    	return ((2*Math.PI)/497) * getElbowEncoderVal();
    }
    
    //returns the outer angle in radians
    public double getWristAngle()
    {
    	return ((2*Math.PI)/497) * getWristEncoderVal();
    }
    
    public double getElbowDegrees()
    {
    	return getElbowAngle() * (180/Math.PI);
    }
    
    public double getWristDegrees()
    {
    	return getWristAngle() * (180/Math.PI);
    }
    
  //checks to see if the arm goes outside of the 15" limit
  	public boolean perimeterChecker(){
  		
  		double angleElbow = getElbowAngle();
  		double angleWrist = getWristAngle();
  		
  		//if greater than 120 degrees
  		if(angleElbow >= (2*Math.PI/3))
  			return true;
  		//if outside of perimeter (See math notes)
  		else if(30*Math.sin(angleElbow-(Math.PI/2)) + (15*Math.cos(angleElbow-angleWrist)) > 15)
  			return true;
  		
  		return false;
  	}
    
    //prints the current values on SmartDashboard
    public void printCurrents()
    {
    	//used to print the currents on the PDB...not working :(
    	//    	System.out.print(" total Current: " + this.getTotalPDPCurrent());
//    	System.out.print(" Motor Right Front Current: " + this.getMotorCurrentRightFront());
//    	System.out.print(" Motor Left Front Current: " + this.getMotorCurrentLeftFront());
//    	System.out.print(" Motor Right Back Current: " + this.getMotorCurrentRightBack());
//    	System.out.print(" Motor Left Back Current: " + this.getMotorCurrentLeftBack());
//   
//    	SmartDashboard.putDouble("Total Current", getTotalPDPCurrent());
//    	SmartDashboard.putDouble("Motor Right Front Current", getMotorCurrentRightFront());
//    	SmartDashboard.putDouble("Motor Left Front Current", getMotorCurrentLeftFront());
//    	SmartDashboard.putDouble("Motor Right Back Current", getMotorCurrentRightBack());
//    	SmartDashboard.putDouble("Motor Left Back Current", getMotorCurrentLeftBack());
    	
    	SmartDashboard.putDouble("Elbow Encoder", getElbowEncoderVal());
    	SmartDashboard.putDouble("Wrist Encoder", getWristEncoderVal());
    	SmartDashboard.putDouble("Elbow Angle", getElbowDegrees());
    	SmartDashboard.putDouble("Wrist Angle", getWristDegrees());
    	SmartDashboard.putBoolean("Outside 15?", perimeterChecker());
    }
    
    
}

