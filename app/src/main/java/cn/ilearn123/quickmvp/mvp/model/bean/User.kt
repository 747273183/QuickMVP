package cn.ilearn123.quickmvp.mvp.model.bean

/**
 * Created by dillon on 2017/6/16.
 */

class User{
    var nickName: String? = null//昵称
    var age: Int = 0//年龄
    var gender: Int = 0//性别 1:男 male 2:女 female
    var userIcon: String? = null//头像
    var userId: Int = 0//用户id
    var province: String? = null//省份
    var city: String? = null//城市
    var signature: String? = null//个性签名
    var popularCover: String? = null//热门人物时封面
    var fansCount: Int = 0//总粉丝数
    var followCount: Int = 0//总关注数
    var followRelation: Int = 0//关注状态 0:互相未关注 1：我关注了对方 2：对方关注了我 3：互相关注
    var checkFaceTime: Int = 0//检测人脸次数
    var canCheckFaceTime: Int = 0//剩余检测人脸次数
    var compareFaceTime: Int = 0//对比人脸次数
    var canCompareFaceTime: Int = 0//剩余对比人脸次数

    var pkFaceTimeByOtherTotal: Int = 0//被人PK总数
    var compareTimeByOtherTotal: Int = 0//被人对比总数
    var pkFaceTimeByOtherToday: Int = 0//今天被人PK总数
    var compareTimeByOtherToday: Int = 0//今天被人对比总数

    var faceCount: Int = 0//总颜值
    var faceNowCount: Int = 0//当前颜值
    var faceConsumeCount: Int = 0//消费颜值
    var faceRankNow: Int = 0//当前颜值排名
    var faceRankTimes: Int = 0//颜值上榜次数
    var faceRankBest: Int = 0//颜值最佳上榜名次
    var photoCount: Int = 0//发布图片数
    var videoCount: Int = 0 //发视频数
    var backgroundPic: String? = null//用户页面背景图
    var commonPass: String? = null
    override fun toString(): String {
        return "User(nickName=$nickName, age=$age, gender=$gender, userIcon=$userIcon, userId=$userId, province=$province, city=$city, signature=$signature, popularCover=$popularCover, fansCount=$fansCount, followCount=$followCount, followRelation=$followRelation, checkFaceTime=$checkFaceTime, canCheckFaceTime=$canCheckFaceTime, compareFaceTime=$compareFaceTime, canCompareFaceTime=$canCompareFaceTime, pkFaceTimeByOtherTotal=$pkFaceTimeByOtherTotal, compareTimeByOtherTotal=$compareTimeByOtherTotal, pkFaceTimeByOtherToday=$pkFaceTimeByOtherToday, compareTimeByOtherToday=$compareTimeByOtherToday, faceCount=$faceCount, faceNowCount=$faceNowCount, faceConsumeCount=$faceConsumeCount, faceRankNow=$faceRankNow, faceRankTimes=$faceRankTimes, faceRankBest=$faceRankBest, photoCount=$photoCount, videoCount=$videoCount, backgroundPic=$backgroundPic, commonPass=$commonPass)"
    }

}
