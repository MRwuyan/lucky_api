package com.exhk.robot.order.utils.date;

import com.exhk.robot.order.utils.DateSimpleUtil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeekDateUtil {



    @SuppressWarnings("unused")
    public static Date getBeginDayOfGapWeek(Date date,Integer gap) {
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
            dayofweek += 7;
        }
        cal.add(Calendar.DATE, 2 - dayofweek +(gap* 7));
        return getDayStartTime(cal.getTime());
    }




    // 获取某个日期的开始时间
    public static Timestamp getDayStartTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        if (null != d)
            calendar.setTime(d);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }



    // 获取本月是哪一月
    private static int getNowMonth(Date date) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return gc.get(2) + 1;
    }


    // 获取上月的开始时间
    public static Date getBeginDayOfGapMonth(Date date,Integer gap) {
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(getNowYear(calendar.getTime()), getNowMonth(calendar.getTime()) - 1+gap, 1);
        return getDayStartTime(calendar.getTime());
    }

    // 获取今年是哪一年
    private static Integer getNowYear(Date date ) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        return Integer.valueOf(gc.get(1));
    }


    public  static void main(String args[]){

    }






    public static int calcDayOffset(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2) {  //同一年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //闰年
                    timeDistance += 366;
                } else {  //不是闰年

                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else { //不同年
            return day2 - day1;
        }
    }


    /**
     * 计算两个日期之间 相差的周数
     * @param startTime
     * @param endTime
     * @return
     */
    public static int calcWeekOffset(Date startTime, Date endTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        dayOfWeek = dayOfWeek - 1;
        if (dayOfWeek == 0) dayOfWeek = 7;

        int dayOffset = calcDayOffset(startTime, endTime);

        int weekOffset = dayOffset / 7;
        int a;
        if (dayOffset > 0) {
            a = (dayOffset % 7 + dayOfWeek > 7) ? 1 : 0;
        } else {
            a = (dayOfWeek + dayOffset % 7 < 1) ? -1 : 0;
        }
        weekOffset = weekOffset + a;
        return weekOffset;
    }

    public static int calcMonthOffset(Date startTime, Date endTime){
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);

        Calendar calEndTime = Calendar.getInstance();
        calEndTime.setTime(endTime);

        Integer monthResult = calEndTime.get(Calendar.MONTH) - cal.get(Calendar.MONTH);

        Integer yearResult  = calEndTime.get(Calendar.YEAR)- cal.get(Calendar.YEAR);

        if(yearResult!=0){
            monthResult= yearResult*12+monthResult;

        }
        return monthResult;
    }





    /**
     *  获取
     * @param nnn
     * @param mod
     * @return
     * @throws ParseException
     */
    public static  Date getLastCloseMinuteTime(Date nnn, Integer mod) throws ParseException {
        return  getCloseMinuteTime(nnn,mod,false);
    }

/*    public static  Date getNextCloseMinuteTime(Date nnn, Integer mod) throws ParseException {
        return  getCloseMinuteTime(nnn,mod,true);
    }*/


    public static Date getGapMinuteTimeByModAndGap(Date nnn, Integer mod,Integer gap) throws ParseException {
          Date gapDate;
         gapDate= getLastCloseMinuteTime(nnn,mod);
        return  getDateByGapMinute(gapDate,gap*mod);
    }

    private static Date getCloseMinuteTime(Date nnn, Integer mod,boolean isNext) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nnn);
        int minute = calendar.get(Calendar.MINUTE);
        while (minute%mod!=0){
            //当前时间取整，
            Integer wi=0;

            if (isNext){
                wi=1;
            }else {
                wi=-1;
            }

            String next= DateSimpleUtil.getNextMinutesStrByGap(calendar.getTime(),wi);
            nnn=simpleDateFormat.parse(next);
            calendar.setTime(nnn);
            minute = calendar.get(Calendar.MINUTE);
        }
        return  calendar.getTime();
    }


    private static Date getCloseHourTime(Date nnn, Integer mod,boolean isNext) throws ParseException {

        String  nnnStr= DateSimpleUtil.getNowHourStr(nnn);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        nnn=simpleDateFormat.parse(nnnStr);
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nnn);
        int minute = calendar.get(Calendar.HOUR_OF_DAY);
        while (minute%mod!=0){
            //当前时间取整，
            Integer wi=0;
            if (isNext){
                wi=1;
            }else {
                wi=-1;
            }
            String next= DateSimpleUtil.getNextHourStrByGap(calendar.getTime(),wi);
            nnn=simpleDateFormat.parse(next);
            calendar.setTime(nnn);
            minute = calendar.get(Calendar.HOUR_OF_DAY);
        }


        return  calendar.getTime();
    }


    /**
     * 获得当前时间，最靠近的小时数
     * @param nnn
     * @param mod
     * @return
     * @throws ParseException
     */
    public static  Date getLastCloseHourTime(Date nnn, Integer mod) throws ParseException {
        return   getCloseHourTime(nnn,mod,false);
    }



    public static Date getGapHourTimeByModAndGap(Date nnn, Integer mod,Integer gap) throws ParseException {
        Date gapDate;
        gapDate= getLastCloseHourTime(nnn,mod);
        return  getDateByGapHour(gapDate,gap*mod);
    }






    public static int calcMinuteOffsetByMod(Date startTime,Date endTime,Integer mod) throws ParseException {
        Date startTimeM= getLastCloseMinuteTime(startTime,mod);
        Date endTimeM= getLastCloseMinuteTime(endTime,mod);

        Integer oriGap=getMinutesGapByDate(startTimeM,endTimeM);
        Integer resultGap=oriGap/mod;

        return resultGap;
    }


    public static int calcHourOffsetByMod(Date startTime,Date endTime,Integer mod) throws ParseException {

        Date startTimeM=getLastCloseHourTime(startTime,mod);
        Date endTimeM=getLastCloseHourTime(endTime,mod);

        Integer oriGap=getHourGapByDate(startTimeM,endTimeM);
        Integer resultGap=oriGap/mod;

        return resultGap;
    }


    /**
     * 获取两个给定时间，计算时间分钟差
     *
     * @param startTime
     * @param endTime
     * @return
     */

    public static Integer getMinutesGapByDate(Date startTime, Date endTime) {
      long diff=  getDateDiff(startTime,endTime);

        double minute =   diff / 60 /  1000   ;
        return Double.valueOf(minute).intValue();
    }

    private static long getDateDiff(Date startTime, Date endTime){
        long time1 = startTime.getTime();
        long time2 = endTime.getTime();

        long diff;
        if (time1 < time2) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        return  diff;
    }


    public static Integer getHourGapByDate(Date startTime, Date endTime) {
        long diff=  getDateDiff(startTime,endTime);
        double hour =   diff / 60 / 60/ 1000   ;
        return Double.valueOf(hour).intValue();
    }

    /**
     * 通过给定的间隔，获取间隔之后 的 分钟时间，
     * @param now
     * @param gap
     * @return date
     */
    public static Date getDateByGapMinute(Date now, Integer gap){
        Calendar nowCan= Calendar.getInstance();
        nowCan  .setTime(now);
        nowCan.set(Calendar.SECOND, 0);
        nowCan.set(Calendar.MINUTE, nowCan.get(Calendar.MINUTE)+gap);
        return  nowCan.getTime();
    }



    /**
     * 通过给定的间隔，获取间隔之后 的 分钟时间，
     * @param now
     * @param gap
     * @return date
     */
    public static Date getDateByGapHour(Date now, Integer gap){
        Calendar nowCan= Calendar.getInstance();
        nowCan  .setTime(now);
        nowCan.set(Calendar.HOUR, nowCan.get(Calendar.HOUR)+gap);
        return  nowCan.getTime();
    }

    /**
     * 获取昨天开始时间
     * @param date
     * @return
     */
    public static Date getYesTodayStart(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取昨天结束时间
     * @param date
     * @return
     */
    public static Date getYesTodayEnd(Date date) {
        //取时间

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 11);
        calendar.set(Calendar.MINUTE, 59);
        calendar.add(Calendar.DATE, -1);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 获取上月第一天
     * @throws Exception
     */
    public static Date getBeforeFirstMonthdate(){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }
    public static Date getBeforeLastMonthdate(){
        Calendar calendar=Calendar.getInstance();
        int month=calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }


}
