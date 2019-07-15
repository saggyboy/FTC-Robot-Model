package edu.ahs.robotics;

import org.firstinspires.ftc.robotcontroller.internal.FtcOpModeRegister;
import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;

import java.util.HashMap;

public class MecanumChassis extends Chassis {

    private HashMap<MotorLocations, String> deviceNames;

    private DriveUnit frontLeft;
    private DriveUnit frontRight;
    private DriveUnit backLeft;
    private DriveUnit backRight;

    public void execute(PlanElement planElement){
        if (planElement instanceof ForwardMotion) {
            motionInterpreter((ForwardMotion)planElement);
        }
        else if (planElement instanceof ArcMotion){
            motionInterpreter((ArcMotion)planElement);
        }
        else {
            throw new Warning("Couldn't find a way to execute Planelement " + planElement.toString());
        }
    }

    public MecanumChassis() {
        deviceNames = BotFactory.getDriveMotorDeviceNames();

        frontLeft = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(),deviceNames.get(MotorLocations.FRONTLEFT) ,BotFactory.getDriveMotorType()); // input over output gear ratio
        frontRight = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.FRONTRIGHT), BotFactory.getDriveMotorType());
        backLeft = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.BACKLEFT), BotFactory.getDriveMotorType());
        backRight = new DriveUnit(BotFactory.getDriveGears(), BotFactory.getWheelDiameter(), deviceNames.get(MotorLocations.BACKRIGHT), BotFactory.getDriveMotorType());

        frontLeft.init();
        frontRight.init();
        backLeft.init();
        backRight.init();
    }



    private void motionInterpreter(ForwardMotion forwardMotion) {

        frontLeft.zeroDistance();
        frontRight.zeroDistance();
        backLeft.zeroDistance();
        backRight.zeroDistance();

        double encoderAverage = 0;

        FTCUtilities.OpSleep(10000);

        while(encoderAverage<forwardMotion.travelDistance){
            encoderAverage = (frontRight.getDistance() + frontLeft.getDistance() + backRight.getDistance()+ backLeft.getDistance())/4;
            //FTCUtilities.OpLogger("EncoderAverage", encoderAverage);
            frontRight.setPower(forwardMotion.motorPower);
            frontLeft.setPower(forwardMotion.motorPower);
            backRight.setPower(forwardMotion.motorPower);
            backLeft.setPower(forwardMotion.motorPower);
        }
        //throw new Warning("you done");
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);

    }

    private void motionInterpreter(ArcMotion arcMotion){

    }


}
