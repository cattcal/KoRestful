package cn.hujw.kactionlibrary.ui.banner

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.view.View
import com.bigkoo.convenientbanner.holder.Holder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

/**
 * @author: hujw
 * @date: 2019/6/29
 * @description:
 * @email: hujw_android@163.com
 */
class ImageHolder(itemView: View?) : Holder<String>(itemView) {
    private lateinit var mImageView: AppCompatImageView

    //private var context = context

    companion object {
        private val BANNER_POSITIONS =
            RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.ALL) //全部缓存
                .dontAnimate().centerCrop()
    }


    override fun initView(itemView: View) {
        mImageView = AppCompatImageView(itemView.context)
    }

    override fun updateUI(data: String?) {
        Glide.with(itemView.context).load(data).apply(BANNER_POSITIONS).into(mImageView)
    }


}