package by.limitAlltheir.myapplication

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_cat.*

class CatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat)

        imageViewCat.setBackgroundResource(R.drawable.cat_animation)
        val anim = imageViewCat.background as AnimationDrawable
        anim.start()
    }
}