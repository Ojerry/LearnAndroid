package com.ojinc.learnandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ojinc.learnandroid.adapter.TopicsAdapter
import com.ojinc.learnandroid.model.Topics

class HomeActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Topics>
    lateinit var topicImage : Array<Int>
    lateinit var heading : Array<String>
    lateinit var details : Array<String>
    private var isLinearLayoutManager = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        topicImage = arrayOf(
            R.drawable.theroadmap,
            R.drawable.kotlinjava,
            R.drawable.versioncontrol,
            R.drawable.github,
            R.drawable.ide,
            R.drawable.views,
            R.drawable.activities,
            R.drawable.fragments,
            R.drawable.dataalgorithms,
            R.drawable.uidesigns,
            R.drawable.gradle,
            R.drawable.keeplearning
        )

        heading = arrayOf(
            "Android RoadMap",
            "Kotlin or Java",
            "Version Control",
            "GitHub",
            "Integrated Development Environment",
            "Views",
            "Activities",
            "Fragments",
            "Data Structures and Algorithm",
            "UI Designs",
            "Gradle",
            "Keep Learning"
        )

        details = arrayOf(
            getString(R.string.roadmap),
            getString(R.string.kotlinorjava),
            getString(R.string.vControl),
            getString(R.string.github),
            getString(R.string.ide),
            getString(R.string.views),
            getString(R.string.activities),
            getString(R.string.fragments),
            getString(R.string.dataalgorithms),
            getString(R.string.uidesigns),
            getString(R.string.gradle),
            getString(R.string.keeplearning)
        )

        newRecyclerView = findViewById(R.id.recyclerVeiw)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Topics>()
        getUserData()


    }

    private fun getUserData() {
        for(i in topicImage.indices) {
            val topics = Topics(topicImage[i], heading[i])
            newArrayList.add(topics)
        }

        var adapter = TopicsAdapter(newArrayList)
        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : TopicsAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                val intent = Intent(this@HomeActivity, HomeActivity::class.java)
//                intent.putExtra("heading",newArrayList[position].heading)
//                intent.putExtra("imageId",newArrayList[position].topicImage)
//                intent.putExtra("details",details[position])
//                startActivity(intent)
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val mFragment = TopicsFragment()

                fragmentManager.findFragmentByTag(TopicsFragment::class.java.simpleName)
                val mBundle = Bundle()
                mBundle.putString("heading", newArrayList[position].heading)
                mBundle.putInt("topicImage", newArrayList[position].topicImage)
                mBundle.putString("details", details[position])
                mFragment.arguments = mBundle
                fragmentTransaction.add(R.id.fragmentContainer, mFragment, TopicsFragment::class.java.simpleName).addToBackStack(null).commitAllowingStateLoss()
//                fragmentTransaction.replace(R.id.fragmentContainer, mFragment).addToBackStack(null).commit()
//                fragmentTransaction.replace(R.id.fragmentContainer, mFragment).commit()
                val view : View = findViewById(R.id.recyclerVeiw)
                view.visibility = View.GONE



            }
        })

    }

    override fun onBackPressed()
    {
        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        val mFragment = DetailFragment()
        val currentFragment =this@HomeActivity.supportFragmentManager.findFragmentById(R.id.fragmentContainer)
        if(currentFragment is TopicsFragment)
        {
//            Toast.makeText(this, "There", Toast.LENGTH_SHORT).show()

            fragmentManager.popBackStack()

            val view : View = findViewById(R.id.recyclerVeiw)
            view.visibility = View.VISIBLE
//                fragmentTransaction.remove(DetailFragment()).commit()
        }
        else if(currentFragment is AboutFragment){
            fragmentManager.popBackStack()
            val view : View = findViewById(R.id.recyclerVeiw)
            view.visibility = View.VISIBLE
        } else if(currentFragment is ContactFragment) {
            fragmentManager.popBackStack()

            val view : View = findViewById(R.id.recyclerVeiw)
            view.visibility = View.VISIBLE
        }
        else{
            super.onBackPressed()
        }
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            newRecyclerView.layoutManager = LinearLayoutManager(this)
        } else{
            newRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//                GridLayoutManager(this, 2)
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(item.itemId){
           R.id.contactUs -> {
               val fragmentManager = supportFragmentManager
               val fragmentTransaction = fragmentManager.beginTransaction()
               val cFragment = ContactFragment()
               fragmentManager.popBackStack()
               fragmentManager.findFragmentByTag(ContactFragment::class.java.simpleName)
               fragmentTransaction.add(R.id.fragmentContainer, cFragment, ContactFragment::class.java.simpleName).addToBackStack(null).commitAllowingStateLoss()

//               replaceFragment(ContactFragment())
               val view : View = findViewById(R.id.recyclerVeiw)
               view.visibility = View.GONE
           }
           R.id.aboutUs -> {
               val fragmentManager = supportFragmentManager
               val fragmentTransaction = fragmentManager.beginTransaction()
               val aFragment = AboutFragment()
               fragmentManager.popBackStack()
               fragmentManager.findFragmentByTag(ContactFragment::class.java.simpleName)
               fragmentTransaction.add(R.id.fragmentContainer, aFragment, AboutFragment::class.java.simpleName).addToBackStack(null).commitAllowingStateLoss()


//               replaceFragment(AboutFragment())
               val view : View = findViewById(R.id.recyclerVeiw)
               view.visibility = View.GONE
           }
           R.id.layout -> {
               isLinearLayoutManager = !isLinearLayoutManager
               chooseLayout()
           }


       }

        return super.onOptionsItemSelected(item)
    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
////        val aFragment = AboutFragment()
////        val cFragment = ContactFragment()
//        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
////        fragmentTransaction.add(R.id.fragmentContainer, mFragment, TopicsFragment::class.java.simpleName).addToBackStack(null).commitAllowingStateLoss()
//
//        fragmentTransaction.commit()
//    }






}