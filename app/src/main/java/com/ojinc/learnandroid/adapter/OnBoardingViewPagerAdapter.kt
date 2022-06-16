package com.ojinc.learnandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.ojinc.learnandroid.R
import com.ojinc.learnandroid.model.onBoardingData

class OnBoardingViewPagerAdapter(
    private var context: Context,
    private var onBoardingDataList: List<onBoardingData>
) : PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val  view:View = LayoutInflater.from(context).inflate(R.layout.onboarding_screen_layout, null);
        val imageView: ImageView
        val title: TextView
        val desc : TextView

        imageView = view.findViewById(R.id.imageView)
        title = view.findViewById(R.id.theTitle)
        desc = view.findViewById(R.id.desc)

        imageView.setImageResource(onBoardingDataList[position].imageUrl)
        title.text = onBoardingDataList[position].title
        desc.text = onBoardingDataList[position].desc

        container.addView(view)
        return view
    }



}