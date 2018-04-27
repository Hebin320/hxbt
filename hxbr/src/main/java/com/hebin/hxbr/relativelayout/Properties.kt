package com.hebin.hxbr.relativelayout

import android.view.View
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Author Hebin
 * <p>
 * created at 2018/4/26
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
var View.widths: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setRelativeWidth(v)

var View.heigths: Int
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setRelativeHeight(v)