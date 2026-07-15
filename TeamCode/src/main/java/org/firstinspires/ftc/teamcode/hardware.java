package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class hardware {
    public DcMotor left;
    public DcMotor right;
    public DcMotor claw;
    public Servo clw;
    public double clawClose = .3;
    public double clawOpen = .7;
    public hardware(HardwareMap hwMap){
        // Drive motors
        left = hwMap.get(DcMotor.class, "leftMotor");
        right = hwMap.get(DcMotor.class, "RightMotor");

        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        // servos and motors
        clw = hwMap.get(Servo.class, "clw");
        claw = hwMap.get(DcMotor.class, "Claw");
    }

    public void init(){
        closeCLaw();
    }
    public void openClaw(){
        clw.setPosition(clawClose);
    }
    public void closeCLaw(){
        clw.setPosition(clawOpen);
    }
}
