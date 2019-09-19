package com.merveylcu.marketim.view.login

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.util.Constants
import com.merveylcu.marketim.util.multiLet
import com.merveylcu.marketim.view.login.LoginScreenResult.*

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginScreenResult = MutableLiveData<LoginScreenResult>()

    fun login(view: View) {
        multiLet(username.value, password.value) { username, password ->
            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (username == Constants.Session.username && password == Constants.Session.password) {
                    loginScreenResult.postValue(SUCCESSFUL)
                } else {
                    loginScreenResult.postValue(WRONG_USER_INFO)
                }
            } else {
                loginScreenResult.postValue(EMPTY_INFO)
            }
        } ?: also {
            loginScreenResult.postValue(EMPTY_INFO)
        }
    }

}

enum class LoginScreenResult {
    EMPTY_INFO,
    WRONG_USER_INFO,
    SUCCESSFUL
}