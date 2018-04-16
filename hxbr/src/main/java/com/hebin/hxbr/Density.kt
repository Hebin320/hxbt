@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.content.Context
import android.util.TypedValue

/**
 * Author Hebin
 * <p>
 * created at 2018/4/16 12:02
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：常用单位转换的辅助类
 */
/**
 * dp转px
 */
inline fun Context.dp2px(dpVal: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            dpVal, this.resources.displayMetrics).toInt()
}

/**
 * sp转px
 */
inline fun Context.sp2px(spVal: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
            spVal, this.resources.displayMetrics).toInt()
}

/**
 * px转dp
 */
inline fun Context.px2dp(pxVal: Float): Float {
    val scale = this.resources.displayMetrics.density
    return pxVal / scale
}

/**
 * px转sp
 */
inline fun Context.px2sp(pxVal: Float): Float {
    return pxVal / this.resources.displayMetrics.scaledDensity
}

/**
 * dip转px
 */
inline fun Context.dip2px(dpValue: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}
