package by.limitAlltheir.myapplication.fibonacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import by.limitAlltheir.myapplication.R

class FibonacciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibanachi)

        val fibTV = findViewById<TextView>(R.id.fibonacci_tv)
        val fibBtn = findViewById<Button>(R.id.button_fibonacci)
        val fibET = findViewById<EditText>(R.id.fibonacci_et)

        fibBtn.setOnClickListener {
            if (fibET.text.isNotEmpty()) {
                fibTV.text = fibonacci(fibET.text.toString().toInt()).toString()
            }
        }

    }

    fun fibonacci(n: Int): Int {

        return when (n) {
            0 -> {
                0
            }
            1 -> {
                1
            }
            else -> fibonacci(n - 1) + fibonacci(n - 2)
        }
    }
}