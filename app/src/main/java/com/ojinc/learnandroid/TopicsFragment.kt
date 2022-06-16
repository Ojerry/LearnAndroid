package com.ojinc.learnandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ojinc.learnandroid.adapter.TopicsAdapter
import com.ojinc.learnandroid.model.Topics
import java.util.zip.Inflater

class TopicsFragment : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Topics>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
//    lateinit var price   : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }


    imageId = arrayOf(
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1,
        R.drawable.le1
    )

    heading = arrayOf(
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android",
        "Learn Android"
    )

    newRecyclerView = requireView().findViewById<RecyclerView>(R.id.recyclerVeiw)
    newRecyclerView.layoutManager = LinearLayoutManager(activity)
    newRecyclerView.setHasFixedSize(true)
    getUserData()


    }

    private fun getUserData(){
        for(i in imageId.indices) {
            val topics = Topics(imageId[i], heading[i])
            newArrayList.add(topics)
        }
        var adapter = TopicsAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topics, container, false)

    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            TopicsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}