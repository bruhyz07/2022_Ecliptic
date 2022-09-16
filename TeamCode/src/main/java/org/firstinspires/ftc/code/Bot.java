package org.firstinspires.ftc.code;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.Robot;

public class Bot extends Robot {
    private BotContainer container = new BotContainer();
    private Command autoCommand;

    public enum OpMode {
        TELEOP, AUTO
    }

    public Bot(OpMode opMode) {
        reset();
        if (opMode == OpMode.AUTO) {
            initAuto();
        } else {
            initTeleOp();
        }

    }

    public void initAuto() {
        reset();
        autoCommand = container.getAutonomousCommand();

        if (autoCommand != null) {
            schedule(autoCommand);
        }
    }

    public void initTeleOp() {

    }
}
