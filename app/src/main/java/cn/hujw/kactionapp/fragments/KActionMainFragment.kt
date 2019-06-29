package cn.hujw.kactionapp.fragments

import android.graphics.Color
import cn.hujw.kactionapp.fragments.bottom.HomeFragment
import cn.hujw.kactionapp.fragments.bottom.ShoppingCartFragment
import cn.hujw.kactionapp.fragments.bottom.SortFragment
import cn.hujw.kactionapp.fragments.bottom.UserFragment
import cn.hujw.kactionlibrary.fragments.bottom.BaseBottomFragment
import cn.hujw.kactionlibrary.fragments.bottom.BottomItemFragment
import cn.hujw.kactionlibrary.fragments.bottom.BottomTabBean
import cn.hujw.kactionlibrary.fragments.bottom.ItemBuilder

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
class KActionMainFragment : BaseBottomFragment() {
    override fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, BottomItemFragment> {

        val items = LinkedHashMap<BottomTabBean, BottomItemFragment>()
        //添加需要的主界面Tab对
        items[BottomTabBean("{fa-home}", "主页")] = HomeFragment()
        items[BottomTabBean("{fa-sort}", "分类")] = SortFragment()
        items[BottomTabBean("{fa-shopping-cart}", "购物")] = ShoppingCartFragment()
        items[BottomTabBean("{fa-user}", "我的")] = UserFragment()

        return builder.addItems(items).build()
    }

    override fun setIndexFragment(): Int {
        return 0
    }

    override fun setClickedColor(): Int {
        return Color.parseColor("#ffff8800")
    }
}