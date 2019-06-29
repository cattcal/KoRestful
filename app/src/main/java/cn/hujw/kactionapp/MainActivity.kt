package cn.hujw.kactionapp

import cn.hujw.kactionapp.fragments.KActionMainFragment
import cn.hujw.kactionlibrary.activities.ProxyActivity
import cn.hujw.kactionlibrary.fragments.KActionFragment

class MainActivity : ProxyActivity() {

    override fun setRootFragment(): KActionFragment {

        return KActionMainFragment()
    }

}
