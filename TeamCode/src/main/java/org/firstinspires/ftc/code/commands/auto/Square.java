package org.firstinspires.ftc.code.commands.auto;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.code.commands.drive.FollowTrajectory;
import org.firstinspires.ftc.code.subsystems.drive.Trajectories;

public class Square extends SequentialCommandGroup {
    public Square() {
        addCommands(
                new FollowTrajectory(Trajectories.Square.square)
        );
    }
}
