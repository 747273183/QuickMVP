package cn.ilearn123.quickmvp.mvp.model.bean

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Created by dillon on 2017/7/8.
 */

class CardMulti : MultiItemEntity {
    companion object {
        val CARD_NORMAL = 1//普通类型
        val CARD_GRID = 2//宫格类型
        val CARD_BANNER = 3//Banner轮播类型

        val AD_NORMAL = 4//正常广告类型
        val AD_GRID = 5//宫格类型
        val AD_BANNER = 6//Banner轮播类型

    }

    var dataType: Int = 0//类型

    //广告AD部分
    var adId: Int = 0 //广告ID
    var adMasterId: String? = null//广告主id
    var adCoverUrl: String? = null//广告封面地址
    var adTitle: String? = null//广告标题
    var adTitleSmall: String? = null//广告小标题
    var adIntroduce: String? = null//广告介绍


    var cardName: String? = null//卡片名称
    var cardImagePath: String? = null//卡片图片路径
    var cardIntroduce: String? = null//卡片介绍

    var testImagePath: Int = 0//测试用路径

    override fun getItemType(): Int {
        return dataType
    }

    override fun toString(): String {
        return "CardMulti(dataType=$dataType, adId=$adId, adMasterId=$adMasterId, adCoverUrl=$adCoverUrl, adTitle=$adTitle, adTitleSmall=$adTitleSmall, adIntroduce=$adIntroduce, cardName=$cardName, cardImagePath=$cardImagePath, cardIntroduce=$cardIntroduce)"
    }


}