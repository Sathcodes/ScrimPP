package org.firstinspires.ftc.teamcode.teamcodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "teleOp")
public class TeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        DriveTrain drivetrain = new DriveTrain(this);
        Mechanisms mech = new Mechanisms(this);

        mech.initMechanisms(hardwareMap);
        drivetrain.initDriveTrain(hardwareMap);

        telemetry.addData("Status", "Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        while (opModeIsActive()) {

            double y = -gamepad1.left_stick_y; // Forward/back
            double x = gamepad1.left_stick_x;  // Strafe
            double rx = gamepad1.right_stick_x; // Rotation


            double deadzone = 0.05;
            if (Math.abs(y) < deadzone) y = 0;
            if (Math.abs(x) < deadzone) x = 0;
            if (Math.abs(rx) < deadzone) rx = 0;


            y = 0.2 * Math.pow(y, 3) + 0.8 * y;
            x = 0.2 * Math.pow(x, 3) + 0.8 * x;
            rx = 0.2 * Math.pow(rx, 3) + 0.8 * rx;


            double magnitude = Math.sqrt(y * y + x * x);
            if (magnitude > 1) {
                y /= magnitude;
                x /= magnitude;
            }


            double speedModifier = 1.0;
            String modeName = "Normal";
            if (gamepad1.right_bumper) {
                speedModifier = 0.5;
                modeName = "Precision";
            }

            y *= speedModifier;
            x *= speedModifier;
            rx *= speedModifier;


            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            drivetrain.frontLeft.setPower(frontLeftPower);
            drivetrain.frontRight.setPower(frontRightPower);
            drivetrain.backLeft.setPower(backLeftPower);
            drivetrain.backRight.setPower(backRightPower);

            telemetry.addData("Drive Mode", modeName);
            telemetry.addData("y (forward/back)", y);
            telemetry.addData("x (strafe)", x);
            telemetry.addData("rx (rotate)", rx);
            telemetry.update();

            if (gamepad2.right_trigger > 0.1)
            {
                mech.Intake();
            }


            if (gamepad2.left_trigger > 0.1)
            {
                mech.Outtake();
            }

            else {
                mech.StopIntake();
                mech.StopOuttake();

            }


        }
    }
}
