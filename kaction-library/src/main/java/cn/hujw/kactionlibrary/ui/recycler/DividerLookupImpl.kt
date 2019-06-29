package cn.hujw.kactionlibrary.ui.recycler

import com.choices.divider.Divider
import com.choices.divider.DividerItemDecoration

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description:
 * @email: hujw_android@163.com
 */
class DividerLookupImpl(private val color: Int, private val size: Int) : DividerItemDecoration.DividerLookup {

    override fun getHorizontalDivider(position: Int): Divider {
        return Divider.Builder().size(size).color(color).build()
    }

    override fun getVerticalDivider(position: Int): Divider {
        return Divider.Builder().size(size).color(color).build()
    }
}