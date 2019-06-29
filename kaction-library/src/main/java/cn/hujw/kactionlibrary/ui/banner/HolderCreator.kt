package cn.hujw.kactionlibrary.ui.banner

import android.view.View
import cn.hujw.kactionlibrary.R
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator

/**
 * @author: hujw
 * @date: 2019/6/29
 * @description:
 * @email: hujw_android@163.com
 */
class HolderCreator : CBViewHolderCreator {

    override fun createHolder(itemView: View?): ImageHolder {
        return ImageHolder(itemView)
    }

    override fun getLayoutId(): Int {
        return R.layout.item_multiple_banner
    }

}