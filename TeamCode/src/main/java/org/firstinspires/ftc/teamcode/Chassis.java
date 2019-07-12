package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis {
    Motion liveMotion;

    public Chassis(){
    }

    public void getMotion(Motion motion){
        liveMotion = motion;
    }

    public void motionInterpreter(ForwardMotion forwardMotion) {

    }


}
