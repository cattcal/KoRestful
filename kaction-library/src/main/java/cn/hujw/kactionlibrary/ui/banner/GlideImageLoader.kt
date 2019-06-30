package cn.hujw.kactionlibrary.ui.banner

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.youth.banner.loader.ImageLoader

/**
 * @author: hujw
 * @date: 2019/7/1
 * @description:
 * @email: hujw_android@163.com
 */
class GlideImageLoader : ImageLoader() {


    companion object {

        private val BANNER_POSITIONS =
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL) //全部缓存
                .dontAnimate().centerCrop()
    }

    override fun createImageView(context: Context?): ImageView {
        return AppCompatImageView(context)
    }

    override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
        Glide.with(context).load(path).apply(BANNER_POSITIONS).into(imageView)

    }
}