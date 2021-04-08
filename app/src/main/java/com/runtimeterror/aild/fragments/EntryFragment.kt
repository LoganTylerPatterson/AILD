package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.runtimeterror.aild.R
import com.runtimeterror.aild.databinding.FragmentEntryBinding
import com.runtimeterror.aild.db.entities.Journal
import com.runtimeterror.aild.util.replaceFragment
import com.runtimeterror.aild.viewmodels.EntryViewModel


private const val JOURNAL_ID = "journal_id"
class EntryFragment : Fragment() {

    private lateinit var binding: FragmentEntryBinding
    private lateinit var entryViewModel: EntryViewModel
    private lateinit var entry: Journal
    private var entryId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instantiate our viewModels
        entryViewModel = ViewModelProvider(this)
            .get(EntryViewModel::class.java)

        //If fab was clicked, just create a new journal
        //If list item was clicked, the id was passed here and we need to pass the appropriate data
        if(arguments?.getInt(JOURNAL_ID) == null){
            entry = Journal()
        }else{
            entryId = arguments?.getInt(JOURNAL_ID)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Create binding object
        binding = FragmentEntryBinding.inflate(inflater, container, false)

        //Create view

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_alarm_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_trash -> replaceFragment(parentFragmentManager, AlarmFragment())
        //TODO delete fragment for journal entries
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveEntryText(){
        //TODO Need to figure out the file manager
    }

}
