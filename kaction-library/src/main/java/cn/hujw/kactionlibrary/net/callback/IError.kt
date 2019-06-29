package com.hujw.kactionlibrary.net.callback

interface IError {
    fun onError(code: Int, msg: String)
}