package edu.ahs.robotics;

import org.firstinspires.ftc.robotcore.internal.android.dx.util.Warning;

/**
 * THe Chassis class is the superclass for all chassis types
 */
public abstract class Chassis implements Executor{

    public Chassis(){
    }
    public abstract void execute(PlanElement planElement);

}
