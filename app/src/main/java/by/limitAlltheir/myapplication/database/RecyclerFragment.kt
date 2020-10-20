package by.limitAlltheir.myapplication.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.limitAlltheir.myapplication.R
import kotlinx.android.synthetic.main.fragment_recycler.*

class RecyclerFragment : Fragment() {

    val adapter = DoctorAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val rv = recycler_container
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this.context)
        rv.hasFixedSize()

    }
}