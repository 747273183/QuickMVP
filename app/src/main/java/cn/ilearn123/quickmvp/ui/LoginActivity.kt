package cn.ilearn123.quickmvp.ui

import android.content.Intent
import android.view.View
import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseActivity
import cn.ilearn123.quickmvp.mvp.contract.LoginContract
import cn.ilearn123.quickmvp.mvp.model.bean.User
import cn.ilearn123.quickmvp.mvp.presenter.LoginPre
import cn.ilearn123.quickmvp.usual.ParamsKey
import cn.ilearn123.quickmvp.usual.ParamsKey.password
import cn.ilearn123.quickmvp.usual.ParamsKey.username
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast


class LoginActivity : BaseActivity(), LoginContract.View, View.OnClickListener {

    private val mPresenter by lazy {
        LoginPre(  this)
    }

    init {
        mPresenter.attachView(this)
    }

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        super.initView()
    }

    override fun initListener() {
        super.initListener()
        tv_login.setOnClickListener(this)
        tv_to_register.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_login -> {
                tv_login.text = "正在检测..."
                mPresenter.validateCredentials(username, password)
            }

            tv_to_register -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }

        }
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun loginFailure(error: String) {
        tv_login.text = "登录"
        if (error == ParamsKey.paramsError) {
            return
        }
        toast(error)
    }

    override fun loginSuccess(user: User) {
        // toast("" + resources.getString(R.string.login_success))
        tv_login.text = "登录成功，自动跳转..."
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun onBackPressedSupport() {
        logOutApp()
    }

}
