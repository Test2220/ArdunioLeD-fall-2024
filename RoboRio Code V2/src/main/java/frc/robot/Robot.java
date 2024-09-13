// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.SignalLogger;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.lib.CommandObserver;
import frc.lib.LoopTimer;
import frc.lib.eventLoops.EventLoops;
import frc.lib.faults.Fault;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {
  private Command autonomousCommand;
  private Command testCommand;

  private RobotContainer robotContainer;

  @Override
  public void robotInit() {
    SignalLogger.start();
    DataLogManager.start();
    BuildConstToString buildConst = new BuildConstToString();
    DataLogManager.log(buildConst.toString());

    DriverStation.startDataLog(DataLogManager.getLog());

    CommandObserver.start();
    addPeriodic(EventLoops.everyLoop::poll, 0.02);
    addPeriodic(EventLoops.oncePerSec::poll, 1);
    addPeriodic(EventLoops.oncePerMin::poll, 60);
    Fault.setupDefaultFaults();

    DriverStation.silenceJoystickConnectionWarning(true);

    robotContainer = new RobotContainer();
    Shuffleboard.getTab("Scheduler").add("Scheduler", CommandScheduler.getInstance()).withSize(3, 2);
  }

  LoopTimer loopTimer = new LoopTimer("Robot Periodic", 15);

  @Override
  public void robotPeriodic() {
    loopTimer.measure(() -> {
      CommandScheduler.getInstance().run();
    });
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    robotContainer.arm.setNeturalMode(NeutralModeValue.Brake);
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
    if (testCommand != null) {
      testCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
    testCommand = robotContainer.getTestCommand();
    if (testCommand != null) {
      testCommand.schedule();
    }
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
}


//########################################################################\\


public class Robot extends TimedRobot {
  
  private SerialPort arduino; //The serial port that we try to communicate with

  private Timer timer; //The timer to keep track of when we send our signal to the Arduino

  @Override
  public void robotInit() {
    //A "Capture Try/Catch". Tries all the possible serial port
    //connections that make sense if you're using the USB ports
    //on the RoboRIO. It keeps trying unless it never finds anything.
    try {
      arduino = new SerialPort(9600, SerialPort.Port.kUSB);
      System.out.println("Connected on kUSB!");
    } catch (Exception e) {
      System.out.println("Failed to connect on kUSB, trying kUSB 1");

      try {
        arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
        System.out.println("Connected on kUSB1!");
      } catch (Exception e1) {
        System.out.println("Failed to connect on kUSB1, trying kUSB 2");

        try {
          arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
          System.out.println("Connected on kUSB2!");
        } catch (Exception e2) {
          System.out.println("Failed to connect on kUSB2, all connection attempts failed!");
        }
      }
    }

    //Create a timer that will be used to keep track of when we should send
    //a signal and start it. 
    timer = new Timer();
    timer.start();
  }
  

  @Override
  public void robotPeriodic() {
    //If we've received something, read the entire buffer
    //from the arduino as a string
    if(arduino.getBytesReceived() > 0) {
      System.out.print(arduino.readString());
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
