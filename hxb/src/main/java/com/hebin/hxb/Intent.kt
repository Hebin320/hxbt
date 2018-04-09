@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.app.Activity
import android.content.Context

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
inline fun Activity.getStringExtra(mTAG: String) {
    this.intent.getStringExtra(mTAG)
}

inline fun Activity.getIntExtra(mTAG: String) {
    this.intent.getIntExtra(mTAG, 0)
}

inline fun Activity.getBooleanExtra(mTAG: String) {
    this.intent.getBooleanExtra(mTAG, false)
}