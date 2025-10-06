package org.firstinspires.ftc.teamcode.teamcodes;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

public class DriveTrain {

    public DcMotor frontLeft; //0
    public DcMotor backLeft; //1
    public DcMotor frontRight; //2
    public DcMotor backRight; //3
    public IMU imu;


    private ElapsedTime runtime = new ElapsedTime();

    LinearOpMode opMode;

    public DriveTrain(LinearOpMode op) {
        opMode = op;
    }

    public void initDriveTrain(HardwareMap hardwareMap) {
        // imu tomfoolery
//        imu = hardwareMap.get(IMU.class, "imu"); // Match the name in the configuration
//        IMU.Parameters parameters = new IMU.Parameters(
//                new RevHubOrientationOnRobot(
//                        RevHubOrientationOnRobot.LogoFacingDirection.LEFT,  // Logo facing backward
//                        RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD         // USB ports facing up
//                )
//        );
//        imu.initialize(parameters);

        frontLeft = hardwareMap.get(DcMotor.class, "leftFront");
        backLeft = hardwareMap.get(DcMotor.class, "leftBack");
        frontRight = hardwareMap.get(DcMotor.class, "rightFront");
        backRight = hardwareMap.get(DcMotor.class, "rightBack");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        frontRight.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        backLeft.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));
        backRight.setZeroPowerBehavior((DcMotor.ZeroPowerBehavior.BRAKE));

        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);


    }
}
