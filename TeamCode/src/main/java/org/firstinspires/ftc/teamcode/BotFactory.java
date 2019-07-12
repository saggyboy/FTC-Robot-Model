package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;

public class BotFactory {
    private static Class chassisType;
    private static String driveMotorType;
    private static double wheelDiameter;
    private static GearRatio driveGearRatio = new GearRatio();
    private static boolean wasDriveGearRatioInitialized = false;

    public static void setChassisType (Class chassisType) {
        if((chassisType.getSuperclass() != Chassis.class) && (chassisType != Chassis.class)) {
            throw new Error("The Chassis you specified is not a subclass of the Chassis Class");
        }
    }

    public static void setDriveMotors (String driveMotorType) {
        if(!MotorHashService.hasMotor(driveMotorType)) {
            throw new Error("MotorHashService does not have data on motor" + driveMotorType + ". Make sure you typed it correctly");
        }
        BotFactory.driveMotorType = driveMotorType;
    }

    public static void setWheelDiameter(double wheelDiameter){//in inches (for now)
        if(wheelDiameter <=0.0) {
            throw new Error("Wheel Diameter should be greater than zero");
        }
        BotFactory.wheelDiameter = Math.abs(wheelDiameter); // no negatives plz
    }

    public static void setDriveGearRatio(int inputTeeth, int outputTeeth){
        if(inputTeeth<1||outputTeeth<1){
            throw new Error("Your gearRatio teeth must be a positive nonzero integer");
        }
        BotFactory.driveGearRatio = new GearRatio(inputTeeth, outputTeeth);
        wasDriveGearRatioInitialized = true;
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

    public static GearRatio getDriveGearRatio (){
        return driveGearRatio;
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
