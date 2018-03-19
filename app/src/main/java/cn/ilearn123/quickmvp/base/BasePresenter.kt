package cn.ilearn123.quickmvp.base


open class BasePresenter<V : IBaseView> : IBasePresenter<V> {

    var mRootView: V? = null

    override fun attachView(mRootView: V) {
        this.mRootView = mRootView
    }

    override fun detachView() {
        mRootView = null
    }
}
