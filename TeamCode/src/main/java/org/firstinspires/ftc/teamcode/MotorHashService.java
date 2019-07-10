package org.firstinspires.ftc.teamcode;

import java.util.HashMap;

public class MotorHashService {


    public static HashMap<String,Double> motorList;
    static {
        motorList.put("AM20", 537.6);
        motorList.put("YJ223", 753.2);

    }

    public static double getTicks(String code){
        return motorList.get(code);

    }


}
