package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Asansor;
public class asansorstop extends Command {
Asansor asansoroto;

  public asansorstop(Asansor asansoroto) {
    this.asansoroto=asansoroto;
    addRequirements(asansoroto);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    asansoroto.AsansorStop();
    
  }

  @Override
  public void end(boolean interrupted
) {
}

  @Override
  public boolean isFinished() {
    return false;
  }
}
