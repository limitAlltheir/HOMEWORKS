package by.limitAlltheir.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_coffee.*
import kotlinx.android.synthetic.main.fragment_add_coffee.add_coffee_to_collection
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        floating_action_button.setOnClickListener {
            val nav1 = findNavController()
            nav1.navigate(R.id.action_mainFragment_to_addCoffeeFragment)
        }

        show_collection_button.setOnClickListener {
            val nav2 = findNavController()
            nav2.navigate(R.id.action_mainFragment_to_showCollectionFragment)
        }
    }


}

