/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EBoard extends SubsystemBase {
  /**
   * Creates a new EBoard.
   */
  
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

  public EBoard() {

  }
  public void motor3(double speed){ //frontlefttalon
    if ( !(speed < 0.2 && speed > -0.2) )
      frontLeftTalon.set(speed);
    else
      frontLeftTalon.set(0);
   }
   public void motor1(double speed){ //rightfronttalon
      frontRightTalon.set(speed);
  }
    public void motor11(double speed){
      backLeftTalon.set(speed);
    }
    public void motor10(double speed){
      topLeftTalon.set(speed);
    }
    public void motor5(double speed){
      topRightTalon.set(speed);
    }
    public void motor2(double speed){
      backRightTalon.set(speed);
    }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
