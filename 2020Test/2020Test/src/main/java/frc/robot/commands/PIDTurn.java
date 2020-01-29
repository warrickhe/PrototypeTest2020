package frc.robot.commands;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.*;
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
  private static final double kTurnP = 0.008;
  private static final double kTurnI = 0.0;
  private static final double kTurnD = 0.0;// a tenth of p at mostx
  private Drivetrain drivetrain;
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
          drivetrain.arcadeDrive(0, -output);
        });
    this.drivetrain = drivetrain;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(kTurnToleranceDeg);


    System.out.println("Command started");
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println(getController().getPositionError());
    if (getController().atSetpoint()){
      System.out.println("Command ended at " + drivetrain.getHeading());
      return true;
    }
    return false;
  }
}




