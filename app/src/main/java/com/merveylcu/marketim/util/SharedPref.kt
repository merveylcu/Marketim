package com.merveylcu.marketim.util

import android.content.Context

class SharedPref constructor(var context: Context) {

    private val credentialsPreferences: android.content.SharedPreferences
        get() = context.getSharedPreferences(Constants.Preferences.userCredentials, Context.MODE_PRIVATE)

    private val credentialsPreferencesEditor: android.content.SharedPreferences.Editor
        get() = credentialsPreferences.edit()

    var username: String?
        get() = credentialsPreferences.getString(Constants.Preferences.username, "")
        set(username) {
            val editor = credentialsPreferencesEditor.putString(Constants.Preferences.username, username)
            editor.commit()
        }

    var password: String?
        get() = credentialsPreferences.getString(Constants.Preferences.password, "")
        set(password) {
            val editor = credentialsPreferencesEditor.putString(Constants.Preferences.password, password)
            editor.commit()
        }

}