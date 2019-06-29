package cn.hujw.kactionlibrary.ui.recycler

import android.support.annotation.ColorInt
import com.choices.divider.DividerItemDecoration

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description:
 * @email: hujw_android@163.com
 */
class BaseDecoration private constructor(@ColorInt color: Int, size: Int) : DividerItemDecoration() {
    init {
        setDividerLookup(DividerLookupImpl(color, size))
    }

    companion object {
        fun create(@ColorInt color: Int, size: Int): BaseDecoration {
            return BaseDecoration(color, size)
        }
    }
}