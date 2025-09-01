package org.firstinspires.ftc.teamcode.Competition_Code.Auto.OpModes;

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.roadrunner.Action
import com.acmerobotics.roadrunner.ParallelAction
import com.acmerobotics.roadrunner.SequentialAction
import com.acmerobotics.roadrunner.ftc.runBlocking
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode

import org.firstinspires.ftc.teamcode.Competition_Code.Actions.ExampleActions
import org.firstinspires.ftc.teamcode.Competition_Code.Auto.AutoPoints
import org.firstinspires.ftc.teamcode.Competition_Code.Auto.RunToExactForever
import org.firstinspires.ftc.teamcode.Competition_Code.Subsystems.Drivetrain
import org.firstinspires.ftc.teamcode.Competition_Code.PinpointLocalizer.Localizer
import org.firstinspires.ftc.teamcode.Competition_Code.Utilities.Poses

@Autonomous(name = "ExampleAuto", group = "Auto")
class ExampleAuto : LinearOpMode() {

    companion object{
        var rT = Poses(-19.0,-66.0,0.0)
    }

    override fun runOpMode() {
        telemetry = FtcDashboard.getInstance().telemetry
        ExampleAuto.rT = Poses(-19.0,-66.0,0.0)

        val localizer = Localizer(hardwareMap, rT)
        val drive = Drivetrain(hardwareMap)
        val robot = ExampleActions(hardwareMap)

        localizer.update()
        robot.update()

        waitForStart()

        runBlocking(
            ParallelAction(
                Action {
                    localizer.update()
                    RunToExactForever(rT)
                    telemetry.addData("hello", ExampleAuto.rT)
                    telemetry.addData("df", Localizer.pose.heading)
                    telemetry.addData("x", Localizer.pose.x)
                    telemetry.addData("y", Localizer.pose.y)
                    telemetry.update()
                    robot.update()
                    true
                },
                SequentialAction(
                    robot.example,
                    AutoPoints.Pos1Y.runToExact,
                    AutoPoints.GotoSample1Y.runToExact,
                    AutoPoints.PushtoSample1Y.runToExact,
                    AutoPoints.GotoSample1Y.runToExact,
                    AutoPoints.GotoSample2Y.runToExact,
                    robot.example,
                    AutoPoints.PushtoSample2Y.runToExact,
                    AutoPoints.GotoSample2Y.runToExact,
                    AutoPoints.GotoSample3Y.runToExact,
                    AutoPoints.PushtoSample3Y.runToExact,
                    AutoPoints.GotoSample1Y.runToExact,
                    AutoPoints.YEnd.runToExact

                )
            )
        )

    }
}
