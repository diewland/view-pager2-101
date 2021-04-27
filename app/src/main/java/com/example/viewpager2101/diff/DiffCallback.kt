package com.example.viewpager2101.diff

import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil

class DiffCallback(
    oldItems: ArrayList<TextView>,
    newItems: ArrayList<TextView>
): DiffUtil.Callback() {

    private val oldItems = oldItems
    private val newItems = newItems

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val old = oldItems[oldItemPosition]
        val new = newItems[newItemPosition]
        return old.text.toString().equals(new.text.toString())
    }

}