@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity

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
 *  传值获取 -> 类型、字符串
 * */
inline fun Activity.getStringExtra(mTAG: String): String {
    return this.intent.getStringExtra(mTAG)
}

/**
 *  传值获取 -> 类型、数字
 * */
inline fun Activity.getIntExtra(mTAG: String): Int {
    return this.intent.getIntExtra(mTAG, 0)
}

/**
 *  传值获取 -> 类型、布尔值
 * */
inline fun Activity.getBooleanExtra(mTAG: String): Boolean {
    return this.intent.getBooleanExtra(mTAG, false)
}

// 接收值，不为空
inline fun String.intentNotNull(activity: Activity, notNull: (value: String) -> Unit) {
    if (activity.intent.getStringExtra(this) != null) {
        notNull.invoke(activity.intent.getStringExtra(this))
    }
}

// 接收值，为true
inline fun String.intentIsTrue(activity: Activity, isTrue: () -> Unit) {
    if (activity.intent.getBooleanExtra(this, false)) {
        isTrue.invoke()
    }
}

// 接收值，为true
inline fun String.intentIsFalse(activity: Activity, isFalse: () -> Unit) {
    if (!activity.intent.getBooleanExtra(this, false)) {
        isFalse.invoke()
    }
}
