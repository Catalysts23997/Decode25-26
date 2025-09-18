package org.firstinspires.ftc.teamcode.Competition_Code.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.AprilTag;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.ColorSensors;
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.Servo;

public class Comp1Actions {
    AprilTag aprilTag;
    Servo holder;
    ColorSensors outtake;

    // Motor launch;
    // Motor intake;

    //apriltag will dictate the motif number
    public int motif;

    //TODO() Need to make motor subsystem, find Servo values, and get a color sensor to check purple/green. Also make tests


    public void update() {
        aprilTag.update();
        holder.update();
        //intake.update();
        //launch.update():

    }



    public Comp1Actions(HardwareMap hardwareMap) {
        aprilTag = new AprilTag(hardwareMap);
        holder = new Servo(hardwareMap, "port1");
        outtake = new ColorSensors(hardwareMap);
        // launch = new Motor(hardwareMap);
        // intake = new Motor(hardwareMap);
    }

    public Action CheckMotif = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {
            motif = aprilTag.getMotif();
            return motif == 0;
        }
    };


    public Action Intake = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            return false;

        }
    };


    public Action Shoot = new Action() {
        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            return false;
        }
    };

}
