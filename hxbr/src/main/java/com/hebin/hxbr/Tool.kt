@file:Suppress("NOTHING_TO_INLINE", "SENSELESS_COMPARISON")

package com.hebin.hxbr

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.CountDownTimer
import android.telephony.TelephonyManager
import android.widget.ScrollView
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
inline fun Context.getVersionName(): String {
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
inline fun Context.getVersionCode(): Int {
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

// Any类型强转 Int
inline fun Any.asInt() = this as Int

// Any类型强转 String
inline fun Any.asString() = this as String

// Any类型强转 Boolean
inline fun Any.asBoolean() = this as Boolean

// Any类型强转 Float
inline fun Any.asFloat() = this as Float

// 给月份或者日期前面加0
inline fun Int.addZero(): String {
    var date = ""
    this.isNotNull {
        if (this in 1..9) {
            date = "0${this}"
        } else if (this >= 10) {
            date = this.toString()
        }
    }
    return date
}

// 给月份或者日期前面加0
inline fun String.addZero(): String {
    var date = ""
    this.isNotNull {
        this.isNotEmpty {
            if (this.toInt() in 1..9) {
                date = "0${this}"
            } else if (this.toInt() >= 10) {
                date = this
            }
        }
    }
    return date
}
