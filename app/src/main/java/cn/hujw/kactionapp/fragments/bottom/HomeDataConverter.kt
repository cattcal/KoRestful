package cn.hujw.kactionapp.fragments.bottom

import cn.hujw.kactionlibrary.ui.recycler.DataConverter
import cn.hujw.kactionlibrary.ui.recycler.ItemType
import cn.hujw.kactionlibrary.ui.recycler.MultipleFields
import cn.hujw.kactionlibrary.ui.recycler.MultipleItemEntity
import com.alibaba.fastjson.JSON

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description:
 * @email: hujw_android@163.com
 */
class HomeDataConverter : DataConverter() {
    override fun convert(): ArrayList<MultipleItemEntity> {
        val dataArray = JSON.parseObject(jsonData).getJSONArray("data")
        val size = dataArray.size
        for (i in 0 until size) {
            val data = dataArray.getJSONObject(i)
            val imageUrl = data.getString("image_url")
            val text = data.getString("text")
            val spanSize = data.getInteger("spanSize")
            val id = data.getBigInteger("goodsId")
            val banners = data.getJSONArray("banners")

            val bannerImages = ArrayList<String>()
            var type = 0
            //判断渲染数据
            if (imageUrl == null && text != null) {
                type = ItemType.TEXT
            } else if (imageUrl == null && text != null) {
                type = ItemType.IMAGE
            } else if (imageUrl != null) {
                type = ItemType.TEXT_IMAGE
            } else if (banners != null) {
                type = ItemType.BANNER
                //初始化轮播图
                val bannerSize = banners.size
                for (j in 0 until bannerSize) {
                    val banner = banners.getString(j)
                    bannerImages.add(banner)
                }
            }

            //构造Entity
            val entity = MultipleItemEntity.builder()
                .setField(MultipleFields.ITEM_TYPE, type)
                .setField(MultipleFields.SPAN_SIZE, spanSize)
                .setField(MultipleFields.ID, id)
                .setField(MultipleFields.TEXT, text)
                .setField(MultipleFields.IMAGE_URL, imageUrl)
                .setField(MultipleFields.BANNERS, bannerImages)
                .build()

            mEntities.add(entity)
        }
        return mEntities
    }
}