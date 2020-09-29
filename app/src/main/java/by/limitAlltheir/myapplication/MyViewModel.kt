package by.limitAlltheir.myapplication

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.security.acl.Owner

class MyViewModel : ViewModel() {

    var nameWinner: String = ""

    var minsk_potato = MutableLiveData<Int>(0)
    var pinsk_potato = MutableLiveData<Int>(0)
    var brest_potato = MutableLiveData<Int>(0)
    var minsk_cabbage = MutableLiveData<Int>(0)
    var pinsk_cabbage = MutableLiveData<Int>(0)
    var brest_cabbage = MutableLiveData<Int>(0)
    var minsk_carrot = MutableLiveData<Int>(0)
    var pinsk_carrot = MutableLiveData<Int>(0)
    var brest_carrot = MutableLiveData<Int>(0)

    fun userClicked() {
        CoroutineScope(Dispatchers.IO).launch {
            while (!hasWinner()) {
                delay(1000)
                var m_p = minsk_potato.value
                m_p = m_p?.plus((0..5).random())
                minsk_potato.postValue(m_p)

                var m_cb = minsk_cabbage.value
                m_cb = m_cb?.plus((0..5).random())
                minsk_cabbage.postValue(m_cb)

                var m_cr = minsk_carrot.value
                m_cr = m_cr?.plus((0..5).random())
                minsk_carrot.postValue(m_cr)

                var b_p = brest_potato.value
                b_p = b_p?.plus((0..5).random())
                brest_potato.postValue(b_p)

                var b_cb = brest_cabbage.value
                b_cb = b_cb?.plus((0..5).random())
                brest_cabbage.postValue(b_cb)

                var b_cr = brest_carrot.value
                b_cr = b_cr?.plus((0..5).random())
                brest_carrot.postValue(b_cr)

                var p_p = pinsk_potato.value
                p_p = p_p?.plus((0..5).random())
                pinsk_potato.postValue(p_p)

                var p_cb = pinsk_cabbage.value
                p_cb = p_cb?.plus((0..5).random())
                pinsk_cabbage.postValue(p_cb)

                var p_cr = pinsk_carrot.value
                p_cr = p_cr?.plus((0..5).random())
                pinsk_carrot.postValue(p_cr)
            }
        }
    }

    private fun hasWinner(): Boolean {
        return (minsk_potato.value!! >= 100 && minsk_cabbage.value!! >= 100 && minsk_carrot.value!! >= 100) ||
                (pinsk_potato.value!! >= 100 && pinsk_cabbage.value!! >= 100 && pinsk_carrot.value!! >= 100) ||
                (brest_potato.value!! >= 100 && brest_cabbage.value!! >= 100 && brest_carrot.value!! >= 100)
    }

    private fun whoWinner() {
        if (minsk_potato.value!! >= 100 && minsk_cabbage.value!! >= 100 && minsk_carrot.value!! >= 100) {
            nameWinner = "Minsk"
        } else if (pinsk_potato.value!! >= 100 && pinsk_cabbage.value!! >= 100 && pinsk_carrot.value!! >= 100) {
            nameWinner = "Pinsk"
        } else if (brest_potato.value!! >= 100 && brest_cabbage.value!! >= 100 && brest_carrot.value!! >= 100) {
            nameWinner = "Brest"
        }
    }

    fun showWinner(context: Context) {
        if (hasWinner()) {
            Toast.makeText(context, "$nameWinner WINNER!", Toast.LENGTH_SHORT).show()
        }
    }
}