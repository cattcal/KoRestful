package cn.hujw.kactionlibrary.net

import cn.hujw.kactionlibrary.global.GlobalKeys
import cn.hujw.kactionlibrary.global.KAction
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description: 创建Retrofit的各个实例
 * @email: hujw_android@163.com
 */
object  RestCreator {

    /**
     * 构建OKHttp
     */
    private object OkHttpHolder {
        private const val TIME_OUT = 60
        private val BUILDER = OkHttpClient.Builder()
        internal val OK_HTTP_CLIENT = BUILDER
            .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
            .build()
    }

    private object RetrofitHolder {
        //从全局配置中获取baseUrl
        private val BASE_URL = KAction.getConfiguration<String>(GlobalKeys.API_HOST)

        internal val REFROFIT_CLIENT = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpHolder.OK_HTTP_CLIENT)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private object RestServiceHolder {
        internal val REST_SERVICE = RetrofitHolder.REFROFIT_CLIENT
            .create(RestService::class.java)
    }

    val restService:RestService
    get() = RestServiceHolder.REST_SERVICE
}