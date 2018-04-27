package com.hebin.hxbr.util

import android.annotation.SuppressLint
import android.util.Log
import android.view.MotionEvent
import android.view.View

@Suppress("DEPRECATED_IDENTITY_EQUALS")
/**
 * Author Hebin
 * <p>
 * created at 2018/1/22
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
class OnDoubleClickListener(private val mCallback: DoubleClickCallback?) : View.OnTouchListener {
    private val TAG = this.javaClass.simpleName
    private var count = 0
    private var firClick: Long = 0
    private var secClick: Long = 0
    /**
     * 两次点击时间间隔，单位毫秒
     */
    private val interval = 1500

    interface DoubleClickCallback {
        fun onDoubleClick()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(v: View, event: MotionEvent): Boolean {
        if (MotionEvent.ACTION_DOWN === event.action) {
            count++
            if (1 == count) {
                firClick = System.currentTimeMillis()
            } else if (2 == count) {
                secClick = System.currentTimeMillis()
                if (secClick - firClick < interval) {
                    if (mCallback != null) {
                        mCallback.onDoubleClick()
                    } else {
                        Log.e(TAG, "请在构造方法中传入一个双击回调")
                    }
                    count = 0
                    firClick = 0
                } else {
                    firClick = secClick
                    count = 1
                }
                secClick = 0
            }
        }
        return true
    }
}