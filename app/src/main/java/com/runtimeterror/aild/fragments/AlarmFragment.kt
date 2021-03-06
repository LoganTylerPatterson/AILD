package com.runtimeterror.aild.fragments

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.runtimeterror.aild.*
import com.runtimeterror.aild.databinding.FragmentAlarmBinding
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.recievers.AlarmBroadCastReciever
import com.runtimeterror.aild.util.TimePickerUtil
import com.runtimeterror.aild.util.replaceFragment
import com.runtimeterror.aild.util.setAlarm
import com.runtimeterror.aild.viewmodels.AlarmViewModel
import java.util.*


private const val TAG = "AlarmFragment"
private const val ARG_ALARM_ID = "alarm_id"

class AlarmFragment : Fragment() {

    private lateinit var binding: FragmentAlarmBinding
    private lateinit var alarmViewModel: AlarmViewModel
    private var alarmId: Int? = null
    private var replaceAlarm = false
    private var alarm: Alarm = Alarm()
    private var soundIsPlaying = false
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var spinnerAdapter: ArrayAdapter<CharSequence>
    private var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments?.getSerializable(ARG_ALARM_ID) != null) {
            alarmId = arguments?.getInt(ARG_ALARM_ID)
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

        /**
         * Sets up the stupid spinner
         */
        this.context?.let {
            spinnerAdapter = ArrayAdapter.createFromResource(
                it,
                R.array.sound_array,
                android.R.layout.simple_spinner_item
            )
            spinnerAdapter.also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                //Apply the adapter to the spinner
                binding.buttonSound.adapter = it
            }
        }

        /**
         * This is the onClicklistener for the sound spinner!
         */
        binding.buttonSound.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (parent?.selectedItem) {
                    "BetterDays" -> {
                        alarm.sound = R.raw.betterdays
                    }
                    "OnceAgain" -> {
                        alarm.sound = R.raw.onceagain

                    }
                    "SlowMotion" -> {
                        alarm.sound = R.raw.slowmotion
                    }
                    "Tomorrow" -> {
                        alarm.sound = R.raw.tomorrow
                    }
                }
                value = parent?.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        /**
         * Sets the data depending on whether or not this alarm was selected from the list
         * or is a brand new alarm
         */
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

        /**
        This handles the play samples sound button, the alarm.sound contains the Res id of the sound
         **/
        binding.buttonPlayTest.setOnClickListener {
            if (soundIsPlaying) {
                mediaPlayer.stop()
                soundIsPlaying = false
                binding.buttonPlayTest.text = getString(R.string.test_alarmsound)
                return@setOnClickListener
            } else {
                mediaPlayer = MediaPlayer.create(context, alarm.sound)
                mediaPlayer.start()
                soundIsPlaying = true
                binding.buttonPlayTest.text = getString(R.string.stop)
                return@setOnClickListener
            }

        }

        /**
         * If the setAutoDismiss button gets checked, update the alarm
         * and to display the seconds editText
         */
        binding.checkBoxAutoDismiss.setOnClickListener {
            if(binding.checkBoxAutoDismiss.isChecked){
                alarm.autoOff = true
                binding.groupDismissSeconds.visibility = View.VISIBLE
            } else{
                alarm.autoOff = false
                binding.groupDismissSeconds.visibility = View.GONE
            }
        }

        /**
         * The onClickListener to set the duration for an alarm's autodismiss
         */
        binding.editTextAdseconds.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
               //Dont do shit
            }

            override fun onTextChanged(sequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //same
            }

            override fun afterTextChanged(sequence: Editable?) {
                alarm.autoOffDuration = Integer.parseInt(sequence.toString())
                Log.e(TAG, "autoOffDuration is ${alarm.autoOffDuration}")
            }

        })



        /**
         * This sets the alarm and the onClickListener on the done button
         */
        binding.buttonDone.setOnClickListener {
            //If replaceAlarm is true just update it in the db and set the alarm
            if (replaceAlarm) {
                alarm.let { alarm -> alarmViewModel.updateAlarm(alarm) }
            } else {
                if (TimePickerUtil.getTimePickerHour(binding.timePicker) >= 12) {
                    alarm.dayHalf = "PM"
                }
                alarm.hour = TimePickerUtil.getTimePickerHour(binding.timePicker)
                alarm.minute = TimePickerUtil.getTimePickerMinute(binding.timePicker)
                alarmViewModel.insertAlarm(alarm)
            }
            setAlarm(alarm, context)
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

    /**
     * Sets the different components to the data in the selected alarm
     */
    private fun updateUI() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            binding.timePicker.hour = alarm.hour
            binding.timePicker.minute = alarm.minute
            binding.editTextAlarmTitle.text = SpannableStringBuilder(alarm.title)
            //TODO yayaya get this done binding.buttonSound.
        }
    }
}