package org.firstinspires.ftc.code.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.hardware.RevIMU;
import org.firstinspires.ftc.code.utils.structure.SensorTouch;

public class Sensors {
    private static Sensors instance;
    public static synchronized Sensors getInstance() {
        if (instance == null) instance = new Sensors();
        return instance;
    }

    private RevIMU imu = new RevIMU(hardwareMap, "imu");
    private SensorTouch touchSensor = new SensorTouch(hardwareMap, "touchSensor");

    public Sensors() {
        imu.init();
        
    }

    public boolean isPressed() {
        return touchSensor.isPressed();
    }

    public double getGyroAngle() {
        return imu.getRotation2d().getDegrees();
    }

    public Rotation2d getRotation2d() {
        return imu.getRotation2d();
    }

    public void resetGyro() {
        imu.reset();
    }

}
