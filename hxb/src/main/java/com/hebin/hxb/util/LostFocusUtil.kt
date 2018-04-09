package com.hebin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager


@SuppressLint("ClickableViewAccessibility")
class LostFocusUtil  {


    companion object {

        fun lostByViewGroup(context: Context, viewGroup: ViewGroup) {
            viewGroup.setOnTouchListener { _, _ ->
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(viewGroup.windowToken, 0)
                false
            }
        }



        fun lostByView(context: Context, view: View) {
            view.setOnTouchListener { _, _ ->
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                false
            }
        }



        fun hideImmByView(context: Context, view: View) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }


        fun listLostByViewGroup(viewGroup: ViewGroup) {
            viewGroup.isFocusable = true
            viewGroup.isFocusableInTouchMode = true
            viewGroup.requestFocus()
        }

        fun listLostByView(view: View) {
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.requestFocus()
        }
    }

}
