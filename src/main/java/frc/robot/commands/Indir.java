package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.kaldirindir;
public class Indir extends Command {
kaldirindir kalk;

  public Indir(kaldirindir kalk) {
    this.kalk=kalk;
    addRequirements(kalk);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    kalk.Indir();
  }

  @Override
  public void end(boolean interrupted) {
   
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
