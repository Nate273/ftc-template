package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class hardware {
    // 193.168.43.1
    public DcMotor left;
    public DcMotor right;
    public DcMotor claw;
    public Servo clw;
    public DcMotor rotater;
    public double clawClose = .3;
    public double clawOpen = .7;
    public hardware(HardwareMap hwMap){
        // Drive motors
        left = hwMap.get(DcMotor.class, "leftMotor");
        right = hwMap.get(DcMotor.class, "RightMotor");
        rotater = hwMap.get(DcMotor.class, "da rotater");
        claw = hwMap.get(DcMotor.class, "Claw");

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rotater.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        claw.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rotater.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        claw.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rotater.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        claw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // servos and motors
        clw = hwMap.get(Servo.class, "clw");
    }

    public void init(){
        openClaw();
    }
    public void openClaw(){
        clw.setPosition(clawClose);
    }
    public void closeCLaw(){
        clw.setPosition(clawOpen);
    }
    public void righturn(){
        right.setPower(-.65);
        left.setPower(.65);
    }
}
