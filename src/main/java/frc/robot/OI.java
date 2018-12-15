/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick leftStick = new Joystick(0);

  public OI() {
    Button[] left = new Button[12];
    for (int i = 1; i < left.length; i++) {
      left[i] = new JoystickButton(leftStick, i);
    }

   left[2].whenPressed(new DriveWithJoystick());
      
    left[4].whenPressed(new SetLeftMotor(-0.5));
  }
}
