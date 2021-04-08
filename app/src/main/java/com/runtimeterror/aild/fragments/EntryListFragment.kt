package com.runtimeterror.aild.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.runtimeterror.aild.adapters.EntryListAdapter
import com.runtimeterror.aild.databinding.FragmentEntryListBinding
import com.runtimeterror.aild.db.entities.Journal
import com.runtimeterror.aild.util.replaceFragment
import com.runtimeterror.aild.viewmodels.EntryListViewModel

class EntryListFragment: Fragment() {

    private lateinit var binding: FragmentEntryListBinding
    private lateinit var adapter: EntryListAdapter
    private lateinit var entryListViewModel: EntryListViewModel
    private lateinit var entryList: List<Journal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Instantiate our viewModels
        entryListViewModel = ViewModelProvider(this)
            .get(EntryListViewModel::class.java)

        //Instantiate the list of journals
        entryList = entryListViewModel.journalListLiveData.value ?: emptyList()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Instantiate the binding object and inflate the view
        binding = FragmentEntryListBinding.inflate(inflater, container, false)

        //Instantiate our adapters
        adapter = EntryListAdapter(entryList, layoutInflater)

        //Hook up our RecyclerView
        binding.rvEntries.layoutManager = LinearLayoutManager(context)
        binding.rvEntries.adapter = adapter

        //Handle onClickListener for FAB, go to EntryFragment for creation
        binding.fabEntry.setOnClickListener {
            replaceFragment(parentFragmentManager, EntryFragment())
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }
}