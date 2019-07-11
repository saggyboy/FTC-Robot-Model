package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumChassis extends Chassis {

    DriveUnit frontLeft = new DriveUnit(1.0/1.0, 4.0, "frontLeft",BotFactory.getDriveMotorType()); // input over output gear ratio
    DriveUnit frontRight = new DriveUnit(1.0/1.0, 4.0, "frontRight", BotFactory.getDriveMotorType());
    DriveUnit backLeft = new DriveUnit(1.0/1.0, 4.0, "backLeft", BotFactory.getDriveMotorType());
    DriveUnit backRight = new DriveUnit(1.0/1.0, 4.0, "backRight", BotFactory.getDriveMotorType());

    public MecanumChassis() {
    }
}
