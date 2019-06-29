package cn.hujw.kactionlibrary.utils.storage

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description:
 * @email: hujw_android@163.com
 */
class MemoryStore private constructor() {

    private object Holder {
        internal val INSTANCE = MemoryStore()
    }

    companion object {
        val instance: MemoryStore
            get() = Holder.INSTANCE
    }

    private val mDataMap = HashMap<String, Any>()

    fun <T> getData(key: String): T {
        @Suppress("UNCHECKED_CAST")
        return mDataMap[key] as T
    }

    fun <T> getData(key: Enum<*>): T {
        return getData(key.name)
    }

    fun addData(key: String, value: Any): MemoryStore {
        mDataMap[key] = value
        return this
    }

    fun addData(key: Enum<*>, value: Any): MemoryStore {
        addData(key.name, value)
        return this
    }
}