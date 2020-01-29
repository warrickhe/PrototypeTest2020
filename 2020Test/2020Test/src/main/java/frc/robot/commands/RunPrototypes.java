/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.EBoard;

public class RunPrototypes extends CommandBase {
  private final Joystick left;
  private final Joystick right;
  private final XboxController gamepad;
  private final EBoard eBoard;
  public RunPrototypes(Joystick left, Joystick right, XboxController gamepad, EBoard subsystem) {
    this.left = left;
    this.right = right;
    this.gamepad = gamepad;
    eBoard = subsystem;

    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    eBoard.motor1(left.getX());
    eBoard.motor10(left.getY());
    eBoard.motor11(right.getX());
    eBoard.motor2(right.getY());
    eBoard.motor3(gamepad.getRawAxis(1));
    eBoard.motor5(gamepad.getRawAxis(0));

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    eBoard.motor1(0);
    eBoard.motor10(0);
    eBoard.motor11(0);
    eBoard.motor2(0);
    eBoard.motor3(0);
    eBoard.motor5(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
