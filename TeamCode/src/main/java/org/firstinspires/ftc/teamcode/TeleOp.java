
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotorEx;

/*
 * Sample teleop opmode
 */
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="USS Iowa BB-61")

public class TeleOp extends LinearOpMode {

    //Method that gets called when you hit "init" on the drivers hub
    public Hardware robot;
    double TARGET_VELOCITY = 1000;
    @Override
    // when you press init
    public void runOpMode() {
        robot = new Hardware(hardwareMap);
        gamepad2.setTriggerThreshold(.5f);
        // after this line is when the driver presses start
        waitForStart();
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            // Set up a variable for each drive wheel to save power level for telemetry
            double leftPower;
            double rightPower;

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            //double drive = -gamepad1.left_stick_x;
            //double turn = gamepad1.left_stick_y;
            double drive = -gamepad1.right_stick_y;
            double turn = gamepad1.left_stick_x;
            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            robot.left.setPower(gamepad1.right_bumper ? leftPower * 0.5 : leftPower);
            robot.right.setPower(gamepad1.right_bumper ? rightPower * 0.5 : rightPower);

            if(gamepad2.right_stick_y > 0.35){
                robot.claw.setVelocity(gamepad2.right_bumper ? TARGET_VELOCITY * 0.2 : TARGET_VELOCITY);
            } else if (gamepad2.right_stick_y < -0.35){
                robot.claw.setVelocity(gamepad2.right_bumper ? -TARGET_VELOCITY * 0.2 : TARGET_VELOCITY);
            }else{
                robot.claw.setPower(0);
            }
//            double armControl = gamepad2.right_stick_y;
//            double armPower = Range.clip(armControl, -1.0, 1.0);
//            robot.claw.setVelocity(armPower);
//            telemetry.addData("Left target", robot.left.getTargetPosition());
//            telemetry.addData("Claw Target", robot.claw.getTargetPosition());
//            telemetry.addData("Right target", robot.right.getTargetPosition());
//            telemetry.addData("Left current", robot.left.getCurrentPosition());
//            telemetry.addData("Right current", robot.right.getCurrentPosition());
//            telemetry.addData("Claw current", robot.claw.getCurrentPosition());
//            telemetry.update();
        }
    }


    }
