@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Author Hebin
 * <p>
 * created at 2018/4/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */


inline fun RecyclerView.setLinearLayoutManager(context: Context) {
    val layoutManager = LinearLayoutManager(context)
    this.layoutManager = layoutManager
}

inline fun RecyclerView.setGridLayoutManager(context: Context, count: Int) {
    val layoutManager = GridLayoutManager(context, count)
    this.layoutManager = layoutManager
}