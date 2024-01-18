// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.IsPROLicensedValue;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.controls.Follower;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveTrain extends SubsystemBase {
  private TalonFX frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
  private MotorControllerGroup leftMotors, rightMotors;
  private DifferentialDrive differentialDrive;
  /** Creates a new ExampleSubsystem. */

  public DriveTrain() {
    frontLeftMotor = new TalonFX(Constants.FRONT_LEFT_MOTOR_ID);
    backLeftMotor = new TalonFX(Constants.BACK_LEFT_MOTOR_ID);
    frontRightMotor = new TalonFX(Constants.FRONT_RIGHT_MOTOR_ID);
    backRightMotor = new TalonFX(Constants.BACK_RIGHT_MOTOR_ID);

    frontLeftMotor.setNeutralMode(NeutralModeValue.Coast);
    backLeftMotor.setNeutralMode(NeutralModeValue.Brake);
    frontRightMotor.setNeutralMode(NeutralModeValue.Coast);
    backRightMotor.setNeutralMode(NeutralModeValue.Brake);

    frontLeftMotor.setInverted(Constants.LEFT_MOTOR_INVERTED);
    frontRightMotor.setInverted(Constants.RIGHT_MOTOR_INVERTED);
    backLeftMotor.setInverted(Constants.LEFT_MOTOR_INVERTED);
    backRightMotor.setInverted(Constants.RIGHT_MOTOR_INVERTED);

    leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * makes the robot drive
   * 
   * <p>
   * 
   * speed and rotation are double; range is [-1.0, 1.0]
   * @param speed
   * @param rotation
   */
  public void drive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
