/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private final WPI_TalonSRX leftDrive1 = new WPI_TalonSRX(RobotMap.leftDrive);
  private final WPI_TalonSRX rightDrive1 = new WPI_TalonSRX(RobotMap.rightDrive);

  public DriveTrain(){
    leftDrive1.setNeutralMode(NeutralMode.Brake);
  }
/**
 * Runs the left motor at specified percentage
 * @param percent -1.0 to +1.0
 */
  public void setLeftMotor(double percent){
    if(percent > 1.0) percent = 1.0;
    if (percent <- 1.0) percent = -1.0;
    leftDrive1.set(ControlMode.PercentOutput, percent);
  }
  
  public void setRightMotor(double percent){
    if(percent > 1.0) percent = 1.0;
    if (percent <- 1.0) percent = -1.0;
    rightDrive1.set(ControlMode.PercentOutput, percent);
  }

  /**
   * stops all motors in the drivetrain (percent output to 0)
   */
  public void stopAllMotors(){
    leftDrive1.set(ControlMode.PercentOutput, 0.0);
    //stop any other motors here
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
