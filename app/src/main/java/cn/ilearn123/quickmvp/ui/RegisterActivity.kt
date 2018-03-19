package cn.ilearn123.quickmvp.ui

import android.content.Intent
import android.graphics.Color
import android.view.View
import cn.ilearn123.quickmvp.R

import cn.ilearn123.quickmvp.base.BaseActivity
import cn.ilearn123.quickmvp.usual.ParamsKey
import cn.ilearn123.quickmvp.usual.ParamsKey.nickName
import cn.ilearn123.quickmvp.usual.ParamsKey.password
import cn.ilearn123.quickmvp.usual.ParamsKey.phoneNum
import cn.ilearn123.quickmvp.usual.ParamsKey.smsCode
import cn.ilearn123.quickmvp.mvp.contract.RegisterContract
import cn.ilearn123.quickmvp.mvp.model.bean.User
import cn.ilearn123.quickmvp.mvp.presenter.RegisterPre
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.toast

/**
 * Created by dillon on 2017/7/21.
 */

class RegisterActivity : BaseActivity(), RegisterContract.View, View.OnClickListener {
    private val mPresenter by lazy {
        RegisterPre(this)
    }

    init {
        mPresenter.attachView(this)
    }

    override fun layoutId(): Int {
        return R.layout.activity_register
    }


    override fun initView() {
        super.initView()
        titleBar.setLeftText("< 返回")
        titleBar.setLeftTextColor(Color.WHITE)
        titleBar.setLeftTextSize(resources.getDimension(R.dimen.margin6))
        titleBar.setLeftClickListener(View.OnClickListener { finish() })
    }

    override fun initListener() {
        super.initListener()
        tv_register.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {


            tv_register -> {
                tv_register.text = "正在检测..."
                mPresenter.register(phoneNum, password, smsCode, nickName)
            }

        }
    }


    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun registerFailure(error: String) {
        tv_register.text = "注册"
        if (error == ParamsKey.paramsError) {
            return
        }
        toast(error)
    }

    override fun registerSuccess(user: User) {
        tv_register.text = "注册成功，自动登录..."
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }


    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}
