package com.exhk.robot.order.common.conts;

/*
 * 00 11 00
 *
 * 业务code
 * 定义原则:根据用户行为定义，如果粉丝操作粉丝圈应定义在粉丝模块
 * 系统错误 code org.springframework.http.HttpStatus
 * 公共模块 code 取值范围 1001-1999
 * 业务模块 code 取值范围 2001-9999
 *      2001-2999 艺人模块
 *      3001-3999 粉丝模块
 *      4001-4999 莫后人模块
 *      5001-5999 我的个人中心
 *      6001-7999 粉丝圈
 *
 *      9001-9999 其他
 * @date 2018/4/11 17:14
 */
public interface BizCode {

    //----------------------------- 1001-1999 公共模块 -----------------------------
    /** 操作失败  所有方法默认返回 **/
     Integer FAIL = 1001;

    /** 参数错误 old = 6 **/
     Integer PARAM_ERROR = 1002;

    /** 签名校验失败 old = 7 **/
     Integer SIGNATURE_FAIL = 1003;

    /** 验证码错误 old = 8**/
     Integer VERIFICATION_ERROR = 1004;

    /** 未登录 **/
     Integer NOT_LOGIN  = 1005;

    /** 删除失败 **/
    /** 登录失败，用户不存在 **/
    Integer LOGIN_NON_EXISTENT  = 1008;
     Integer DELETE_FAIL  = 1006;

    /** 修改失败 **/
     Integer UPDATE_FAIL  = 1007;


    /** 数据存在 **/
     Integer DATA_EXISTS = 1009;

    /** 操作异常 **/
     Integer EXEC_EXCEPTION = 1010;

    /** 用户不可用 **/
     Integer USER_NOT_DISABLE = 1011;

    /** 帐号或密码错误 **/
    Integer PWD_ERROR = 1012;


    /** 通用状态 审核状态 审核失败**/
    Integer AUDIT_FAILURE = 1012;
    /** 通用状态 审核状态 审核成功 预留，请使用 HttpStatus.OK.value() **/
    Integer AUDIT_SUCCESS = 1013;
    /** 通用状态 审核状态 审核中  **/
    Integer AUDIT_ING = 1014;
    /** 没有权限  **/
    Integer NOT_AUTH = 1015;

    /** 已经提交审核 **/
    Integer SUBMIT_AUTH = 1016;

    Integer GOOGLECODE_ERROR=1017;


    Integer 需要谷歌验证码=1018;


    //----------------------------- 2001-2999 艺人模块 -----------------------------
    /** 艺人不存在 **/
     Integer ARTIS_NOT_EXIS = 2001;

    /** 创建艺人心愿决策失败,该心愿下已有审核通过的决策 **/
     Integer ARTIS_WISH_EXIS = 2002;
    /** 创建艺人心愿决策失败 **/
     Integer ARTIS_WISH_FAIL = 2007;

    /** 创建艺人心愿成行失败 **/
     Integer ARTIS_WISH_TRIPS_FAIL = 2004;
    /** 创建艺人心愿成行失败,已存在审核通过的艺人心愿成行 **/
     Integer ARTIS_WISH_TRIPS_EXIS = 2006;

    /** 粉丝还没有加入该粉丝圈 或者不是该粉丝圈管理员 TODO 应该定义在粉丝模块**/
     Integer USER_NOT_JOIN_FANDOM = 2007;

    /** 新增艺人信息失败，该艺人已存在 **/
     Integer ARTIS_EXIS = 2008;

    /**  参与艺人心愿决策操作失败,决策不存在或未审核过  **/
     Integer ARTIS_WISH_OPTION_NOT_EXIS = 2009;

    /**  参与艺人心愿决策操作失败,已经操作过  **/
     Integer ARTIS_WISH_OPTION_EXIS = 2010;

    /**  参与艺人心愿成行操作失败,你已参与过该成行  **/
     Integer ARTIS_WISH_TRIP_OPTION_EXIS = 2011;

    /**  参与艺人心愿成行操作失败,该成行已完成  **/
     Integer ARTIS_WISH_TRIP_OPTION_COMPLETED = 2012;

    /**  参与艺人心愿成行操作失败,成行不存在或未审核过  **/
     Integer ARTIS_WISH_TRIP_FAIL = 2013;

    /**  查找单个艺人专辑失败  **/
    Integer FIND_ARTIS_ALBUM_FAIL = 2014;



    //----------------------------- 3001-3999 粉丝模块 -----------------------------
    /** 粉丝圈大战 {option} 已经存在 **/
     Integer FANDOM_AFFAIR_OPTION__EXIS = 3001;
    /** 创建粉丝圈动态失败 **/
     Integer FANDOM_NOT__EXIS = 3002;
    /** 粉丝心愿 已经支持过 **/
    Integer FANS_SUPPORT_EXIS = 3003;


    //----------------------------- 4001-4999 幕后人模块 ---------------------------


    //----------------------------- 5001-5999 我的个人中心 -------------------------

    //----------------------------- 6001-7999 粉丝圈 -------------------------
    /** 添加关注信息失败,不在同一粉丝圈 **/
    Integer NOT_FANDOM_USER = 6001;
    /** 已经关注 **/
    Integer TO_FONDOM_FOLLOW_EXIS = 6002;
    /** 不能关注自己 **/
    Integer NOT_FOLLOW_ME = 6003;


    //--------------------------------- 9001-9999 其他 -----------------------------
    /** 新增评论失败 **/
     Integer COMMENT_INSERT_FAIL = 9001;

    /** 应援票不足，操作失败 **/
     Integer NOT_ASSIST_TICKET = 9002;

    /** 重复报名 **/
     Integer INTERNALAPPLY_EXIS = 9003;

    /** 超出限制上传个数 **/
     Integer INTERNALAPPLY_UPLOAD_BEYOND = 9004;

    /** 已点过赞或已投过票 **/
     Integer INTERNALAPPLY_PRAISE = 9005;

    /** 不是评委投票 **/
     Integer INTERNALAPPLY_PRAISE_TYPE = 9006;

    /** 管理后台注册失败 **/
     Integer REGISTER_ERROR = 9007;

    /**没有报名，没有个人主页*/
     Integer NO_INTERNAL_APPLY = 9008;

    /**没有报名，没有个人主页*/
     Integer NO_SUPER_ADMIN = 9009;

    /**用户已关注该歌曲*/
     Integer USER_FOLLOWED_SONG = 9010;

    /**用户已关注该话题*/
    Integer USER_FOLLOWED_TOPIC = 9011;

    /**取消关注成功*/
    Integer CANCEL_USER_FOLLOWED_TOPIC_SUCCESS = 9012;

    /**取消关注失败*/
    Integer CANCEL_USER_FOLLOWED_TOPIC_FAIL = 9013;

    /** 职位已申请 */
    Integer FANDOM_USER_CHARGE_ALREADY_APPLY = 9014;

    /** org.springframework.http.HttpStatus
    200;	//成功
    400	//错误请求，该请求是无效的
    401	//未授权，验证失败
    403	//服务器拒绝请求，被拒绝调用
    404	//未找到，服务器找不到请求的地址
    405	//方法禁用
    500	//服务器内部错误
    504	//网关超时，服务器在运行，本次请求响应超时，请稍后重试
    **/
}

