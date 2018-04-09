package com.hebin.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.hebin.hxb.R
import com.hebin.hxb.util.GlideCircleTransform
import com.hebin.hxb.util.GlideRoundTransform


@Suppress("DEPRECATION")

class ImageUtil {


    companion object {

        fun getBitmap(file: String, inSampleSize: Int): Bitmap {
            System.gc()
            val options = BitmapFactory.Options()
            options.inPurgeable = true
            options.inSampleSize = inSampleSize
            return BitmapFactory.decodeFile(file, options)
        }

        fun glideRoundImage(context: Context, url: Any, roundSize: Int, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .transform(GlideRoundTransform(context, roundSize))
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }

        fun glideCircleImage(context: Context, url: Any, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .transform(GlideCircleTransform(context))
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }

        fun glideNormalImage(context: Context, url: Any, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }

    }

}
