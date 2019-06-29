package cn.hujw.kactionlibrary.ui.recycler

import java.lang.NullPointerException

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description: 数据转换曾
 * @email: hujw_android@163.com
 */
abstract class DataConverter {

    protected val mEntities = ArrayList<MultipleItemEntity>()

    private lateinit var mJsonData: String

    protected val jsonData: String
        get() {
            if (mJsonData.isEmpty()) {
                throw NullPointerException("Data is null")
            }
            return mJsonData
        }

    abstract fun convert(): ArrayList<MultipleItemEntity>

    fun setJsonData(json: String): DataConverter {
        this.mJsonData = json
        return this
    }

    fun clearData() {
        mEntities.clear()
    }
}