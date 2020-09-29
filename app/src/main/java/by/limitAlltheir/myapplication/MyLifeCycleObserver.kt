package by.limitAlltheir.myapplication

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class MyLifeCycleObserver(val context: Context) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun showPause() {
        Toast.makeText(context, "Harvest is piling up", Toast.LENGTH_SHORT).show()
    }
}