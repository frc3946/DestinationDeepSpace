/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.IntakeStop;

/**
 * Add your docs here.
 */
public class IntakeSub extends Subsystem {
  Spark intakeLeft = new Spark (RobotMap.intakeLeft);
  Spark intakeRight = new Spark (RobotMap.intakeRight);
  Solenoid solenoidOne = new Solenoid (RobotMap.solenoidOne);
  Solenoid solenoidTwo = new Solenoid (RobotMap.solenoidTwo);
  Solenoid rampSolenoid = new Solenoid (RobotMap.rampSolenoid);

  public void intakeIn() {
    intakeLeft.setSpeed(0.4);
    intakeRight.setSpeed(-0.4);
  }
  public void intakeOut() {
    intakeLeft.setSpeed(1);
    intakeRight.setSpeed(-1);
  }
  public void intakeStop() {
    intakeLeft.setSpeed(0);
    intakeRight.setSpeed(0);
  }
  public void raise1() {
    solenoidOne.set(true);
  }
  public void raise2() {
    solenoidTwo.set (true);
  }
  public void lower1() {
    solenoidOne.set (false);
  }
  public void lower2() {
    solenoidTwo.set(false);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakeStop());
  }
}
