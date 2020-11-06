package by.limitAlltheir.myapplication.cryptoAPI

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.limitAlltheir.myapplication.R
import by.limitAlltheir.myapplication.cryptoAPI.entity.Rates
import kotlinx.android.synthetic.main.crypto_item.view.*

class CryptoAdapter() : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    var cryptoList = ArrayList<Rates>()

    class CryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(rates: Rates) {

            with(itemView) {
                name_view.text = rates.name
                price_view.text = rates.price.toString()
                change_view.text = rates.change.toString()
                if (rates.change < 0.0) {
                    change_view.setTextColor(Color.RED)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_item, parent, false)
        return CryptoViewHolder(view)
    }

    override fun getItemCount() = cryptoList.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(cryptoList[position])
    }

    fun setList(list: List<Rates>?) {

        cryptoList = list as ArrayList<Rates>
        notifyDataSetChanged()
    }
}