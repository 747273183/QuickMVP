package cn.ilearn123.quickmvp.mvp.presenter

import cn.ilearn123.quickmvp.base.BasePresenter
import cn.ilearn123.quickmvp.mvp.contract.RegisterContract
import cn.ilearn123.quickmvp.mvp.model.RegisterModel
import cn.ilearn123.quickmvp.mvp.model.bean.User

class RegisterPre(private var view: RegisterContract.View) : BasePresenter<RegisterContract.View>(), RegisterContract.Presenter, RegisterModel.OnFinishedListener {

    private val registerModel by lazy {
        RegisterModel()
    }

    override fun register(phoneNum: String,  password: String, smsCode: String, nickName: String) {
        registerModel.register(  phoneNum, password, smsCode, nickName, this)
    }


    override fun onRegisterFailure(error: String) {
        view.registerFailure(error)
    }

    override fun onRegisterSuccess(user: User) {
        view.registerSuccess(user)

    }


}
