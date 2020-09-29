package by.limitAlltheir.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        lifecycle.addObserver(MyLifeCycleObserver(this))

        val myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        myViewModel.minsk_potato.observe(this, Observer {
            minsk_potato.text = it.toString()
        })
        myViewModel.minsk_cabbage.observe(this, Observer {
            minsk_cabbage.text = it.toString()
        })
        myViewModel.minsk_carrot.observe(this, Observer {
            minsk_carrot.text = it.toString()
        })
        myViewModel.brest_potato.observe(this, Observer {
            brest_potato.text = it.toString()
        })
        myViewModel.brest_cabbage.observe(this, Observer {
            brest_cabbage.text = it.toString()
        })
        myViewModel.brest_carrot.observe(this, Observer {
            brest_carrot.text = it.toString()
        })
        myViewModel.pinsk_potato.observe(this, Observer {
            pinsk_potato.text = it.toString()
        })
        myViewModel.pinsk_cabbage.observe(this, Observer {
            pinsk_cabbage.text = it.toString()
        })
        myViewModel.pinsk_carrot.observe(this, Observer {
            pinsk_carrot.text = it.toString()
        })
        myViewModel.nameWinner.observe(this, Observer {
            winner_view.text = it.toString()
        })

        start_harvest_button.setOnClickListener()
        {
            myViewModel.userClicked()
        }


    }
}