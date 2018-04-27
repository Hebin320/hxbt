@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr.constraint

import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.FrameLayout
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
    val lp = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
    lp.height = dip(height)
    lp.width = dip(width)
    this.layoutParams = lp
}


// 高度全屏，设置宽度
inline fun View.setConstraintWidth(width: Int) {
    val lp = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.MATCH_PARENT)
    lp.width = dip(width)
    this.layoutParams = lp
}


// 宽度全屏，设置高度
inline fun View.setConstraintHeight(height: Int) {
    val lp = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.WRAP_CONTENT)
    lp.height = dip(height)
    this.layoutParams = lp
}


