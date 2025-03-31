
package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.classes.LimelightHelpers;

public class Coral extends SubsystemBase {
  public static SparkMax coraloynarmotor = new SparkMax(29, MotorType.kBrushless);
  public SparkMax coralalatmotor = new SparkMax(2, MotorType.kBrushless);
  public RelativeEncoder coraloynarmotorEncoder = coraloynarmotor.getEncoder();
 boolean atisyapildi;
 
  
  public Coral() {

  }

  @Override
  public void periodic() {
}
public void CoralBiraktamoto()
{
  coraloynarmotor.set(-0.16);
  if(coraloynarmotorEncoder.getPosition()<=-5.3)
    {
  coraloynarmotor.set(0);

  coralalatmotor.set(0.6);
  
  Timer.delay(1);
  atisyapildi=true;
  coralalatmotor.set(0);
    }

    if(atisyapildi==true){
    coraloynarmotor.set(0.14);

    if(coraloynarmotorEncoder.getPosition()>=-3)
    {
      coraloynarmotor.set(0);
      atisyapildi=false;
    }
      
  }

}



public void CoralAsagiBukOto()
{
  if(coraloynarmotorEncoder.getPosition() > -5.3) {
    coraloynarmotor.set(-0.13);
   
  } 
  else if (coraloynarmotorEncoder.getPosition() < -5.3) {
    coraloynarmotor.set(0.13);
  }

  if (coraloynarmotorEncoder.getPosition() > -5.7 && coraloynarmotorEncoder.getPosition() < -4.7) {

    coraloynarmotor.set(0);
  }
}

public void CoralAl()
{
coralalatmotor.set(-0.65);
coraloynarmotor.set(-0.08);



}

public void CoralAsagiBuk()
{

  coraloynarmotor.set(-0.10);



  
}

public void CoralGericek()
{

  coraloynarmotor.set(0.10);



  
}
public void CoralIceAl()
{

  coralalatmotor.set(-0.65);


  
}
public void CoralBirak()
{

  coralalatmotor.set(0.30);



  
}



public void CoralgericekOto()
{

  if(coraloynarmotorEncoder.getPosition() > -3) {
    coraloynarmotor.set(-0.13);
   
  } 
  else if (coraloynarmotorEncoder.getPosition() < -3) {
    coraloynarmotor.set(0.13);
  }

  if (coraloynarmotorEncoder.getPosition() > -3.5 && coraloynarmotorEncoder.getPosition() < -2.5) {
 
    coraloynarmotor.set(0);
  }


}


public void  CoralStop()
{
coraloynarmotor.set(0);
coralalatmotor.set(0);

}


  }

