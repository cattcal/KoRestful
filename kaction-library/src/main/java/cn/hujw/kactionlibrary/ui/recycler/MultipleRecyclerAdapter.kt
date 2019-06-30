package cn.hujw.kactionlibrary.ui.recycler

import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.ImageView
import cn.hujw.kactionlibrary.R
import cn.hujw.kactionlibrary.ui.banner.BannerCreator
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.youth.banner.Banner

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description:
 * @email: hujw_android@163.com
 */
open class MultipleRecyclerAdapter constructor(data: List<MultipleItemEntity>) :
    BaseMultiItemQuickAdapter<MultipleItemEntity, MultipleViewHolder>(data), BaseQuickAdapter.SpanSizeLookup{

    //确保Banner初始化一次
    private var mIsInitBanner = false

    //初始化静态的参数和对象
    companion object {
        private val RECYCLER_POSITIONS =
            RequestOptions().centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate()

        fun create(data: List<MultipleItemEntity>): MultipleRecyclerAdapter {
            return MultipleRecyclerAdapter(data)
        }

        fun create(converter: DataConverter): MultipleRecyclerAdapter {
            return MultipleRecyclerAdapter(converter.convert())
        }
    }

    init {
        initView()
    }

    //根据不同的布局初始化响应的UI
    private fun initView() {
        addItemType(ItemType.TEXT, R.layout.item_multiple_text)
        addItemType(ItemType.IMAGE, R.layout.item_multiple_image)
        addItemType(ItemType.TEXT_IMAGE, R.layout.item_multiple_text_image)
        addItemType(ItemType.BANNER, R.layout.item_multiple_banner)

        //设置宽度监听
        setSpanSizeLookup(this)
        openLoadAnimation()
        //反复动画
        isFirstOnly(false)
    }

    override fun createBaseViewHolder(view: View): MultipleViewHolder {
        return MultipleViewHolder.create(view)
    }

    //将布局转换为UI需要的方法
    override fun convert(holder: MultipleViewHolder, entity: MultipleItemEntity) {
        val text: String
        val imageUrl: String
        val bannerImages: ArrayList<String>

        when (holder.itemViewType) {
            ItemType.TEXT -> {
                text = entity.getField(MultipleFields.TEXT)
                holder.setText(R.id.text_single, text)
            }

            ItemType.IMAGE -> {
                imageUrl = entity.getField(MultipleFields.IMAGE_URL)
                Glide.with(mContext).load(imageUrl).apply(RECYCLER_POSITIONS)
                    .into(holder.getView<View>(R.id.img_single) as ImageView)
            }

            ItemType.TEXT_IMAGE -> {
                text = entity.getField(MultipleFields.TEXT)
                imageUrl = entity.getField(MultipleFields.IMAGE_URL)
                holder.setText(R.id.tv_multiple, text)
                Glide.with(mContext).load(imageUrl).apply(RECYCLER_POSITIONS)
                    .into(holder.getView<View>(R.id.img_multiple) as ImageView)
            }

            ItemType.BANNER -> if (!mIsInitBanner) {
                bannerImages = entity.getField(MultipleFields.BANNERS)
                val banner = holder.getView<Banner>(R.id.banner_recycler_item)
                //设置默认的Banner
                BannerCreator.setDefault(banner, bannerImages)
                mIsInitBanner = true
            }

            else -> {
            }

        }
    }

    //根据SpanSize来判断多布局的分割
    override fun getSpanSize(gridLayoutManager: GridLayoutManager?, position: Int): Int {
        return data[position].getField(MultipleFields.SPAN_SIZE)
    }


}