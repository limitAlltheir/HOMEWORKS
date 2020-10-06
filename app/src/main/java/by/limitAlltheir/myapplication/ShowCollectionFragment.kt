package by.limitAlltheir.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_show_collection.*

class ShowCollectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_collection, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        for (i in sortsOfCoffee) {
            addCoffeeToCollection(i)
        }
    }

    private fun addCoffeeToCollection(cc: CoffeeCollection) {
        val item = ConstraintLayout(context)
        val myImageView = ImageView(context).apply {
            id = View.generateViewId()
            layoutParams = ViewGroup.LayoutParams(300, 300)
        }
        Picasso.get().load(cc.url).into(myImageView)
        val nameTextView = TextView(context).apply {
            id = View.generateViewId()
            text = cc.name
            textSize = 30f
        }
        val priceTextView = TextView(context).apply {
            id = View.generateViewId()
            text = "${cc.price.toString()}$"
            textSize = 20f
        }
        with(item){
            addView(myImageView)
            addView(nameTextView)
            addView(priceTextView)
        }
        val set = ConstraintSet()
        set.constrainWidth(ConstraintSet.PARENT_ID, container.width)
        set.clone(item)
        set.connect(myImageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 16)
        set.connect(myImageView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 16)
        set.connect(nameTextView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 16)
        set.connect(nameTextView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 16)
        set.connect(priceTextView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 16)
        set.connect(priceTextView.id, ConstraintSet.TOP, nameTextView.id, ConstraintSet.BOTTOM, 16)
        set.applyTo(item)
        container.addView(item)

    }
}