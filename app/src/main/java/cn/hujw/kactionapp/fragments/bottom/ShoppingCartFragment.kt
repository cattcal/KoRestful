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

    override fun setLayout(): Any {

        return R.layout.fragment_shopping_cart
    }

    override fun onBindView(saveInstanceState: Bundle?, rootView: View?) {

    }


}