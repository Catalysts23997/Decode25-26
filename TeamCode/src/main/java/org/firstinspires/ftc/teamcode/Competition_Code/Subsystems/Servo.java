package org.firstinspires.ftc.teamcode.Competition_Code.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;


public class Servo {

    int age = 16;
    double height = 6.25;
    String name = "John";
    Boolean isCool = true;


    public com.qualcomm.robotcore.hardware.Servo servo;
    public ClawState clawState = ClawState.CLOSED;

    public Servo(HardwareMap hardwareMap){
        servo = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "port4");
    }

    public void update(){
        servo.setPosition(clawState.servoPos);

        int factorial = 1;
        for (int i = 1; i<10; i++){
            factorial = factorial * i;
        }
    }

    public enum ClawState {
        CLOSED(1.0),
        OPEN(.85);
        public final double servoPos;
        ClawState(double servoPos) {
            this.servoPos = servoPos;
        }
    }


}
