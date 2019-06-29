package com.hujw.kactionlibrary.net.callback

import android.os.Handler
import android.util.Log
import cn.hujw.kactionlibrary.global.GlobalKeys
import cn.hujw.kactionlibrary.global.KAction
import cn.hujw.kactionlibrary.ui.loader.KActionLoader
import cn.hujw.kactionlibrary.ui.loader.LoaderStyles
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestCallBacks(
    private val request: IRequest?,
    private val success: ISuccess?,
    private val failure: IFailure?,
    private val error: IError?,
    private val complete: IComplete?,
    private val loaderStyle: LoaderStyles?
) : Callback<String> {

    override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
            if (call.isExecuted) {
                if (success != null) {
                    if (response.body() != null) {
                        success.onSuccess(response.body().toString())
                    }
                }
            }
        } else {
            error?.onError(response.code(), response.message())
        }
        onRequestFinish()
    }

    private fun onRequestFinish() {
        val delayed = KAction.getConfiguration<Long>(GlobalKeys.LOADER_DELAYED)
        if (loaderStyle != null) {
            HANDLER.postDelayed({KActionLoader.stopLoading()},delayed)
        }
    }

    override fun onFailure(call: Call<String>, t: Throwable) {
        Log.d("onFailure", "${t.message}")
        failure?.onFailure()
        request?.onRequestEnd()
    }

    companion object {
        private var HANDLER = KAction.getConfiguration<Handler>(GlobalKeys.HANDLER)
    }

}