package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.Robot;

public class Bot extends Robot {
    private Command autoCommand;
    private BotContainer container;

    public enum OpMode {
        TELEOP, AUTO
    }

    public Bot(OpMode opMode) {
        container = new BotContainer();
        if (opMode == OpMode.TELEOP) {
            initTele();
        } else {
            initAuto();
        }
    }

    public void initTele() {
        if (autoCommand != null) {
            autoCommand.cancel();
        }
    }

    public void initAuto() {
        autoCommand = container.getAutoCommand();

        if (autoCommand != null) {
            autoCommand.schedule();
        }
    }
}
