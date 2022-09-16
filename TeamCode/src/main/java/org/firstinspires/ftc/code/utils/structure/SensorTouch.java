package org.firstinspires.ftc.code.utils.structure;

import com.arcrobotics.ftclib.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class SensorTouch implements HardwareDevice {

    private TouchSensor touchSensor;

    public SensorTouch(TouchSensor touchSensor) {
        this.touchSensor = touchSensor;
    }

    public SensorTouch(HardwareMap hardwareMap, String name) {
        this(hardwareMap.get(TouchSensor.class, name));
    }

    public boolean isPressed() {
        return touchSensor.isPressed();
    }

    @Override
    public void disable() {
        touchSensor.close();
    }

    @Override
    public String getDeviceType() {
        return "Touch Sensor";
    }
}
