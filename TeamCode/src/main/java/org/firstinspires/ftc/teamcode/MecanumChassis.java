package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.lang.reflect.Method;

public class MecanumChassis extends Chassis {

    DriveUnit frontLeft = new DriveUnit(BotFactory.getDriveGearRatio(), BotFactory.getWheelDiameter(), "frontLeft",BotFactory.getDriveMotorType()); // input over output gear ratio
    DriveUnit frontRight = new DriveUnit(BotFactory.getDriveGearRatio(), BotFactory.getWheelDiameter(), "frontRight", BotFactory.getDriveMotorType());
    DriveUnit backLeft = new DriveUnit(BotFactory.getDriveGearRatio(), BotFactory.getWheelDiameter(), "backLeft", BotFactory.getDriveMotorType());
    DriveUnit backRight = new DriveUnit(BotFactory.getDriveGearRatio(), BotFactory.getWheelDiameter(), "backRight", BotFactory.getDriveMotorType());

    public MecanumChassis() {
    }

    public void motionInterpreter(ForwardMotion forwardMotion) {
        frontLeft.zeroDistance();
        frontRight.zeroDistance();
        backLeft.zeroDistance();
        backRight.zeroDistance();

        double encoderAverage = 0;

        frontRight.setPower(forwardMotion.motorPower);
        frontLeft.setPower(forwardMotion.motorPower);
        backRight.setPower(forwardMotion.motorPower);
        backLeft.setPower(forwardMotion.motorPower);

        while(encoderAverage<forwardMotion.travelDistance){
            encoderAverage = (frontRight.getDistance() + frontLeft.getDistance() + backRight.getDistance()+ backLeft.getDistance())/4;
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);

    }

}
