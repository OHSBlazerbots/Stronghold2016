package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;

/**
 *
 */
public class DriveWithJoystick extends CommandBase {

    public DriveWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(chassis);
        requires(sensorBase);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	chassis.driveWithJoystick(OI.getJoystick());
    	sensorBase.printCurrents();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
