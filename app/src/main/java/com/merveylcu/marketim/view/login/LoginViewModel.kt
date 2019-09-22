package com.merveylcu.marketim.view.login

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.merveylcu.marketim.util.Constants
import com.merveylcu.marketim.util.SharedPref
import com.merveylcu.marketim.util.multiLet
import com.merveylcu.marketim.view.login.LoginScreenResult.*

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val loginScreenResult = MutableLiveData<LoginScreenResult>()

    /**
     * giriş yap butonuna basılması durumunda çalışır.
     * gerekli kontrollere göre loginScreenResult değerini setler.
     */
    fun onClickedLogin(view: View) {
        multiLet(username.value, password.value) { username, password ->
            if (username.isNotEmpty() && password.isNotEmpty()) {
                if (isCorrectLoginInfo()) {
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

    /**
     * beni hatırla switch'i açılıp kapandığında çalışır.
     * switch açıksa ve girilen username ve password doğru ise bilgiler,
     * SharedPref sınıfına gönderilerek burada saklanır.
     */
    fun onCheckedChangedRememberMe(view: View, isChecked: Boolean) {
        if (isChecked && isCorrectLoginInfo()) {
            multiLet(username.value, password.value) { username, password ->
                val sharedPref = SharedPref(view.context)
                sharedPref.username = username
                sharedPref.password = password
            }
        }
    }

    /**
     * girilen username ve password doğruluğunun kontrolünü yapar.
     */
    private fun isCorrectLoginInfo(): Boolean {
        var isCorrect = false
        multiLet(username.value, password.value) { username, password ->
            isCorrect = username == Constants.Session.username && password == Constants.Session.password
        }
        return isCorrect
    }

}

enum class LoginScreenResult {
    EMPTY_INFO,
    WRONG_USER_INFO,
    SUCCESSFUL
}