package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MecanumChassis extends Chassis {

    private HashMap<MotorLocations, String> deviceNames;

    private DriveUnit frontLeft;
    private DriveUnit frontRight;
    private DriveUnit backLeft;
    private DriveUnit backRight;

    public MecanumChassis() {
        deviceNames = BotFactory.getDriveMotorDeviceNames();

        frontLeft = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(),deviceNames.get(MotorLocations.FRONTLEFT) ,BotFactory.getDriveMotorType()); // input over output gear ratio
        frontRight = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.FRONTRIGHT), BotFactory.getDriveMotorType());
        backLeft = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.BACKLEFT), BotFactory.getDriveMotorType());
        backRight = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.BACKRIGHT), BotFactory.getDriveMotorType());
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
            FTCUtilities.OpLogger("EncoderAverage", encoderAverage);
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);

    }

}
