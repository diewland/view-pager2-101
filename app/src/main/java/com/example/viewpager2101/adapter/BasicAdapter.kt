package com.example.viewpager2101.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isNotEmpty
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2101.R

class BasicAdapter(context: Context, tvList: ArrayList<TextView>, viewPager2: ViewPager2):
    RecyclerView.Adapter<BasicAdapter.ViewHolder>() {

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
        if(holder.container.isNotEmpty()) return
        val t = data.get(position)
        holder.container.addView(t)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder internal constructor(itemView: View):
        RecyclerView.ViewHolder(itemView) {

        var container: LinearLayout

        init {
            container = itemView.findViewById(R.id.blank_container)
            /*
            myTextView = itemView.findViewById(R.id.tvTitle)
            relativeLayout = itemView.findViewById(R.id.container)
            button = itemView.findViewById(R.id.btnToggle)
            button.setOnClickListener {
                viewPager2.orientation = when(viewPager2.orientation) {
                    ViewPager2.ORIENTATION_HORIZONTAL -> ViewPager2.ORIENTATION_VERTICAL
                    else -> ViewPager2.ORIENTATION_HORIZONTAL
                }
            }
            */
        }
    }

}