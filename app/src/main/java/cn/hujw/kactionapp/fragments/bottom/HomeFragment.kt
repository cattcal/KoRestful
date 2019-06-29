package cn.hujw.kactionapp.fragments.bottom

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import cn.hujw.kactionapp.R
import cn.hujw.kactionlibrary.fragments.bottom.BottomItemFragment

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
class HomeFragment : BottomItemFragment() {

    private lateinit var mRecyclerView: RecyclerView

    override fun setLayout(): Any {

        return R.layout.fragment_home
    }

    override fun onBindView(saveInstanceState: Bundle?, rootView: View?) {
        mRecyclerView = findView(R.id.rv_home)
    }
}