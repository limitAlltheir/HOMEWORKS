package by.limitAlltheir.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.core.widget.addTextChangedListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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

    private fun successRegistration() {
        MaterialAlertDialogBuilder(this)
            .setTitle(resources.getString(R.string.title))
            .setIcon(getDrawable(R.drawable.ic_outline_person_24))
            .setMessage(resources.getString(R.string.supporting_text))
            .setNeutralButton(resources.getString(R.string.cancel)) { dialog, which ->
                dialog.cancel()
            }
            .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                intent = Intent(this, SignInActivity::class.java)
            }
            .show()
    }
}

