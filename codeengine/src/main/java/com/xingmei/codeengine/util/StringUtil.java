package com.xingmei.codeengine.util;

/**
 * 字符串工具
 * @author JiangZhiYong
 * @date 2015-11-26 16:58:59
 * */
public class StringUtil {

    /**
     * 首字母大写
     * */
    public static String capitalize(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }

        char firstChar = str.charAt(0);
        if (Character.isTitleCase(firstChar)) {
            // already capitalized
            return str;
        }

        return new StringBuilder(strLen)
            .append(Character.toTitleCase(firstChar))
            .append(str.substring(1))
            .toString();
    }
}
