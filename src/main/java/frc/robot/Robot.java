// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.arcadeDriveCommand;
import frc.robot.Commands.tankDriveCommand;
import frc.robot.Subsystems.tanktanktankSubsystem;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;
//  private XboxController m_controller;


  private tanktanktankSubsystem _tanktanktankSubsystem;
  private tankDriveCommand _tankDriveCommand;
  private arcadeDriveCommand _arcadeDriveCommand;

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
//    m_rightMotor.setInverted(true);

    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);

    _tanktanktankSubsystem = new tanktanktankSubsystem();
    _tankDriveCommand = new tankDriveCommand(_tanktanktankSubsystem, m_leftStick, m_rightStick);
    _arcadeDriveCommand = new arcadeDriveCommand(_tanktanktankSubsystem, m_leftStick, m_rightStick);


  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
//    m_myRobot.tankDrive(m_controller.getLeftY(), m_controller.getRightY());
    CommandScheduler.getInstance().schedule(_arcadeDriveCommand);


  }

  @Override
  public void testInit() {

  }

  @Override
  public void testPeriodic() {

  }

  @Override
  public void simulationInit() {

  }

  @Override
  public void simulationPeriodic() {

  }

  @Override
  public void disabledInit() {
      CommandScheduler.getInstance().cancel(_tankDriveCommand);
  }

  @Override
  public void disabledPeriodic() {

  }

}
