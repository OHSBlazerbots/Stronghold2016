package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.OI;
import org.usfirst.frc.team3807.robot.RobotMap;
import org.usfirst.frc.team3807.robot.commands.CommandBase;
import org.usfirst.frc.team3807.robot.commands.DriveArmWithJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*import edu.wpi.first.identifiers.Input;
import edu.wpi.first.identifiers.Output;*/


public class PIDArmWrist extends PIDSubsystem {

	/*private static final double deafaultLoopTime = 0.02;
	private final double input=CommandBase.sensorBase.getInnerEncoderVal();;
	private final double output=CommandBase.sensorBase.getOuterEncoderVal();
	private double minimumInput = Double.MIN_VALUE, maximumInput = Double.MAX_VALUE;
    private double minimumOutput = -1, maximumOutput = +1;
    private double totalError = 0;
    private double prevError = 0;
    private double prevResult = 0;
    private double tolerance = 0;
    private final Object lock = new Object();
    
	private double setpoint= 0.0;
	private double I;
	private double D;
	private double P;
	*/
	
	CANTalon talon = RobotMap.ARM_WRIST;
	Encoder encoder = CommandBase.sensorBase.getWristEncoder();
	
	public PIDArmWrist(double p, double i, double d) {
		super("Wrist", p, i, d);
		// TODO Auto-generated constructor stub
		//talon.set(0);
		
	}
	
	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		encoder.setPIDSourceType(PIDSourceType.kDisplacement);
		//SmartDashboard.putDouble("Wrist SetPoint", this.getSetpoint());
		return -CommandBase.sensorBase.getWristDegrees();
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		talon.pidWrite(output);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		//setDefaultCommand(new DriveArmWithJoystick());
	}
	
	public void driveWithJoystick(Joystick j)
	{
		double speed = j.getY();
		
		if(onTarget())
		this.setSetpoint(this.getPosition() + 2*speed);
	}
	
	public Encoder getEncoder()
	{
		return encoder;
	}

}
