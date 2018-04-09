@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.ViewGroup
import com.hebin.hxb.util.WindowUtil
import com.hebin.utils.LostFocusUtil
import com.hebin.utils.ScaleAnimatorUtil

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

inline fun Activity.getStatusbar() = WindowUtil.getStatusbar(this)

inline fun Activity.getSwidth() = WindowUtil.getSwidth(this)

inline fun Activity.getShigh() = WindowUtil.getShigh(this)

inline fun Activity.setFullScreen() = WindowUtil.setFullScreen(this)

inline fun setScalse(view: View) = ScaleAnimatorUtil.setScalse(view)

inline fun Context.lostByViewGroup(viewGroup: ViewGroup) = LostFocusUtil.lostByViewGroup(this, viewGroup)

inline fun Context.lostByView(view: View) = LostFocusUtil.lostByView(this, view)

inline fun listLostByViewGroup(view: ViewGroup) = LostFocusUtil.listLostByViewGroup(view)

inline fun listLostByView(view: View) = LostFocusUtil.listLostByView(view)

inline fun Context.hideImmByView(view: View) = LostFocusUtil.hideImmByView(this, view)

inline fun Activity.appSetting(tag: Int) {
    val packageURI = Uri.parse("package:$packageName")
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI)
    this.startActivityForResult(intent, tag)
}