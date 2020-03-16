package com.exhk.robot.order.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSimpleUtil {


    //获取当前时间，与给定一个时间的分钟间隔


    /**
     * 获取给定时间的上一分钟，
     * 字符串
     * @param now
     * @return
     */
    public  static  String getLastMinutesStartStr(Date now){
        return  getMinutesStr(now,-1);
    }


    /**
     * 获取给定时间的下一分钟字符串
     * @param now
     * @return
     */
    public static  String getNextMinutesStr(Date now){
        return  getMinutesStr(now,1);
    }


    /**
     * 获取给定时间的下一分钟字符串
     * @param now
     * @return
     */
    public static  String getNextMinutesStrByGap(Date now,Integer gap){
        return  getMinutesStr(now,gap);
    }



    /**
     * 获取给定时间的下一分钟字符串
     * @param now
     * @return
     */
    public static  String getNextHourStrByGap(Date now,Integer gap){
        return  getHourStr(now,gap);
    }

    /**
     * 获取给定时间的下一分钟字符串
     * @param now
     * @return
     */
    public static  String getNextDayStrByGap(Date now,Integer gap){
        return  getDayStr( now,gap);
    }

    /**
     * 获取给定时间的当前分钟字符串
     * @param now
     * @return
     */
    public static String getNowMinutesStr(Date now){
        return  getMinutesStr(now,0);
    }

    /**
     * 获取给定时间的当前分钟字符串
     * @param now
     * @return
     */
    public static String getNowHourStr(Date now){
        return  getHourStr( now,0);
    }



    /**
     * 获取给定时间的当前分钟字符串
     * @param now
     * @return
     */
    public static String getNowDayStr(Date now){
        return  getDayStr(  now,0);
    }




    /**
     *
     *  格式化规整当前分钟的时间到 整分钟
     * 开闭区间
     * @param now
     * @return
     */
    public  static String getMinutesStr(Date now,Integer splitMinute){
        Calendar nowCan= Calendar.getInstance();
        nowCan  .setTime(now);
        nowCan.set(Calendar.MINUTE, nowCan.get(Calendar.MINUTE)+splitMinute);
        SimpleDateFormat endSimpleDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        return  endSimpleDate.format(nowCan.getTime());
    }


    /**
     *
     *  格式化规整当小时的时间到 整点
     *
     * @param now
     * @return
     */
    public  static String getHourStr(Date now,Integer splitHour){
        Calendar nowCan= Calendar.getInstance();
        nowCan .setTime(now);
        nowCan.set(Calendar.HOUR, nowCan.get(Calendar.HOUR)+splitHour);
        SimpleDateFormat endSimpleDate=new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        return  endSimpleDate.format(nowCan.getTime());
    }


    /**
     * 格式化规整当天的时间到 0点
     * @param now
     * @param splitDay
     * @return
     */
    public  static String getDayStr(Date now,Integer splitDay){
        Calendar nowCan= Calendar.getInstance();
        nowCan  .setTime(now);
        nowCan.set(Calendar.HOUR, nowCan.get(Calendar.HOUR)+24*splitDay);
        SimpleDateFormat endSimpleDate=new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        return  endSimpleDate.format(nowCan.getTime());
    }
    public static Date str2Date(String dateStr,String format) throws ParseException {
        if(format==null){
            format="yyyy-MM-dd hh:mm:ss.SSS";
        }
       SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
       Date date= simpleDateFormat.parse(dateStr);
       return  date;
    }

    public static void main(String[] args) throws ParseException {

        String s = "2019-10-22T02:31:00.000Z";
        Date date = str2Date(s, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println(date);
    }
    public static Date getBeforeByHourTime(Date dateEnd){
        Calendar date = Calendar.getInstance();
        date.setTime(dateEnd);
        date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);
        return date.getTime();
    }
    public static Date getHourOfDay(Date date,int splitHour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,splitHour);
        return calendar.getTime();
    }

    public static String date2Str(Date date,String fromat){
        if(fromat==null){
            fromat="yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(fromat);
        String dateStr= simpleDateFormat.format(date);
        return  dateStr;
    }


}
