package cn.hujw.kactionlibrary.ui.recycler

import android.view.View
import com.chad.library.adapter.base.BaseViewHolder

/**
 * @author: hujw
 * @date: 2019/6/30
 * @description:
 * @email: hujw_android@163.com
 */
class MultipleViewHolder constructor(view:View):BaseViewHolder(view){

    //简单工厂模式的创建
    companion object{
        fun create(view:View):MultipleViewHolder{
            return MultipleViewHolder(view)
        }
    }
}