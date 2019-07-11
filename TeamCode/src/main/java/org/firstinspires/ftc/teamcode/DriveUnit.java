package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveUnit {

    private double gearRatio = 1.0/1.0;
    private double wheelDiameter = 4; // in inches
    private final double wheelCircumference = wheelDiameter * Math.PI;
    DcMotor motor;
    HardwareMap hardwareMap = FTCUtilities.getHardwareMap(); //retreive current OpMode's hardwareMap
    String deviceName;
    String motorName;
    private double ticksPerRotation =  MotorHashService.getTicks(motorName);

    public DriveUnit(double gearRatio, double wheelDiameter, String deviceName, String motorName) {
        this.gearRatio = gearRatio;  // input over output gear ratio
        this.wheelDiameter = wheelDiameter;
        this.deviceName = deviceName;
        this.motorName = motorName;
    }

    public void init(){
        motor = hardwareMap.get(DcMotor.class, deviceName);

    }

    public void setPower(double motorPower){
        if (Math.abs(motorPower) > 1) {
            throw new Error("DriveUnit motorPower is not between 1 and -1");
        }
        motor.setPower(motorPower);
    }

    public void zeroDistance(){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public double getDistance (){
        double rotations = motor.getCurrentPosition()/ticksPerRotation;
        double rotationsAfterGears = rotations*gearRatio;
        double inchesTraveled = wheelCircumference * rotationsAfterGears;
        return inchesTraveled;
    }

}


