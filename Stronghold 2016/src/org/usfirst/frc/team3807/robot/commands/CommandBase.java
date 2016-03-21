package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;
import org.usfirst.frc.team3807.robot.RobotMap;
import org.usfirst.frc.team3807.robot.subsystems.Chassis;
//import org.usfirst.frc.team3807.robot.subsystems.PIDArmElbow;
import org.usfirst.frc.team3807.robot.subsystems.PIDArmWrist;
import org.usfirst.frc.team3807.robot.subsystems.PotArm;
//import org.usfirst.frc.team3807.robot.subsystems.PotArm;
import org.usfirst.frc.team3807.robot.subsystems.SensorBase;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    
    //OLD ARM
    //public static PIDArmElbow PIDElbow;
    public static PIDArmWrist PIDWrist;
    
    //NEW ARM
    public static PotArm arm;
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        
        chassis = new Chassis(RobotMap.FRONT_LEFT, RobotMap.FRONT_RIGHT, RobotMap.BACK_LEFT, RobotMap.BACK_RIGHT);
        sensorBase = new SensorBase();
        
        //NEW ARM
        arm = new PotArm(0.065, 0, 0.001);
        arm.enable();
        arm.setSetpoint(CommandBase.sensorBase.getElbowAngle());
        SmartDashboard.putInt("Manual Arm Elbow", 0);
        
        //arm = new Arm(RobotMap.ELBOW_MOTOR, RobotMap.WRIST_MOTOR);
       
        //OLD ARM
        //DONT FORGET TO .enable() ANY SUBSYSTEM WITH PID!!!!!!!!!!!!!!!!!!
//        PIDElbow = new PIDArmElbow(.055, 0, 0);
//        PIDElbow.enable();
//        PIDElbow.setAbsoluteTolerance(4);


        PIDWrist = new PIDArmWrist(.05, .001, 0);
        PIDWrist.enable();
        PIDWrist.setAbsoluteTolerance(.5);
        SmartDashboard.putInt("Manual Wrist Angle", 0);
        
        
        //OI always instantiated LAST!!!
        oi = new OI();

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
