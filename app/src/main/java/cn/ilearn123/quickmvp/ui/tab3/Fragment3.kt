package cn.ilearn123.quickmvp.ui.tab3

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_3.*
import kotlinx.android.synthetic.main.layout_title_bar.*


/**
 * Created by dillon on 2017/7/5.
 */

class Fragment3 : BaseFragment(), View.OnClickListener {
    private var girdLayoutManager: GridLayoutManager? = null

    var isLoadMore = false  //关闭上拉加载 //判断，是否处于上拉刷新
    val coverUrl1 = "http://img3.duitang.com/uploads/item/201607/06/20160706214940_eXxiR.jpeg"
    val coverUrl2 = "http://cdn.duitang.com/uploads/item/201511/29/20151129133322_dW3uF.thumb.700_0.jpeg"
    val coverUrl3 = "http://img4.duitang.com/uploads/item/201608/01/20160801203242_MiVWK.thumb.700_0.jpeg"
    val coverUrl4 = "http://img3.duitang.com/uploads/item/201607/06/20160706214940_eXxiR.jpeg"
    val coverUrl5 = "http://cdn.duitang.com/uploads/item/201511/29/20151129133322_dW3uF.thumb.700_0.jpeg"
    var distance_recyclerView = 0

    companion object {
        fun newInstance(): Fragment3 {
            val args = Bundle()
            val fragment = Fragment3()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_3
    }



    override fun initView() {
        super.initView()
        titleBar.setTitleBold("页面3", true)
        titleBar.setTitleColor(resources.getColor(R.color.black))
        titleBar.setBackgroundColor(resources.getColor(R.color.white))
        titleBar.setTitleSize(resources.getDimension(R.dimen.title_bar_title_size))
        titleBar.setLeftText("我的")
        titleBar.setLeftTextColor(resources.getColor(R.color.black))
        titleBar_divider.visibility = View.INVISIBLE
        girdLayoutManager = GridLayoutManager(activity, 1)
        recyclerView.layoutManager = girdLayoutManager
        recyclerView.setHasFixedSize(true)
    }

    override fun initListener() {
        super.initListener()
        titleBar.setOnClickListener(this)
        smartRefreshLayout.setOnRefreshListener {
            //
            smartRefreshLayout.finishRefresh()
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            titleBar -> {
                smoothTop(recyclerView)
            }
        }
    }

}



