package cn.hujw.kactionapp.fragments.bottom

import android.os.Bundle
import android.view.View
import android.widget.Toast
import cn.hujw.kactionapp.R
import cn.hujw.kactionlibrary.fragments.KActionFragment
import cn.hujw.kactionlibrary.fragments.bottom.BottomItemFragment
import cn.hujw.kactionlibrary.ui.banner.BannerCreator
import com.bigkoo.convenientbanner.ConvenientBanner
import com.bigkoo.convenientbanner.listener.OnItemClickListener
import com.blankj.utilcode.util.ToastUtils

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
class ShoppingCartFragment : BottomItemFragment() {

    private lateinit var convenientBanner: ConvenientBanner<String>

    private lateinit var arrayList: ArrayList<String>

    override fun setLayout(): Any {

        return R.layout.fragment_shopping_cart
    }

    override fun onBindView(saveInstanceState: Bundle?, rootView: View?) {
        addData()
        BannerCreator.setDefault(
            rootView!!.context,
            convenientBanner,
            arrayList,
            OnItemClickListener {
                ToastUtils.showShort("点击了不知道第几个")
            })
    }


    private fun addData() {
        arrayList = ArrayList()
        arrayList.add("http://img2.imgtn.bdimg.com/it/u=1447362014,2103397884&fm=200&gp=0.jpg");
        arrayList.add("http://img1.imgtn.bdimg.com/it/u=111342610,3492888501&fm=26&gp=0.jpg");
        arrayList.add("http://imgsrc.baidu.com/imgad/pic/item/77094b36acaf2eddc8c37dc7861001e9390193e9.jpg");
    }
}