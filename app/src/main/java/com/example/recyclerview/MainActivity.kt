package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var newsarray : ArrayList<News>
    lateinit var myRecycleView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRecycleView = findViewById(R.id.recyclView)

        val headingtxt = arrayOf("No link to arrested cow vigilante Bittu Bajrangi, says Hindu group VHP",
            "Centre’s draft SOP wants courts to ‘exercise restraint’",
            "Himachal Pradesh Rain: Landslide hits Shimla’s Summer Hill area, Rescue operation underway",
        "Congress hits out at PM Modi over renaming Nehru Memorial Museum and Library, and all the latest news",
        "CBI forms 53-member team to probe Manipur sexual assault case",
        "Sharad Pawar was asked if he was offered Cabinet berth. He said...")

        val content = arrayOf(getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content),getString(R.string.news_content)
                ,getString(R.string.news_content),getString(R.string.news_content))

        val headingImg = arrayOf(R.drawable.headingimg01,R.drawable.headingimg02, R.drawable.headingimg03, R.drawable.headingimg04, R.drawable.headingimg05, R.drawable.headingimg6)
        newsarray = arrayListOf<News>()
        myRecycleView.layoutManager = LinearLayoutManager(this)
        for (index in headingtxt.indices) {
            val newsinfo = News(headingtxt[index], headingImg[index],content[index])
            newsarray.add(newsinfo)
        }
        var myadapter = MyAdapter(newsarray, this)
        myRecycleView.adapter = myadapter

        myadapter.setItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onClicking(position: Int) {
                val intent = Intent(this@MainActivity, DisplayNewsActivity::class.java)
                intent.putExtra("headingnews", newsarray[position].newsHeading)
                intent.putExtra("headingimg", newsarray[position].newsHeadingImg)
                intent.putExtra("content", newsarray[position].content)
                startActivity(intent)
            }

        })

    }
}