package org.firstinspires.ftc.code;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.code.commands.auto.Square;
import org.firstinspires.ftc.code.subsystems.drive.Drivetrain;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;

public class BotContainer {
    private Drivetrain drivetrain = Drivetrain.getInstance();

    private GamepadEx pilot = new GamepadEx(gamepad1);

    private HashMap<String, SequentialCommandGroup> autos = new HashMap<String, SequentialCommandGroup>();
    private boolean selected = false;
    private int selection = 0;

    public BotContainer() {

    }

    public void setDefaultCommands() {
        drivetrain.setDefaultCommand(new RunCommand(() -> drivetrain.drive(
            pilot.getLeftX(),
            pilot.getLeftY(),
            pilot.getRightX(),
            false))
        );
    }

    public void setBindings() {

    }


    public void putChooser() {
        autos.put("Nothing", new SequentialCommandGroup());
        autos.put("Square", new Square());

        telemetry.addData("Selected Auto" , autos.keySet().toArray()[selection]);
    }

    public void eventListener() {
        while(pilot.getGamepadButton(GamepadKeys.Button.START).get()) {
            if (pilot.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER).get()) {
                if (selection == 0) selection = autos.size() ;
                selection--;
            }
            if (pilot.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).get()) {
                if (selection == autos.size() - 1) selection = -1;
                selection++;
            }
        }
    }

    public Command getAutonomousCommand() {
        return autos.get(autos.keySet().toArray()[selection]);
    }
}
