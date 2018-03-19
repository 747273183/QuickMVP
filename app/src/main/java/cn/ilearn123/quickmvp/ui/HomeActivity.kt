package cn.ilearn123.quickmvp.ui

import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseActivity


/**
 * Created by dillon on 2017/7/5.
 */

class HomeActivity : BaseActivity() {

    override fun layoutId(): Int {
        return R.layout.activity_home
    }

    override fun initView() {
        if (findFragment(HomeFragment::class.java) == null) {
            loadRootFragment(R.id.fl_container, HomeFragment.newInstance())  // 加载根Fragment
        }
    }

    override fun onBackPressedSupport() {
        super.onBackPressedSupport()
        logOutApp()
    }
}
