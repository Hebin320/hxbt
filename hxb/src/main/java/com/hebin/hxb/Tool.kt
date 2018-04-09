@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.os.CountDownTimer


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


