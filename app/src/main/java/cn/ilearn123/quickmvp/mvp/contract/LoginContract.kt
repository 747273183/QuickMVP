package cn.ilearn123.quickmvp.mvp.contract

import cn.ilearn123.quickmvp.base.IBasePresenter
import cn.ilearn123.quickmvp.base.IBaseView
import cn.ilearn123.quickmvp.mvp.model.bean.User

/**
 * Created by dillon on 2018/3/17.
 */
interface LoginContract {

    interface View : IBaseView {
        //登录失败提示
        fun loginFailure(error: String)

        //登录成功（提示信息，保存登录信息并跳转首页）
        fun loginSuccess(user: User)
    }

    interface Presenter : IBasePresenter<View> {
        //验证账号密码
        fun validateCredentials(username: String, password: String)
    }
}