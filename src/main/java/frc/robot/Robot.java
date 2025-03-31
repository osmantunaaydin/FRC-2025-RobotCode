package frc.robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;

import edu.wpi.first.cscore.UsbCamera;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;



public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  Thread m_visionThread;
Constants degerler = new Constants();

  private final RobotContainer m_robotContainer;

  public Robot() {
    m_robotContainer = new RobotContainer();
    m_visionThread =
    new Thread(
        () -> {
          // Get the UsbCamera from CameraServer
          UsbCamera camera = CameraServer.startAutomaticCapture();
          // Set the resolution
          camera.setResolution(640, 480);

          // Get a CvSink. This will capture Mats from the camera
          CvSink cvSink = CameraServer.getVideo();
          // Setup a CvSource. This will send images back to the Dashboard
          CvSource outputStream = CameraServer.putVideo("Rectangle", 640, 480);

          // Mats are very memory expensive. Lets reuse this Mat.
          Mat mat = new Mat();

          // This cannot be 'true'. The program will never exit if it is. This
          // lets the robot stop this thread when restarting robot code or
          // deploying.
          while (!Thread.interrupted()) {
            // Tell the CvSink to grab a frame from the camera and put it
            // in the source mat.  If there is an error notify the output.
            if (cvSink.grabFrame(mat) == 0) {
              // Send the output the error.
              outputStream.notifyError(cvSink.getError());
              // skip the rest of the current iteration
              continue;
            }
            // Put a rectangle on the image
            Imgproc.rectangle(
                mat, new Point(100, 100), new Point(400, 400), new Scalar(255, 255, 255), 5);
            // Give the output stream a new image to display
            outputStream.putFrame(mat);
          }
        });
m_visionThread.setDaemon(true);
m_visionThread.start();
}

 
 


  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    //m_robotContainer.swerve.zeroGyroWithAlliance();
    m_robotContainer.swerve.zeroGyro();
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() { 




   }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();

    }
    //m_robotContainer.algaeRemover.pidSetPoint = Constants.Algae.RemoverArmUp;
    //m_robotContainer.algaeRemover.autoPosition();
  
  }

  @Override
  public void teleopPeriodic() {
/*SmartDashboard.putNumber("ENCODER CORAL", degerler.coraloynarmotorEncoder.getPosition());
SmartDashboard.putNumber("ENCODER ASANSOR", degerler.asansorEncoder.getPosition());




if(degerler.xboxController2.getAButtonPressed())
{

  degerler.abutonbasildi=true;

}
if(degerler.xboxController2.getBButtonPressed())
{

  degerler.bbutonbasildi=true;

}
if(degerler.xboxController2.getXButtonPressed())
{

  degerler.xbutonbasildi=true;

}
if(degerler.xboxController2.getYButtonPressed())
{

  degerler.ybutonbasildi=true;

}
if(degerler.xboxController2.getRightBumperButtonPressed())
{

  degerler.rightbumperbasildi=true;

}
if(degerler.xboxController2.getLeftBumperButtonPressed())
{

  degerler.leftbumperbasildi=true;

}
if(degerler.xboxController2.getStartButtonPressed())
{

  degerler.startabasildi=true;
}
if(degerler.xboxController1.getLeftBumperPressed())
{

  degerler.leftbumper2=true;
}




if(degerler.startabasildi)
{
  if (degerler.asansorEncoder.getPosition() > degerler.ASANSOR0) {
    degerler.asansormotorsag.set(-0.7);
    degerler.asansormotorsol.set(0.7);
} 
else if (degerler.asansorEncoder.getPosition() < degerler.ASANSOR0) {
  degerler.asansormotorsag.set(0.7);
  degerler.asansormotorsol.set(-0.7);
}

if (degerler.asansorEncoder.getPosition() > -4 && degerler.asansorEncoder.getPosition() < -2) {
  degerler.startabasildi = false;
  degerler.asansormotorsag.set(0);
  degerler.asansormotorsol.set(0);
}



}

if(degerler.leftbumperbasildi)
{
  if (degerler.asansorEncoder.getPosition() > degerler.ASANSORALMA) {
    degerler.asansormotorsag.set(-0.7);
    degerler.asansormotorsol.set(0.7);
} 
else if (degerler.asansorEncoder.getPosition() < degerler.ASANSORALMA) {
  degerler.asansormotorsag.set(0.7);
  degerler.asansormotorsol.set(-0.7);
}

if (degerler.asansorEncoder.getPosition() > -12 && degerler.asansorEncoder.getPosition() < -11) {
  degerler.leftbumperbasildi = false;
  degerler.asansormotorsag.set(0);
  degerler.asansormotorsol.set(0);
  degerler.coralalatmotor.set(1);
    Timer.delay(2);
    degerler.coralalatmotor.set(0);
}

}


    // ASANSÖR KODU
    if (degerler.abutonbasildi) {
      
        if (degerler.asansorEncoder.getPosition() > degerler.ASANSORL1) {
          degerler.asansormotorsag.set(-0.7);
          degerler.asansormotorsol.set(0.7);
        } 
        else if (degerler.asansorEncoder.getPosition() < degerler.ASANSORL1) {
          degerler.asansormotorsag.set(0.7);
          degerler.asansormotorsol.set(-0.7);
        }
    
        if (degerler.asansorEncoder.getPosition() > -31 && degerler.asansorEncoder.getPosition() < -29) {
          degerler.abutonbasildi = false;
          degerler.asansormotorsag.set(0);
          degerler.asansormotorsol.set(0);
        }
    }
    
    
    
    
    // **CORAL MOTORLARI ANCAK ASANSÖR DURDUYSA ÇALIŞSIN**
    if (degerler.xbutonbasildi) {
      
      if (degerler.asansorEncoder.getPosition() > degerler.ASANSORL2) {
        degerler.asansormotorsag.set(-0.7);
        degerler.asansormotorsol.set(0.7);
      } 
      else if (degerler.asansorEncoder.getPosition() < degerler.ASANSORL2) {
        degerler.asansormotorsag.set(0.7);
        degerler.asansormotorsol.set(-0.7);
      }
  
      if (degerler.asansorEncoder.getPosition() > -24 && degerler.asansorEncoder.getPosition() < -22) {
        degerler.xbutonbasildi = false;
        degerler.asansormotorsag.set(0);
        degerler.asansormotorsol.set(0);
      }
  }
  
  if (degerler.bbutonbasildi) {
      
    if (degerler.asansorEncoder.getPosition() > degerler.ASANSORL3) {
      degerler.asansormotorsag.set(-0.7);
      degerler.asansormotorsol.set(0.7);
    } 
    else if (degerler.asansorEncoder.getPosition() < degerler.ASANSORL3) {
      degerler. asansormotorsag.set(0.7);
      degerler.asansormotorsol.set(-0.7);
    }

    if (degerler.asansorEncoder.getPosition() > -70 && degerler.asansorEncoder.getPosition() < -68) {
      degerler.bbutonbasildi = false;
      degerler.asansormotorsag.set(0);
      degerler.asansormotorsol.set(0);
    }
}



if (degerler.ybutonbasildi) {
      
  if (degerler.asansorEncoder.getPosition() > degerler.ASANSORL4) {
    degerler.asansormotorsag.set(-0.7);
    degerler.asansormotorsol.set(0.7);
  } 
  else if (degerler.asansorEncoder.getPosition() < degerler.ASANSORL4) {
    degerler.asansormotorsag.set(0.7);
    degerler.asansormotorsol.set(-0.7);
  }

  if (degerler.asansorEncoder.getPosition() > -131 && degerler.asansorEncoder.getPosition() < -129) {
    degerler.ybutonbasildi = false;
    degerler.asansormotorsag.set(0);
    degerler.asansormotorsol.set(0);
  }
}




if(degerler.rightbumperbasildi)
{
  degerler.coraloynarmotor.set(-0.16);

if(degerler.coraloynarmotorEncoder.getPosition()<=-4.50)
  {

    degerler. coraloynarmotor.set(0);
    degerler.coralalatmotor.set(-0.825);
    degerler.algalatmotorsag.set(-1);
    degerler.algalatmotorsol.set(1);
    degerler.coralatildi = true;
Timer.delay(0.7);
degerler.coralalatmotor.set(0);
degerler.algalatmotorsag.set(0);
degerler.algalatmotorsol.set(0);
degerler.rightbumperbasildi=false;

}



}
if(degerler.coralatildi==true){
  degerler.coraloynarmotor.set(0.14);
  degerler.algoynarmotor.set(0.6);
  if(degerler.coraloynarmotorEncoder.getPosition()>=-3)
  {
    degerler.coraloynarmotor.set(0);
    degerler.algoynarmotor.set(0);
    degerler.coralatildi = false;
    
  
  }

}
  


*/

  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}