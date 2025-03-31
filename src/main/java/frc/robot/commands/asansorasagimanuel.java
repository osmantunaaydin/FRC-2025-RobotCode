package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Asansor;
public class asansorasagimanuel extends Command {
Asansor asansoroto;

  public asansorasagimanuel(Asansor asansoroto) {
    this.asansoroto=asansoroto;
    addRequirements(asansoroto);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    asansoroto.AsansorManuelIn();
    
  }

  @Override
  public void end(boolean interrupted
) {
  asansoroto.AsansorStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
