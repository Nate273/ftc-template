
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

/*
 * Sample teleop opmode
 */
@TeleOp(name="Nathan's wOrk")

public class Teleop extends LinearOpMode {

    //Method that gets called when you hit "init" on the drivers hub
    public hardware robot;
    @Override
    // when you press init
    public void runOpMode() {
        robot = new hardware(hardwareMap);
        robot.init();
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
            double drive = -gamepad1.right_stick_y;
            double turn  =  gamepad1.left_stick_x;
            leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            robot.left.setPower(leftPower);
            robot.right.setPower(rightPower);

            if (gamepad2.square){
                robot.openClaw();
            }
            if (gamepad2.triangle){
                robot.closeCLaw();
            }
            if (gamepad2.right_bumper){
                robot.claw.setPower(-0.5);
            }
            if (gamepad2.right_trigger_pressed){
                robot.claw.setPower(0.5);
            }
            if(gamepad1.right_trigger_pressed){
                robot.rotater.setPower(0.2);
            }
            if (gamepad1.right_bumper){
                robot.rotater.setPower(-0.2);
            }
        }
    }


    }
