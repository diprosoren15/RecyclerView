package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsarray : ArrayList<News>, var context: Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var myListener : onItemClickListener
    interface onItemClickListener {
        fun onClicking(position: Int)
    }
    fun setItemClickListener (listener : onItemClickListener) {
        myListener = listener
    }

    //to create a new view instance
    //when layout manager fails to to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewHolder(itemView, myListener)
    }
    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        var currentItem = newsarray[position]
        holder.HeadingText.setText(currentItem.newsHeading)
        holder.HeadingImg.setImageResource(currentItem.newsHeadingImg)
    }
    //how many list items present in your array
    override fun getItemCount(): Int {
        return newsarray.size
    }
    // it holds the view so that view is not created everytime/ it is done to save memory
    class MyViewHolder(v : View, listener: onItemClickListener) : RecyclerView.ViewHolder(v) {

        val HeadingText = v.findViewById<TextView>(R.id.headingtitle)
        val HeadingImg = v.findViewById<ShapeableImageView>(R.id.headingimg)

        init {
            v.setOnClickListener {
                listener.onClicking(adapterPosition)
            }
        }
    }
}