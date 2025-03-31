package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral;
public class coralal extends Command {
Coral coral;

  public coralal(Coral coral) {
    this.coral=coral;
    addRequirements(coral);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    coral.CoralAl();
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
