package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Coral;
public class coralyukarioto extends Command {
Coral coral;

  public coralyukarioto(Coral coral) {
    this.coral=coral;
    addRequirements(coral);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    coral.CoralgericekOto();
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
