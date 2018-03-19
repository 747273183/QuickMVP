package cn.ilearn123.quickmvp.mvp.model

import cn.ilearn123.quickmvp.mvp.model.bean.User
import com.blankj.utilcode.util.AppUtils

class RegisterModel {
    interface OnFinishedListener {
        fun onRegisterFailure(error: String)

        fun onRegisterSuccess(user: User)

    }

    var versionCode = AppUtils.getAppVersionCode()

    fun register( phoneNum: String, password: String, smsCode: String, nickName: String, listener: RegisterModel.OnFinishedListener) {
        listener.onRegisterFailure("测试回调注册失败")
    }
    /**
    fun register(context: Context, phoneNum: String, password: String, smsCode: String, nickName: String, listener: RegisterModel.OnFinishedListener) {
    var autoNickName: String  //防止昵称为空
    if (TextUtils.isEmpty(phoneNum) || phoneNum.length != 11) {
    ToastUtils.showShort (context.resources.getString(R.string.please_check_phoneNum))
    listener.onRegisterFailure(ParamsKey.paramsError)
    return
    }
    if (TextUtils.isEmpty(password) || password.length > 15 || password.length < 5) {
    ToastUtils.showShort (context.resources.getString(R.string.please_check_password))
    listener.onRegisterFailure(ParamsKey.paramsError)
    return
    }
    if (TextUtils.isEmpty(smsCode)) {
    ToastUtils.showShort (context.resources.getString(R.string.please_check_smsCode))
    listener.onRegisterFailure(ParamsKey.paramsError)
    return
    }
    if (TextUtils.isEmpty(nickName)) {
    autoNickName = "换个昵称呗"
    } else {
    autoNickName = nickName
    }
    var localUserUtil = LocalUserUtil(context)
    var params = HttpParams()
    params.put(ParamsKey.phoneNum, phoneNum)
    params.put(ParamsKey.password, password)
    params.put(ParamsKey.smsCode, smsCode)
    params.put(ParamsKey.nickName, autoNickName)
    params.put(ParamsKey.versionCode, versionCode)
    OkGo.post<User>(BmobApi.userRegisterApi)
    .tag(context)
    .params(params)
    .execute(object : JsonCallback<User>() {
    override fun onSuccess(p0: Response<User>?) {
    if (p0!!.body().code == ResponseKey.SUCCESS) {
    listener.onRegisterSuccess(p0.body())
    localUserUtil.updateLocalUser(p0.body(), password)
    } else {
    listener.onRegisterFailure(p0.body().error_msg)
    localUserUtil.clearLocalUser()
    }
    }

    override fun onError(response: Response<User>?) {
    listener.onRegisterFailure(context.resources.getString(R.string.timeout_error_tip))

    }
    })
    }
     */
}