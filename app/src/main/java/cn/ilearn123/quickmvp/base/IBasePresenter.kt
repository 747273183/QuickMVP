package cn.ilearn123.quickmvp.base

interface IBasePresenter<in V : IBaseView> {
    fun attachView(mRootView: V)

    fun detachView()
}