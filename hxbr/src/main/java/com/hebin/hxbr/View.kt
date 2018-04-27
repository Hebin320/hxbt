@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ScrollView
import com.hebin.hxbr.util.OnDoubleClickListener

/**
 * Author Hebin
 * <p>
 * created at 2018/4/27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

// 长按事件
inline fun View.onLongClickListener(noinline listener: (view: View) -> Unit) {
    this.setOnLongClickListener {
        listener(it)
        true
    }
}

// 双击事件
inline fun View.onDoubleClickListener(noinline listener: () -> Unit) {
    this.setOnTouchListener(OnDoubleClickListener(object : OnDoubleClickListener.DoubleClickCallback {
        override fun onDoubleClick() {
            listener()
        }
    }))
}

// 创建View
inline fun Context.creatView(layout: Int): View {
    return LayoutInflater.from(this).inflate(layout, null)
}

// 创建View
inline fun Context.creatView(layout: Int, viewGroup: ViewGroup): View {
    return LayoutInflater.from(this).inflate(layout, viewGroup, false)
}

// 设置动画
inline fun View.setAnimation(context: Context, anim: Int) {
    val animation = AnimationUtils.loadAnimation(context, anim)
    this.startAnimation(animation)
}