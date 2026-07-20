package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Worst Best Auto")

public class Auto extends LinearOpMode {
    public double ticksperInch = 0;
    public double ticksperDegree = 0;
    public Hardware robot;
    // when you press init
    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Hardware(hardwareMap);
        // intiailizes the motors and servos
        // when you press play
        waitForStart();


        Foward(.65);

        turn(-.65);

        turnencoderversion(1,20);
    }
    public void turn(double power){
        robot.right.setPower(power);
        robot.left.setPower(-power);
        sleep(50);
        robot.left.setPower(0);
        robot.right.setPower(0);

    }
    public void Foward(double power){
        robot.right.setPower(power);
        robot.left.setPower(power);
        sleep(2500);
        robot.left.setPower(0);
        robot.right.setPower(0);
    }
    public void forwardencoderversion(double power, double inches){
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksperInch);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }
    public void turnencoderversion(double power, double inches){
        robot.left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        int ticks = (int) (inches * ticksperDegree);

        robot.left.setTargetPosition(ticks);
        robot.right.setTargetPosition(-ticks);

        robot.left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.left.setPower(power);
        robot.right.setPower(power);
    }
}
