package by.limitAlltheir.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_add_coffee.*

class AddCoffeeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_coffee, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        add_coffee_to_collection.setOnClickListener {
            addToCollection(CoffeeCollection(add_name_coffee.text.toString(),
                add_url_coffee.text.toString(),
                add_price_coffee.text.toString().toDouble()))

            add_name_coffee.text.clear()
            add_url_coffee.text.clear()
            add_price_coffee.text.clear()

            Toast.makeText(context, "Coffee added!", Toast.LENGTH_SHORT).show()
        }
    }
}