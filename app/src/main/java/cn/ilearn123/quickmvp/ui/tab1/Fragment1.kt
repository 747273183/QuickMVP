package cn.ilearn123.quickmvp.ui.tab1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import cn.ilearn123.quickmvp.R
import cn.ilearn123.quickmvp.base.BaseFragment
import cn.ilearn123.quickmvp.mvp.contract.TestFragmentContract
import cn.ilearn123.quickmvp.mvp.model.bean.User
import cn.ilearn123.quickmvp.mvp.presenter.TestFragmentPre
import cn.ilearn123.quickmvp.ui.view.TitleBar
import kotlinx.android.synthetic.main.layout_title_bar.*
import org.jetbrains.anko.support.v4.toast


/**
 * Created by dillon on 2017/7/5.
 */

class Fragment1 : BaseFragment(), TestFragmentContract.View, View.OnClickListener {

    private val mPresenter by lazy {
        TestFragmentPre(this)
    }

    init {
        mPresenter.attachView(this)
    }

    var titleRight: TextView? = null

    companion object {
        fun newInstance(): Fragment1 {
            val args = Bundle()
            val fragment = Fragment1()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_1
    }

    override fun initView() {
        super.initView()
        titleBar.setTitleBold("页面1", true)
        titleBar.setTitleColor(resources.getColor(R.color.black))
        titleBar.setBackgroundResource(R.color.white95)
        titleBar.setTitleSize(resources.getDimension(R.dimen.title_bar_title_size))
        titleBar.setLeftText("榜单")
        titleBar.setLeftTextColor(resources.getColor(R.color.black))
        titleBar_divider.visibility = View.INVISIBLE
        //  genderType = BaseApplication.localUser!!.gender
        //TextAction不能传""，可以传" ",否则会自动转换为ImageAction
        titleRight = titleBar.addAction(object : TitleBar.TextAction(" ") {
            override fun performAction(view: View) {
            }
        }) as TextView
    }

    override fun initListener() {
        titleBar.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0) {
            titleBar -> {
                toast("点击了标题")
                mPresenter.validateCredentials("123", "123")
            }
        }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginFailure(error: String) {
        toast(error)
    }

    override fun loginSuccess(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}
