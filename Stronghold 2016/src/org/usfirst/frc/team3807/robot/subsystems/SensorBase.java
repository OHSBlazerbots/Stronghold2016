package org.usfirst.frc.team3807.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorBase extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	BuiltInAccelerometer bia;
	
	public SensorBase()
	{
		bia = new BuiltInAccelerometer();
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
}

