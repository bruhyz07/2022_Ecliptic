package org.firstinspires.ftc.code.subsystems.drive;


import org.firstinspires.ftc.code.Constants;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveKinematics;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveOdometry;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.MecanumDriveWheelSpeeds;
import com.arcrobotics.ftclib.util.Timing;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.code.Constants;
import org.firstinspires.ftc.code.subsystems.Sensors;

public class Drivetrain extends SubsystemBase {
    private static Drivetrain instance;
    public static synchronized Drivetrain getInstance() {
        if (instance == null) instance = new Drivetrain();
        return instance;
    }

    private MotorEx flMotor = Constants.Drivetrain.flMotor;
    private MotorEx frMotor = Constants.Drivetrain.frMotor;
    private MotorEx blMotor = Constants.Drivetrain.blMotor;
    private MotorEx brMotor = Constants.Drivetrain.brMotor;

    private PIDController frController = Constants.Drivetrain.frController;
    private PIDController flController = Constants.Drivetrain.flController;
    private PIDController blController = Constants.Drivetrain.blController;
    private PIDController brController = Constants.Drivetrain.brController;

    private Sensors sensors = Sensors.getInstance();

    private MecanumDrive drivetrain = new MecanumDrive(flMotor, frMotor, blMotor, brMotor);
    private MecanumDriveKinematics kinematics = new MecanumDriveKinematics(Constants.Drivetrain.flLocation, Constants.Drivetrain.frLocation,
                                                                            Constants.Drivetrain.blLocation, Constants.Drivetrain.brLocation);
    private MecanumDriveOdometry odometry = new MecanumDriveOdometry(kinematics, sensors.getRotation2d());

    private ElapsedTime time = new ElapsedTime(0);

    public Drivetrain() {
        init();
    }

    public void init() {
        flMotor.setDistancePerPulse(0.0);
        frMotor.setDistancePerPulse(0.0);
        brMotor.setDistancePerPulse(0.0);
        blMotor.setDistancePerPulse(0.0);

        frMotor.setInverted(true);
        brMotor.setInverted(true);

        flMotor.resetEncoder();
        frMotor.resetEncoder();
        blMotor.resetEncoder();
        brMotor.resetEncoder();

        sensors.resetGyro();

        odometry.resetPosition(new Pose2d(), new Rotation2d());
    }

    public void updateOdometry() {
        odometry.updateWithTime(time.seconds(), sensors.getRotation2d(), getWheelSpeeds());
    }

    public void setWheelSpeeds(MecanumDriveWheelSpeeds speeds) {
        double frSet = Constants.Drivetrain.feedforward.calculate(speeds.frontRightMetersPerSecond);
        double flSet = Constants.Drivetrain.feedforward.calculate(speeds.frontLeftMetersPerSecond);
        double brSet = Constants.Drivetrain.feedforward.calculate(speeds.rearRightMetersPerSecond);
        double blSet = Constants.Drivetrain.feedforward.calculate(speeds.rearLeftMetersPerSecond);


        drivetrain.driveWithMotorPowers(flSet / 12.0, frSet / 12.0,
                                        blSet / 12.0, brSet / 12.0);
    }

    public void drive(double xSpeed, double ySpeed, double turnSpeed, boolean fieldCentric) {
        if (fieldCentric) {
            drivetrain.driveFieldCentric(xSpeed, ySpeed, turnSpeed, sensors.getGyroAngle(), false);
        } else {
            drivetrain.driveRobotCentric(xSpeed, ySpeed, turnSpeed, false);
        }
    }

    public MecanumDriveWheelSpeeds getWheelSpeeds() {
        return new MecanumDriveWheelSpeeds(flMotor.getVelocity(), frMotor.getVelocity(),
                                            blMotor.getVelocity(), brMotor.getVelocity());

    }

    public ChassisSpeeds getChassisSpeeds(MecanumDriveWheelSpeeds speeds) {
        return kinematics.toChassisSpeeds(speeds);
    }

    public MecanumDriveKinematics getKinematics() {
        return kinematics;
    }

    public Pose2d getPose() {
        return odometry.getPoseMeters();
    }

    @Override
    public void periodic() {
        updateOdometry();
    }

}
