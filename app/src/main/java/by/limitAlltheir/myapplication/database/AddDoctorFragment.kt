package by.limitAlltheir.myapplication.database

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.limitAlltheir.myapplication.R
import by.limitAlltheir.myapplication.database.dao.DoctorDao
import by.limitAlltheir.myapplication.database.DoctorDB
import by.limitAlltheir.myapplication.database.Db
import by.limitAlltheir.myapplication.database.entity.Doctor
import by.limitAlltheir.myapplication.database.utils.launchIo
import kotlinx.android.synthetic.main.fragment_add_doctor.*

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

        val db: DoctorDao = Db.getDb(requireContext()).doctorDao()


        btn_add.setOnClickListener {

            val fio = EditTextFIO.text.toString()
            val pos = EditTextPosition.text.toString()
            val cab = EditTextCabinet.text.toString()

            val doctor = Doctor(fio, pos, cab)

            launchIo {
                db.addDoctor(doctor)
            }

            Toast.makeText(requireActivity(), "Doctor has been added", Toast.LENGTH_SHORT).show()
        }
    }
}