@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.view.View

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

inline fun Int.zeroOrNot(isZero: () -> Unit, isNotZero: () -> Unit) {
    if (0 == this) {
        isZero()
    } else {
        isNotZero()
    }
}

inline fun lastOrNot(position: Int, all: Int, isLast: () -> Unit, isNotLast: () -> Unit) {
    if (position == all - 1) {
        isLast()
    } else {
        isNotLast()
    }
}

inline fun String.emptyOrNot(isEmpty: () -> Unit, isNotEmpty: () -> Unit) {
    if (this.isEmpty()) {
        isEmpty()
    } else {
        isNotEmpty()
    }
}

inline fun ArrayList<String>.allNotEmpty(allNotEmpty: () -> Unit, someOneEmpty: () -> Unit) {
    var isAllEmpty = true
    for (string in this) {
        if (string.isEmpty()) {
            isAllEmpty = false
        }
    }
    if (isAllEmpty) {
        allNotEmpty()
    } else {
        someOneEmpty()
    }
}
inline fun ArrayList<String>.allEmpty(allEmpty: () -> Unit, someOneNotEmpty: () -> Unit) {
    var isAllEmpty = true
    for (string in this) {
        if (string.isNotEmpty()) {
            isAllEmpty = false
        }
    }
    if (isAllEmpty) {
        allEmpty()
    } else {
        someOneNotEmpty()
    }
}

inline fun View.setVisible() {
    this.visibility = View.VISIBLE
}

inline fun View.setGone() {
    this.visibility = View.GONE
}

inline fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}