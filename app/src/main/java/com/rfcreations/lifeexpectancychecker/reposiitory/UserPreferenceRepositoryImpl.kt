package com.rfcreations.lifeexpectancychecker.reposiitory

import android.content.SharedPreferences

class UserPreferenceRepositoryImpl(
    private val sharedPreferences: SharedPreferences
) : UserPreferenceRepository {

    override fun getIntPref(key: String, defValue: Int): Int {
        return sharedPreferences.getInt(key, defValue)
    }
    override fun getBooleanPref(key: String, defValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defValue)
    }
    override fun editIntPref(key: String, newValue: Int) {
        sharedPreferences.edit().putInt(key, newValue).apply()
    }
    override fun editBooleanPref(key: String, newValue: Boolean) {
        sharedPreferences.edit().putBoolean(key, newValue).apply()
    }
}