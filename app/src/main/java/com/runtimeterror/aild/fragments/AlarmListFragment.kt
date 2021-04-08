package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.runtimeterror.aild.R
import com.runtimeterror.aild.databinding.FragmentAlarmListBinding
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.util.cancelAlarm
import com.runtimeterror.aild.util.getDateString
import com.runtimeterror.aild.util.replaceFragment
import com.runtimeterror.aild.util.setAlarm
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
        Log.d(TAG, "OnStart Called")
        viewModel.alarmListLiveData.observe(
            viewLifecycleOwner,
            { alarms ->
                alarms?.let {
                    updateUI(alarms)
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    private fun updateUI(alarms: List<Alarm>) {
        adapter.let {
            Log.d(TAG, "AlarmList is ${alarms.size}")
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
            bind(holder, position)
        }

        /**
         *All this does is not make my onBind so damn messy
         */
        private fun bind(holder: AlarmViewHolder, position: Int) {
            val alarm = alarmList[position]

            //Formats that damn date string
            holder.timeTextView.text = getDateString(
                alarmList[position].hour,
                alarmList[position].minute
            )

            //Gets am/pm text, and sets the title under the alarm time and meridian
            holder.alarmTitle.text = alarmList[position].title
            holder.amTextView.text = alarmList[position].dayHalf

            //Handles whether to show the auto dismiss text and box
            if(!alarm.autoOff){
                holder.autoDismissCheckBox.visibility = View.GONE
                holder.textViewDismiss.visibility = View.GONE
            }else{
                holder.autoDismissCheckBox.isChecked =true
                holder.autoDismissCheckBox.visibility = View.VISIBLE
            }

            //Sets whether the alarm is active or not
            holder.activeSwitch.isChecked = alarmList[position].active
            holder.id = alarmList[position].id

            //If the user clicks on the view,
            //We will display the alarm details
            holder.itemView.setOnClickListener {
                val frag = AlarmFragment()
                val args = Bundle()
                args.putSerializable(ARG_ALARM_ID, holder.id)
                frag.arguments = args
                replaceFragment(parentFragmentManager, frag)
            }

            //If the user clicks the active switch we will turn off the alarm
            holder.activeSwitch.setOnClickListener{
                if(alarm.active){
                    holder.activeSwitch.isActivated = false
                    cancelAlarm(alarm, context)
                }else{
                    setAlarm(alarm, context)
                }
            }

        }
    }

    /**
     * My bitchin viewHolder class
     */
    inner class AlarmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val alarmTitle = view.findViewById<TextView>(R.id.text_view_title)
        val timeTextView = view.findViewById<TextView>(R.id.time_text_view)
        val deletCheckbox = view.findViewById<CheckBox>(R.id.check_delete)
        val amTextView = view.findViewById<TextView>(R.id.am_text_view)
        val textViewDismiss = view.findViewById<TextView>(R.id.text_view_dismiss)
        val activeSwitch: SwitchCompat = view.findViewById(R.id.switch_on)
        val autoDismissCheckBox = view.findViewById<CheckBox>(R.id.checkbox_auto_off)
        var id: Int = 0
    }

    /**
     * Sets up my bitchin options menu, should also add a settings probably
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_trash -> replaceFragment(parentFragmentManager, DeleteAlarmFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * Inflates my bitchin options menu
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //Have to clear the menu so shit doesnt get duplicated
        menu.clear()
        inflater.inflate(R.menu.menu_alarm_list, menu)
    }


}