package cn.hujw.kactionlibrary.ui.recycler

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description:
 * @email: hujw_android@163.com
 */
class MultipleEntityBuilder {

    companion object {
        private val FIELDS = LinkedHashMap<Any, Any>()
    }

    init {
        //清空上一个数据
        FIELDS.clear()
    }

    fun setItemType(itemType: Int): MultipleEntityBuilder {
        FIELDS[MultipleFields.ITEM_TYPE] = itemType
        return this
    }

    fun setField(key: Any, value: Any?): MultipleEntityBuilder {
        if (value != null)
            FIELDS[key] = value
        return this
    }

    fun setFields(map: LinkedHashMap<*, *>): MultipleEntityBuilder {
        FIELDS.putAll(map)
        return this
    }

    fun build(): MultipleItemEntity {
        return MultipleItemEntity(FIELDS)
    }
}