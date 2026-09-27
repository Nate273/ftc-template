package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="Telop for Straffer")
public class StrafferTeleOp extends LinearOpMode {
    public Hardware robot;
    @Override
    // when you press init
    public void runOpMode() {
        robot = new Hardware(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            double drive  = -gamepad1.left_stick_y;
            double turn  =  gamepad1.left_stick_x * 1.1;
            double Strafe =  gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(drive) + Math.abs(turn) + Math.abs(Strafe), 1);

            double leftPower  = (drive + turn + Strafe) / denominator;
            double backLeftPower   = (drive - turn + Strafe) / denominator;
            double rightPower = (drive - turn - Strafe) / denominator;
            double backRightPower  = (drive + turn - Strafe) / denominator;

            robot.left.setPower(gamepad1.right_bumper ? leftPower * 0.5: leftPower);
            robot.right.setPower(gamepad1.right_bumper ? rightPower * 0.5: rightPower);
            robot.rightBack.setPower(gamepad1.right_bumper ? backRightPower * 0.5: backRightPower);
            robot.leftBack.setPower(gamepad1.right_bumper ? backLeftPower * 0.5: backLeftPower);
        }
    }
}
