package cn.hujw.kactionapp.fragments.bottom

import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import cn.hujw.kactionapp.R
import cn.hujw.kactionlibrary.fragments.bottom.BottomItemFragment
import cn.hujw.kactionlibrary.net.RestClient
import cn.hujw.kactionlibrary.ui.recycler.BaseDecoration
import cn.hujw.kactionlibrary.ui.recycler.MultipleRecyclerAdapter
import com.hujw.kactionlibrary.net.callback.ISuccess

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
class HomeFragment : BottomItemFragment() {

    private lateinit var mRecyclerView: RecyclerView

    override fun setLayout(): Any {

        return R.layout.fragment_home
    }

    override fun onBindView(saveInstanceState: Bundle?, rootView: View?) {
        mRecyclerView = findView(R.id.rv_home)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //ToolBar 初始状态图 透明
        val toolBar = view.findViewById<Toolbar>(R.id.tb_home)
        toolBar.background.alpha = 0
    }

    //懒加载数据和UI
    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        initRecyclerView()
        initData()
    }

    private fun initRecyclerView() {
        val manager = GridLayoutManager(context, 4)
        mRecyclerView.layoutManager = manager
        mRecyclerView.addItemDecoration(BaseDecoration.create(Color.LTGRAY, 5))
    }

    private fun initData() {
        RestClient.builder().url("index.php").loader(context).success(object : ISuccess {
            override fun onSuccess(response: String) {
                val adapter = MultipleRecyclerAdapter.create(HomeDataConverter().setJsonData(response))
                mRecyclerView.adapter = adapter
            }
        }).build().get()
    }
}