/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  public static WPI_TalonSRX frontLeftTalon = new WPI_TalonSRX(RobotMap.frontLeftTalon);
  public static WPI_TalonSRX frontRightTalon = new WPI_TalonSRX(RobotMap.frontRightTalon);
  public static WPI_VictorSPX rearLeftVictor = new WPI_VictorSPX(RobotMap.rearLeftVictor);
  public static WPI_VictorSPX rearRightVictor = new WPI_VictorSPX(RobotMap.rearRightVictor);

  public static DifferentialDrive difDrive = new DifferentialDrive(frontLeftTalon, frontRightTalon);
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  public void arcadeDrive(double forward, double turn) {
    rearLeftVictor.follow(frontLeftTalon);
    rearRightVictor.follow(frontRightTalon);

    difDrive.arcadeDrive(forward, turn);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcDrive());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
