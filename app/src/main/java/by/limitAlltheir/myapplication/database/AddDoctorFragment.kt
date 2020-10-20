package by.limitAlltheir.myapplication.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import by.limitAlltheir.myapplication.R
import by.limitAlltheir.myapplication.database.dao.DoctorDao
import by.limitAlltheir.myapplication.database.DoctorDB
import by.limitAlltheir.myapplication.database.Db

class AddDoctorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_doctor, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val db: DoctorDao = Db.getDb(this.requireContext()).doctorDao()

    }
}