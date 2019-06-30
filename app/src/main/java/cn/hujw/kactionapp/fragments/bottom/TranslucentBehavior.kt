package cn.hujw.kactionapp.fragments.bottom

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import cn.hujw.kactionapp.R
import cn.hujw.kactionlibrary.global.GlobalKeys
import cn.hujw.kactionlibrary.global.KAction

/**
 * @author: hujw
 * @date: 2019/7/1
 * @description:
 * @email: hujw_android@163.com
 */
class TranslucentBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<Toolbar>(context, attrs) {
    companion object {
        //延长滑动
        private const val MORE = 100
    }

    private var mOffset = 0

    override fun layoutDependsOn(parent: CoordinatorLayout, child: Toolbar, dependency: View): Boolean {

        return dependency.id == R.id.rv_home
    }


    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: Toolbar,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return true
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        toolbar: Toolbar,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
        val startOffset = 0
        val context =
            KAction.getConfiguration<Context>(GlobalKeys.APPLICATION_CONTEXT)
        val endOffset = context.resources.getDimensionPixelOffset(
            R.dimen.header_height
        ) + MORE
        mOffset += dyConsumed
        when {
            mOffset <= startOffset -> toolbar.background.alpha = 0
            mOffset in (startOffset + 1)..(endOffset - 1) -> {
                val percent =
                    (mOffset - startOffset).toFloat() / endOffset
                val alpha = Math.round(percent * 255)
                toolbar.background.alpha = alpha
            }
            mOffset >= endOffset -> toolbar.background
        }
    }
}
