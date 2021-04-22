package com.androidbootcamp.mysnackbar

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(val context: Context) {

    private var sharedPreferences: SharedPreferences

    init {
       sharedPreferences = getPreferences()
    }

    fun getPreferences(): SharedPreferences {
        //Alocação do shared preferences
        return context.getSharedPreferences(
            context.getString(R.string.preference_key),
            Context.MODE_PRIVATE
        )
    }

    fun saveIntOnPreferences(key: String, value: Int) {
        sharedPreferences.edit()
            .putInt(key, value)
            .apply()
    }

    fun saveFloatOnPreferences(key: String, value: Float) {
        sharedPreferences.edit()
            .putFloat(key, value)
            .apply()
    }

    fun getIntValue(key:String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun getFloatValue(key:String): Float {
       return sharedPreferences.getFloat(key, 0F)
    }
}