package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class BotFactory {
    private static Class chassisType;
    private static String driveMotorType;
    private static double wheelDiameter;
    private static GearRatio driveGearRatio = new GearRatio();
    private static int[] driveGears = new int[]{1,1}; //input, output
    private static boolean wasDriveGearRatioInitialized = false;
    private static HashMap<MotorLocations, String> driveMotorDeviceNames;

    public static void setChassisType (Class chassisType) {
        if((chassisType.getSuperclass() != Chassis.class) && (chassisType != Chassis.class)) {
            throw new Error("The Chassis you specified is not a subclass of the Chassis Class");
        }
        BotFactory.chassisType = chassisType;
    }

    public static void setDriveMotors (String driveMotorType) {
        if(!MotorHashService.hasMotor(driveMotorType)) {
            //throw new Error("MotorHashService does not have data on motor" + driveMotorType + ". Make sure you typed it correctly");
        }
        BotFactory.driveMotorType = driveMotorType;
    }

    public static void setWheelDiameter(double wheelDiameter){//in inches (for now)
        if(wheelDiameter <=0.0) {
            throw new Error("Wheel Diameter should be greater than zero");
        }
        BotFactory.wheelDiameter = wheelDiameter;
    }

    public static void setDriveGears(int inputTeeth, int outputTeeth){
        if(inputTeeth<1||outputTeeth<1){
            throw new Error("Your gearRatio teeth must be a positive nonzero integer");
        }
        BotFactory.driveGears[0] = inputTeeth;
        BotFactory.driveGears[1] = outputTeeth;
        wasDriveGearRatioInitialized = true;
    }

    public static void setDriveMotorDeviceNames(HashMap<MotorLocations, String> driveMotorDeviceNames){
        BotFactory.driveMotorDeviceNames = driveMotorDeviceNames; {}
    }

    public static Class getChassisType (){
        return chassisType;
    }

    public static double getWheelDiameter () {
        return wheelDiameter;
    }

    public static String getDriveMotorType () {
        return driveMotorType;
    }

    public static int[] getDriveGears (){
        return driveGears;
    }

    public static HashMap<MotorLocations, String> getDriveMotorDeviceNames (){
        return driveMotorDeviceNames;
    }

    public static boolean isFullyConfigured(){
        boolean chassis, driveMotors, wheels; // are these things configured?
        chassis = chassisType != null;
        driveMotors = driveMotorType != null;
        wheels = wheelDiameter != 0;

        if(!wasDriveGearRatioInitialized){
            throw new Warning("The Drive Gear Ratio was never configured using BotFactory. DriveUnits will assume a 1:1 ratio.");
        }

        return chassis && driveMotors && wheels;
    }



    private BotFactory(){} // no constructo statico

}
