package org.firstinspires.ftc.teamcode.teamcodes;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLStatus;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import javax.xml.transform.Result;

public class Mechanisms {



    public DriveTrain driveTrain;

    public DcMotor intakeMotor;

    public DcMotor outtakeMotor;

    private final LinearOpMode opMode;

    public Mechanisms(LinearOpMode op) {
        this.opMode = op;

    }

    public void initMechanisms(HardwareMap hardwareMap) {
        driveTrain = new DriveTrain(opMode);
        driveTrain.initDriveTrain(hardwareMap);
        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");
        outtakeMotor = hardwareMap.get(DcMotor.class,"outtakeMotor");
    }

    public void Intake() {
        intakeMotor.setPower(-0.85);
    }

    public void Outtake() {
        outtakeMotor.setPower(0.85);

    }

    public void StopIntake() {
        intakeMotor.setPower(0);
    }

    public void StopOuttake() {
        outtakeMotor.setPower(0);
    }
}






