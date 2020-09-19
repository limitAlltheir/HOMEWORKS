package by.limitAlltheir.myapplication

import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hw1.*

class hw1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw1)

        buttonLoad.setOnClickListener {
            var url = editText.text.toString()
            val pic = Picasso.get()
            pic.isLoggingEnabled = true
            pic.load(url).into(this.imageView)
        }
    }
}