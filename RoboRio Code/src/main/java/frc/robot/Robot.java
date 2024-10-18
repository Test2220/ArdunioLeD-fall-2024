/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import static frc.robot.Arduino.ArduinoCommand.*;

import javax.xml.xpath.XPathVariableResolver;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Arduino.Arduino;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Arduino arduino; // The serial port that we try to communicate with

  @Override
  public void robotInit() {
    arduino = new Arduino();
  }

  XboxController xboxController = new XboxController(0);

  @Override
  public void robotPeriodic() {
    // If more than 5 seconds has passed

    if (xboxController.getAButton()) {
      System.out.println("Wrote to Arduino");
      arduino.runCommand(OFF);
    }

    if (xboxController.getBButton()) {
      System.out.println("Wrote to Arduino");
      arduino.runCommand(RED);
    }
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
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
