package com.rfcreations.lifeexpectancychecker.reposiitory

interface UserPreferenceRepository {

    fun getIntPref(key: String, defValue: Int): Int
    fun getBooleanPref(key: String, defValue: Boolean): Boolean

    fun editIntPref(key: String, newValue: Int)
    fun editBooleanPref(key: String, newValue: Boolean)

}