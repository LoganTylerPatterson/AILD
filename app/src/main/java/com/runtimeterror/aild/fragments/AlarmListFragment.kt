package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.text.SpannableStringBuilder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.TimePicker
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.runtimeterror.aild.replaceFragment
import com.runtimeterror.aild.R
import com.runtimeterror.aild.TimePickerUtil
import com.runtimeterror.aild.databinding.FragmentAlarmListBinding
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.getDateString
import com.runtimeterror.aild.viewmodels.AlarmListViewModel
import java.util.*


private const val TAG = "AlarmListFragment"
private const val ARG_ALARM_ID = "alarm_id"

class AlarmListFragment : Fragment() {

    private lateinit var binding: FragmentAlarmListBinding
    private var adapter: AlarmListAdapter = AlarmListAdapter(emptyList())
    private lateinit var viewModel: AlarmListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)
            .get(AlarmListViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        //Instantiate binding object and inflate layout
        binding = FragmentAlarmListBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        binding.rvAlarms.layoutManager = LinearLayoutManager(context)
        binding.rvAlarms.adapter = adapter

        //Set up floating action button
        binding.fabAlarm.setOnClickListener {
            replaceFragment(parentFragmentManager, AlarmFragment())
        }

        return view
    }

    override fun onStart() {
        super.onStart()
        viewModel.alarmListLiveData.observe(
                viewLifecycleOwner,
                { alarms ->
                    alarms?.let {
                        updateUI(alarms)
                    }
                }
        )
    }

    private fun updateUI(alarms: List<Alarm>) {
        adapter.let {
            it.alarmList = alarms
        }
        binding.rvAlarms.adapter = adapter
    }

    inner class AlarmListAdapter(var alarmList: List<Alarm>) :
            RecyclerView.Adapter<AlarmViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.alarm_item_view, parent, false)
            return AlarmViewHolder(view)
        }

        override fun getItemCount(): Int {
            return alarmList.size
        }

        override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
            holder.timeTextView.text = getDateString(
                alarmList[position].hour,
                alarmList[position].minute
            )
            holder.alarmTitle.text = alarmList[position].title
            holder.amTextView.text = alarmList[position].dayHalf
            holder.amTextView.text = alarmList[position].dayHalf
            holder.activeSwitch.isChecked = alarmList[position].active
            holder.autoDismissCheckBox.isChecked = alarmList[position].autoOff
            holder.id = alarmList[position].id

            holder.itemView.setOnClickListener{
                val frag = AlarmFragment()
                val args = Bundle()
                args.putSerializable(ARG_ALARM_ID, holder.id)
                frag.arguments = args
                replaceFragment(parentFragmentManager, frag)
            }
        }
    }

    inner class AlarmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val alarmTitle = view.findViewById<TextView>(R.id.text_view_title)
        val timeTextView = view.findViewById<TextView>(R.id.time_text_view)
        val amTextView = view.findViewById<TextView>(R.id.am_text_view)
        val textView = view.findViewById<TextView>(R.id.text_view_dismiss)
        val activeSwitch: SwitchCompat = view.findViewById(R.id.switch_on)
        val autoDismissCheckBox = view.findViewById<CheckBox>(R.id.checkbox_auto_off)
        var id: UUID? = null
    }


}