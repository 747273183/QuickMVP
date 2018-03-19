package cn.ilearn123.quickmvp.mvp.contract

import cn.ilearn123.quickmvp.base.IBasePresenter
import cn.ilearn123.quickmvp.base.IBaseView
import cn.ilearn123.quickmvp.mvp.model.bean.User

/**
 * Created by dillon on 2018/3/17.
 */
interface RegisterContract {

    interface View : IBaseView {

        //注册失败提示
        fun registerFailure(error: String)

        //注册成功（提示信息，保存信息并自动登录跳转首页）
        fun registerSuccess(user: User)




    }


    interface Presenter : IBasePresenter<View> {

        //注册账号
        fun register(phoneNum: String, nickName: String, password: String, smsCode: String)
    }
}