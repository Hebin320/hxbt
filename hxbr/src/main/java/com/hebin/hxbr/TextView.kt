@file:Suppress("NOTHING_TO_INLINE", "SENSELESS_COMPARISON")

package com.hebin.hxbr

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import org.jetbrains.anko.internals.AnkoInternals

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
 *  是否为0
 * */

inline fun Int.checkZero(init: CheckZeroListener.() -> Unit) {
    val listener = CheckZeroListener()
    listener.init()
    listener.check(this)
}

class CheckZeroListener {
    private var isZero: (() -> Unit)? = null
    private var notZero: (() -> Unit)? = null

    fun isZero(listener: () -> Unit) {
        isZero = listener
    }

    fun notZero(listener: () -> Unit) {
        notZero = listener
    }

    fun check(position: Int) {
        if (position == 0) {
            isZero?.invoke()
        } else {
            notZero?.invoke()
        }
    }
}

inline fun Int.isZero(isZero: () -> Unit) {
    if (this == 0) {
        isZero.invoke()
    }
}

inline fun Int.notZero(notZero: () -> Unit) {
    if (this != 0) {
        notZero.invoke()
    }
}

inline fun Int.zeroOrNot(isZero: () -> Unit, isNotZero: () -> Unit) {
    if (0 == this) {
        isZero()
    } else {
        isNotZero()
    }
}

/**
 *  是否为最后一行
 * */

inline fun checkLast(position: Int, all: Int, init: CheckLastListener.() -> Unit) {
    val listener = CheckLastListener()
    listener.init()
    listener.check(position, all)
}

class CheckLastListener {
    private var isLast: (() -> Unit)? = null
    private var notLast: (() -> Unit)? = null

    fun isLast(listener: () -> Unit) {
        isLast = listener
    }

    fun notLast(listener: () -> Unit) {
        notLast = listener
    }

    fun check(position: Int, all: Int) {
        if (position == all - 1) {
            isLast?.invoke()
        } else {
            notLast?.invoke()
        }
    }
}

inline fun lastOrNot(position: Int, all: Int, isLast: () -> Unit, isNotLast: () -> Unit) {
    if (position == all - 1) {
        isLast()
    } else {
        isNotLast()
    }
}

/**
 *  字符串是否为空
 * */
inline fun String.isEmpty(isEmpty: () -> Unit) {
    if (this.isEmpty()) {
        isEmpty()
    }
}

/**
 *  字符串是否为空
 * */
inline fun String.isNotEmpty(isNotEmpty: () -> Unit) {
    if (this.isNotEmpty()) {
        isNotEmpty()
    }
}

// 不为空
inline fun Any.isNotNull(noinline isNotNull: () -> Unit) {
    if (this != null) {
        isNotNull()
    }
}

/**
 *  字符串是否为空
 * */

inline fun String.checkEmpty(init: CheckEmptyListener.() -> Unit) {
    val listener = CheckEmptyListener()
    listener.init()
    listener.check(this)
}

class CheckEmptyListener {
    private var isEmpty: (() -> Unit)? = null
    private var notEmpty: (() -> Unit)? = null

    fun isEmpty(listener: () -> Unit) {
        isEmpty = listener
    }

    fun notEmpty(listener: () -> Unit) {
        notEmpty = listener
    }

    fun check(string: String) {
        if (string.isEmpty()) {
            isEmpty?.invoke()
        } else {
            notEmpty?.invoke()
        }
    }
}

inline fun String.emptyOrNot(isEmpty: () -> Unit, isNotEmpty: () -> Unit) {
    if (this.isEmpty()) {
        isEmpty()
    } else {
        isNotEmpty()
    }
}

/**
 *  多个字符串全部不为空或者部分为空
 * */
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

/**
 *  多个字符串全部为空或者部分不为空
 * */
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

/**
 *  显示布局
 * */
inline fun View.setVisible() {
    this.visibility = View.VISIBLE
}

/**
 *  隐藏布局
 * */
inline fun View.setGone() {
    this.visibility = View.GONE
}

/**
 *  占位隐藏布局
 * */
inline fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}

// 时时监听EditText的文本变化
inline fun EditText.addTextChangedListener(listener: HxbrTextWatcher) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            listener.afterTextChanged(p0)
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            listener.beforeTextChanged(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            listener.onTextChanged(p0, p1, p2, p3)
        }
    })
}

inline fun EditText.addTextChangedListener(noinline mAfterTextChanged: (p0: Editable) -> Unit,
                                           noinline mBeforeTextChanged: (p0: CharSequence, p1: Int, p2: Int, p3: Int) -> Unit,
                                           noinline mOnTextChanged: (p0: CharSequence, p1: Int, p2: Int, p3: Int) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            mAfterTextChanged(p0)
        }

        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            mBeforeTextChanged(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            mOnTextChanged(p0, p1, p2, p3)
        }
    })
}

inline fun EditText.addTextChangedListener(noinline mAfterTextChanged: (p0: Editable) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            mAfterTextChanged(p0)
        }

        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }
    })
}

interface HxbrTextWatcher {
    fun afterTextChanged(p0: Editable?) {}
    fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
}

// 获取文本
inline fun EditText.getString(): String {
    return this.text.toString()
}

// 获取文本
inline fun TextView.getString(): String {
    return this.text.toString()
}

// 获取文本
inline fun Button.getString(): String {
    return this.text.toString()
}

// 获取文本
inline fun RadioButton.getString(): String {
    return this.text.toString()
}

// 获取文本
inline fun CheckBox.getString(): String {
    return this.text.toString()
}

// 获取颜色
inline fun Context.getColors(color: Int) = ContextCompat.getColor(this, color)

// 获取颜色
inline fun getColors(color: String) = Color.parseColor(color)

// 设置字体颜色
inline fun TextView.setTextColor(context: Context, color: Int) = this.setTextColor(ContextCompat.getColor(context, color))

// 设置字体颜色
inline fun EditText.setTextColor(context: Context, color: Int) = this.setTextColor(ContextCompat.getColor(context, color))

// 设置字体颜色
inline fun Button.setTextColor(context: Context, color: Int) = this.setTextColor(ContextCompat.getColor(context, color))

// 设置字体颜色
inline fun RadioButton.setTextColor(context: Context, color: Int) = this.setTextColor(ContextCompat.getColor(context, color))

// 设置字体颜色
inline fun CheckBox.setTextColor(context: Context, color: Int) = this.setTextColor(ContextCompat.getColor(context, color))

// 设置字体颜色
inline fun TextView.setTextColors(color: String) = this.setTextColor(Color.parseColor(color))

var TextView.textColor: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColors(v)

// 设置字体颜色
inline fun EditText.setTextColors(color: String) = this.setTextColor(Color.parseColor(color))

var EditText.textColor: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColors(v)

// 设置字体颜色
inline fun Button.setTextColors(color: String) = this.setTextColor(Color.parseColor(color))

var Button.textColor: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColors(v)

// 设置字体颜色
inline fun RadioButton.setTextColors(color: String) = this.setTextColor(Color.parseColor(color))

var RadioButton.textColor: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColors(v)

// 设置字体颜色
inline fun CheckBox.setTextColors(color: String) = this.setTextColor(Color.parseColor(color))

var CheckBox.textColor: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColors(v)

inline fun EditText.setEdTexts(string: String) {
    this.setText(string)
}

var EditText.texts: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setEdTexts(v)

