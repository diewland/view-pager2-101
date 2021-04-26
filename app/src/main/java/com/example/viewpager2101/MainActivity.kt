package com.example.viewpager2101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        viewPager2.adapter = ViewPagerAdapter(this, list, viewPager2)
    }
}