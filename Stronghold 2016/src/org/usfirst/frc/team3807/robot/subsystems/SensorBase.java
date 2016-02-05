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

	BuiltInAccelerometer bia;
	PowerDistributionPanel pdp;
	Encoder innerEncoder, outerEncoder;
	double innerAngle, outerAngle;
	
	public SensorBase()
	{
		bia = new BuiltInAccelerometer();
		pdp = new PowerDistributionPanel();
		
		//creates encoder
		if(RobotMap.INNER_ENCODER_A != -1 && RobotMap.INNER_ENCODER_B != -1 &&
				RobotMap.OUTER_ENCODER_A != -1 && RobotMap.OUTER_ENCODER_B != -1){
		innerEncoder = new Encoder(RobotMap.INNER_ENCODER_A,RobotMap.INNER_ENCODER_B);
		outerEncoder = new Encoder(RobotMap.OUTER_ENCODER_A,RobotMap.OUTER_ENCODER_B);
		innerAngle = innerEncoder.get();
		outerAngle = outerEncoder.get();
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
    
//    //returns pdp current
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
    
    //"elbow" angle
    public double getInnerEncoderVal()
    {
    	if(innerEncoder == null)
    		return 0; 
    	return innerEncoder.get();
    }
    
    //"wrist" angle
    public double getOuterEncoderVal()
    {
    	if(outerEncoder == null)
    		return 0;
    	return outerEncoder.get();
    }
    
    
     //Must be in radians!!!! (*(PI/180))
    public double getInnerAngle()
    {
    	return ((2*Math.PI)/497) * getInnerEncoderVal();
    }
    
    //returns the outer angle in radians
    public double getOuterAngle()
    {
    	return ((2*Math.PI)/497) * getInnerEncoderVal();
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
    	
    	SmartDashboard.putDouble("Inner Encoder", getInnerEncoderVal());
    	SmartDashboard.putDouble("Inner Angle (elbow)", getInnerAngle());
    	SmartDashboard.putDouble("Outer Angle (wrist)", getOuterAngle());
    }
}

