package com.rd4j.common.util;

import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 字符串工具 <br>
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public final class Strings {
    private Strings() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * ""的字符
     */
    public static final String EMPTY = "";
    /**
     * "NULL" 的字符
     */
    public static final String NULL = "NULL";

    /**
     * "0" 字符
     */
    public static final String ZERO = "0";

    /**
     * GBK 编码
     */
    public static final Charset GBK = Charset.forName("GBK");

    /**
     * UTF-8 编码
     */
    public static final Charset UTF8 = Charset.forName("UTF-8");


    /**
     * 去除字符串两端空格 <br>
     * 支持半角/全角空格 <br>
     *
     * @param value 需要处理的字符串
     *
     * @return 返回结果
     */
    public static final String trim(String value) {
        int len = value.length();
        int st = 0;
        char[] val = value.toCharArray(); /* avoid getfield opcode */

        while ((st < len) && Character.isSpaceChar(val[st])) {
            st++;
        }
        while ((st < len) && Character.isSpaceChar(val[len - 1])) {
            len--;
        }
        return ((st > 0) || (len < value.length())) ? value.substring(st, len)
                : value;
    }

    /**
     * 去除字符串两端空格, 并支持null对象 <br>
     * 支持半角/全角空格 <br>
     *
     * @param value 处理的字符串
     *
     * @return 如果为null则返回null
     */
    public static final String trimNullable(String value) {
        if (Check.isNull(value)) {
            return null;
        } else {
            return trim(value);
        }
    }


    /**
     * 计算gbk字符的长度 <br>
     *
     * @param string 待检测字符串
     *
     * @return 长度
     */
    public static int gbkLength(String string) {
        return string.getBytes(GBK).length;
    }

    /**
     * 连接对象数组为字符串 <br>
     *
     * @param data 对象数组
     * @param sepa 分隔符
     *
     * @return null or empty result to ""
     */
    public static String joint(Object[] data, String sepa) {
        if (null == data || 0 == data.length) {
            return "";
        }

        int maxIndex = data.length - 1;

        StringBuilder str = new StringBuilder();
        IntStream.range(0, maxIndex).forEach(i -> str.append(data[i]).append(sepa));

        return str.append(data[maxIndex]).toString();
    }

    /**
     * 连接对象集合为字符串<br>
     *
     * @param data 对象集合
     * @param sepa 分隔符
     *
     * @return null or empty result to ""
     */
    public static String joint(List<?> data, String sepa) {
        if (null == data || data.isEmpty()) {
            return "";
        }

        int maxIndex = data.size() - 1;

        StringBuilder str = new StringBuilder();
        IntStream.range(0, maxIndex).forEach(i -> str.append(data.get(i)).append(sepa));

        return str.append(data.get(maxIndex)).toString();
    }

    /**
     * 连接对象数组为字符串 <br>
     *
     * @param objects 待连接的对象数组
     *
     * @return 结果
     */
    public static String join(Object... objects) {
        StringBuffer sb = new StringBuffer();
        for (Object object : objects) {
            sb.append(object);
        }
        return sb.toString();
    }

    /**
     * 连接对象集合为字符串
     *
     * @param data 待连接的对象集合
     *
     * @return 结果
     */
    public static String join(List<?> data) {
        StringBuffer sb = new StringBuffer();
        for (Object object : data) {
            sb.append(object);
        }
        return sb.toString();
    }

    /**
     * 获取string的值<br>
     * 当str=null时,返回""
     *
     * @param string 待处理的字符串
     *
     * @return 结果
     */
    public static String value(String string) {
        return value(string, EMPTY);
    }

    /**
     * 获取string的值<br>
     * 如果string=null时,返回defaultValue<br>
     *
     * @param string       待处理的字符串
     * @param defaultValue 默认值
     *
     * @return string or defaultValue
     */
    public static String value(String string, String defaultValue) {
        if (Check.isNull(string)) {
            return defaultValue;
        } else {
            return string;
        }
    }

    /**
     * 获取string的值<br>
     * string==null时返回null
     *
     * @param string 待处理字符串
     *
     * @return string or null
     */
    public static String valueNullable(String string) {
        if (Check.isNull(string)) {
            return null;
        } else {
            return string;
        }
    }

    /**
     * 获取string的值<br>
     * 当str=null时,返回""<br>
     * 当str="null" or "NULL" or "Null" 时,返回""
     *
     * @param string 字符串
     *
     * @return string or ""
     */
    public static String valueCutNull(String string) {
        if (Check.isNull(string)) {
            return EMPTY;
        } else if (NULL.equalsIgnoreCase(string)) {
            return EMPTY;
        } else {
            return string;
        }
    }

    /**
     * 获取string的值<br>
     * 当str=null时,返回""<br>
     * 当str="null" or "NULL" or "Null" 时,返回""<br>
     * 并且去掉两端空格
     *
     * @param string 字符串
     *
     * @return string or ""
     */
    public static String valueTrimCutNull(String string) {
        if (Check.isNull(string)) {
            return EMPTY;
        }
        String trimStr = trim(string);
        if (NULL.equalsIgnoreCase(trimStr)) {
            return EMPTY;
        }
        return trimStr;
    }

    /**
     * 16进制转换
     *
     * @param bytes byte数组
     *
     * @return 16进制字符串
     */
    public static String bytesToHexString(byte[] bytes) {
        StringBuilder des = new StringBuilder();
        String tmp = null;
        for (int i = 0; i < bytes.length; i++) {
            tmp = (Integer.toHexString(bytes[i] & 0xFF));
            if (tmp.length() == 1) {
                des.append(ZERO);
            } else {
                des.append(tmp);
            }
        }
        return des.toString();
    }

    /**
     * 字符串转换成16进制bytes
     *
     * @param string 16进制字符串
     *
     * @return 16进制bytes
     */
    public static byte[] stringToHexBytes(String string) {
        if (string == null) {
            return null;
        }

        byte[] bytes = new byte[string.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            String tmp = string.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(tmp, 16);
        }
        return bytes;
    }

    /**
     * 首字母转大写
     *
     * @param string 字符串
     *
     * @return 结果
     */
    public static String firstLetterToUpperCase(String string) {
        if (Check.isNull(string) || string.length() < 1) {
            return string;
        } else if (string.length() == 1) {
            return string.toUpperCase();
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }

    /**
     * 首字母转小写
     *
     * @param string 字符串
     *
     * @return 结果
     */
    public static final String firstLetterToLowerCase(String string) {
        if (Check.isNull(string) || string.length() < 1) {
            return string;
        } else if (string.length() == 1) {
            return string.toLowerCase();
        } else {
            return string.substring(0, 1).toLowerCase() + string.substring(1);
        }
    }


}
