package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Worst Best Auto")

public class auto extends LinearOpMode {
    public hardware robot;
    // when you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new hardware(hardwareMap);
        // intiailizes the motors and servos
        robot.init();
        // when you press play
        waitForStart();
    }
}
