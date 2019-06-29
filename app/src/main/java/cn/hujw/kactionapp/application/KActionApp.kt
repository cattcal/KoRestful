package cn.hujw.kactionapp.application

import android.app.Application
import cn.hujw.kactionlibrary.global.KAction
import com.joanzapata.iconify.fonts.FontAwesomeModule

/**
 * @author: hujw
 * @date: 2019/6/26
 * @description: 整个程序的入口 进行初始化工作
 * @email: hujw_android@163.com
 */
class KActionApp : Application() {

    override fun onCreate() {
        super.onCreate()
        KAction.init(this)
            .withIcon(FontAwesomeModule())
            .withLoaderDelayed(2000) ///假装延迟测试 观察Loding
            .withApiHost("http://mock.fulingjie.com/mock/api/")
            .configure()
    }
}