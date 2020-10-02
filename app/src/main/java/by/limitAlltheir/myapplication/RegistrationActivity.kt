package by.limitAlltheir.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        edit_text.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                edit_text.isEnabled = true
                edit_text.error = "Name mustn't be empty!"
            } else
                edit_text.error = null
        }
        edit_password.addTextChangedListener {
            when {
                it.isNullOrEmpty() -> {
                    edit_password.isEnabled = true
                    edit_password.error = "Password mustn't be empty!"
                }
                it.length in 1..7 -> {
                    edit_password.isEnabled = true
                    edit_password.error = "Password must be more then 8 symbols!"
                }
                else -> edit_password.error = null
            }
        }
    }
}