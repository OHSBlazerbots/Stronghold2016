package org.usfirst.frc.team3807.robot;

import org.usfirst.frc.team3807.robot.commands.DriveArmWithJoystick;
import org.usfirst.frc.team3807.robot.commands.GoToAngleWrist;
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
	private final JoystickButton armMotor,goToAngle90, driveArm, angleCheval, portcullis1, zero, portcullis2, zeroZero;
	
	public OI() {
		//armMotor used to test the motor encoder
		armMotor = new JoystickButton(joystick, 11);
		//armMotor.whileHeld(new RunArmWhenPressed(.25));
		//armMotor.whenReleased(new RunArmWhenPressed(0));
		
		driveArm = new JoystickButton(coDriver1, 1);
		driveArm.whileHeld(new DriveArmWithJoystick());
		
		goToAngle90 = new JoystickButton(coDriver2, 10);
		goToAngle90.whenPressed(new MoveArm(90,90));
		
		angleCheval = new JoystickButton(coDriver2, 9);
		angleCheval.whenPressed(new MoveArm(0, 200));
		
		portcullis1 = new JoystickButton(coDriver2, 7);
		portcullis1.whenPressed(new MoveArm(0, 250));
		
		portcullis2 = new JoystickButton(coDriver2, 8);
		portcullis2.whenPressed(new MoveArm(90, 270));
		
		zero = new JoystickButton(coDriver2, 6);
		zero.whenPressed(new MoveArm(5, 10));
		
		zeroZero = new JoystickButton(coDriver2, 11);
		zeroZero.whenPressed(new MoveArm(10,0));
	
    }
	
	//returns the driver joystick
	public static Joystick getJoystick()
	{
		return joystick;
	}
	
	public static Joystick getCoDriverJoystick1()
	{
		return coDriver1;
	}
	
	public static Joystick getCoDriverJoystick2()
	{
		return coDriver2;
	}
	
	public static Joystick getXBoxController()
	{
		return xBoxCoDriver;
	}
}
