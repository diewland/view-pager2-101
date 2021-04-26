package com.example.viewpager2101

import android.content.Context
import androidx.viewpager2.widget.ViewPager2
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.viewpager2101.R
import android.widget.TextView
import android.widget.RelativeLayout

class ViewPagerAdapter internal constructor(
    context: Context?,
    data: List<String>,
    viewPager2: ViewPager2
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    private val mData: List<String>
    private val mInflater: LayoutInflater
    private val viewPager2: ViewPager2
    private val colorArray = intArrayOf(
        android.R.color.black,
        android.R.color.holo_blue_dark,
        android.R.color.holo_green_dark,
        android.R.color.holo_red_dark
    )

    init {
        mInflater = LayoutInflater.from(context)
        mData = data
        this.viewPager2 = viewPager2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.item_viewpager, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = mData[position]
        holder.myTextView.text = animal
        holder.relativeLayout.setBackgroundResource(colorArray[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var myTextView: TextView
        var relativeLayout: RelativeLayout
        var button: Button

        init {
            myTextView = itemView.findViewById(R.id.tvTitle)
            relativeLayout = itemView.findViewById(R.id.container)
            button = itemView.findViewById(R.id.btnToggle)
            button.setOnClickListener {
                viewPager2.orientation = when(viewPager2.orientation) {
                    ViewPager2.ORIENTATION_HORIZONTAL -> ViewPager2.ORIENTATION_VERTICAL
                    else -> ViewPager2.ORIENTATION_HORIZONTAL
                }
            }
        }
    }

}