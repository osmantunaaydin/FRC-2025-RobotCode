package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.kaldirindir;
public class Kaldir extends Command {
kaldirindir kalk;

  public Kaldir(kaldirindir kalk) {
    this.kalk=kalk;
    addRequirements(kalk);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    kalk.Kaldir();
  }

  @Override
  public void end(boolean interrupted) {
   
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
