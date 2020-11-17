package by.limitAlltheir.myapplication.sensor

import android.content.Context
import android.graphics.Color
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_LIGHT
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import by.limitAlltheir.myapplication.R

class SensorActivity : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(TYPE_LIGHT)


        val buttonLight = findViewById<Button>(R.id.button_light)

        buttonLight.setOnClickListener {

            sensorManager.registerListener(this, lightSensor, 1)
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        val layoutSensor = findViewById<ConstraintLayout>(R.id.sensor_layout)
        val textLight = findViewById<TextView>(R.id.text_view_light)
        textLight.text = event?.values?.get(0).toString()

        if (event?.values?.get(0)?.toInt()!! >= 300) {
            layoutSensor.setBackgroundColor(GREEN)
        } else {
            layoutSensor.setBackgroundColor(RED)
        }
    }
}