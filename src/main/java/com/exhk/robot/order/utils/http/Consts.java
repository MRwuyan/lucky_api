package com.exhk.robot.order.utils.http;

public class Consts {
	public final static int CONNECTIONTIMEOUT = 3000;
	public final static int SOCKETTIMEOUT = 3000;
	public final static int READTIMEOUT = 3000;
	public final static int MAXCONNECTIONPERHOST = 5;
	public final static int MAXTOTALCONNECTIONS = 40;
	public final static String UTF_8_ENCODING = "UTF-8";
	public final static String GBK_ENCODING = "GBK";
	public final static String DATEFORMAT_yyyy_MM_dd = "yyyy-MM-dd";

	public final static String TONGLIAN_USERNAME = "20049100001719004";

	public final static int CHINAPAY_STUDENT = 1;// 学生提现
	public final static int CHINAPAY_BUSSINSE = 2; // 商家的订单

	/** 登录token有效时间 2周 */
	public final static int TOKEN_VALID_TIME = 60 * 60 * 24 * 7 * 2;// 2周
	/** 登录失败次数记录时间 15分钟 */
	public final static int LOGIN_FAILURE_COUNT_TIME = 60 * 15;// 15分钟
	/** 十一记录时间 一天 */
	public final static int SHIYI_VALID_TIME = 60 * 60 * 24;// 一天

	public final static int PHONE_CODE_TIME = 60 * 5;// 验证码有效时间
	public final static int PHONE_CODE_RESEND_TIME = 60;// 验证码重复发送限制时间

	public final static int ONE_HOUR = 60 * 60;// 1小时
	public final static int TWO_HOUR = 60 * 60 * 2;// 2小时
	public final static int THREE_HOUR = 60 * 60 * 3;// 3小时
	/**
	 * 发放代金券工资起点
	 */
	public final static int COUPON_SATRT_SALARY = 50;
	// 测试用
	public final static String COUPON_SATRT_SALARY_TEST = "0.01";

	/** 周边职位缓存key长度 */
	public final static int JOB_CACHE_KEY_LENGHT = 5;
	/** 周边职位最大覆盖距离 */
	public final static int JOB_AROUND_MAX_DISTANCECOPE = 6163;
	/** 缓存周边职位查询记录有效时间 */
	public final static int JOB_AROUND_CACHE_TIME = 60 * 10;

	/** 周边职位查询距离保留小数位数 */
	public final static String JOB_AROUND_DISTANCE_DECIMALS = "#0.0";

	/** 经纬度 精准度位数 */
	public final static Integer LA_LO_ACUITY_SIZE = 6;

	public final static Integer DEFAULT_PAGE_SIZE = 20;
	public final static Integer EXPORT_COUNT = 100000;

	/** 当月单商户最多充值金额 */
	public final static int PAY_MAX = 200000;
	/** 充值 查询前3条数据 */
	public final static int PAY_HISTORY = 3;

	public final static String REDIS_CORP_OLDMAX_ID = "CORP_OLDMAX_ID";
	/** 是否初始化 已被bd认领的商家 */
	public final static String REDIS_WEBINIT_ALLOCATE = "REDIS_WEBINIT_ALLOCATE";

	public final static int WECHAT_DEFAULT_RETURN = 22;// 22 微信默认回复
	public final static int WECHAT_SUBCRIPT_RETURN = 21;// 21 微信关注回复

	/** sql的in(*,*,*)查询 的分组长度 */
	public final static int SQL_IN_PAGESIZE = 500;

	/** 专题内 高薪 默认过滤 */
	public final static String HIGH_MONEY = "90";

	/** 专题 最多4个上线 */
	public final static int THEME_MAX_ONLINE = 4;

	public final static String REDIS_ALL_MONEY = "REDIS_ALL_MONEY_";

	public final static String REDIS_ALL_MONEY_NEW = "REDIS_ALL_MONEY_NEW_";

	public final static String REDIS_YUNYIONG_EXCETIOPN_ACCOUNTEXCTIONID_ = "REDIS_YUNYIONG_EXCETIOPN_ACCOUNTEXCTIONID_";
	public final static String REDIS_YUNYIONG_EXCETIOPN_PHONEEXCTIONID_ = "REDIS_YUNYIONG_EXCETIOPN_PHONEEXCTIONID_";
	public final static String REDIS_YUNYIONG_EXCETIOPN_LISTBANKEXCETIONCARDS_ = "REDIS_YUNYIONG_EXCETIOPN_LISTBANKEXCETIONCARDS_";
	public final static String REDIS_YUNYIONG_EXCETIOPN_CARDMAP_ = "REDIS_YUNYIONG_EXCETIOPN_CARDMAP_";
	//判断刷单异常的用户id 
	public final static String REDIS_YUNYIONG_EXCETIOPN_SHUADAN = "REDIS_YUNYIONG_EXCETIOPN_SHUADAN";
	public final static String REDIS_YUNYIONG_EXCETIOPN_PHONE = "REDIS_YUNYIONG_EXCETIOPN_PHONE";
	public final static String REDIS_YUNYIONG_EXCETIOPN_CORP_PHONE = "REDIS_YUNYIONG_EXCETIOPN_CORP_PHONE";

	public final static String REDIS_YUNYIONG_COMPENSATION_TIME_ = "REDIS_YUNYIONG_COMPENSATION_TIME_";
	public final static String REDIS_YUNYIONG_COMPENSATION_LOWMONEY_ = "REDIS_YUNYIONG_COMPENSATION_LOWMONEY_";

	/** 新客户注册,一个城市下最新系统分配记录的BD的ID 永久有效 (cityid : BD的id) (1:商家组,2:渠道组,3:其他) */
	public final static String REDIS_SYS_ALLOCATE_RECENTLY_CITY_ = "REDIS_SYS_ALLOCATE_RECENTLY_CITY_";

	public static final String WITHDRAW_LIMIT_BANKNO = "CAPP_WITHDRAW_LIMIT_BANKNO";// 提现的限制，一个银行卡，
	public static final String WITHDRAW_LIMIT_USERID = "CAPP_WITHDRAW_LIMIT_USERID";// 提现的限制，一个userid只能限制一次。
	public static final String WITHDRAW_LIMIT_ALIACCOUNT = "CAPP_WITHDRAW_LIMIT_ALIACCOUNT_";// 支付宝账户提现的限制
	//城市最多banner数
	public static final int BANNER_MAXNUM = 5;

	public static final String EXPORT_COUNT_LIMIT = "export_count_limit";//限制导出的人数,
	public static final int EXPORT_COUNT_LIMITP_COUNT = 60;//限制导出的人数,

	public final static String STATIC_FILE_VERSION = System.currentTimeMillis()
			+ "";//JS/css等文件版本

	public final static String SALE_ROLE_PERSSION_PROPERTY = "salerole ";//CC,BD,运营体系的权限perpoty。

	/**
	 * 用户异常7天内是不能使用代金券的
	 */
	public final static int USER_EXCEPTION_DAYS = 7;//7;
	/** 是否开启报名限制(同一个用户一天内只能签约一个职位) */
	public final static Boolean RESUME_OVERLAP_SWITCH = true;
	/** 现场点名任务 日期最大长度(数据库常量表中的item) */
	public final static String ROLLCALL_WORKDATE_MAX_SIZE_KEY = "ROLLCALL_WORKDATE_MAX_SIZE";
	/** 职位重复提交, 两个发布时间间隔为{0},则判定为重复提交 */
	public final static int JOB_REPEAT_CREATE_INTERVAL_TIME = 30;
	/** 金额的精确位数 */
	public final static int MONEY_ACUITY_SIZE = 2;
	/** 默认评价分数，0次评价时的默认评分5.0 */
	public final static Double DEFAULT_COMMENT_SCORE = 5.0;
}
