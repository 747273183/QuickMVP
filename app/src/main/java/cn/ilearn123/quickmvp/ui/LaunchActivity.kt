package cn.ilearn123.quickmvp.ui

import android.content.Intent
import android.view.View
import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseActivity
import com.blankj.utilcode.util.ActivityUtils
import kotlinx.android.synthetic.main.activity_launch.*
import org.jetbrains.anko.toast

class LaunchActivity : BaseActivity(), View.OnClickListener {

    override fun layoutId(): Int {
        return R.layout.activity_launch
    }

    override fun initListener() {
        super.initListener()
        tv_to_login.setOnClickListener(this)
        tv_to_main.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        when (v) {
            tv_to_main -> {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()

            }

            tv_to_login -> {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()

            }

        }
    }

    override fun netConnectFail() {
        super.netConnectFail()
        if (ActivityUtils.getTopActivity() == this) {
            toast("网络连接恢复")
        }
    }

    override fun netReconnect(netWorkStates: Int) {
        super.netReconnect(netWorkStates)
        if (ActivityUtils.getTopActivity() == this) {
            toast("网络连接失败")
        }
    }

    override fun onBackPressedSupport() {
        super.onBackPressedSupport()
        logOutApp()
    }
}
