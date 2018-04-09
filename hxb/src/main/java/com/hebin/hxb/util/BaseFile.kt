package com.hebin.hxb.util

import android.content.Context


class BaseFile {

    companion object {

        const val TOKEN = "TOKEN"
        const val USERID = "USERID"
        const val SHOPID = "SHOPID"
        const val DOMAIN = "DOMAIN"
        const val WEBDOMAIN = "WEBDOMAIN"


        fun saveUserData(context: Context, token: String, userid: String, name: String, typeid: String, mobile: String, shopid: String, openid: String) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(TOKEN, token)
            editor.putString(USERID, userid)
            editor.putString("name", name)
            editor.putString("typeid", typeid)
            editor.putString("mobile", mobile)
            editor.putString(SHOPID, shopid)
            editor.putString("openid", openid)
            editor.apply()
        }

        fun cleanUserData(context: Context) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.remove(TOKEN)
            editor.remove(USERID)
            editor.remove("name")
            editor.remove("typeid")
            editor.remove("mobile")
            editor.remove(SHOPID)
            editor.remove("openid")
            editor.apply()
        }

        fun saveString(context: Context, infoKey: String, info: String) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(infoKey, info)
            editor.apply()
        }

        fun loadString(context: Context, infoKey: String): String {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getString(infoKey, "")
        }

        fun saveBoolean(context: Context, infoKey: String, isTrue: Boolean) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean(infoKey, isTrue)
            editor.apply()
        }

        fun loadBoolean(context: Context, infoKey: String): Boolean {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getBoolean(infoKey, false)
        }

        fun saveInt(context: Context, infoKey: String, position: Int) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putInt(infoKey, position)
            editor.apply()
        }

        fun loadInt(context: Context, infoKey: String): Int {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getInt(infoKey, 0)
        }
    }
}