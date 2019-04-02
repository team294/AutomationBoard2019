/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ExampleSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX motor = new WPI_TalonSRX(RobotMap.leftMotor);
  private SensorCollection encoders;

  private double encoderDegreesPerTicks = 360.0 / 4096.0;
  private double encoderTicksPerDegrees = 4096.0 / 360.0;

  public ExampleSubsystem() {
    motor.set(ControlMode.PercentOutput, 0);
    motor.setInverted(true);
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
    motor.configFeedbackNotContinuous(true, 0);
    motor.setSensorPhase(false);         // Flip sign of sensor reading
    motor.setNeutralMode(NeutralMode.Brake);
    motor.configVoltageCompSaturation(12.0);
    motor.enableVoltageCompensation(true);
    motor.clearStickyFaults();

    encoders = motor.getSensorCollection();
  }

  /**
   * 
   * @return raw encoder ticks, adjusted direction (positive is towards stowed, negative is towards lower hard stop)
   */
  public double getWristEncoderTicksRaw() {
    return motor.getSelectedSensorPosition(0);
  }

  /**
   * 
   * @param encoderTicks encoder ticks
   * @return parameter encoder ticks converted to equivalent degrees
   */
  public double encoderTicksToDegrees(double encoderTicks) {
    return encoderTicks * encoderDegreesPerTicks;
  }

  /**
   * 
   * @param degrees angle in degrees
   * @return parameter degrees converted to equivalent encoder ticks
   */
  public double degreesToEncoderTicks(double degrees) {
    return degrees * encoderTicksPerDegrees;
  }

  /**
   * 
   * @return current encoder ticks converted to degrees
   */
  public double getWristEncoderDegreesRaw() {
    return encoderTicksToDegrees(getWristEncoderTicksRaw());
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  public void periodic() {
      SmartDashboard.putNumber("Ticks Raw", getWristEncoderTicksRaw());
      SmartDashboard.putNumber("Degrees Raw", getWristEncoderDegreesRaw());
  }
}
