package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral;
public class coralbirak extends Command {
Coral coral;

  public coralbirak(Coral coral) {
    this.coral=coral;
    addRequirements(coral);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    coral.CoralBirak();
  }

  @Override
  public void end(boolean interrupted) {
coral.CoralStop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
