/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new 
   */
  public Constants constants = new Constants();
  private final Gyro gyro = new ADXRS450_Gyro();

  private final WPI_TalonSRX frontLeftTalon = new WPI_TalonSRX(
    Constants.FRONT_LEFT_TALON);
  private final WPI_TalonSRX topLeftTalon = new WPI_TalonSRX(
    Constants.MID_LEFT_TALON);
  private final WPI_TalonSRX backLeftTalon = new WPI_TalonSRX(
    Constants.BACK_LEFT_TALON);
  private final WPI_TalonSRX frontRightTalon = new WPI_TalonSRX(
    Constants.FRONT_RIGHT_TALON);
  private final WPI_TalonSRX topRightTalon = new WPI_TalonSRX(
    Constants.MID_RIGHT_TALON);
  private final WPI_TalonSRX backRightTalon = new WPI_TalonSRX(
    Constants.BACK_RIGHT_TALON);

  public Drivetrain() {
    frontLeftTalon.setInverted(true);
      backLeftTalon.setInverted(true);
      topLeftTalon.setInverted(true);

      backLeftTalon.follow(frontLeftTalon);
      backRightTalon.follow(frontRightTalon);
      topRightTalon.follow(frontRightTalon);
      topLeftTalon.follow(frontLeftTalon);
  }
  public void tankDrive(double left, double right){
    setLeft(left);
    setRight(right);
  }
  public void arcadeDrive(double forward, double turn){
    setLeft(forward + turn);
    setRight(forward - turn);
   }
   public void setLeft(double speed){
     frontLeftTalon.set(speed);
   }
   public void setRight(double speed){
     frontRightTalon.set(speed);
   }
   public double getHeading(){
     return gyro.getAngle();
   }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
