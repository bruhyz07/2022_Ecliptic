package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Constants;

public class Flywheel extends SubsystemBase {
    private static Flywheel instance;
    public static synchronized Flywheel getInstance() {
        if (instance == null) instance = new Flywheel();
        return instance;
    }

    private MotorEx motor = new MotorEx(Constants.hardwareMap, "motor");
    private PIDController pid = new PIDController(Constants.Flywheel.kP, Constants.Flywheel.kI, Constants.Flywheel.kD);

    private Flywheel() {
        motor.resetEncoder();
        motor.setZeroPowerBehavior(Motor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void periodic() {
        Constants.telemetry.addData("vel", getVelocity());
        Constants.telemetry.update();
    }

    public void set(double percent) {
        motor.set(percent);
    }

    public void setVelocity(double velocity) {
        set(pid.calculate(getVelocity(), velocity));
    }

    public double getVelocity() {
        return motor.getVelocity() / motor.getCPR();
    }

    public double get() {
        return motor.get();
    }

}
