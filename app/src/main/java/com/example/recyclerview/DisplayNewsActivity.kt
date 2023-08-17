package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DisplayNewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_news)


        val heatingtxt = intent.getStringExtra("headingnews")
        val newscontent = intent.getStringExtra("content")
        val headingimg = intent.getIntExtra("headingimg", R.drawable.headingimg01)

        val headingTV = findViewById<TextView>(R.id.headingTV)
        val headingIV = findViewById<ImageView>(R.id.headingIV)
        val contentTV = findViewById<TextView>(R.id.contentTV)

        headingIV.setImageResource(headingimg)
        headingTV.text = heatingtxt
        contentTV.text = newscontent
    }
}