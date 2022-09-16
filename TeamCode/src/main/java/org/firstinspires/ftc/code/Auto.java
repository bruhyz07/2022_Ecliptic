package org.firstinspires.ftc.code;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

@Autonomous
@Disabled
public class Auto extends CommandOpMode {
    private Bot bot = new Bot(Bot.OpMode.AUTO);
    @Override
    public void initialize() {
        bot.reset();
        bot.run();
    }
}
