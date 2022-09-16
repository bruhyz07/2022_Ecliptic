package org.firstinspires.ftc.code.subsystems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class Flywheel {
    private static Flywheel instance;
    public static synchronized Flywheel getInstance() {
        if (instance == null) instance = new Flywheel();
        return instance;
    }

    private MotorEx motor = new MotorEx(hardwareMap, "motor");
    private PIDController controller = new PIDController(1.0, 0.0, 0.0);

    public Flywheel() {
        motor.resetEncoder();
    }

    public void set(double percent) {
        motor.set(percent);
    }

    public void setVelocity(double rpm) {
        motor.setVelocity(rpm);
    }

    public void setPIDs(double kP, double kI, double kD) {
        controller.setPID(kP, kI, kD);
    }

    public double getVelocity() {
        return motor.getVelocity();
    }


}
