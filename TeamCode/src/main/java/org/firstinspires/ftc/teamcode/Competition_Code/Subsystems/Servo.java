package org.firstinspires.ftc.teamcode.Competition_Code.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;


public class Servo {

    public com.qualcomm.robotcore.hardware.Servo servo;
    public State state = State.HOLD;

    public Servo(HardwareMap hardwareMap){
        servo = hardwareMap.get(com.qualcomm.robotcore.hardware.Servo.class, "port4");
    }

    public void update(){
        servo.setPosition(state.servoPos);
    }

    public enum State {
        HOLD(1.0),
        PURPLE(.85),
        GREEN(0.0),
        LAUNCHP(0.0),
        LAUNCHG(0.0),
        HOLDP(0.0),
        HOLDG(0.0);
        public final double servoPos;
        State(double servoPos) {
            this.servoPos = servoPos;
        }
    }


}
