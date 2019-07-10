package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveUnit {

    double gearRatio = 0;
    double wheelDiameter = 4;
    DcMotor motor;
    HardwareMap hardwareMap;
    String deviceName;

    public DriveUnit(double gearRatio, double wheelDiameter, String deviceName, HardwareMap hardwareMap) {
        this.gearRatio = gearRatio; // This is the gear ratio
        this.wheelDiameter = wheelDiameter;
        this.hardwareMap = hardwareMap;
        this.deviceName = deviceName;
    }

    public void init(){
        motor = hardwareMap.get(DcMotor.class, deviceName);

    }

    public void setPower(double motorPower){


    }

    public void zeroDistance(){


    }

    public void getDistance (){


    }

}


