package cn.ilearn123.quickmvp.mvp.model

import cn.ilearn123.quickmvp.mvp.model.bean.User

class LoginModel {
    interface OnFinishedListener {
        fun onLoginFailure(error: String)

        fun onLoginSuccess(user: User)

    }
    fun login(  username: String, password: String, listener: OnFinishedListener) {
        listener.onLoginFailure("测试回调登录失败")
    }
        /**
    fun login(context: Context, username: String, password: String, listener: OnFinishedListener) {
    if (TextUtils.isEmpty(username) || username.length != 11) {
    ToastUtils.showShort(context.resources.getString(R.string.please_check_account))
    listener.onLoginFailure(ParamsKey.paramsError)
    return
    }
    if (TextUtils.isEmpty(password) || password.length > 15 || password.length < 5) {
    ToastUtils.showShort(context.resources.getString(R.string.please_check_password))
    listener.onLoginFailure(ParamsKey.paramsError)
    return
    }
    var versionCode = AppUtils.getAppVersionCode()
    var localUserUtil = LocalUserUtil(context)
    var params = HttpParams()
    params.put(ParamsKey.username, username)
    params.put(ParamsKey.password, password)
    params.put(ParamsKey.versionCode, versionCode)
    OkGo.post<User>(BmobApi.userLoginApi)
    .tag(context)
    .params(params)
    .execute(object : JsonCallback<User>() {
    override fun onSuccess(p0: Response<User>?) {
    if (p0!!.body().code == ResponseKey.SUCCESS) {
    listener.onLoginSuccess(p0.body())
    localUserUtil.updateLocalUser(p0.body(), password)
    } else {
    listener.onLoginFailure(p0.body().error_msg)
    localUserUtil.clearLocalUser()
    }
    }

    override fun onError(response: Response<User>?) {
    listener.onLoginFailure(context.resources.getString(R.string.timeout_error_tip))

    }
    })
    }
     */
}
