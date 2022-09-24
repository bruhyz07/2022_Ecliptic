package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.RunCommand;

import org.firstinspires.ftc.teamcode.subsystems.Flywheel;

public class BotContainer {
    private Flywheel flywheel = Flywheel.getInstance();

    public BotContainer() {

    }

    private void setDefaultCommands() {

    }

    private void configBindings() {

    }

    public Command getAutoCommand() {
        return new RunCommand(() -> flywheel.set(1.0), flywheel);
    }
}
