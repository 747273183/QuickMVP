package cn.ilearn123.quickmvp.ui.tab2

import android.os.Bundle
import android.view.View
import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseFragment
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.support.v4.toast


/**
 * Created by dillon on 2017/7/5.
 */

class Fragment2 : BaseFragment() {

    companion object {
        fun newInstance(): Fragment2 {
            val args = Bundle()
            val fragment = Fragment2()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_2
    }


    override fun initView() {
        super.initView()
        titleBar.setTitleBold("页面2", true)
        titleBar.setTitleColor(resources.getColor(R.color.black))
        titleBar.setBackgroundColor(resources.getColor(R.color.white0))
        titleBar.setTitleSize(resources.getDimension(R.dimen.title_bar_title_size))
        titleBar.setLeftClickListener(View.OnClickListener {
            toast("点击了设置")
        })
        titleBar_divider.visibility = View.VISIBLE

    }


}
