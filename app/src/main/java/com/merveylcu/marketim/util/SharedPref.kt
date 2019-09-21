package com.merveylcu.marketim.util

import android.content.Context

class SharedPref constructor(var context: Context) {

    private val credentialsPreferences: android.content.SharedPreferences
        get() = context.getSharedPreferences(Constants.SharedPref.userCredentials, Context.MODE_PRIVATE)

    private val credentialsPreferencesEditor: android.content.SharedPreferences.Editor
        get() = credentialsPreferences.edit()

    var username: String?
        get() = credentialsPreferences.getString(Constants.SharedPref.username, "")
        set(username) {
            val editor = credentialsPreferencesEditor.putString(Constants.SharedPref.username, username)
            editor.commit()
        }

    var password: String?
        get() = credentialsPreferences.getString(Constants.SharedPref.password, "")
        set(password) {
            val editor = credentialsPreferencesEditor.putString(Constants.SharedPref.password, password)
            editor.commit()
        }

    fun clearCredentials() {
        credentialsPreferencesEditor.clear().commit()
    }

}