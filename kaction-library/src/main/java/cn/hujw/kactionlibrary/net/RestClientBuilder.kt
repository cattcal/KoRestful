package cn.hujw.kactionlibrary.net

import android.content.Context
import cn.hujw.kactionlibrary.ui.loader.LoaderStyles
import com.hujw.kactionlibrary.net.callback.*
import java.util.*

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description:
 * @email: hujw_android@163.com
 */
class RestClientBuilder(
    private var url: String? = null,
    private var request: IRequest? = null,
    private var success: ISuccess? = null,
    private var failure: IFailure? = null,
    private var error: IError? = null,
    private var complete: IComplete? = null,
    private var context: Context? = null,
    private var loaderStyles: LoaderStyles? = null
) {
    private val mPamars = WeakHashMap<String, Any>()

    fun url(url: String): RestClientBuilder {
        this.url = url
        return this
    }

    fun params(key: String, value: Any): RestClientBuilder {
        mPamars[key] = value
        return this
    }

    fun params(params: WeakHashMap<String, Any>): RestClientBuilder {
        mPamars.putAll(params)
        return this
    }

    fun request(iRequest: IRequest): RestClientBuilder {
        this.request = iRequest
        return this
    }

    fun success(iSuccess: ISuccess): RestClientBuilder {
        this.success = iSuccess
        return this
    }

    fun failure(iFailure: IFailure): RestClientBuilder {
        this.failure = iFailure
        return this
    }

    fun error(iError: IError): RestClientBuilder {
        this.error = iError
        return this
    }

    fun complete(iComplete: IComplete): RestClientBuilder {
        this.complete = iComplete
        return this
    }

    fun loader(context: Context?,styles: LoaderStyles):RestClientBuilder{
        this.context=context
        this.loaderStyles=styles
        return this
    }


    fun loader(context: Context?):RestClientBuilder{
        this.context=context
        this.loaderStyles=LoaderStyles.BallClipRotateIndicator
        return this
    }
    fun build(): RestClient {
        return RestClient(url, mPamars, request, success, failure, error, complete,context,loaderStyles)
    }

}