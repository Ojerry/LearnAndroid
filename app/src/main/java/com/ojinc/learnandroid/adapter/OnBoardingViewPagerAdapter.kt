package com.ojinc.learnandroid.adapter

import android.content.Context
import android.view.View
import androidx.viewpager.widget.PagerAdapter
import com.ojinc.learnandroid.model.onBoardingData

class OnBoardingViewPagerAdapter(private var context: Context, private var onBoardingDataList: List<onBoardingData>)  : PagerAdapter() {
    override fun getCount(): Int {
        return onBoardingDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}