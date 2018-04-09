@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.content.Context
import com.hebin.hxb.util.ToastUtil

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
 *  toast(string)
 * */
inline fun Context.showToast(string: String) = ToastUtil.showToast(this, string)


/**
 * print(string)
 * */
inline fun printData(string: String) = ToastUtil.printData(string)

/**
 * print(string)
 * */
inline fun printData(tag: String, string: String) = ToastUtil.printData(tag, string)

/**
 * Log.e(string)
 * */
inline fun printLog(string: String) = ToastUtil.printLog(string)

/**
 * Log.e(string)
 * */
inline fun printLog(tag: String, string: String) = ToastUtil.printLog(tag, string)