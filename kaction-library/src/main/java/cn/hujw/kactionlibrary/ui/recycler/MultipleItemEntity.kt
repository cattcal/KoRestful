package cn.hujw.kactionlibrary.ui.recycler

import com.chad.library.adapter.base.entity.MultiItemEntity
import kotlin.collections.LinkedHashMap

/**
 * @author: hujw
 * @date: 2019/6/29
 * @description:
 * @email: hujw_android@163.com
 */
class MultipleItemEntity internal constructor(fields: LinkedHashMap<Any, Any>) : MultiItemEntity {

    private val mMultipleFields = LinkedHashMap<Any, Any>()

    init {
        mMultipleFields.putAll(fields)
    }

    companion object {
        fun builder(): MutipleEntityBuilder {
            return MutipleEntityBuilder()
        }
    }

    override fun getItemType(): Int {
        return mMultipleFields[MultipleFields.ITEM_TYPE] as Int
    }

    fun <T> getField(key: Any): T {
        @Suppress("UNCHECKED_CAST")
        return mMultipleFields[key] as T
    }

    fun setField(key: Any, value: Any): MultipleItemEntity {
        mMultipleFields[key] = value
        return this
    }
}