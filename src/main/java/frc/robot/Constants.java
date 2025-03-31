package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

public class Constants {
    public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
    public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
    public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag
    public static final double MAX_SPEED  = Units.feetToMeters(14.5);

 
  boolean coralatildi;
  boolean leftbumper2;
  
    public static final class OperatorConstants {
      public static final int DriverOne = 0;
      public static final int DriverTwo = 1;
      public static final int ButtonBoxControllerOne = 2;
      public static final int ButtonBoxControllerTwo = 3;
    }
    public static final class DriveConstants {
      public static final double kMaxSpeedMetersPerSecond = 5.88264;
      public static final double kMaxAngularSpeed = 4 * Math.PI;
    }
    public static final class SwerveConstants {
        public static final double kTrackWidth = Units.inchesToMeters(26.5);
        public static final double kWheelBase = Units.inchesToMeters(26.5);

        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
            new Translation2d(kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
            new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

        //The following values are only for reference.  You must change them in the Src -> Deploy -> Swerve -> *.json files
        public static final double kFrontLeftOffset = 270;
        public static final double kFrontRightOffset = 0.7;
        public static final double kRearLeftOffset = 183.6;
        public static final double kRearRightOffset = 86.3;
      
        public static final int kFrontLeftDrivingCanId = 22;
        public static final int kFrontRightDrivingCanId = 12;
        public static final int kRearLeftDrivingCanId = 32;
        public static final int kRearRightDrivingCanId = 42;
      
        public static final int kFrontLeftTurningCanId = 21;
        public static final int kFrontRightTurningCanId = 11;
        public static final int kRearLeftTurningCanId = 31;
        public static final int kRearRightTurningCanId = 4;
      
       public static final int kFrontLeftCANcoder = 0;
        public static final int kFrontRightCANcoder = 0;
        public static final int kRearLeftCANcoder = 0;
        public static final int kRearRightCANcoder = 0;
 
        public static final int navx = 0;
    }
   
    public static final class LimeLightOffsets{
      public static final double HorizontalOffset = -10;
      public static final double DistanceOffset = -15;
    }
}