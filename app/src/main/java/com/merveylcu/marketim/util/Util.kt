package com.merveylcu.marketim.util

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.widget.Toast

class Util {

    companion object {

        fun isConnectedToInternet(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            return activeNetwork?.isConnected == true
        }

        fun showToast(activity: Activity, stringResId: Int) {
            Toast.makeText(activity, activity.resources.getString(stringResId), Toast.LENGTH_LONG).show()
        }

    }

}