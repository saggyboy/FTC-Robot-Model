package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class FTCUtilities { //handles inaccessable objects in FTCapp. hardwareMap exists under OpMode.
    private static HardwareMap hardwareMap;
    private static OpMode opMode;

    public static void setHardwareMap(HardwareMap hardwareMap) {
        FTCUtilities.hardwareMap = hardwareMap;
    }

    public static HardwareMap getHardwareMap() {
        return hardwareMap;
    }

    public static void setOpmode(OpMode opMode){
        FTCUtilities.opMode = opMode;
    }

    public static OpMode getOpMode(){
        return opMode;
    }

    public static void OpLogger(String caption, Object object){
        opMode.telemetry.addData(caption, object);
        opMode.telemetry.update();
    }

    private FTCUtilities () {} //no constructo statico
}
