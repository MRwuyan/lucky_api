package com.exhk.robot.order.bean.pojo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * json 返回结果工具类
 * ClassName: JsonResponseResult <br/>
 * date: 2014年9月30日 下午5:37:15 <br/>
 *
 * @author Forint
 * @version v1.0
 */
@Slf4j
public class JsonResult  <T>  implements Serializable {
    private static final long serialVersionUID = 1292534262025735952L;

    /* 数据对象 */
    private T data = null;

    /* 状态码 */
    private Integer code;
    /**
     * 消息描述
     */
    private String message;



    public JsonResult() {
    }

    public JsonResult(final Integer code) {
        super();
        this.code = code;
    }

    public JsonResult(T data) {
        this.code=HttpStatus.OK.value();
        this.message=HttpStatus.OK.getReasonPhrase();
        this.data=data;
    }

    public JsonResult(final Integer code, final String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public JsonResult(Integer code, String message,T data) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * 创建成功的JsonResult对象。
     *
     * @return
     */
    public static JsonResult createSuccess() {
        return new JsonResult(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
    }
    public static JsonResult createSuccess(Object data) {
        return new JsonResult (HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(),data);
    }

    public static JsonResult createSuccess(Object data,String message) {
        return new JsonResult (HttpStatus.OK.value(), message,data);
    }



    /**
     * 创建失败的JsonResult对象。
     *
     * @return
     */
    public static JsonResult createFalied() {
        return new JsonResult( );
    }

    /**
     * 创建成功的JsonResult对象，支持自定义消息
     * 请使用 createFalied(final Integer code)
     * @return
     */
    @Deprecated
    public static JsonResult createSuccess(String msg) {
        log.info("*********************" + msg + "*********************");
        return new JsonResult(HttpStatus.OK.value(), msg);
    }

    /**
     * 创建失败的JsonResult对象。返回系统异常
     * 请使用 createFalied(final Integer code)
     * @return
     */
    public static JsonResult createFalied(final String msg) {
        final JsonResult jsonResult = new JsonResult(HttpStatus.EXPECTATION_FAILED.value(), msg);
        log.info("*********************" + msg + "*********************");
        return jsonResult;
    }

    /**
     * 创建成功的JsonResult对象，支持自定义消息
     *
     * @return
     */
    public static JsonResult createSuccess(final Integer code) {
        final JsonResult jsonResult = new JsonResult(code);
        log.info("*********************" + code + "*********************");
        return jsonResult;
    }

    /**
     * 创建失败的JsonResult对象。返回系统异常
     *
     * @return
     */
    public static JsonResult createFalied(final Integer code) {
        final JsonResult jsonResult = new JsonResult(code);
        log.info("*********************" + code + "*********************");
        return jsonResult;
    }

    /**
     * 创建失败的JsonResult对象。返回系统异常
     *
     * @return
     */
    public static JsonResult createFalied(final Integer code,final String message) {
        final JsonResult jsonResult = new JsonResult(code,message);
        log.info("*********************" + code +":"+ message+"*********************");
        return jsonResult;
    }

    /**
     * 创建失败的JsonResult对象。返回自定义删除失败
     *
     * @return
     */
    public static JsonResult createFaliedByDel() {
        final JsonResult jsonResult = new JsonResult( );
        return jsonResult;
    }

    /**
     * 验证码错误
     *
     * @return
     */
    public static JsonResult createVerificationError() {
        final JsonResult jsonResult = new JsonResult( "verification error");
        return jsonResult;
    }



    /**
     * 参数不完整
     *
     * @return
     */
    public static JsonResult createNullParam() {
        final JsonResult jsonResult = new JsonResult(HttpStatus.BAD_REQUEST.value(), "param is null");
        return jsonResult;
    }

    public Object getData() {
        return data;
    }

    public void addData(  T obj) {
        this.data = obj;
    }


    public void removeDataAll() {
        if (data != null) {
            data = null;
        }
    }

    //    @SuppressWarnings({ "unchecked", "rawtypes" })
//    public void addDataAll(List list) {
//    	if(null != list)
//    		data.addAll(list);
//    }


    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
