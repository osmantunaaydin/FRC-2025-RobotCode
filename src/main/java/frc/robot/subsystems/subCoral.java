package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class subCoral extends SubsystemBase {
  DigitalInput inSensor = new DigitalInput(Constants.Coral.InSensor);
  DigitalInput outSensor = new DigitalInput(Constants.Coral.OutSensor);
  SparkMax feedMotor = new SparkMax(Constants.Coral.FeedMotor, SparkMax.MotorType.kBrushless);
  SparkMaxConfig feedConfig = new SparkMaxConfig();
  public subCoral() {
    feedConfig
      .inverted(false)
      .idleMode(IdleMode.kBrake);
    feedConfig.encoder
      .positionConversionFactor(1000)
      .velocityConversionFactor(1000);
    feedMotor.configure(feedConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
   }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Coral In Sensor", InSensor());
    SmartDashboard.putBoolean("Coral Out Sensor", OutSensor());
    SmartDashboard.putBoolean("Coral Has Coral", hasCoral());
  }

  public void teleOp(double speed) {
    feedMotor.set(speed);
  }

  public boolean hasCoral(){
    return InSensor() && OutSensor();
  }

  public void stop(){
    feedMotor.stopMotor();
  }

  public boolean InSensor(){
    return !inSensor.get();
  }
  public boolean OutSensor(){
    return !outSensor.get();
  }
}