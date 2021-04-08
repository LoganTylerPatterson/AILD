package com.runtimeterror.aild.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.runtimeterror.aild.R
import com.runtimeterror.aild.db.entities.Journal

class EntryListAdapter(var list: List<Journal>, private val inflater: LayoutInflater): RecyclerView.Adapter<EntryListAdapter.EntryViewHolder>() {

    inner class EntryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.text_view_title)
        val date = itemView.findViewById<TextView>(R.id.text_view_date)
        val tags = itemView.findViewById<TextView>(R.id.text_view_tags)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val view = inflater.inflate(R.layout.journal_item_view, parent, false)
        return EntryViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        val entry = list[position]
        holder.title.text = entry.title
        holder.date.text = entry.date.toString() //TODO need to change this to be formated to a date
        holder.tags.text = entry.tags.toString() //TODO need to format this as well with pretty little commas and shit
    }

    override fun getItemCount(): Int {
        return list.size
    }
}