package com.vstd.weather.util

import android.app.Activity
import android.content.Context
import com.vstd.weather.consts.Keys

class UserPref {
    fun getUnits(activity: Activity): String? {
        return activity.getPreferences(Context.MODE_PRIVATE)
            .getString(Keys.UNITS, "metric")
    }

    fun setUnits(activity: Activity, newUnits: String) {
        activity.getPreferences(Context.MODE_PRIVATE)
            .edit()
            .putString(Keys.UNITS, newUnits)
            .apply()
    }
}