package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;
import org.usfirst.frc.team3807.robot.RobotMap;
import org.usfirst.frc.team3807.robot.subsystems.Arm;
import org.usfirst.frc.team3807.robot.subsystems.Chassis;
import org.usfirst.frc.team3807.robot.subsystems.SensorBase;

import edu.wpi.first.wpilibj.command.Command;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    
    public static Chassis chassis;
    public static SensorBase  sensorBase;
    //public static Arm arm;
    public static OI oi;

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        
        chassis = new Chassis(RobotMap.FRONT_LEFT, RobotMap.FRONT_RIGHT, RobotMap.BACK_LEFT, RobotMap.BACK_RIGHT);
        sensorBase = new SensorBase();
       // arm = new Arm(RobotMap.ARM_MOTOR_LONG, RobotMap.ARM_MOTOR_SHORT);
        //OI always instantiated LAST
        oi = new OI();

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
