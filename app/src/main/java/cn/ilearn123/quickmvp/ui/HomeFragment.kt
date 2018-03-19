package cn.ilearn123.quickmvp.ui

import android.os.Bundle
import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseFragment
import cn.ilearn123.quickmvp.ui.tab1.Fragment1
import cn.ilearn123.quickmvp.ui.tab2.Fragment2
import cn.ilearn123.quickmvp.ui.tab3.Fragment3
import kotlinx.android.synthetic.main.fragment_home.*
import me.majiajie.pagerbottomtabstrip.NavigationController
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem
import me.majiajie.pagerbottomtabstrip.item.NormalItemView
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener
import me.yokeyword.fragmentation.SupportFragment
import org.jetbrains.anko.support.v4.toast


/**
 * Created by dillon on 2017/7/5.
 */

class HomeFragment : BaseFragment() {

    companion object {
        var bottomTab: NavigationController? = null
        val FRAGMENT1 = 0
        val FRAGMENT2 = 1
        val FRAGMENT3 = 2
        val mFragments = arrayOfNulls<SupportFragment>(3)

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        super.initView()
        val firstFragment = findChildFragment(Fragment1::class.java)
        if (firstFragment == null) {
            mFragments[FRAGMENT1] = Fragment1.newInstance()
            mFragments[FRAGMENT2] = Fragment2.newInstance()
            mFragments[FRAGMENT3] = Fragment3.newInstance()
            loadMultipleRootFragment(R.id.fl_tab_container, FRAGMENT1,
                    mFragments[FRAGMENT1],
                    mFragments[FRAGMENT2],
                    mFragments[FRAGMENT3])
        } else {
            mFragments[FRAGMENT1] = firstFragment
            mFragments[FRAGMENT2] = findChildFragment(Fragment2::class.java)
            mFragments[FRAGMENT3] = findChildFragment(Fragment3::class.java)
        }
        bottomTab = bottom_tab.custom()
                .addItem(newItem(R.drawable.tab_xy_normal, R.drawable.tab_xy_pressed, resources.getString(R.string.bottom_tab_1)))
                .addItem(newItem(R.drawable.tab_bag_normal, R.drawable.tab_bag_pressed, resources.getString(R.string.bottom_tab_2)))
                .addItem(newItem(R.drawable.tab_mine_normal, R.drawable.tab_mine_pressed, resources.getString(R.string.bottom_tab_3)))
                .build()
        bottomTab!!.addTabItemSelectedListener(object : OnTabItemSelectedListener {
            override fun onSelected(index: Int, old: Int) {
                when (index) {
                    0 -> {
                        showHideFragment(mFragments[FRAGMENT1])
                    }
                    1 -> {
                        showHideFragment(mFragments[FRAGMENT2])
                    }
                    2 -> {
                        showHideFragment(mFragments[FRAGMENT3])
                        //设置消息圆点
                        bottomTab!!.setMessageNumber(2, 12)
                        bottomTab!!.setHasMessage(2, true)

                    }
                }
            }

            override fun onRepeat(index: Int) {
                when (index) {
                    0 -> {
                        toast("刷新：FRAGMENT1")
                        //重复点击，清空右上角红点
                        bottomTab!!.setMessageNumber(0, 0)
                        bottomTab!!.setHasMessage(0, false)
                    }
                    1 -> {
                        toast("刷新：FRAGMENT2")
                        bottomTab!!.setMessageNumber(1, 0)
                        bottomTab!!.setHasMessage(1, false)
                    }
                    2 -> {
                        toast("刷新：FRAGMENT3")
                        bottomTab!!.setMessageNumber(2, 0)
                        bottomTab!!.setHasMessage(2, false)
                    }

                }
            }
        })
    }

    private fun newItem(drawable: Int, checkedDrawable: Int, text: String): BaseTabItem {
        val normalItemView = NormalItemView(activity)
        normalItemView.initialize(drawable, checkedDrawable, text)
        normalItemView.setTextDefaultColor(resources.getColor(R.color.bottom_bar_text_normal))
        normalItemView.setTextCheckedColor(resources.getColor(R.color.bottom_bar_text_check))
        return normalItemView
    }

}
