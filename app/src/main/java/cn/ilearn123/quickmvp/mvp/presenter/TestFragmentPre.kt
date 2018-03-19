package cn.ilearn123.quickmvp.mvp.presenter

import cn.ilearn123.quickmvp.base.BasePresenter
import cn.ilearn123.quickmvp.mvp.contract.TestFragmentContract
import cn.ilearn123.quickmvp.mvp.model.TestFragmentModel
import cn.ilearn123.quickmvp.mvp.model.bean.User

class TestFragmentPre(private var view: TestFragmentContract.View) : BasePresenter<TestFragmentContract.View>(), TestFragmentContract.Presenter, TestFragmentModel.OnFinishedListener {

    private val loginModel by lazy {
        TestFragmentModel()
    }

    override fun validateCredentials(username: String, password: String) {
        loginModel.login(username, password, this)
    }

    override fun onLoginSuccess(user: User) {
        view.loginSuccess(user)
    }

    override fun onLoginFailure(error: String) {
        view.loginFailure(error)

    }

}