package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.renderscript.ScriptGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.runtimeterror.aild.R
import com.runtimeterror.aild.db.entities.Alarm

private const val TAG = "AlarmListFragment"

class AlarmListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm_list, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                AlarmListFragment()
    }

    class AlarmListAdapter(private val alarmList: List<Alarm>):
            RecyclerView.Adapter<AlarmListAdapter.AlarmViewHolder>(){

        class AlarmViewHolder(view: View): RecyclerView.ViewHolder(view){
            //TODO place all the textViews and Images here - find by id

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
            TODO("Not yet implemented")
        }

        override fun getItemCount(): Int {
            TODO("Not yet implemented")
        }

        override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
            TODO("Not yet implemented")
        }
    }
}