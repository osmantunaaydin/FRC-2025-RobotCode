
package frc.robot.subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.classes.LimelightHelpers;

public class kaldirindir extends SubsystemBase {
  private SparkMax kaldirindir1 = new SparkMax(6, MotorType.kBrushed);
  private SparkMax kaldirindir2 = new SparkMax(7, MotorType.kBrushed);
  
  public kaldirindir() {

  }

  @Override
  public void periodic() {
}
public void Kaldir()
{
  kaldirindir1.set(-1);
  kaldirindir2.set(1);
  
  }

  public void Indir()
  {
    kaldirindir1.set(1);
    kaldirindir2.set(-1);
    
    }

public void Durdur()
{
  kaldirindir1.set(0);
  kaldirindir2.set(0);

}



  }

