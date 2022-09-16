package org.firstinspires.ftc.code;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.Robot;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
@Disabled
public class TeleOperated extends CommandOpMode {
    Bot robot = new Bot(Bot.OpMode.TELEOP);

    @Override
    public void initialize() {
        robot.reset();
        robot.run();
        
    }
}
