package org.firstinspires.ftc.teamcode.Competition_Code.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.AprilTag;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.ColorSensors;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.Servo;

public class Actions {
    AprilTag aprilTag;
    ColorSensors sorterColor;
    Servo sorter;
    Servo purpleLaunch;
    Servo greenLaunch;

    // Motor launch;
    // Motor intake;

    //apriltag will dictate the motif number
    public int motif;



    public void update() {
        aprilTag.update();
        sorter.update();
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
            sorter.state = Servo.State.HOLD;
            //intake.state = Motor.State.Stop
            return false;
        }
    };


    public Action Intake = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            sorter.state = Servo.State.HOLD;
            //intake.state = Motor.State.Intake
            if(sorterColor.checkForRecognition()){
                return false;
                //intake.state = Motor.State.Stop
            }
            else return true;

        }
    };

    public Action Sort = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            /*if(sorterColor.color == purple){
                sorter.state = Servo.State.PURPLE;
                return false;
            }
            else if (sorterColor.color == green) {
                sorter.state = Servo.State.GREEN;
                return false;
            }
            else return true;

             */
            return false;

        }
    };

    public SequentialAction SortBall = new SequentialAction(Intake, Sort, Reset);

    public Action ShootGreen = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };

    public Action ShootPurple = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };

    public SequentialAction ShootMotif1 = new SequentialAction(ShootGreen, ShootPurple, ShootPurple, Reset);

    public SequentialAction ShootMotif2 = new SequentialAction(ShootPurple, ShootGreen, ShootPurple, Reset);

    public SequentialAction ShootMotif3 = new SequentialAction(ShootPurple, ShootPurple, ShootGreen, Reset);

    public Action Endgame = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            //stuff
            return false;
        }
    };
}
