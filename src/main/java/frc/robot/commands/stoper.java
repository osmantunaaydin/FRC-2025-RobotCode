package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Asansor;
import frc.robot.subsystems.Coral;

public class stoper extends Command {
Asansor asansoroto;
Coral coral;

  public stoper(Asansor asansoroto,Coral coral) {
    this.asansoroto=asansoroto;
    this.coral=coral; 
    addRequirements(asansoroto,coral);
  }

  @Override
  public void initialize() {
coral.CoralStop();
asansoroto.AsansorStop();





  }

  @Override
  public void execute() {
  
    
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
