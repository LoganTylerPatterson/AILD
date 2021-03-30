package com.runtimeterror.aild.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.runtimeterror.aild.R
import com.runtimeterror.aild.databinding.AlarmItemViewBinding
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.fragments.AlarmFragment
import com.runtimeterror.aild.fragments.AlarmListFragment
import com.runtimeterror.aild.getDateString
import com.runtimeterror.aild.replaceFragment
import java.util.*

class DeleteAlarmListAdapter(
    var layoutInflater: LayoutInflater,
    var alarmList: List<Alarm> = emptyList(),
    var onItemClicked: (Alarm) -> Unit
) : RecyclerView.Adapter<DeleteAlarmListAdapter.AlarmViewHolder>() {

    inner class AlarmViewHolder(view: View, onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
        val alarmTitle = view.findViewById<TextView>(R.id.text_view_title)
        val timeTextView = view.findViewById<TextView>(R.id.time_text_view)
        val deleteCheckbox = view.findViewById<CheckBox>(R.id.check_delete)
        val amTextView = view.findViewById<TextView>(R.id.am_text_view)
        val autoDismissText = view.findViewById<TextView>(R.id.text_view_dismiss)
        val activeSwitch: SwitchCompat = view.findViewById(R.id.switch_on)
        val autoDismissCheckBox = view.findViewById<CheckBox>(R.id.checkbox_auto_off)
        var id: UUID? = null

        init{
            view.setOnClickListener{
                deleteCheckbox.isChecked = true
                onItemClicked(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = layoutInflater.inflate(R.layout.alarm_item_view, parent, false)
        return AlarmViewHolder(view){
            onItemClicked(alarmList[it])
        }
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        bind(holder, position)
    }

    override fun getItemCount(): Int {
        return alarmList.size
    }

    private fun bind(holder: AlarmViewHolder, position: Int) {
        holder.timeTextView.text = getDateString(
            alarmList[position].hour,
            alarmList[position].minute
        )
        holder.id = alarmList[position].id
        holder.alarmTitle.text = alarmList[position].title
        holder.amTextView.text = alarmList[position].dayHalf
        holder.activeSwitch.visibility = View.GONE
        holder.autoDismissCheckBox.visibility = View.GONE
        holder.autoDismissText.visibility = View.GONE
        holder.deleteCheckbox.visibility = View.VISIBLE
        holder.id = alarmList[position].id

//        holder.itemView.setOnClickListener {
//            holder.deleteCheckbox.isChecked = true
//        }
    }
}