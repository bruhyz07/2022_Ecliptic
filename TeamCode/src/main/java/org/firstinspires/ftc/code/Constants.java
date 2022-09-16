package org.firstinspires.ftc.code;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.ProfiledPIDController;
import com.arcrobotics.ftclib.controller.wpilibcontroller.SimpleMotorFeedforward;
import com.arcrobotics.ftclib.geometry.Translation2d;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.trajectory.TrajectoryConfig;
import com.arcrobotics.ftclib.trajectory.TrapezoidProfile;

public class Constants {
    public static final class Devices {



    }

    public static final class Drivetrain {
        public static final MotorEx frMotor = new MotorEx(hardwareMap, "frMotor");
        public static final MotorEx brMotor = new MotorEx(hardwareMap, "brMotor");
        public static final MotorEx flMotor = new MotorEx(hardwareMap, "flMotor");
        public static final MotorEx blMotor = new MotorEx(hardwareMap, "blMotor");

        public static final PIDController flController = new PIDController(0.0, 0.0, 0.0);
        public static final PIDController frController = new PIDController(0.0, 0.0, 0.0);
        public static final PIDController blController = new PIDController(0.0, 0.0, 0.0);
        public static final PIDController brController = new PIDController(0.0, 0.0, 0.0);

        public static final SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0.0, 0.0);

        public static final double wheelWidth = 0.0;
        public static final double wheelLength = 0.0;
        public static final Translation2d flLocation = new Translation2d(wheelWidth / 2, wheelLength / 2);
        public static final Translation2d frLocation = new Translation2d(wheelWidth / 2, -wheelLength / 2);
        public static final Translation2d blLocation = new Translation2d(-wheelWidth / 2, wheelLength / 2);
        public static final Translation2d brLocation = new Translation2d(-wheelWidth / 2, -wheelLength / 2);

        public static final class Auto {
            public static final PIDController xController = new PIDController(0.0 ,0.0, 0.0);
            public static final PIDController yController = new PIDController(0.0 ,0.0, 0.0);
            public static final ProfiledPIDController thetaController = new ProfiledPIDController(0.0, 0.0, 0.0, new TrapezoidProfile.Constraints(3.0 ,1.0));
            public static final TrajectoryConfig CONFIG = new TrajectoryConfig(3.0, 1.0);
        }

    }

    public static final class Sensors {
        public static final RevIMU imu = new RevIMU(hardwareMap);
    }
}
