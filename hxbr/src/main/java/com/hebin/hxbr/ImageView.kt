@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.content.Context
import android.support.constraint.Placeholder
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.hebin.hxbr.util.GlideCircleTransform
import com.hebin.hxbr.util.GlideRoundTransform
import com.hebin.hxbr.util.ImageUtil

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
 *  加载圆形图片
 * */
inline fun Context.glideCircleImage(url: Any, imageView: ImageView) = ImageUtil.glideCircleImage(this, url, imageView)

/**
 *  加载正常图片
 * */
inline fun Context.glideNormalImage(url: Any, imageView: ImageView) = ImageUtil.glideNormalImage(this, url, imageView)

/**
 *  加载圆角图片
 * */
inline fun Context.glideRoundImage(url: Any, roundSize: Int, imageView: ImageView) = ImageUtil.glideRoundImage(this, url, roundSize, imageView)

class ImageViewUtil {

    private var mContext: Context? = null
    private var imgUrl: Any? = null
    private var roundSize = 1
    private var imageView: ImageView? = null
    private var errorImage = R.drawable.ic_img_default
    private var placeHolder = R.drawable.ic_img_default

    fun setContext(context: Context): ImageViewUtil {
        this.mContext = context
        return this
    }

    fun setImgUrl(imgUrl: Any): ImageViewUtil {
        this.imgUrl = imgUrl
        return this
    }

    fun setRoundSize(roundSize: Int): ImageViewUtil {
        this.roundSize = roundSize
        return this
    }

    fun setImageView(imageView: ImageView): ImageViewUtil {
        this.imageView = imageView
        return this
    }

    fun setErrorImage(errorImage: Int): ImageViewUtil {
        this.errorImage = errorImage
        return this
    }

    fun setPlaceHolder(placeHolder: Int): ImageViewUtil {
        this.placeHolder = placeHolder
        return this
    }

    /**
     *  加载圆角图片
     * */
    fun glideRoundImage(): ImageViewUtil {
        if (Util.isOnMainThread()) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .asBitmap()
                    .dontAnimate()
                    .transform(GlideRoundTransform(mContext, roundSize))
                    .error(errorImage)
                    .placeholder(placeHolder)
                    .into(imageView)
        }
        return this
    }

    /**
     *  加载圆形图片
     * */
    fun glideCircleImage(): ImageViewUtil {
        if (Util.isOnMainThread()) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .asBitmap()
                    .dontAnimate()
                    .transform(GlideCircleTransform(mContext))
                    .error(errorImage)
                    .placeholder(placeHolder)
                    .into(imageView)
        }
        return this
    }

    /**
     *  加载圆形图片
     * */
    fun glideNormalImage(): ImageViewUtil {
        if (Util.isOnMainThread()) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .asBitmap()
                    .dontAnimate()
                    .error(errorImage)
                    .placeholder(placeHolder)
                    .into(imageView)
        }
        return this
    }
}