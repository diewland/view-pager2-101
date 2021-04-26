package com.example.viewpager2101

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    lateinit var viewPager2: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById(R.id.viewPager2)

        val list = arrayListOf(
            "First Screen",
            "Second Screen",
            "Third Screen",
            "Fourth Screen",
        )

        val tvList = arrayListOf<TextView>()
        list.forEach {
            val t = TextView(this)
            t.text = it
            tvList.add(t)
        }

        // viewPager2.adapter = ViewPagerAdapter(this, list, viewPager2)
        viewPager2.adapter = BasicAdapter(this, tvList, viewPager2)
    }
}