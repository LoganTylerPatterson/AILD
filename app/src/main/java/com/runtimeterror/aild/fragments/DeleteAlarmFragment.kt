package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.runtimeterror.aild.adapters.DeleteAlarmListAdapter
import com.runtimeterror.aild.databinding.FragmentDeleteAlarmBinding
import com.runtimeterror.aild.db.entities.Alarm
import com.runtimeterror.aild.util.replaceFragment
import com.runtimeterror.aild.viewmodels.AlarmListViewModel
import com.runtimeterror.aild.viewmodels.AlarmViewModel
import java.util.*

private const val TAG = "DeleteAlarmFragment"
class DeleteAlarmFragment: Fragment() {

    private lateinit var binding: FragmentDeleteAlarmBinding
    private lateinit var adapter: DeleteAlarmListAdapter
    private lateinit var viewModel: AlarmListViewModel
    private lateinit var alarmViewModel: AlarmViewModel
    private var listToDelete = mutableListOf<Alarm>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)
            .get(AlarmListViewModel::class.java)

        alarmViewModel = ViewModelProvider(this)
            .get(AlarmViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDeleteAlarmBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        adapter = DeleteAlarmListAdapter(layoutInflater){
            listToDelete.add(it)
        }
        binding.rvAlarms.layoutManager = LinearLayoutManager(context)
        binding.rvAlarms.adapter = adapter

        binding.buttonCancel.setOnClickListener {
            replaceFragment(parentFragmentManager, AlarmListFragment())
        }

        binding.buttonDelete.setOnClickListener{
            for(item in listToDelete){
                alarmViewModel.deleteAlarm(item)
            }
            replaceFragment(parentFragmentManager, AlarmListFragment())
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
}