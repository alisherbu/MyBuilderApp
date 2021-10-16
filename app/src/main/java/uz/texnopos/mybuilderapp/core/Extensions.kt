package uz.texnopos.mybuilderapp.core

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import okhttp3.Cache
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.texnopos.mybuilderapp.App
import uz.texnopos.mybuilderapp.App.Companion.getAppInstance
import uz.texnopos.mybuilderapp.R
import uz.texnopos.mybuilderapp.base.AppBaseActivity
import uz.texnopos.mybuilderapp.core.Constants.SharedPref.USER_EMAIL
import uz.texnopos.mybuilderapp.core.Constants.SharedPref.USER_FULLNAME
import uz.texnopos.mybuilderapp.core.Constants.SharedPref.USER_PHONE_NUMBER
import uz.texnopos.mybuilderapp.core.Constants.TAG
import uz.texnopos.mybuilderapp.core.Constants.USER_EXISTS
import uz.texnopos.mybuilderapp.core.Constants.USER_ID
import java.util.*


fun Context.toast(text: String, duration: Int = Toast.LENGTH_LONG) =
    Toast.makeText(this, text, duration).show()

fun Fragment.toast(text: String, duration: Int = Toast.LENGTH_LONG) {
    if (context != null) {
        context!!.toast(text, duration)
    }
}

inline fun <T : View> T.onClick(crossinline func: T.() -> Unit) = setOnClickListener { func() }

fun TextInputEditText.textToString() = this.text.toString()
fun TextView.textToString() = this.text.toString()


fun getSharedPreferences(): SharedPrefUtils {
    return if (App.sharedPrefUtils == null) {
        App.sharedPrefUtils = SharedPrefUtils()
        App.sharedPrefUtils!!
    } else App.sharedPrefUtils!!
}

fun Fragment.isGPSEnable(): Boolean =
    context!!.getLocationManager().isProviderEnabled(LocationManager.GPS_PROVIDER)

fun Context.getLocationManager() = getSystemService(Context.LOCATION_SERVICE) as LocationManager

fun View.showSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    this.requestFocus()
    imm.showSoftInput(this, 0)
}

fun View.hideSoftKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun TextInputEditText.checkIsEmpty(): Boolean = text == null ||
        textToString() == "" ||
        textToString().equals("null", ignoreCase = true)

fun TextInputEditText.showError(error: String) {
    this.error = error
    this.showSoftKeyboard()
}

fun getFullName(): String = getSharedPreferences().getStringValue(USER_FULLNAME)
fun getPhoneNumber(): String = getSharedPreferences().getStringValue(USER_PHONE_NUMBER)
fun getEmail(): String = getSharedPreferences().getStringValue(USER_EMAIL)
fun isLoggedIn() = getSharedPreferences().getIntValue(USER_EXISTS, 0) == 1

var curUserUid = getSharedPreferences().getStringValue(USER_ID)
    set(value) {
        field = value
        getSharedPreferences().setValue(USER_ID, value)
    }


fun clearLoginPref() {
    getSharedPreferences().removeKey(USER_FULLNAME)
    getSharedPreferences().removeKey(USER_PHONE_NUMBER)
    getSharedPreferences().removeKey(USER_EMAIL)
    getSharedPreferences().removeKey(USER_EXISTS)
    getSharedPreferences().removeKey(USER_ID)
}

fun Fragment.showProgress() {
    (requireActivity() as AppBaseActivity).showProgress(true)
}

fun Fragment.hideProgress() {
    (requireActivity() as AppBaseActivity).showProgress(false)
}

fun isNetworkAvailable(): Boolean {
    val info = getAppInstance().getConnectivityManager().activeNetworkInfo
    return info != null && info.isConnected
}

fun Context.getConnectivityManager() =
    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


fun <T> callApi(
    call: Call<T>,
    onApiSuccess: (T?) -> Unit = {},
    onApiError: (errorMsg: String) -> Unit = {},
) {
    Log.d("api_calling", call.request().url.toString())
    call.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            when {
                response.isSuccessful -> onApiSuccess.invoke(response.body())
                else -> {
                    onApiError.invoke(response.errorBody().toString())
                    Log.d("api-failure", response.errorBody().toString())
                }
            }
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            onApiError.invoke(t.localizedMessage!!)
            Log.d("api-failure", t.localizedMessage!!)
        }

    })
}

fun Long.toDate(): String {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this
    return calendar.time.toString()
}

fun Fragment.setStatusBarColor(colorId: Int) {
    when (colorId) {
        R.color.sky -> requireActivity().window.decorView.systemUiVisibility = 0
        R.color.white -> requireActivity().window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
    requireActivity().window.statusBarColor = ContextCompat.getColor(requireContext(), colorId)
}

fun showLog(msg: String) {
    Log.d(TAG, msg)
}

const val cacheSize = (5 * 1024 * 1024).toLong()
val myCache = Cache(getAppInstance().cacheDir, cacheSize)