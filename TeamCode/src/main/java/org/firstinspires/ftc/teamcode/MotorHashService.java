package org.firstinspires.ftc.teamcode;

import java.util.HashMap;

public class MotorHashService {


    private static HashMap<String,Double> motorList;
    static {
        motorList.put("AM-20", 537.6);
        motorList.put("YJ-223", 753.2);

    }

    public static double getTicks(String code){
        return motorList.get(code);
    }
    public static boolean hasMotor(String motorName) {
        return motorList.containsKey(motorName);
    }


}
