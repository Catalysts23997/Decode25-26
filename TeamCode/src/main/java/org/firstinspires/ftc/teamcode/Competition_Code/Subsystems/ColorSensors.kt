package org.firstinspires.ftc.teamcode.Competition_Code.Subsystems

import com.qualcomm.robotcore.hardware.ColorSensor
import com.qualcomm.robotcore.hardware.DistanceSensor
import com.qualcomm.robotcore.hardware.HardwareMap
import com.qualcomm.robotcore.hardware.NormalizedColorSensor
import org.firstinspires.ftc.robotcore.external.JavaUtil
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit
import android.graphics.Color


class ColorSensors(hwMap: HardwareMap, name: String) {

    val hsvValues = FloatArray(3)

    private val colorSensor: ColorSensor =
        hwMap.get(ColorSensor::class.java, name)

    fun checkForRecognition(): Boolean {

        //right sensor
        (colorSensor as NormalizedColorSensor).gain = 2f
        val normalizedColors = (colorSensor as NormalizedColorSensor).normalizedColors
        val color = normalizedColors.toColor()
        val value = JavaUtil.colorToValue(color)

        val inside =
            ((colorSensor as DistanceSensor).getDistance(DistanceUnit.CM) < 7) && value >= .05

        return inside
    }

    fun isGreen(): Boolean {
        Color.RGBToHSV(
            (colorSensor.red() * 255) / 800,
            (colorSensor.green() * 255) / 800,
            (colorSensor.blue() * 255) / 800,
            hsvValues
        )

        val hue = hsvValues[0]

        return  hue in 100f..140f
    }

    fun isPurple(): Boolean {
        Color.RGBToHSV(
            (colorSensor.red() * 255) / 800,
            (colorSensor.green() * 255) / 800,
            (colorSensor.blue() * 255) / 800,
            hsvValues
        )

        val hue = hsvValues[0]

        return hue in 250f..290f
    }

}