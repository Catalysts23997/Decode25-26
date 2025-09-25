package org.firstinspires.ftc.teamcode.Competition_Code.Tele.Testing;

import com.qualcomm.robotcore.eventloop.opmode.*;

import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.Launcher;

@TeleOp(name = "Launcher_test")
public class Launcher_test extends LinearOpMode {
    Launcher launcher;
    double speed = 0;

    @Override
    public void runOpMode() {
        // makes a Launcher named launcher, needs hardwareMap because class expects it
        launcher = new Launcher(hardwareMap);
        waitForStart();

        while (opModeIsActive()) {
            if(gamepad1.y){
                speed += 0.2;
                launcher.setSpeed(speed);
            }
            if(gamepad1.a){
                speed -= 0.2;
                launcher.setSpeed(speed);
            }
            if(gamepad1.b){
                launcher.stop();
            }

        }
    }
}
