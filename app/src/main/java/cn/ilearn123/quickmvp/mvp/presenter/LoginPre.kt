package cn.ilearn123.quickmvp.mvp.presenter
import cn.ilearn123.quickmvp.base.BasePresenter
import cn.ilearn123.quickmvp.mvp.contract.LoginContract
import cn.ilearn123.quickmvp.mvp.model.LoginModel
import cn.ilearn123.quickmvp.mvp.model.bean.User

class LoginPre(private var view: LoginContract.View) : BasePresenter<LoginContract.View>(), LoginContract.Presenter , LoginModel.OnFinishedListener{

    private val loginModel by lazy {
        LoginModel()
    }

    override fun validateCredentials(username: String, password: String) {
        loginModel.login(  username, password,this)
    }

    override fun onLoginSuccess(user: User) {
        view.loginSuccess(user)
    }

    override fun onLoginFailure(error: String) {
        view.loginFailure(error)

    }

}
