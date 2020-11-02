package by.limitAlltheir.myapplication.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.limitAlltheir.myapplication.R
import by.limitAlltheir.myapplication.database.entity.Doctor
import kotlinx.android.synthetic.main.item.view.*

class DoctorAdapter(private var listDoctor: List<Doctor>) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    class DoctorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val docItem = view.doctor_item
        val docName = view.view_fio
        val docPos = view.view_prof
        val docCab = view.view_room
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return DoctorViewHolder(view)
    }

    override fun getItemCount(): Int = listDoctor.size

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {

        holder.docItem.visibility = View.VISIBLE
        holder.docName.text = listDoctor[position].name
        holder.docPos.text = listDoctor[position].position
        holder.docCab.text = listDoctor[position].cabinet
    }

    fun setList(s: String, list: List<Doctor>) {
        listDoctor = if (s.isEmpty()) {
            list
        } else {
            list.filter {
                it.name.contains(s, true) || it.position.contains(s, true) || it.cabinet.contains(s, true)
            } as ArrayList
        }
        notifyDataSetChanged()
    }

    fun setList(list: List<Doctor>) {
        listDoctor = list as ArrayList
        notifyDataSetChanged()
    }
}