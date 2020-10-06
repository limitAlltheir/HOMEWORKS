package by.limitAlltheir.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var rightPassword = false
        var rightUsername = false

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        edit_text.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                edit_text.isEnabled = true
                edit_text.error = "Name mustn't be empty!"
            } else {
                edit_text.error = null
                rightUsername = true
            }
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
                else -> {
                    edit_password.error = null
                    rightPassword = true
                }
            }
        }
        registration_user_btn.setOnClickListener {
            if (rightPassword && rightUsername) {
                successRegistration()
            } else {
                unsuccessRegistration()
            }
        }
    }

    private fun successRegistration() {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.title))
            .setIcon(getDrawable(R.drawable.ic_outline_person_24))
            .setMessage(resources.getString(R.string.supporting_text))
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .setPositiveButton(resources.getString(R.string.accept)) { _, _ ->
                intent = Intent(this, SignInActivity::class.java)
            }
            .show()
    }

    private fun unsuccessRegistration() {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.title))
            .setIcon(getDrawable(R.drawable.ic_outline_person_24))
            .setMessage(resources.getString(R.string.supporting_text_error))
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }
}

