@file:Suppress("NOTHING_TO_INLINE", "SENSELESS_COMPARISON")

package com.hebin.hxbr

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.CountDownTimer
import android.telephony.TelephonyManager
import java.util.ArrayList

/**
 *  倒计时
 * */
inline fun setTimer(milisInFuture: Long, countDownInterval: Long, noinline onTick: (time: Long) -> kotlin.Unit, noinline onFinish: () -> kotlin.Unit) {
    val time = object : CountDownTimer(milisInFuture, countDownInterval) {
        override fun onTick(l: Long) {
            onTick(l)
        }

        override fun onFinish() {
            onFinish()
        }
    }
    time.start()
}

/**
 * 获取唯一机械码
 */
@SuppressLint("WrongConstant", "MissingPermission", "HardwareIds")
inline fun Context.getImei(): String {
    var imei = ""
    try {
        val telephonyManager = this.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        imei = telephonyManager.deviceId
    } catch (ignored: Exception) {
    }
    return imei
}

/**
 * 获取版本名称
 */
inline fun Context.getVersion(): String {
    return try {
        val manager = this.packageManager.getPackageInfo(
                this.packageName, 0)
        manager.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        "Unknown"
    }
}

/**
 * 获取版本号
 */
inline fun Context.getlocalVersion(): Int {
    var localversion = 0
    try {
        val info = this.packageManager.getPackageInfo(this.packageName, 0)
        localversion = info.versionCode
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
    }
    return localversion
}


/**
 * 把list转换为一个用逗号分隔的字符串
 */
inline fun listToString(list: ArrayList<String>): String {
    val sb = StringBuilder()
    if (list != null && list.size > 0) {
        for (i in list.indices) {
            if (i < list.size - 1) {
                sb.append(list[i] + ",")
            } else {
                sb.append(list[i])
            }
        }
    }
    return sb.toString()
}

