@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.hebin.utils.ImageUtil

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

inline fun Context.glideCircleImage(url: Any, imageView: ImageView) = ImageUtil.glideCircleImage(this, url, imageView)

inline fun Context.glideNormalImage(url: Any, imageView: ImageView) = ImageUtil.glideNormalImage(this, url, imageView)

inline fun Context.glideRoundImage(url: Any, roundSize: Int, imageView: ImageView) = ImageUtil.glideRoundImage(this, url, roundSize, imageView)