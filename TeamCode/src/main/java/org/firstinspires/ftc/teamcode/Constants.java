package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Constants {
    public static Telemetry telemetry = null;
    public static HardwareMap hardwareMap = null;

    public static final class Flywheel {
        public static final double kP = 10.0;
        public static final double kI = 0.0;
        public static final double kD = 0.0;

        public static final double kV = 6.0;
    }
}
