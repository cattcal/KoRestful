package cn.hujw.kactionlibrary.fragments.bottom

import android.graphics.Color
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.v7.widget.AppCompatTextView
import android.support.v7.widget.LinearLayoutCompat
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import cn.hujw.kactionlibrary.R
import cn.hujw.kactionlibrary.fragments.KActionFragment
import com.joanzapata.iconify.widget.IconTextView
import me.yokeyword.fragmentation.ISupportFragment

/**
 * @author: hujw
 * @date: 2019/6/27
 * @description:
 * @email: hujw_android@163.com
 */
abstract class BaseBottomFragment : KActionFragment(), View.OnClickListener {

    private val mTabBean = ArrayList<BottomTabBean>()

    val mItemFragments = ArrayList<BottomItemFragment>()

    private val mItems = LinkedHashMap<BottomTabBean, BottomItemFragment>()

    private var mCurrentFragment = 0

    //设置首页一打开展示平级的Fragment
    private var mIndexFragment = 0

    private var mClickedColor = Color.RED

    private lateinit var mBottomBar: LinearLayoutCompat

    abstract fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, BottomItemFragment>

    override fun setLayout(): Any {
        return R.layout.fragment_bottom
    }

    /**
     * 设置首页一打开展示平级的Fragment
     */
    abstract fun setIndexFragment(): Int

    @ColorInt
    abstract fun setClickedColor(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mIndexFragment = setIndexFragment()

        if (setClickedColor() != 0) {
            mClickedColor = setClickedColor()
        }

        val builder = ItemBuilder.builder()
        val items = setItems(builder)
        mItems.putAll(items)

        for ((key, value) in mItems) {
            mTabBean.add(key)
            mItemFragments.add(value)
        }
    }

    override fun onBindView(saveInstanceState: Bundle?, rootView: View?) {
        mBottomBar = findView(R.id.bottom_bar)
        val size = mItems.size
        for (i in 0 until size) {
            LayoutInflater.from(context).inflate(R.layout.bottom_item_icon__text, mBottomBar)

            val item = mBottomBar.getChildAt(i) as RelativeLayout

            //辨认点击事件
            item.tag = i
            item.setOnClickListener(this)

            val itemIcon = item.getChildAt(0) as IconTextView
            val itemTitle = item.getChildAt(1) as AppCompatTextView

            //初始化数据
            val bean = mTabBean[i]
            itemIcon.text = bean.icon
            itemTitle.text = bean.title

            if (i == mIndexFragment) {
                itemIcon.setTextColor(mClickedColor)
                itemTitle.setTextColor(mClickedColor)
            }
        }

        val fragments = mItemFragments.toTypedArray<ISupportFragment>()
        supportDelegate.loadMultipleRootFragment(R.id.bottom_bar_fragment_container,mIndexFragment,*fragments)
    }

    private fun resetColor() {
        val count = mBottomBar.childCount
        for (i in 0 until count) {
            val item =
                mBottomBar.getChildAt(i) as RelativeLayout
            val itemIcon =
                item.getChildAt(0) as IconTextView
            val itemTitle =
                item.getChildAt(1) as AppCompatTextView
            itemIcon.setTextColor(Color.GRAY)
            itemTitle.setTextColor(Color.GRAY)
        }
    }

    private fun changeColor(tabIndex: Int) {
        resetColor()
        val item =
            mBottomBar.getChildAt(tabIndex) as RelativeLayout
        val itemIcon =
            item.getChildAt(0) as IconTextView
        val itemTitle =
            item.getChildAt(1) as AppCompatTextView
        itemIcon.setTextColor(mClickedColor)
        itemTitle.setTextColor(mClickedColor)
    }


    override fun onClick(v: View) {
        val tabIndex = v.tag as Int
        changeColor(tabIndex)
        //展示和隐藏内容部分的
        supportDelegate.showHideFragment(
            mItemFragments[tabIndex],
            mItemFragments[mCurrentFragment]
        )
        //先后顺序不能错
        mCurrentFragment = tabIndex
    }
}