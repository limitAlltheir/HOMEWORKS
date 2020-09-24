package by.limitAlltheir.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hw3.*

class Hw3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw3)

        buttonFlags.setOnClickListener {
            val myIntent = Intent(this, FlagsActivity::class.java)
            startActivity(myIntent)
        }

        buttonCat.setOnClickListener {
            val myIntent = Intent(this, CatActivity::class.java)
            startActivity(myIntent)
        }
    }
}