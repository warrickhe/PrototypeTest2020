/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  /**
   * Creates a new Drive.
   */
  private final Drivetrain drivetrain;
  private final DoubleSupplier speed;
  private final DoubleSupplier turn;

  public Drive(DoubleSupplier left, DoubleSupplier right, Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    
    this.drivetrain = drivetrain;
    this.speed = left;
    this.turn = right;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  // persistent no init needed
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(speed.getAsDouble(), turn.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  //never finishes
  @Override
  public boolean isFinished() {
    return false;
  }
}