package com.kuhu.tablayout.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kuhu.tablayout.R

class PagerAdapter(private val context: Context, private val titleList: List<String>) :
    RecyclerView.Adapter<PagerAdapter.PageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageHolder =
        PageHolder(
            LayoutInflater.from(context).inflate(R.layout.item_layout_view_pager, parent, false)
        )

    override fun onBindViewHolder(holder: PageHolder, position: Int) {
        holder.textView.text = titleList[position]
    }

    override fun getItemCount(): Int = titleList.size

    inner class PageHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<TextView>(R.id.title)
    }
}