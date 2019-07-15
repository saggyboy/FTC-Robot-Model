package edu.ahs.robotics;

import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;

public abstract class Chassis implements Executor{

    public Chassis(){
    }
    public abstract void execute(PlanElement planElement);

}
