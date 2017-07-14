package com.lmzqm.mybatis.Server;

import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



/**
 * Created by lmzqm on 2017/6/29.
 */
@Service
public class PushServer {

//    https://docs.jiguang.cn/jpush/server/push/rest_api_v3_push/#notification 可以查看官方文档

    /**
     *  Platform 推送平台
     *
     *  jPush当前支持Android ，iOS ,Windows phone三个平台的推送 对应的关键字分别是 ：'android''ios''winphone'
     *
     *  注意：如果目标平台为ios平台的时候，需要在options中通过apns_production字段来设定推送环境。True表示推送生产环境，
     *  False表示要推送开发环境，如果不指定为推送生产环境
     *
     *  audience :推送目标
     *  推送设备的对象，表示一条推送可以被推送到那些设备列表。确认推送设备对象，JPush提供了多种方式。比如：别名，标签，注册ID
     *  分群，广播
     *
     *  all:表示广播
     *  tag:标签or 是一个json array
     *  alias:别名 也是一个数组 用别名来标识一个用户，一个设备只能绑定一个别名，但多个设备可以绑定同一个别名，一次推送最多1000个
     *  registration_id :设备标示 注册ID 也是数组 一次推送最多1000个
     *
     *  eg:
     *      {
     *          "audience":{
     *              "alias":[]
     *          }
     *      }
     *
     *  notification 通知：
     *      通知对象是一条推送的实体内容对象之一，是会作为通知推送到客户端的。
     *      它的下面属性包含4种，3个平台属性，已经一个alert属性
     *
     *      alert:通知的内容在各个平台上，都可能只有这一个最基础的属性"alert"
     *      {
     *          "notification":{
     *              "alert":"Hello ,JPush!"
     *          }
     *      }
     *
     *      android :安卓平台上的通知
     *          alert:通知内容  这里制定了，则会覆盖上一级指定的alert信息；内容可以为空字符串，则表示不展示到通知栏
     *          title:通知标题  如果指定了，则会通知原来展示App名称的地方，将展示成这个字段
     *          builder_id : 通知栏样式字段 Android SDK可以设置通知栏样式，这里根据样式ID来指定该使用哪套样式
     *          style: 通知栏样式类型 默认为0，还有1，2，3可选，用来指定那种样式，其他值无效。有三种可选分别是bigText=1,inBox=2，bigPicture=3
     *          priority: 通知栏展示优先级 默认为0，范围是-2`2,其他值将会被忽略而采用默认
     *          alert_type:通知提醒方式 可选范围为-1~7 默认为-1 是所有
     *          extras:扩展字段 这里自定义JSON格式的key/value信息，以供业务使用
     *
     *          "android" : {
                "alert" : "hello, JPush!",
                "title" : "JPush test",
                "builder_id" : 3,
                "style":1  // 1,2,3
                "alert_type":1 // -1 ~ 7
                "big_text":"big text content",
                "inbox":JSONObject,
                "big_pic_path":"picture url",
                "priority":0, // -2~2
                "category":"category str",
                "extras" : {
                    "news_id" : 134,
                    "my_key" : "a value"
                }
     *
     *      ios:ios平台上APNS通知结构
     *
     *          alert:通知的内容
     *          sound：通知提示声音    如果无此字段，则此消息无声提示；如果由此字段，找到了指定的声音就会播放该声音，否则就播放默认声音
     *          badge:应用角标  如果不填表示不改变角标数字，否则把角标数字改为指定的数字。为0表示清除，默认填充badge值为"+1"
     *          content-avaliable : 推送唤醒 推送的时候携带"content-available":true 说明是Background Remote Notification 如果不携带此字段则是普通德尔Remote Notification
     *          category:
     *          extra: 附加字段 这里自定义key/value信息，以提供业务使用
     *
     *          "notification" : {
                    "ios" : {
                        "alert" : "hello, JPush!",
                         "sound" : "sound.caf",
                            "badge" : 1,
                        "extras" : {
                             "news_id" : 134,
                            "my_key" : "a value"
                        }
                    }
                }

     *
     *    message:自定义消息
     *    应用内的消息。或者称为自定义消息
     *    此部分内容不会显示在通知栏中，JPush SDK收到消息内容后透传给APP .需要APP自行处理，
     *    IOS 平台上，此部分内容在推送应用消息通道获取
     *
     *      msg_content : 消息内容本身
     *      title:  消息标题
     *      content_type: 消息内容类型
     *      extras: json格式的可选参数
     *
     *    sms_message:短信补充
     *      用于设置短信推送内容以及短信发送的延迟时间。短信接收号码，开发者需要先把用户的手机号码和设备的registration id匹配
     *      content
     *      delay_time: 单位为秒，不能超过24小时 设置为0立即发送 该参数只对android有效
     *
     *    options:可选参数
     *    sendno: 推送序号 int 纯粹用来作为API调用标识，API返回的时候会原样返回
     *    time_to_live: int 推送当前用户不在线的时候，为用户保留多长时间的离线消息，以便其上线后再次推送，默认1天，最长10天
     *    apns_production boolen APNS是否生产环境 True标识推送的是生产环境 False标识是开发环境
     *
     *
     * */

    private static final String PUSHKEY = "e7c06abbbee91ebb6823feff";

    private static final String PUSHSECRET ="25fa7a76bd5e95d624e76290";

    private static Logger logger = LoggerFactory.getLogger(PushServer.class);

    private static JPushClient pushClient = new JPushClient(PUSHSECRET,PUSHKEY);

    public void pushWithPayload(){
        logger.info("pushWithPayload");
        PushPayload payload = buildPushObjectForAll();
        try {
            pushClient.sendPush(payload);
            logger.info("push successful");
        } catch (APIConnectionException e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
        } catch (APIRequestException e) {
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
        }
    }

    public static PushPayload buildPushObjectForAll(){

        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.alias("1315"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert("hello world")
                                .build())
                        .build())
                .setOptions(
                        Options.newBuilder().
                        setApnsProduction(true)
                        .build())
                .build();
    }


}
