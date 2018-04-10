@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager

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


/**
 *  设置线性布局
 * */
inline fun RecyclerView.setLinearLayoutManager(context: Context) {
    val layoutManager = LinearLayoutManager(context)
    this.layoutManager = layoutManager
}

/**
 *  设置九宫格布局
 * */
inline fun RecyclerView.setGridLayoutManager(context: Context, count: Int) {
    val layoutManager = GridLayoutManager(context, count)
    this.layoutManager = layoutManager
}

/**
 *  设置垂直瀑布流布局
 * */
inline fun RecyclerView.setVerticalStaggered(count: Int) {
    val layoutManager = StaggeredGridLayoutManager(count, StaggeredGridLayoutManager.VERTICAL)
    this.layoutManager = layoutManager
}

/**
 *  设置垂直瀑布流布局
 * */
inline fun RecyclerView.setHorizontalStaggered(count: Int) {
    val layoutManager = StaggeredGridLayoutManager(count, StaggeredGridLayoutManager.HORIZONTAL)
    this.layoutManager = layoutManager
}