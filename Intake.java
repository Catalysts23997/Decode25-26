package org.firstinspires.ftc.teamcode.Competition_Code.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    /// This value controls how fast the motors will be spinning
    ///
    /// TODO: Maybe make it so that the motor speed can be changed while the code is running?
    public static final double MOTOR_SPEED = 1;

    ///  The current state of the intake system
    public State state;

    /// The first intake motor
    DcMotor intake1;
    /// The second intake motor
    DcMotor intake2;

    /// Declare a new instance of the intake system.
    ///
    /// # Only one instance should be active at a given time!
    public Intake(HardwareMap hardwareMap) {
        // Assign the physical motor to our variable
        intake1 = hardwareMap.get(DcMotor.class, "intake1");
        // Make sure we know the default state of our motor
        intake1.setDirection(DcMotorSimple.Direction.FORWARD);
        intake1.setPower(0);

        // Assign the physical motor to our variable
        intake2 = hardwareMap.get(DcMotor.class, "intake2");
        // Make sure we know the default state of our motor
        intake2.setDirection(DcMotorSimple.Direction.FORWARD);
        intake2.setPower(0);
    }

    // Helper functions to make setting the state a little more convenient
    ///  Set the current state of the intake system
    public void setState(State state) {
        this.state = state;
    }

    // Allows the intake to be toggled using a boolean, so the parent class doesn't
    // need to keep track of the current state in any way
    /// Set the current state of the intake system with a boolean.
    ///
    /// @param shouldIntake If true, the intake motors will be spinning. If false, they will stop.
    public void setState(boolean shouldIntake) {
        if (shouldIntake) this.state = State.INTAKING;
        else this.state = State.STOPPED;
    }

    ///  Tick the intake system
    public void update() {
        switch (state) {
            case INTAKING: doIntake();
            case STOPPED: stopIntake();
        }
    }

    ///  Make motors spin
    private void doIntake() {
        intake1.setDirection(DcMotorSimple.Direction.FORWARD);
        intake1.setPower(MOTOR_SPEED);
        intake2.setDirection(DcMotorSimple.Direction.REVERSE);
        intake2.setPower(MOTOR_SPEED);
    }

    /// Make motors stop
    private void stopIntake() {
        intake1.setPower(0);
        intake2.setPower(0);
    }

    /// This enum contains every state that the intake system can be in.
    ///
    /// Fields:
    /// - INTAKING: The intake motors will **spin**
    /// - STOPPED: The intake motors will **stop**
    public enum State {
        ///  Make motors spin
        INTAKING,
        /// Make motors stop
        STOPPED
    }
}
