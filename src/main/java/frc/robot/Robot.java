// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Commands.tanktanktankCommand;
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

  private VictorSPX frontleft;
  private VictorSPX backleft;
  private VictorSPX frontright;
  private VictorSPX backright;


  private final MotorController m_leftMotor = new PWMSparkMax(0);
  private final MotorController m_rightMotor = new PWMSparkMax(1);

  private final tanktanktankSubsystem _tanktanktankSubsystem = new tanktanktankSubsystem();
  private final tanktanktankCommand _tanktanktankCommand = new tanktanktankCommand(_tanktanktankSubsystem, m_leftStick, m_rightStick);


  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    m_rightMotor.setInverted(true);

    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
//    m_controller = new XboxController(0);





    frontleft = new VictorSPX(12);
    backleft = new VictorSPX(13);
    backleft.follow(frontleft);
    frontright = new VictorSPX(10);
    backright = new VictorSPX(11);
    backright.follow(frontright);

//    m_myRobot = new DifferentialDrive(m_leftMotor, m_rightMotor);

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
    CommandScheduler.getInstance().schedule(_tanktanktankCommand);
  }

  @Override
  public void teleopPeriodic() {
//    m_myRobot.tankDrive(m_controller.getLeftY(), m_controller.getRightY());


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
      CommandScheduler.getInstance().cancel(_tanktanktankCommand);
  }

  @Override
  public void disabledPeriodic() {

  }

}
