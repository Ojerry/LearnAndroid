package com.ojinc.learnandroid.adapter

import androidx.recyclerview.widget.RecyclerView
import com.ojinc.learnandroid.model.Topics
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.ojinc.learnandroid.R

class TopicsAdapter(private val topicList: ArrayList<Topics>) : RecyclerView.Adapter<TopicsAdapter.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position : Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.topic_item,
            parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = topicList[position]
        holder.topicsImage.setImageResource(currentItem.topicImage)
        holder.tvHeading.text = currentItem.heading

//        holder.itemView.setOnClickListener {
//            fun onClick(v: View) {
//                val activity = v!!.context as AppCompatActivity
//            }
//        }


    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val topicsImage : ShapeableImageView = itemView.findViewById(R.id.topic_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}