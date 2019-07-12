package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MecanumChassis extends Chassis {

    private HashMap<MotorLocations, String> deviceNames = BotFactory.getDriveMotorDeviceNames();

    private DriveUnit frontLeft = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(),deviceNames.get(MotorLocations.FRONTLEFT) ,BotFactory.getDriveMotorType()); // input over output gear ratio
    private DriveUnit frontRight = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.FRONTRIGHT), BotFactory.getDriveMotorType());
    private DriveUnit backLeft = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.BACKLEFT), BotFactory.getDriveMotorType());
    private DriveUnit backRight = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.BACKRIGHT), BotFactory.getDriveMotorType());

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
            FTCUtilities.OpLogger("EncoderAverage", encoderAverage);
        }

        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);

    }

}
