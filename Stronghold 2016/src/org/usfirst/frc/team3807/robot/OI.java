package org.usfirst.frc.team3807.robot;

import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.DriveArmWithJoystick;
import org.usfirst.frc.team3807.robot.commands.ElbowMinus;
import org.usfirst.frc.team3807.robot.commands.ElbowPlus;
import org.usfirst.frc.team3807.robot.commands.GoToAngleElbow;
import org.usfirst.frc.team3807.robot.commands.MoveArm;
import org.usfirst.frc.team3807.robot.commands.RunArmWhenPressed;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    /**
     *
     */
	//driver joystick
	private static Joystick joystick = new Joystick(RobotMap.JOYSTICK_PORT);
	private static Joystick coDriver1 = new Joystick(RobotMap.CODRIVER_JOYSTICK_PORT);
	private static Joystick coDriver2 = new Joystick(RobotMap.CODRIVER_JOYSTICK_PORT2);
	private static Joystick xBoxCoDriver = new Joystick(RobotMap.XBOX_CONTROLLER);
	private final JoystickButton armMotor,goToAngle90, driveArm, angleCheval, portcullis1, zero, portcullis2, zeroZero, upFive, downFive;
	
	
	public OI() {
		//armMotor used to test the motor encoder
		armMotor = new JoystickButton(joystick, 11);
		//armMotor.whileHeld(new RunArmWhenPressed(.25));
		//armMotor.whenReleased(new RunArmWhenPressed(0));
		
		//OLD ARM
		//drives the arm when button 1 is held
		driveArm = new JoystickButton(coDriver1, 1);
		driveArm.whileHeld(new DriveArmWithJoystick());
		
		//when you hit button 10 on JoyStick 2, both the wrist arm and elbow arm go to 90 degrees by PID
		goToAngle90 = new JoystickButton(coDriver2, 10);
		goToAngle90.whenPressed(new MoveArm(90,-90));
		
		//when you hit button 9 on JoyStick 2, the wrist arm moves to 200 degrees by PID
		angleCheval = new JoystickButton(coDriver2, 9);
		angleCheval.whenPressed(new MoveArm(0, 200));
		
		//when you hit button 7 on JoyStick 2, the wrist arm moves to 250 degrees by PID
		portcullis1 = new JoystickButton(coDriver2, 7);
		portcullis1.whenPressed(new MoveArm(0, 250));
		
		//when you hit the button 8 on JoyStick 2, the eblow arm moves to 90 degrees and wrist arm goes to 270 degrees
		portcullis2 = new JoystickButton(coDriver2, 8);
		portcullis2.whenPressed(new MoveArm(90, 270));
		
		//when you hit the button 6 on JoyStick 2,  
		zero = new JoystickButton(coDriver2, 6);
		zero.whenPressed(new MoveArm(40, 10));
		
		//sets the elbow arm to 10 degrees relative to the ground (0 degrees relative to the start)
		zeroZero = new JoystickButton(coDriver2, 11);
		zeroZero.whenPressed(new MoveArm(10,-5));
		
		upFive = new JoystickButton(coDriver1, 3);
		upFive.whenReleased(new ElbowPlus());
	
		downFive = new JoystickButton(coDriver1, 2);
		downFive.whenReleased(new ElbowMinus());
	
    }
	
	//returns the driver joystick
	public static Joystick getJoystick()
	{
		return joystick;
	}
	//returns the codriver joystick
	public static Joystick getCoDriverJoystick1()
	{
		return coDriver1;
	}
	//
	public static Joystick getCoDriverJoystick2()
	{
		return coDriver2;
	}
	
	public static Joystick getXBoxController()
	{
		return xBoxCoDriver;
	}
}
