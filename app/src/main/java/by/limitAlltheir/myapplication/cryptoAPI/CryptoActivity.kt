package by.limitAlltheir.myapplication.cryptoAPI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.limitAlltheir.myapplication.R
import by.limitAlltheir.myapplication.cryptoAPI.entity.Rates
import by.limitAlltheir.myapplication.cryptoAPI.mappers.RatesMapper
import by.limitAlltheir.myapplication.cryptoAPI.retrofit.RetrofitFactory
import by.limitAlltheir.myapplication.database.utils.launchIo
import by.limitAlltheir.myapplication.database.utils.launchUi
import kotlinx.android.synthetic.main.activity_crypto.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CryptoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto)

        val retrofit = RetrofitFactory().getRetrofit()
        val cryptoAdapter = CryptoAdapter()

        recycler_view.apply {
            adapter = cryptoAdapter
            layoutManager = LinearLayoutManager(this@CryptoActivity)
            hasFixedSize()
        }

        launchIo {

            val response = retrofit.getRatesAsync(1, 10, "USD").await()

            if (response.isSuccessful) {

                val ratesResponse = response.body()
                val rates = ratesResponse?.dataList?.map {
                    RatesMapper().map(it)
                }
                launchUi {
                    cryptoAdapter.setList(rates)
                }
            } else {
                launchUi {
                    Toast.makeText(this@CryptoActivity, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}