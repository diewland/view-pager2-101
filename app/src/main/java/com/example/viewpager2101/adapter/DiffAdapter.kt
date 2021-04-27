package com.example.viewpager2101.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2101.R
import com.example.viewpager2101.diff.DiffCallback

const val TAG = "DIFF_ADAPTER"

class DiffAdapter(context: Context, tvList: ArrayList<TextView>, viewPager2: ViewPager2):
    RecyclerView.Adapter<DiffAdapter.ViewHolder>() {

    private val mInflater: LayoutInflater
    private val data: ArrayList<TextView>
    private val viewPager2: ViewPager2

    init {
        mInflater = LayoutInflater.from(context)
        data = tvList
        this.viewPager2 = viewPager2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_blank, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Log.d(TAG, "remove old views and add view number $position")

        holder.container.removeAllViews() // when update items, remove old items first
        holder.container.addView(data.get(position))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder internal constructor(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        var container: LinearLayout
        init {
            container = itemView.findViewById(R.id.blank_container)
        }
    }

    // hilight function <3
    fun updateItems(newData: ArrayList<TextView>) {
        val callback = DiffCallback(data, newData)
        val diffResult = DiffUtil.calculateDiff(callback)

        data.clear()
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }
}