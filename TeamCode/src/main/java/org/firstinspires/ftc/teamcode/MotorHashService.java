package org.firstinspires.ftc.teamcode;

import android.util.Log;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.HashMap;

public class MotorHashService {


    private static HashMap<String,Double> motorList;


    public static void init(){
        motorList = new HashMap<String, Double>();
        motorList.put("AM-20", 537.6);
        motorList.put("YJ-223", 753.2);



    }

    public static double getTicks(String code){
        ;


        return 537;
    }
    public static boolean hasMotor(String motorName) {
        return motorList.containsKey(motorName);
    }


}
