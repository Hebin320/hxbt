@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.widget.*

/**
 * Author Hebin
 * <p>
 * created at 2018/4/4
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

class CheckOrNotListener {
    private var isCheckBoolean: (() -> Unit)? = null
    private var isNotCheckBoolean: (() -> Unit)? = null
    private var isCheck: ((radioButton: CompoundButton) -> Unit)? = null
    private var isNotCheck: ((radioButton: CompoundButton) -> Unit)? = null

    fun isCheck(listener: (radioButton: CompoundButton) -> Unit) {
        isCheck = listener
    }

    fun isNotCheck(listener: (radioButton: CompoundButton) -> Unit) {
        isNotCheck = listener
    }

    fun check(radioButton: RadioButton) {
        radioButton.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                isCheck?.invoke(compoundButton)
            } else {
                isNotCheck?.invoke(compoundButton)
            }
        }
    }

    fun check(checkBox: CheckBox) {
        checkBox.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                isCheck?.invoke(compoundButton)
            } else {
                isNotCheck?.invoke(compoundButton)
            }
        }
    }

    fun check(switch: Switch) {
        switch.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                isCheck?.invoke(compoundButton)
            } else {
                isNotCheck?.invoke(compoundButton)
            }
        }
    }

    fun check(status:Boolean){
        if (status){
            isCheckBoolean?.invoke()
        }else{
            isNotCheckBoolean?.invoke()
        }
    }
}

/**
 *  是否被选中
 * */
inline fun RadioButton.checkOrNot(init: CheckOrNotListener.() -> Unit) {
    val listener = CheckOrNotListener()
    listener.init()
    listener.check(this)
}

inline fun CheckBox.checkOrNot(init: CheckOrNotListener.() -> Unit) {
    val listener = CheckOrNotListener()
    listener.init()
    listener.check(this)
}

inline fun Switch.checkOrNot(init: CheckOrNotListener.() -> Unit) {
    val listener = CheckOrNotListener()
    listener.init()
    listener.check(this)
}
inline fun Boolean.checkOrNot(init: CheckOrNotListener.() -> Unit) {
    val listener = CheckOrNotListener()
    listener.init()
    listener.check(this)
}



/**
 *  是否被选中
 * */


/**
 *  选中
 * */
inline fun RadioButton.isCheck(noinline isCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun CheckBox.isCheck(noinline isCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun Switch.isCheck(noinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

// 选中
inline fun Boolean.isCheck(noinline isCheck: () -> Unit) {
    if (this) {
        isCheck()
    }
}

/**
 *  未选中
 * */
inline fun RadioButton.isNotCheck(noinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun CheckBox.isNotCheck(noinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun Switch.isNotCheck(noinline isNotCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

// 未选中
inline fun Boolean.isNotCheck(noinline isNotCheck: () -> Unit) {
    if (!this) {
        isNotCheck()
    }
}

/**
 *  只选中一个
 * */
inline fun ArrayList<RadioButton>.onlyRadioButton() {
    for (i in this.indices) {
        this[i].setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                for (k in this.indices) {
                    if (i != k) {
                        this[k].isChecked = false
                    }
                }
            }
        }
    }
}

/**
 *  只选中一个
 * */
inline fun ArrayList<CheckBox>.onlyCheckBox() {
    for (i in this.indices) {
        this[i].setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                for (k in this.indices) {
                    if (i != k) {
                        this[k].isChecked = false
                    }
                }
            }
        }
    }
}

/**
 *  只选中一个
 * */
inline fun ArrayList<Switch>.onlySwitch() {
    for (i in this.indices) {
        this[i].setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                for (k in this.indices) {
                    if (i != k) {
                        this[k].isChecked = false
                    }
                }
            }
        }
    }
}

