package cn.hujw.kactionapp

import android.os.Bundle
import cn.hujw.kactionapp.fragments.KActionMainFragment
import cn.hujw.kactionlibrary.activities.ProxyActivity
import cn.hujw.kactionlibrary.fragments.KActionFragment

class MainActivity : ProxyActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }

    override fun setRootFragment(): KActionFragment {

        return KActionMainFragment()
    }

}
