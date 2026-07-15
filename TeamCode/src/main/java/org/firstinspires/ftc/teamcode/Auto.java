package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Worst Best Auto")

public class Auto extends LinearOpMode {
    public Hardware robot;
    // when you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        // intiailizes the motors and servos
        robot.init();
        // when you press play
        waitForStart();


        Foward(.65);


        robot.closeCLaw();

        turn(-.65);

    }
    public void turn(double power){
        robot.right.setPower(power);
        robot.left.setPower(-power);
        sleep(500);
        robot.left.setPower(0);
        robot.right.setPower(0);

    }
    public void Foward(double power){
        robot.right.setPower(power);
        robot.left.setPower(power);
        sleep(1000);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }
}
