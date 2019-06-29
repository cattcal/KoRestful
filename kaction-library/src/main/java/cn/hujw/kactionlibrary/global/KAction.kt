package cn.hujw.kactionlibrary.global

import android.content.Context
import cn.hujw.kactionlibrary.utils.storage.MemoryStore
import com.blankj.utilcode.util.Utils

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description:
 * @email: hujw_android@163.com
 */
object KAction {
    val configurator: Configurator
        get() = Configurator.instance

    fun init(context: Context): Configurator {
        MemoryStore.instance.addData(GlobalKeys.APPLICATION_CONTEXT, context.applicationContext)
        Utils.init(context) //初始化工具类
        return Configurator.instance
    }

    fun <T> getConfiguration(key: String): T {
        return configurator.getConfiguration(key)
    }

    fun <T> getConfiguration(key: Enum<GlobalKeys>): T {
        return getConfiguration(key.name)
    }
}