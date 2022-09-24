package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class Auto extends CommandOpMode {
    private Robot bot;
    @Override
    public void initialize() {
        if (Constants.telemetry == null) Constants.telemetry = telemetry;
        if (Constants.hardwareMap == null) Constants.hardwareMap = hardwareMap;

        bot = new Bot(Bot.OpMode.AUTO);
    }

}
