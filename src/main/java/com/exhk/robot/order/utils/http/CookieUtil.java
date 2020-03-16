package com.exhk.robot.order.utils.http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by konson on 2017/9/15.
 */
public class CookieUtil {


 public static   String getCookie(HttpServletRequest request,String cookieName){

        Cookie[] cookies = request.getCookies();//这样便可以获取一个cookie数组
        for(Cookie cookie : cookies){
           String  orginName= cookie.getName();// get the cookie name
            if(cookieName.equals(orginName)){
                //这就是我们想要得到的cookie 值
               return cookie.getValue(); // get the cookie value
            }
        }
        return  null;
    }


}
