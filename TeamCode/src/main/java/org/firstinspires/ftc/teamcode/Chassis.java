package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Chassis extends Component{
    PlanElement livePlanElement;

    public Chassis(){
    }

    public void getMotion(PlanElement motion){
        livePlanElement = motion;
    }


}
