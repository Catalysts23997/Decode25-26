package org.firstinspires.ftc.teamcode.Competition_Code.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    /// This value controls how fast the motor will be spinning.
    ///
    /// TODO: Maybe make it so that the motor speed can be changed while the code is running?
    public static final double MOTOR_SPEED = 1;

    ///  The current state of the intake system
    public State state = State.STOPPED;

    /// The intake motor
    DcMotor intake;

    /// Declare a new instance of the intake system.
    ///
    /// # Only one instance should be active at a given time!
    public Intake(HardwareMap hardwareMap) {
        // Assign the physical motor to our variable
        intake = hardwareMap.get(DcMotor.class, "intake");
        // Make sure we know the default state of our motor
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        intake.setPower(0);
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
    /// @deprecated This function shouldn't be used, as it assumes you want to set the state to intaking, not reverse.
    /// @param shouldIntake If true, the intake motors will be spinning. If false, they will stop.
    public void setState(boolean shouldIntake) {
        if (shouldIntake) this.state = State.INTAKING;
        else this.state = State.STOPPED;
    }

    ///  Tick the intake system
    public void update() {
        switch (state) {
            case INTAKING: doIntake();
            case REVERSE: doReverse();
            case STOPPED: stopIntake();
        }
    }

    ///  Make motor spin
    private void doIntake() {
        intake.setDirection(DcMotorSimple.Direction.FORWARD);
        intake.setPower(MOTOR_SPEED);
    }

    ///  Make motor spin in reverse
    private void doReverse() {
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        intake.setPower(MOTOR_SPEED);
    }

    /// Make motor stop
    private void stopIntake() {
        intake.setPower(0);
    }

    /// This enum contains every state that the intake system can be in.
    ///
    /// Fields:
    /// - INTAKING: The intake motor will **spin**
    /// - STOPPED: The intake motor will **stop**
    public enum State {
        ///  Make motors spin
        INTAKING,
        /// Reverse the motors
        REVERSE,
        /// Make motors stop
        STOPPED
    }
}
