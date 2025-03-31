package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.kaldirindir;
public class KaldirDurdur extends Command {
kaldirindir kalk;

  public KaldirDurdur(kaldirindir kalk) {
    this.kalk=kalk;
    addRequirements(kalk);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    kalk.Durdur();
  }

  @Override
  public void end(boolean interrupted) {
   
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
