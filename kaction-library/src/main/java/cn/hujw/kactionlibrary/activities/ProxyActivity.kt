package cn.hujw.kactionlibrary.activities

import android.os.Bundle
import android.widget.FrameLayout
import cn.hujw.kactionlibrary.R
import cn.hujw.kactionlibrary.fragments.KActionFragment
import me.yokeyword.fragmentation.SupportActivity


/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
abstract class ProxyActivity : SupportActivity() {

    abstract fun setRootFragment(): KActionFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val container = FrameLayout(this)
        container.id = R.id.fragment_container
        setContentView(container)
        if (savedInstanceState == null) {
            loadRootFragment(R.id.fragment_container, setRootFragment())
        }
    }
}