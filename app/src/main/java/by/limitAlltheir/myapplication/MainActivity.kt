package by.limitAlltheir.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            val myIntent = Intent(this, hw1Activity::class.java)
            startActivity(myIntent)
        }
        button2.setOnClickListener {
            val myIntent = Intent(this, Hw3Activity::class.java)
            startActivity(myIntent)
        }
    }
}