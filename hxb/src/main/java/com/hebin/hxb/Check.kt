@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxb

import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Switch

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

inline fun RadioButton.checkOrNot(noinline isCheck: (radioButton: CompoundButton) -> Unit, noinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        } else {
            isNotCheck(compoundButton)
        }
    }
}

inline fun CheckBox.checkOrNot(noinline isCheck: (checkBox: CompoundButton) -> Unit, noinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        } else {
            isNotCheck(compoundButton)
        }
    }
}

inline fun Switch.checkOrNot(noinline isCheck: (switch: CompoundButton) -> Unit, noinline isNotCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        } else {
            isNotCheck(compoundButton)
        }
    }
}

inline fun RadioButton.isCheck(noinline isCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}
inline fun CheckBox.isCheck(noinline isCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

inline fun Switch.isCheck(noinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

inline fun RadioButton.isNotCheck(noinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

inline fun CheckBox.isNotCheck(noinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

inline fun Switch.isNotCheck(noinline isNotCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}