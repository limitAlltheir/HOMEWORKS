package by.limitAlltheir.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_in.*

private const val USERNAME_KEY = "username"

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val user = intent.getStringExtra(USERNAME_KEY)
        username_sign_in_view.text = "Hello, $user"
    }
}