package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.runtimeterror.aild.databinding.FragmentAlarmBinding
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.viewmodels.AlarmViewModel
import com.runtimeterror.aild.TimePickerUtil
import com.runtimeterror.aild.replaceFragment
import java.util.*


private const val TAG = "AlarmFragment"
private const val ARG_ALARM_ID = "alarm_id"


class AlarmFragment : Fragment() {

    private lateinit var binding: FragmentAlarmBinding
    private lateinit var alarmViewModel: AlarmViewModel
    private var alarmId: UUID? = null
    private var replaceAlarm = false
    private var alarm: Alarm = Alarm()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.getSerializable(ARG_ALARM_ID) != null) {
            alarmId = arguments?.getSerializable(ARG_ALARM_ID) as UUID
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlarmBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        alarmViewModel = ViewModelProvider(this).get(AlarmViewModel::class.java)

        if (alarmId != null) {
            replaceAlarm = true
            alarmViewModel.loadAlarm(alarmId!!)
            alarmViewModel.alarmLiveData.observe(
                viewLifecycleOwner,
                { alarm ->
                    alarm.let {
                        this.alarm = alarm
                        updateUI()
                    }

                }
            )
        }

        binding.buttonDone.setOnClickListener {
            if (replaceAlarm) {
                alarm.let { alarm -> alarmViewModel.saveAlarm(alarm) }
            } else {
                var hour = 0
                if (TimePickerUtil.getTimePickerHour(binding.timePicker) >= 12) {
                    hour = TimePickerUtil.getTimePickerHour(binding.timePicker) - 12
                    alarm.dayHalf = "PM"
                }
                alarm.hour = hour
                alarm.minute = TimePickerUtil.getTimePickerMinute(binding.timePicker)
                alarmViewModel.insertAlarm(alarm)
            }
            setAlarm(alarm)
            replaceFragment(parentFragmentManager, AlarmListFragment())
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher {

            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                // This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                alarm.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
                // This one too
            }
        }
        binding.editTextAlarmTitle.addTextChangedListener(titleWatcher)
    }

    private fun setAlarm(alarm:Alarm){
        //TODO create an alarm intent and wing this bitch

    }
    private fun updateUI() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            binding.timePicker.hour = alarm.hour
            binding.timePicker.minute = alarm.minute
        }
        binding.buttonSound.text = alarm.sound
    }
}