package cn.hujw.kactionlibrary.fragments.bottom

import android.widget.Toast
import cn.hujw.kactionlibrary.fragments.KActionFragment

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
abstract class BottomItemFragment : KActionFragment() {

    private var mTouchTime: Long = 0

    companion object {
        private const val WAIT_TIME = 2000L
    }

    override fun onBackPressedSupport(): Boolean {
        if (System.currentTimeMillis() - mTouchTime < WAIT_TIME) {
            _mActivity.finish()
        } else {
            mTouchTime = System.currentTimeMillis()
            Toast.makeText(_mActivity, "双击退出", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}