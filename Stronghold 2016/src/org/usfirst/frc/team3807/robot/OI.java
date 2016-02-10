package org.usfirst.frc.team3807.robot;

import org.usfirst.frc.team3807.robot.commands.GoToAngle;
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
	private final JoystickButton armMotor,goToAngle90;
	
	public OI() {
		//armMotor used to test the motor encoder
		armMotor = new JoystickButton(joystick, 11);
		//armMotor.whileHeld(new RunArmWhenPressed(.25));
		//armMotor.whenReleased(new RunArmWhenPressed(0));
		
		goToAngle90 = new JoystickButton(joystick, 12);
		goToAngle90.whenPressed(new GoToAngle());
	
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
}
