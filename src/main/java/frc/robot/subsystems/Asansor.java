
package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Asansor extends SubsystemBase {
  public double ASANSORALMA = -9;
  public double ASANSORL1 = -10;
  public double ASANSORL2 = -23;
  public double ASANSORL3 = -69;
  public double ASANSORL4 = -130;
  public double ASANSOR0 = -3;
  

    public  SparkMax asansormotorsol = new SparkMax(1, MotorType.kBrushless);
    public  SparkMax asansormotorsag = new SparkMax(5, MotorType.kBrushless);
    public RelativeEncoder asansorEncoder = asansormotorsag.getEncoder();
  
  public Asansor() {

  }

  @Override
  public void periodic() {
  

  }
public void AsansorL1Otonom()
{

    if(asansorEncoder.getPosition() > ASANSORL1) {
      asansormotorsag.set(-0.7);
      asansormotorsol.set(0.7);
    } 
    else if (asansorEncoder.getPosition() < ASANSORL1) {
      asansormotorsag.set(0.7);
      asansormotorsol.set(-0.7);
    }

    if (asansorEncoder.getPosition() > -11 && asansorEncoder.getPosition() < -9) {
   
      asansormotorsag.set(0);
      asansormotorsol.set(0);
    }
}

public void AsansorL2Otonom()
{

    if(asansorEncoder.getPosition() > ASANSORL2) {
      asansormotorsag.set(-0.7);
      asansormotorsol.set(0.7);
    } 
    else if (asansorEncoder.getPosition() < ASANSORL2) {
      asansormotorsag.set(0.7);
      asansormotorsol.set(-0.7);
    }

    if (asansorEncoder.getPosition() > -24 && asansorEncoder.getPosition() < -22) {
    
      asansormotorsag.set(0);
      asansormotorsol.set(0);
    }
}
public void AsansorL3Otonom()
{

    if(asansorEncoder.getPosition() > ASANSORL3) {
      asansormotorsag.set(-0.7);
      asansormotorsol.set(0.7);
    } 
    else if (asansorEncoder.getPosition() < ASANSORL3) {
      asansormotorsag.set(0.7);
      asansormotorsol.set(-0.7);
    }

    if (asansorEncoder.getPosition() > -70 && asansorEncoder.getPosition() < -68) {
    
      asansormotorsag.set(0);
      asansormotorsol.set(0);
    }
}
public void AsansorL4Otonom()
{

    if(asansorEncoder.getPosition() > ASANSORL4) {
      asansormotorsag.set(-0.7);
      asansormotorsol.set(0.7);
    } 
    else if (asansorEncoder.getPosition() < ASANSORL4) {
      asansormotorsag.set(0.7);
      asansormotorsol.set(-0.7);
    }

    if (asansorEncoder.getPosition() > -131 && asansorEncoder.getPosition() < -129) {
    
      asansormotorsag.set(0);
      asansormotorsol.set(0);
    }
}
public void AsansorAlma()
{
  if(asansorEncoder.getPosition() > ASANSORALMA) {
    asansormotorsag.set(-0.7);
    asansormotorsol.set(0.7);
  } 
  else if (asansorEncoder.getPosition() < ASANSORALMA) {
    asansormotorsag.set(0.7);
    asansormotorsol.set(-0.7);
  }

  if (asansorEncoder.getPosition() > -10 && asansorEncoder.getPosition() < -8) {
 
    asansormotorsag.set(0);
    asansormotorsol.set(0);
  }

}
public void AsansorManuelIn()
{
  asansormotorsag.set(0.5);
  asansormotorsol.set(-0.5);

}


public void AsansorManuelKalk()
{
  asansormotorsag.set(-0.5);
  asansormotorsol.set(0.5);

}













public void AsansorStop()
{
asansormotorsag.set(0);
asansormotorsol.set(0);

}
}