package com.example.viewpager2101

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2101.adapter.BasicAdapter
import com.example.viewpager2101.adapter.DiffAdapter

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2
    lateinit var btn1: Button
    lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager2)
        btn1 = findViewById(R.id.btn_1)
        btn2 = findViewById(R.id.btn_2)

        // init data
        val list = arrayListOf(
            "First Screen",
            "Second Screen",
            "Third Screen",
            "Fourth Screen",
        )
        var tvList = buildList(list)

        // init pager adapter
        // viewPager2.adapter = ViewPagerAdapter(this, list, viewPager2)
        // viewPager2.adapter = BasicAdapter(this, tvList, viewPager2)
        // updateData(tvList)
        val diffAdapter = DiffAdapter(this, tvList, viewPager2)
        viewPager2.adapter = diffAdapter

        // bind buttons
        btn1.setOnClickListener {
            // updateData("one", "two", "three")
            diffAdapter.updateItems(buildList(listOf( "one", "two", "three" )))
        }
        btn2.setOnClickListener {
            // updateData("apple", "microsoft", "google")
            diffAdapter.updateItems(buildList(listOf( "apple", "microsoft", "google" )))
        }
    }


    fun updateData(l: ArrayList<TextView>) {
        viewPager2.adapter = BasicAdapter(this, l, viewPager2)
    }
    fun updateData(vararg l: String) {
        val al = buildList(l.map { it })
        viewPager2.adapter = BasicAdapter(this, al, viewPager2)
    }
    fun buildList(t: List<String>): ArrayList<TextView> {
        val tvList = arrayListOf<TextView>()
        t.forEach {
            val t = TextView(this)
            t.text = it
            tvList.add(t)
        }
        return tvList
    }
}