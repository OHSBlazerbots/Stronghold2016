//package org.usfirst.frc.team3807.robot.subsystems;
//
//import org.usfirst.frc.team3807.robot.OI;
//import org.usfirst.frc.team3807.robot.RobotMap;
//import org.usfirst.frc.team3807.robot.commands.CommandBase;
//import org.usfirst.frc.team3807.robot.commands.DriveArmWithJoystick;
//
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.PIDSourceType;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//
//public class PIDArmElbow extends PIDSubsystem {
//
//	CANTalon talon = RobotMap.ARM_ELBOW;
//	Encoder encoder = CommandBase.sensorBase.getElbowEncoder();
//
//	public PIDArmElbow(double p, double i, double d) {
//		super("Elbow", p, i, d);
//		// TODO Auto-generated constructor stub
//		this.setOutputRange(-1, 1);
//
//	}
//
//	@Override
//	protected double returnPIDInput() {
//		// TODO Auto-generated method stub
//		encoder.setPIDSourceType(PIDSourceType.kDisplacement);
//		SmartDashboard.putDouble("Elbow SetPoint", this.getSetpoint());
//		return -CommandBase.sensorBase.getElbowDegrees();
//	}
//
//	@Override
//	protected void usePIDOutput(double output) {
//		// TODO Auto-generated method stub
//		talon.set(output);
//		SmartDashboard.putDouble("PID output Elbow", output);
//
//	}
//
//	@Override
//	protected void initDefaultCommand() {
//		// TODO Auto-generated method stub
//		// setDefaultCommand(new DriveArmWithJoystick());
//	}
//
//	public void driveWithJoystick(Joystick j) {
//		double speed = j.getY();
//
//		if (onTarget()) {
//			this.setSetpoint(this.getPosition() + 2 * speed);
//		}
//
//	}
//
//}
