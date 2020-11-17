package by.limitAlltheir.myapplication.sensor

import android.content.Context
import android.graphics.Color.GREEN
import android.graphics.Color.RED
import android.hardware.Sensor
import android.hardware.Sensor.TYPE_LIGHT
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import by.limitAlltheir.myapplication.R

class SensorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val lightSensor = sensorManager.getDefaultSensor(TYPE_LIGHT)


        val buttonLight = findViewById<Button>(R.id.button_light)

        buttonLight.setOnClickListener(object : SensorEventListener, View.OnClickListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

            override fun onSensorChanged(event: SensorEvent?) {
                val layoutSensor = findViewById<ConstraintLayout>(R.id.sensor_layout)
                val textLight = findViewById<TextView>(R.id.text_view_light)
                textLight.text = event?.values?.get(0).toString()
                val levelLight = event?.values?.get(0)?.toInt() ?: 0

                if (levelLight >= 300) {
                    layoutSensor.setBackgroundColor(GREEN)
                } else {
                    layoutSensor.setBackgroundColor(RED)
                }
            }

            override fun onClick(v: View?) {
                sensorManager.registerListener(this, lightSensor, 1)
            }

        })




    }
}