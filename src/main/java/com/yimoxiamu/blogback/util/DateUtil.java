package com.yimoxiamu.blogback.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 时间操作类
 * @Author xiamu
 * @Email 768840822@qq.com
 * @Date 2018/8/28 11:03
 * @VERSION 1.0
 **/
public class DateUtil {

    private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

    public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat(
            "yyyyMMddHHmmss");

    /**
     * 获取token失效时间 至前端
     * @return
     */
    public static String getTokenExpireTime(){
        Date date = getTokenFailureTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String expireTime = format.format(date);
        return expireTime;
    }


    public static String date2Str(Date date, SimpleDateFormat date_sdf) {
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }

    public static String date2Str(Date date) {
        if (null == date) {
            return null;
        }
        return yyyymmddhhmmss.format(date);
    }

    /**
     * 设定token失效时间 失效时间设置在次日凌晨三点
     * @return
     */
    public static Date getTokenFailureTime(){
        Date date = new Date(System.currentTimeMillis()+24*60*60*1000);
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        String time = formatter.format(date);
        String failureTimeStr=time+" 03:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date failureTime = null;
        try {
            failureTime = sdf.parse(failureTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return failureTime;
    }

    public static Date String2Date(String dateStr){
        Date date = null;
        try {
            date = yyyymmddhhmmss.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 判断是否需要更新wxToken
     * @param dateStr
     * @return
     */
    public static boolean countWxTokenNeedUpdate(String dateStr){
        Date updateTime = String2Date(dateStr);
        long second = (System.currentTimeMillis() - updateTime.getTime()) / 1000 / 60;
        log.info("距离上次更新token已经过去"+second+"分钟");
        if((int)second - 60 >= 0){
            return true;
        }else{
            return false;
        }
    }
}
