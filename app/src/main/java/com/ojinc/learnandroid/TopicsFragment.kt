package com.ojinc.learnandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ojinc.learnandroid.adapter.TopicsAdapter
import com.ojinc.learnandroid.model.Topics
import java.util.zip.Inflater

class TopicsFragment : Fragment() {
    private lateinit var topic : TextView
    private lateinit var mdetails : TextView
    private lateinit var topicImage : ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View =  inflater.inflate(R.layout.fragment_topics, container, false)

        topic = view.findViewById<View>(R.id.heading) as TextView
        mdetails = view.findViewById<View>(R.id.details) as TextView
        topicImage = view.findViewById<View>(R.id.topicImage) as ImageView

        val bundle = arguments
        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("topicImage")
        val details = bundle.getString("details")

        topic.text = heading
        mdetails.text = details
        topicImage.setImageResource(imageId)

        return view
    }
}