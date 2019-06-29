package cn.hujw.kactionlibrary.fragments.bottom

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
class ItemBuilder {

    //LinkedHashMap有序显示底部Tab
    private val mItems = LinkedHashMap<BottomTabBean, BottomItemFragment>()

    companion object {
        internal fun builder(): ItemBuilder {
            return ItemBuilder()
        }
    }

    fun addItem(bean: BottomTabBean, fragment: BottomItemFragment): ItemBuilder {
        mItems[bean] = fragment
        return this
    }

    fun addItems(items: LinkedHashMap<BottomTabBean, BottomItemFragment>): ItemBuilder {
        mItems.putAll(items)
        return this
    }

    fun build(): LinkedHashMap<BottomTabBean, BottomItemFragment> {
        return mItems
    }
}