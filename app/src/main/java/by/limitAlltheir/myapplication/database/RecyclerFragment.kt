package by.limitAlltheir.myapplication.database

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.limitAlltheir.myapplication.R
import by.limitAlltheir.myapplication.database.dao.DoctorDao
import by.limitAlltheir.myapplication.database.DoctorDB
import by.limitAlltheir.myapplication.database.Db
import by.limitAlltheir.myapplication.database.entity.Doctor
import by.limitAlltheir.myapplication.database.utils.launchForResult
import by.limitAlltheir.myapplication.database.utils.launchIo
import by.limitAlltheir.myapplication.database.utils.launchUi
import kotlinx.android.synthetic.main.fragment_recycler.*

class RecyclerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val db: DoctorDao = Db.getDb(requireActivity()).doctorDao()

        val rv = recycler_container

        launchIo {
            launchForResult {
                val result: List<Doctor> = db.getAllDoctors()

                launchUi {
                    val adapter = DoctorAdapter(result)
                    rv.adapter = adapter
                    rv.layoutManager = LinearLayoutManager(requireActivity())
                    rv.hasFixedSize()
                    adapter.setList(result)
                    EditTextSearch.addTextChangedListener(object : TextWatcher {
                        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

                        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                            adapter.setList(EditTextSearch.text.toString(), result)
                        }

                        override fun afterTextChanged(s: Editable) {}
                    })
                }
            }
        }

        button_add.setOnClickListener {
            val nav1 = findNavController()
            nav1.navigate(R.id.action_recyclerFragment_to_addDoctorFragment)
        }

    }
}