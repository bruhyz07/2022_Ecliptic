package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.subsystems.Flywheel;

public class SpinMotor extends CommandBase {
    private Flywheel flywheel = Flywheel.getInstance();
    private double percent;

    public SpinMotor(double percent) {
        addRequirements(flywheel);

        this.percent = percent;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        flywheel.set(percent);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
