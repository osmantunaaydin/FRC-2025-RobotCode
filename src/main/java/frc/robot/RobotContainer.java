package frc.robot;

import java.io.File;

import com.fasterxml.jackson.databind.util.Named;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.events.EventTrigger;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;

import frc.robot.commands.cmdAuto_AlignRobot;
import frc.robot.commands.coralal;
import frc.robot.commands.coraliceal;
import frc.robot.commands.coralasagi;
import frc.robot.commands.coralstoper;
import frc.robot.commands.coralyukarioto;
import frc.robot.subsystems.Asansor;

import frc.robot.subsystems.Coral;
import frc.robot.subsystems.kaldirindir;




import frc.robot.commands.Kaldir;
import frc.robot.commands.Indir;
import frc.robot.commands.coralyukarioto;
import frc.robot.commands.coralyukari;
import frc.robot.commands.coralbirak;
import frc.robot.commands.coralasagioto;
import frc.robot.commands.coralasagi;
import frc.robot.commands.coralal;
import frc.robot.commands.asansoryukarimanuel;



import frc.robot.commands.asansorasagimanuel;
import frc.robot.commands.asansor2;
import frc.robot.commands.asansor3;
import frc.robot.commands.asansor4;
import frc.robot.commands.asansoralma;
import frc.robot.commands.asansorl1oto;
import frc.robot.commands.asansorstop;
import frc.robot.commands.cmdAuto_Align2Robot;
import frc.robot.commands.cmdAuto_Align3Robot;
import frc.robot.commands.Kaldir;
import frc.robot.commands.KaldirDurdur;
import frc.robot.commands.Indir;
import frc.robot.commands.coralbiraktamoto;

import frc.robot.subsystems.subSwerve;
import swervelib.SwerveInputStream;

import frc.robot.subsystems.subLimelight;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RobotContainer {
  private SendableChooser<Command> chooser = new SendableChooser<>();

  public final subSwerve swerve  = new subSwerve(new File(Filesystem.getDeployDirectory(), "swerve"));

  public final kaldirindir kalk = new kaldirindir();

  public final Asansor asansoroto = new Asansor();

public final Coral coral= new Coral();
public double al;

  //public final subBlinkin blinkin = new subBlinkin();
  public final subLimelight limelight = new subLimelight();
  private final CommandXboxController driverOne = new CommandXboxController(OperatorConstants.DriverOne);
  private final CommandXboxController driverTwo = new CommandXboxController(1);
  public  XboxController xboxController2 = new XboxController(1);

  SwerveInputStream driveAngularVelocity = SwerveInputStream.of(swerve.getSwerveDrive(),
                                                                () -> driverOne.getLeftY() * -0.6,
                                                                () -> driverOne.getLeftX() * -0.6)
                                                            .withControllerRotationAxis(()->driverOne.getRightX()*-0.4)
                                                            .deadband(0.05)
                                                            .scaleTranslation(0.8)
                                                            .allianceRelativeControl(true);



                                                            

  /**
   * Clone's the angular velocity input stream and converts it to a robotRelative input stream.
   */
  SwerveInputStream driveRobotOriented = driveAngularVelocity.copy().robotRelative(true)
                                                             .allianceRelativeControl(false);
  
  public RobotContainer() {
    DriverOneControls();
    ButtonBoxControls();
      NamedCommands.registerCommand("Limelight", new cmdAuto_Align2Robot(swerve, limelight).withTimeout(4));
    NamedCommands.registerCommand("AsansorL4", new asansor4(asansoroto).withTimeout(2.5));
   NamedCommands.registerCommand("AsansorAlKonum", new asansoralma(asansoroto).withTimeout(1));

   NamedCommands.registerCommand("CoralBirak", new coralbiraktamoto(coral).withTimeout(2));
   NamedCommands.registerCommand("CoralAsagi", new coralasagioto(coral).withTimeout(2));

    addAutoOptions();
  }

  private void DriverOneControls(){
    //Swerve
    //Command driveFieldOrientedDirectAngle      = swerve.driveFieldOriented(driveDirectAngle);
    //Command driveFieldOrientedAnglularVelocity = swerve.driveFieldOriented(driveAngularVelocity);
    //Command driveRobotOrientedAngularVelocity  = swerve.driveFieldOriented(driveRobotOriented);
    //Command driveSetpointGen = swerve.driveWithSetpointGeneratorFieldRelative(driveDirectAngle);
    //swerve.setDefaultCommand(swerve.driveFieldOriented(driveAngularVelocity));
    swerve.setDefaultCommand(
        swerve.driveFieldOriented(
            driveRobotOriented.robotRelative(()->driverOne.getRightTriggerAxis()>0.5?true:false)
            .allianceRelativeControl(()->driverOne.getRightTriggerAxis()>0.5?false:true)));
    //swerve.setDefaultCommand(new cmdSwerve_TeleOp(swerve, ()->driverOne.getLeftY()*-1, ()->driverOne.getLeftX()*-1, ()->driverOne.getRightX()*-1, ()->driverOne.getRightTriggerAxis()>0.5 ? false : true));
    //swerve.setDefaultCommand(new cmdSwerve_TeleOpAlt(swerve, ()->driverOne.getLeftY()*-1, ()->driverOne.getLeftX()*-1, ()->driverOne.getRightX()*-1, ()->driverOne.getRightTriggerAxis()>0.5 ? false : true));
    
    if (DriverStation.isTest())
    {
      driverOne.start().onTrue((Commands.runOnce(swerve::zeroGyro)));
      driverOne.back().whileTrue(swerve.centerModulesCommand());
      driverOne.x().whileTrue(Commands.runOnce(swerve::lock, swerve).repeatedly());
      driverOne.y().whileTrue(swerve.driveToDistanceCommand(1.0, 0.2));

     
    } 
    else
    {
      driverOne.start().whileTrue(new InstantCommand(() -> swerve.zeroGyro()));
      driverOne.back().onTrue(Commands.none());//Commands.runOnce(()->swerve.resetOdometry(new Pose2d(3,3, new Rotation2d()))));      

      driverOne.b().whileTrue(new cmdAuto_Align3Robot(swerve, limelight));
      driverOne.a().whileTrue(new cmdAuto_Align2Robot(swerve, limelight));
      driverOne.x().whileTrue(new cmdAuto_AlignRobot(swerve, limelight));

      

      //Kaldirİndir
driverOne.rightBumper().whileTrue(new Indir(kalk));
driverOne.leftBumper().whileTrue(new Kaldir(kalk));
driverOne.rightBumper().onFalse(new KaldirDurdur(kalk));
driverOne.leftBumper().onFalse(new KaldirDurdur(kalk));



//ASANSOR KOD

      driverTwo.a().whileTrue(new asansorl1oto(asansoroto));
      driverTwo.x().whileTrue(new asansor2(asansoroto));
      driverTwo.b().whileTrue(new asansor3(asansoroto));
      driverTwo.y().whileTrue(new asansor4(asansoroto));

      driverTwo.povDown().whileTrue(new asansorstop(asansoroto));
      driverTwo.povRight().whileTrue(new coralbiraktamoto(coral));
      driverTwo.a().onFalse(new asansorstop(asansoroto));
      driverTwo.x().onFalse(new asansorstop(asansoroto));
      driverTwo.b().onFalse(new asansorstop(asansoroto));
      driverTwo.y().onFalse(new asansorstop(asansoroto));
      driverTwo.start().whileTrue(new asansoralma(asansoroto));
      driverTwo.start().onFalse(new asansorstop(asansoroto));

      driverOne.povUp().whileTrue(new asansoryukarimanuel(asansoroto));
      driverOne.povDown().whileTrue(new asansorasagimanuel(asansoroto));
      driverOne.povUp().onFalse(new asansorstop(asansoroto));
      driverOne.povDown().onFalse(new asansorstop(asansoroto));
      



      
driverTwo.povLeft().whileTrue(new coralasagioto(coral));
driverTwo.povLeft().whileTrue(new coralyukarioto(coral));
driverTwo.rightBumper().whileTrue(new coralbirak(coral));
driverTwo.leftBumper().whileTrue(new coralal(coral)); 
driverTwo.leftBumper().onFalse(new coralstoper(coral)); 
driverTwo.rightBumper().onFalse(new coralstoper(coral)); 
driverTwo.povRight().onFalse(new coralstoper(coral)); 


driverTwo.povLeft().whileTrue(new coraliceal(coral));


driverTwo.povLeft().onFalse(new coralstoper(coral));;



driverTwo.povUp().whileTrue(new coralyukari(coral));
driverTwo.povUp().onFalse(new coralstoper(coral));

driverTwo.povDown().whileTrue(new coralasagi(coral));
driverTwo.povDown().onFalse(new coralstoper(coral));



    }
  }

  private void ButtonBoxControls(){
    //algaeRemover.setDefaultCommand(new cmdAuto_AlgaeRemoverToPosition(algaeRemover, Constants.Algae.RemoverArmUp));



  }
  private void addAutoOptions(){
    chooser.addOption("Kirmizi Sag", swerve.getAutonomousCommand("Mavi Sol"));
    chooser.addOption("Kirmizi Sol", swerve.getAutonomousCommand("Mavi Sag"));
    chooser.addOption("Mavi Sag", swerve.getAutonomousCommand("Mavi Sag"));
    chooser.addOption("Mavi Sol", swerve.getAutonomousCommand("Mavi Sol"));
    chooser.addOption("Orta", swerve.getAutonomousCommand("Orta"));



  //chooser.addOption("Drive Forward and Wait", swerve.getAutonomousCommand("Drive Forward and Wait"));
    SmartDashboard.putData("Autonomous Options", chooser);
  }
  public Command getAutonomousCommand() {
    //return new cmdAutonomous_Crossline(swerve); 
    return chooser.getSelected();
  }
}