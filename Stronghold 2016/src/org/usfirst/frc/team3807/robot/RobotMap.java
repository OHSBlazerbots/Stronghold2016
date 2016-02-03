package org.usfirst.frc.team3807.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	//IDs for the chassis wheels, CAN
	public static int FRONT_LEFT = 8;
	public static int FRONT_RIGHT = 4;
	public static int BACK_LEFT = 7;
	public static int BACK_RIGHT = 5;
	
	//IDs for the arm motors
	public static int ARM_MOTOR_SHORT = 2;
	public static int ARM_MOTOR_LONG = 3; 
	
	//IDs for the joysticks
	public static int CODRIVER_JOYSTICK_PORT = 1;
	public static int CODRIVER_JOYSTICK_PORT2= 2; 
	public static int JOYSTICK_PORT = 0;
	
	//DIO ports 
	public static int INNER_ENCODER_A= 0;
	public static int INNER_ENCODER_B= 1;
	public static int OUTER_ENCODER_A= 2;
	public static int OUTER_ENCODER_B = 3;
}
