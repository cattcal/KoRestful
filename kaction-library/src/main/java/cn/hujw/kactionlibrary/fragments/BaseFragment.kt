package cn.hujw.kactionlibrary.fragments

import android.os.Bundle
import android.support.annotation.IdRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.SupportFragment
import java.lang.ClassCastException
import java.lang.NullPointerException

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
abstract class BaseFragment : SupportFragment() {

    private lateinit var mRootView: View

    abstract fun setLayout(): Any

    abstract fun onBindView(saveInstanceState: Bundle?, rootView: View?)

    fun <T : View> findView(@IdRes viewId: Int): T {

        return mRootView.findViewById(viewId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = when {
            setLayout() is Int -> inflater.inflate(setLayout() as Int, container, false)
            setLayout() is View -> setLayout() as View
            else -> throw ClassCastException("type of setLayout() must be int or view")
        }
        mRootView = rootView
        onBindView(savedInstanceState, rootView)
        return rootView
    }

}