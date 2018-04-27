@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr.linearlayout

import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.dip

/**
 * Author Hebin
 * <p>
 * created at 2018/4/25
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

// 设置宽高
inline fun View.setHeigthAndWidth(height: Int, width: Int) {
    val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    lp.height = dip(height)
    lp.width = dip(width)
    this.layoutParams = lp
}


// 高度全屏，设置宽度
inline fun View.setWidth(width: Int) {
    val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT)
    lp.width = dip(width)
    this.layoutParams = lp
}


// 宽度全屏，设置高度
inline fun View.setHeight(height: Int) {
    val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
    lp.height = dip(height)
    this.layoutParams = lp
}


