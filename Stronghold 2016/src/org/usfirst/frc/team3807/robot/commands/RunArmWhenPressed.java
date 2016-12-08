package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunArmWhenPressed extends CommandBase {

	double speed;
    public RunArmWhenPressed(double spd) {
        // Use requires() here to declare subsystem dependencies
    	speed = spd;
      //requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//arm.runMotor(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
