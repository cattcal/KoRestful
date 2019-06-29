package cn.hujw.kactionlibrary.net

import android.content.Context
import cn.hujw.kactionlibrary.ui.loader.KActionLoader
import cn.hujw.kactionlibrary.ui.loader.LoaderStyles
import com.hujw.kactionlibrary.net.callback.*
import retrofit2.Call
import retrofit2.Callback
import java.util.*

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description: 对外暴漏，直接使用的客户端
 * @email: hujw_android@163.com
 */
class RestClient internal constructor(
    private val url: String?,
    private val params: WeakHashMap<String, Any>,
    private val request: IRequest?,
    private val success: ISuccess?,
    private val failure: IFailure?,
    private val error: IError?,
    private val complete: IComplete?,
    private val context: Context?,
    private val loaderStyles: LoaderStyles?
) {
    companion object {
        fun builder(): RestClientBuilder {
            return RestClientBuilder()
        }
    }

    private fun request(method: HttpMethod) {
        val service = RestCreator.restService
        val call: Call<String>?
        request?.onRequestStart()

        if (loaderStyles != null) {
            KActionLoader.showLoading(context, loaderStyles)
        }

        call = when (method) {
            HttpMethod.GET -> service.get(url, params)
            HttpMethod.POST -> service.post(url, params)
            HttpMethod.PUT -> service.put(url, params)
            HttpMethod.DELETE -> service.delete(url, params)
            HttpMethod.UPLOAD -> TODO()
            HttpMethod.DOWNLOAD -> TODO()
        }

        call.enqueue(requestCallBack)
    }

    private val requestCallBack: Callback<String>
        get() = RequestCallBacks(request, success, failure, error, complete, loaderStyles)

    fun get() {
        request(HttpMethod.GET)
    }

    fun post() {
        request(HttpMethod.POST)
    }

    fun put() {
        request(HttpMethod.PUT)
    }

    fun delete() {
        request(HttpMethod.DELETE)
    }

    fun downLoad() {
        request(HttpMethod.DOWNLOAD)
    }

    fun upLoad() {
        request(HttpMethod.UPLOAD)
    }
}