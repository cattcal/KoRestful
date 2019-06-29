package cn.hujw.kactionlibrary.ui.banner

import android.content.Context
import cn.hujw.kactionlibrary.R
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.listener.OnItemClickListener

/**
 * @aut hor: hujw
 * @date: 2019/6/29
 * @description:
 * @email: hujw_android@163.com
 */
object BannerCreator {

    /**
     * 创建默认风格的轮播
     */
    fun setDefault(
        context: Context,
        convertBanner: ConvenientBanner<String>,
        banners: ArrayList<String>,
        clickListener: OnItemClickListener
    ) {
        convertBanner.setPages(HolderCreator(context), banners)
            .setPageIndicator(intArrayOf(R.drawable.dot_normal, R.drawable.dot_focus))
            .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
            .setPointViewVisible(true)
            .setOnItemClickListener(clickListener)
            .startTurning(3000)
            .isCanLoop = true
    }
}