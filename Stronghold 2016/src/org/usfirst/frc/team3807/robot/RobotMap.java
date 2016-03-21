package org.usfirst.frc.team3807.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

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
	public static int WRIST_MOTOR = 2; //outside
	//public static int ELBOW_MOTOR = 3;  //inside
	public static int POT_MOTOR = 3; 
	
	//IDs for the joysticks
	public static int XBOX_CONTROLLER = 1; 
	public static int CODRIVER_JOYSTICK_PORT = 2;
	public static int CODRIVER_JOYSTICK_PORT2= 3; 
	public static int JOYSTICK_PORT = 0;
	
	//DIO ports 
	public static int ELBOW_ENCODER_A= -1;
	public static int ELBOW_ENCODER_B= -1;
	public static int WRIST_ENCODER_A= 2;
	public static int WRIST_ENCODER_B = 3;
	
	public static int ARM_ENCODER_A = 0; //new elbow
	public static int ARM_ENCODER_B = 1;
	public static Encoder armEncoder = new Encoder(ARM_ENCODER_A, ARM_ENCODER_B);
	
	public static int HALL_EFFECT = 4;
	public static DigitalInput HE = new DigitalInput(HALL_EFFECT);
	
	//arm talons
	//public static CANTalon ARM_ELBOW = new CANTalon(ELBOW_MOTOR);
	public static CANTalon ARM_WRIST = new CANTalon(WRIST_MOTOR);
	
	public static CANTalon ARM_POT = new CANTalon(POT_MOTOR);
	
	//chassis talons
	public static CANTalon FRONT_LEFT_TALON = new CANTalon(FRONT_LEFT);
	public static CANTalon FRONT_RIGHT_TALON = new CANTalon(FRONT_RIGHT);
	public static CANTalon BACK_LEFT_TALON = new CANTalon(BACK_LEFT);
	public static CANTalon BACK_RIGHT_TALON = new CANTalon(BACK_RIGHT);
	
}
