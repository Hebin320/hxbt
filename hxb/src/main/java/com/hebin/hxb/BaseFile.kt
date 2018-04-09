@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.content.Context
import com.hebin.hxb.util.BaseFile

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
inline fun Context.saveFile(infoKey: String, info: String) = BaseFile.saveString(this, infoKey, info)

inline fun Context.saveFile(infoKey: String, boolean: Boolean) = BaseFile.saveBoolean(this, infoKey, boolean)

inline fun Context.saveFile(infoKey: String, position: Int) = BaseFile.saveInt(this, infoKey, position)

inline fun Context.loadString(infoKey: String) = BaseFile.loadString(this, infoKey)

inline fun Context.loadBoolean(infoKey: String) = BaseFile.loadBoolean(this, infoKey)

inline fun Context.loadInt(infoKey: String) = BaseFile.loadInt(this, infoKey)