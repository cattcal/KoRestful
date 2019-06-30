package cn.hujw.kactionlibrary.ui.banner

import cn.hujw.kactionlibrary.R
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer

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
        banner: Banner, banners: List<*>
    ) {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
        banner.setImageLoader(GlideImageLoader()) //图片加载器
        banner.setImages(banners)
        banner.setBannerAnimation(Transformer.Default)
        banner.isAutoPlay(true)
        banner.setDelayTime(3000)
        banner.setIndicatorGravity(BannerConfig.CENTER)
        banner.start()
    }
}