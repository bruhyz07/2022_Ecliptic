package org.firstinspires.ftc.code.subsystems.drive;

import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.arcrobotics.ftclib.trajectory.TrajectoryConfig;
import com.arcrobotics.ftclib.trajectory.TrajectoryGenerator;
import com.sun.tools.javac.util.List;

import org.firstinspires.ftc.code.Constants;

public class Trajectories {
    private static final TrajectoryConfig config = Constants.Drivetrain.Auto.CONFIG;
    public static class Square {
        public static final Trajectory square = TrajectoryGenerator.generateTrajectory(
                List.of(
                        new Pose2d(),
                        new Pose2d(1.0, 0.0, new Rotation2d(-90)),
                        new Pose2d(1.0, 1.0, new Rotation2d(90)),
                        new Pose2d(0.0, 1.0, new Rotation2d(90)),
                        new Pose2d()
                ), config);
    }
}
