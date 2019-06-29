package cn.hujw.kactionlibrary.ui.banner

import android.content.Context
import android.view.View
import cn.hujw.kactionlibrary.R
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator
import com.bigkoo.convenientbanner.holder.Holder

/**
 * @author: hujw
 * @date: 2019/6/29
 * @description:
 * @email: hujw_android@163.com
 */
class HolderCreator(context: Context) : CBViewHolderCreator {


    private var context = context


    override fun createHolder(itemView: View?): Holder<*> {
        return ImageHolder(context, itemView)
    }

    override fun getLayoutId(): Int {
        return R.layout.banner_item_layout
    }

}