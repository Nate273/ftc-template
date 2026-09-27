
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Telop for non-Straffer")

public class TeleOp extends LinearOpMode {
    public Hardware robot;
    @Override
    // when you press init
    public void runOpMode() {
        robot = new Hardware(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {
            double leftPower;
            double rightPower;


            double drive = -gamepad1.right_stick_y;
            double turn = gamepad1.left_stick_x;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            robot.left.setPower(gamepad1.right_bumper ? leftPower * 0.5 : leftPower);
            robot.right.setPower(gamepad1.right_bumper ? rightPower * 0.5 : rightPower);

        }
    }


    }
