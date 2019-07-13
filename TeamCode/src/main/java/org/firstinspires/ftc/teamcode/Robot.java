
package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;

public class Robot {

    private Plan plan;
    Chassis chassis;

    public Robot(Chassis chassis){
        this.chassis = chassis;
    }

    public void init(){

        if(FTCUtilities.getHardwareMap() == null) { // Throw an error if the user forgets to set the hardwareMap in OpMode
            throw new Error("HardwareMap not found in Robot. use the FTCUtilities.setHardwareMap() method in OpMode");
        }

        if(!BotFactory.isFullyConfigured()) {
            throw new Error("You haven't fully configured your robot");
        }
        FTCUtilities.OpSleep(10000);
        if (BotFactory.getChassisType() == MecanumChassis.class){
            chassis = new MecanumChassis();
        }
    }

    public void givePlan (Plan plan) {
        this.plan = plan;
    }

    public void execute() {
        ArrayList<PlanElement> plan = this.plan.getPlan();
        for (PlanElement element : plan) {
            if(element.getClass() == Motion.class){
                try {
                    chassis.getMotion(element);
                } catch(Exception e){}
            }
        }
    }

}



