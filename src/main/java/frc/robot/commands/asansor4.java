package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Asansor;
public class asansor4 extends Command {
Asansor asansoroto;

  public asansor4(Asansor asansoroto) {
    this.asansoroto=asansoroto;
    addRequirements(asansoroto);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    asansoroto.AsansorL4Otonom();
    
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
