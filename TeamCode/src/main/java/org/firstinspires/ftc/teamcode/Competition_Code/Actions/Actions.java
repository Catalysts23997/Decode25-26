package org.firstinspires.ftc.teamcode.Competition_Code.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.AprilTag;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.ColorSensors;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.LinearSlide;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.RotaryMotor;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.Servo;

public class Actions {
    AprilTag aprilTag;
    ColorSensors sorterColor;
    Servo sorterServo;

    // Motor intake;
    int motif;



    public void update() {
        aprilTag.update();
        sorterServo.update();
        //intake.update;
    }



    public Actions(HardwareMap hardwareMap) {

    }

    public Action CheckMotif = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            motif = aprilTag.getMotif();
            return motif == 0;
        }
    };

    public Action Reset = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            sorterServo.state = Servo.State.HOLD;
            //intake.state = Motor.Stae.Stop
            return false;
        }
    };


    public Action Intake = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            sorterServo.state = Servo.State.HOLD;
            //intake.state = Motor.Stae.Intake
            if(sorterColor.checkForRecognition()){
                return false;
                //intake.state = Motor.Stae.Stop
            }
            else return true;

        }
    };

    public Action Sort = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            /*if(sorterColor.color == purple){
                sorterServo.state = Servo.State.PURPLE;
                return false;
            }
            else if (sorterColor.color == green) {
                sorterServo.state = Servo.State.GREEN;
                return false;
            }
            else return true;

             */
            return false;

        }
    };

    public SequentialAction SortBall = new SequentialAction(Intake, Sort, Reset);

    public Action ShootMotif1 = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };

    public Action ShootMotif2 = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };

    public Action ShootMotif3 = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };

    public Action Endgame = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };
}
