package org.firstinspires.ftc.code.commands.drive;

import com.arcrobotics.ftclib.command.MecanumControllerCommand;
import com.arcrobotics.ftclib.trajectory.Trajectory;

import org.firstinspires.ftc.code.Constants;
import org.firstinspires.ftc.code.subsystems.drive.Drivetrain;

public class FollowTrajectory extends MecanumControllerCommand {
    private static Drivetrain drivetrain = Drivetrain.getInstance();

    public FollowTrajectory(Trajectory trajectory) {
        super(trajectory, drivetrain::getPose, drivetrain.getKinematics(),
                Constants.Drivetrain.Auto.xController, Constants.Drivetrain.Auto.yController,
                Constants.Drivetrain.Auto.thetaController,
                3.0, drivetrain::setWheelSpeeds);
    }
}
