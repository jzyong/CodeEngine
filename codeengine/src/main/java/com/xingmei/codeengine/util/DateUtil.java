package com.xingmei.codeengine.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * 
 * @author JiangZhiYong
 * @date 2015年7月28日22:52:46
 */
public class DateUtil {
    public static final String YYYY_MM_DD = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取现在时间
     * 
     * @param format
     *            时间格式字符串
     */
    public static String nowData(String format) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
