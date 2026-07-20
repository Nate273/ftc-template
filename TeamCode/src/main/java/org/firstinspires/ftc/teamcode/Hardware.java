package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    // 192.168.43.1
    public DcMotor left;
    public DcMotor right;
    public DcMotorEx claw;
    public Servo clearwater;
    public DcMotor rotater;
    public Servo rotaterServo;
    public Servo clawServo;
    public double clawClose = .3;
    public double clawOpen = .7;
    public Hardware(HardwareMap hwMap){
        // Drive motors
        left = hwMap.get(DcMotor.class, "leftMotor");
        right = hwMap.get(DcMotor.class, "RightMotor");
        rotater = hwMap.get(DcMotor.class, "rotater");
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
        // servo
        clearwater = hwMap.get(Servo.class, "clearwater");
        rotaterServo = hwMap.get(Servo.class, "waterclear");
        clawServo = hwMap.get(Servo.class, "clamper");
    }

    }

