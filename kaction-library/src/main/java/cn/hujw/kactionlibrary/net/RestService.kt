package cn.hujw.kactionlibrary.net

import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description: Restful
 * @email: hujw_android@163.com
 */
interface RestService {

    @GET
    fun get(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @FormUrlEncoded
    fun put(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    @DELETE
    fun delete(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<String>

    //下载一部分写一部分写到内存里，而不是一次性下载
    @Streaming
    @GET
    fun download(@Url url: String?, @QueryMap params: WeakHashMap<String, Any>?): Call<ResponseBody>

    fun upload(@Url url: String?, @Part file: MultipartBody.Part?): Call<String>

}