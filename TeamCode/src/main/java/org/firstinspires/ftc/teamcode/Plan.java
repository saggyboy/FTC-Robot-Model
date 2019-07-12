package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import java.util.ArrayList;

public class Plan {
    private ArrayList<PlanElement> plan;

    public Plan (ArrayList<PlanElement> plan) {
        this.plan = plan;
    }
    public Plan () {}

    public void addToPlan(PlanElement element) {
        plan.add(element);
    }

    public PlanElement getFromPlan(int index) {
        return plan.get(index);
    }

    public int planLength() {
        return plan.size();
    }

    public ArrayList<PlanElement> getPlan() {
        return plan;
    }

    public void logPlan(OpMode opMode){
        for(PlanElement i : plan){
            //opMode.telemetry.addData(i);
        }
    }
}
