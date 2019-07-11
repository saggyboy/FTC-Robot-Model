package org.firstinspires.ftc.teamcode;

public class BotFactory {
    private static Class chassisType;
    private static String driveMotorType;
    private static double wheelDiameter;

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

    public static Class getChassisType (){
        return chassisType;
    }

    public static double getWheelDiameter () {
        return wheelDiameter;
    }

    public static String getDriveMotorType () {
        return driveMotorType;
    }



    public static boolean isFullyConfigured(){
        boolean chassis, driveMotors, wheels; // are these things configured?
        chassis = chassisType != null;
        driveMotors = driveMotorType != null;
        wheels = wheelDiameter != 0;

        return chassis && driveMotors && wheels;
    }

    private BotFactory(){} // no constructo statico

}
