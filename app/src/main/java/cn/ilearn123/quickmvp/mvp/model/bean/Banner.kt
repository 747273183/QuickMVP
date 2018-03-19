package cn.ilearn123.quickmvp.mvp.model.bean

/**
 * Created by dillon on 2017/7/8.
 */
class Banner {

    var bannerId: Int = 0 //
    var type: Int = 0 //banner类型。0:无跳转，1：网页跳转 2：跳转人物，3：跳转话题
    var link: String? = null //banner跳转参数
    var masterId: String? = null//banner主id(可能是用户id,也可能商家id)
    var coverUrl: String? = null//banner封面地址
    var title: String? = null//banner标题
    var subTitle: String? = null//banner小标题
    var introduce: String? = null//banner介绍
    override fun toString(): String {
        return "Banner(bannerId=$bannerId, type=$type, link=$link, masterId=$masterId, coverUrl=$coverUrl, title=$title, subTitle=$subTitle, introduce=$introduce)"
    }

}