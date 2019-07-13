package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FTCUtilities { //handles inaccessable objects in FTCapp. hardwareMap exists under OpMode.
    private static HardwareMap hardwareMap;
    private static LinearOpMode opMode;

    public static void setHardwareMap(HardwareMap hardwareMap) {
        FTCUtilities.hardwareMap = hardwareMap;
    }

    public static HardwareMap getHardwareMap() {
        return hardwareMap;
    }

    public static void setOpmode(LinearOpMode opMode){
        FTCUtilities.opMode = opMode;
    }

    public static LinearOpMode getOpMode(){
        return opMode;
    }

    public static void OpLogger(String caption, Object object){
        opMode.telemetry.addData(caption, object);
        opMode.telemetry.update();
    }

    public static void OpSleep(long ms) {
        opMode.sleep(ms);
    }

    private FTCUtilities () {} //no constructo statico
}
