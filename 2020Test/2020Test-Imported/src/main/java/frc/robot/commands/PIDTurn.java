package frc.robot.commands;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.subsystems.Drivetrain;
// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class PIDTurn extends PIDCommand {
  /**
   * Creates a new PIDTurn.
   */
  private static final double kTurnToleranceDeg = 0.5;
  private static final double kTurnRateToleranceDegPerS = 3;
  private static final double kTurnP = 1;
  private static final double kTurnI = 1;
  private static final double kTurnD = 0;
  public PIDTurn(double targetAngle, Drivetrain drivetrain) {
    super(
        // The controller that the command will use
        new PIDController(kTurnP, kTurnI, kTurnD),
        // This should return the measurement
        drivetrain::getHeading,
        // This should return the setpoint (can also be a constant)
        targetAngle,
        // This uses the output
        output -> {
          // Use the output here
          drivetrain.arcadeDrive(0, output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
    // Configure additional PID options by calling `getController` here.  
    getController().enableContinuousInput(-180, 180);
    getController()
    .setTolerance(kTurnToleranceDeg, kTurnRateToleranceDegPerS);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}




