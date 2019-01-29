/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.Lower1;
import frc.robot.commands.Lower2;
import frc.robot.commands.Raise1;
import frc.robot.commands.Raise2;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  XboxController xboxControl = new XboxController(RobotMap.xboxControl);
  Button intakeIn = new JoystickButton(xboxControl, 1);
  Button intakeOut = new JoystickButton(xboxControl, 2);
  Button raise1 = new JoystickButton(xboxControl, 3);
  Button raise2 = new JoystickButton(xboxControl, 4);
  Button lower1 = new JoystickButton(xboxControl, 5);
  Button lower2 = new JoystickButton(xboxControl, 6);
  public OI() {
    intakeIn.whileHeld(new IntakeIn());
    intakeOut.whileHeld(new IntakeOut());
    raise1.whenPressed(new Raise1());
    raise2.whenPressed(new Raise2());
    lower1.whenPressed(new Lower1());
    lower2.whenPressed(new Lower2());
  }
}