@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton

/**
 * Author Hebin
 * <p>
 * created at 2018/4/16
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

inline fun ViewPager.setRBCheck(radioButton: Array<RadioButton>) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

        override fun onPageSelected(position: Int) {
            for (i in radioButton.indices) {
                radioButton[i].isChecked = i == position
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    })
    for (i in radioButton.indices) {
        radioButton[i].setOnClickListener { this.currentItem = i }
    }
}

inline fun ViewPager.addOnPageChangeListener(listener: HxbrPageChangeListener) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            listener.onPageScrollStateChanged(state)
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            listener.onPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            listener.onPageSelected(position)
        }
    })
}

inline fun ViewPager.addOnPageChangeListener(noinline mOnPageSelected: (position: Int) -> Unit,
                                             noinline mOnPageScrollStateChanged: (state: Int) -> Unit,
                                             noinline mOnPageScrolled: (position: Int, positionOffset: Float, positionOffsetPixels: Int) -> Unit) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
            mOnPageScrollStateChanged(state)
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            mOnPageScrolled(position, positionOffset, positionOffsetPixels)
        }

        override fun onPageSelected(position: Int) {
            mOnPageSelected(position)
        }
    })
}

inline fun ViewPager.addOnPageChangeListener(noinline mOnPageSelected: (position: Int) -> Unit) {
    this.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            mOnPageSelected(position)
        }
    })
}

interface HxbrPageChangeListener {
    fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
    fun onPageSelected(position: Int) {}
    fun onPageScrollStateChanged(state: Int) {}
}
