package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Chassis extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	// RobotDrive robotDrive;
	CANTalon frontLeft, frontRight, backLeft, backRight;
	RobotDrive drive;

	public Chassis(int frontL, int frontR, int backL, int backR) {
		if (frontL != -1 && frontR != -1 && backL != -1 && backR != -1) {
			// robotDrive = new RobotDrive(frontL, backL, frontR, backR);
			frontLeft = new CANTalon(frontL);
			frontRight = new CANTalon(frontR);
			backLeft = new CANTalon(backL);
			backRight = new CANTalon(backR);
		}
		drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
	}

	
	public void drive(double speed, double turn) {
		drive.arcadeDrive(speed * .5, turn * .35);
	}

	//getting user input with joysticks
	public void driveWithJoystick(Joystick joystick) {
		double turn = joystick.getZ();
        //Drive is the y
        double move = joystick.getY();
        if (drive != null) {
            drive(-move * (((joystick.getThrottle() + 1) * .5) + 1), -turn);
        }
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
	}

	public void Halt()
	{
		frontLeft.set(0);
		frontRight.set(0);
		backLeft.set(0);
		backRight.set(0);
	}
}
