package com.rd4j.common.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.rd4j.common.util.Strings.EMPTY;
import static com.rd4j.common.util.Strings.trim;

/**
 * 检查工具 <br>
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class Check {

    /**
     * 邮箱<br>
     * eg: rd4j@rd4j.com
     */
    public static final Pattern EMAIL_FORMAT = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    /**
     * 中国手机号码<br>
     * eg: 13800000000
     */
    public static final Pattern CHINA_PHONE_FORMAT = Pattern.compile("^[1][3-9][0-9]{9}$");

    /**
     * 正整数<br>
     * eg: 1000
     */
    public static final Pattern INTEGER_FORMAT = Pattern.compile("^[-+]?((0)|[1-9][0-9]*)$");
    /**
     * 数字字符<br>
     * eg: 000123123
     */
    public static final Pattern NUMBER_FORMAT = Pattern.compile("^[0-9]+$");

    /**
     * 双精度数字<br>
     * eg: 10 or 1.0 or 0.1
     */
    public static final Pattern DOUBLE_FORMAT = Pattern.compile("^[-+]?((0)|[1-9][0-9]*)([.][0-9]+)?$");

    /**
     * 用户名称<br>
     * eg: a_a1b
     */
    public static final Pattern USER_NAME_FORMAT = Pattern.compile("^[A-Za-z]+([_]?[A-Za-z0-9]+)*$");

    /**
     * 字母<br>
     * eg: Abc or ABC or abc
     */
    public static final Pattern LETTER_FORMAT = Pattern.compile("^[A-Za-z]+$");

    /**
     * 中文<br>
     */
    public static final Pattern CHINESE_FORMAT = Pattern.compile("^[\\u4E00-\\u9FA5]+$");

    /**
     * 驼峰命名 <br>
     * eg: CamelCase
     */
    public static final Pattern CAMEL_CASE_NAMED_FORMAT = Pattern.compile("^([A-Z][a-z0-9]*)+$");
    /**
     * 小驼峰命名 <br>
     * eg: lowerCamelCase
     */
    public static final Pattern LOWER_CAMEL_CASE_NAMED_FORMAT = Pattern.compile("^[a-z][a-z0-9]*([A-Z][a-z0-9]*)*$");

    /**
     * 蛇形命名<br>
     * eg: snake_case
     */
    public static final Pattern SNAKE_CASE_NAMED_FORMAT = Pattern.compile("^[a-z][a-z0-9]*([_][a-z0-9]+)*$");

    /**
     * 大蛇形命名<br>
     * eg: UPPER_SNAKE_CASE
     */
    public static final Pattern UPPER_SNAKE_CASE_NAMED_FORMAT = Pattern.compile("^[A-Z][A-Z0-9]*([_][A-Z0-9]+)*$");

    /**
     * 串式命名<br>
     * eg: kebab-case
     */
    public static final Pattern KEBAB_CASE_NAMED_FORMAT = Pattern.compile("^[a-z][a-z0-9]*([-][a-z0-9]+)*$");
    /**
     * 大串式命名<br>
     * eg: KEBAB-CASE
     */
    public static final Pattern UPPER_KEBAB_CASE_NAMED_FORMAT = Pattern.compile("^[A-Z][A-Z0-9]*([-][A-Z0-9]+)*$");

    /**
     * 是否是邮箱<br>
     * eg: rd4j@rd4j.com
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isEmail(String value) {
        return EMAIL_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是中国手机号码<br>
     * eg: 13800000000
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isChinaPhone(String value) {
        return CHINA_PHONE_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是数字字符<br>
     * eg: 000123123
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isNumber(String value) {
        return NUMBER_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是正整数<br>
     * eg: 1000
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isInteger(String value) {
        return INTEGER_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是双精度数字<br>
     * eg: 10 or 1.0 or 0.1
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isDouble(String value) {
        return DOUBLE_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是用户名称<br>
     * eg: a_a1b
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isUserName(String value) {
        return USER_NAME_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是字母<br>
     * eg: Abc or ABC or abc
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isLetter(String value) {
        return LETTER_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是中文<br>
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isChinese(String value) {
        return CHINESE_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是驼峰命名 <br>
     * eg: CamelCase
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isCamelCaseNamed(String value) {
        return CAMEL_CASE_NAMED_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是小驼峰命名 <br>
     * eg: lowerCamelCase
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isLowerCamelCaseNamed(String value) {
        return LOWER_CAMEL_CASE_NAMED_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是蛇形命名<br>
     * eg: snake_case
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isSnakeCaseNamed(String value) {
        return SNAKE_CASE_NAMED_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是大蛇形命名<br>
     * eg: UPPER_SNAKE_CASE
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isUpperSnakeCaseNamed(String value) {
        return UPPER_SNAKE_CASE_NAMED_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是串式命名<br>
     * eg: kebab-case
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isKebabCaseNamed(String value) {
        return KEBAB_CASE_NAMED_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是大串式命名<br>
     * eg: KEBAB-CASE
     *
     * @param value 待检测字符
     *
     * @return 结果
     */
    public static final boolean isUpperKebabCaseNamed(String value) {
        return UPPER_KEBAB_CASE_NAMED_FORMAT.matcher(value).matches();
    }

    /**
     * 是否是中国身份证号码
     *
     * @param identityCode 待检测字符
     *
     * @return 结果
     */
    public static final boolean isChineseIdentity(String identityCode) {
        return ChineseIdentityUtil.isIdentity(identityCode);
    }

    /**
     * 是否为null<br>
     * {@code object == null}
     *
     * @param object 检测对象
     *
     * @return 结果
     */
    public static final boolean isNull(Object object) {
        return null == object;
    }

    /**
     * 是否不为null<br>
     * {@code object != null}
     *
     * @param object 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNull(Object object) {
        return !isNull(object);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     * @param <T>   object
     *
     * @return 结果
     */
    public static final <T> boolean isEmpty(T[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     * @param <T>   object
     *
     * @return 结果
     */
    public static final <T> boolean isNotEmpty(T[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     * @param <T>   object
     *
     * @return 结果
     */
    public static final <T> boolean isNullOrEmpty(T[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     * @param <T>   object
     *
     * @return 结果
     */
    public static final <T> boolean isNotNullAndNotEmpty(T[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(byte[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(byte[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(byte[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(byte[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(short[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(short[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(short[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(short[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(int[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(int[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(int[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(int[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(char[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(char[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(char[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(char[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(double[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(double[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(double[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(double[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 数组长度是否为0<br>
     * {@code array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(long[] array) {
        return array.length == 0;
    }

    /**
     * 数组长度是否不为0<br>
     * {@code array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(long[] array) {
        return !isEmpty(array);
    }

    /**
     * 数组对象是否为null或者长度为0<br>
     * {@code array == null || array.length == 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(long[] array) {
        return isNull(array) || isEmpty(array);
    }

    /**
     * 数组对象是否不为null或者长度不为0<br>
     * {@code array != null && array.length != 0}
     *
     * @param array 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(long[] array) {
        return !isNullOrEmpty(array);
    }

    /**
     * 集合长度是否为0<br>
     * {@code collection.isEmpty()}
     *
     * @param collection 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(Collection<?> collection) {
        return collection.isEmpty();
    }

    /**
     * 集合长度是否不为0<br>
     * {@code !collection.isEmpty()}
     *
     * @param collection 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    /**
     * 集合对象是否为null或者长度为0<br>
     * {@code collection == null || collection.isEmpty()}
     *
     * @param collection 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(Collection<?> collection) {
        return isNull(collection) || isEmpty(collection);
    }

    /**
     * 集合对象是否不为null或者长度不为0<br>
     * {@code collection != null && !collection.isEmpty()}
     *
     * @param collection 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(Collection<?> collection) {
        return !isNullOrEmpty(collection);
    }

    /**
     * Map长度是否为0<br>
     * {@code map.isEmpty()}
     *
     * @param map 检测对象
     *
     * @return 结果
     */
    public static final boolean isEmpty(Map<?, ?> map) {
        return map.isEmpty();
    }

    /**
     * Map长度是否不为0<br>
     * {@code !map.isEmpty()}
     *
     * @param map 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    /**
     * Map对象是否为null或者长度为0<br>
     * {@code map == null || map.isEmpty()}
     *
     * @param map 检测对象
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(Map<?, ?> map) {
        return isNull(map) || isEmpty(map);
    }

    /**
     * Map对象是否不为null或者长度不为0<br>
     * {@code map != null && !map.isEmpty()}
     *
     * @param map 检测对象
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(Map<?, ?> map) {
        return !isNullOrEmpty(map);
    }

    /**
     * 两个对象是否相等<br>
     * {@code a.equals(b)}
     *
     * @param a   对象a
     * @param b   对象b
     * @param <T> Object
     *
     * @return 结果
     */
    public static final <T> boolean isEq(T a, T b) {
        return a.equals(b);
    }

    /**
     * 两个对象是否不相等<br>
     * {@code !a.equals(b)}
     *
     * @param a   对象a
     * @param b   对象b
     * @param <T> Object
     *
     * @return 结果
     */
    public static final <T> boolean isNeq(T a, T b) {
        return !isEq(a, b);
    }

    /**
     * 两个对象是否相等<br>
     * 可空<br>
     * {@code (null == a || null == b) ? a == b : a.equals(b)}
     *
     * @param a   对象a
     * @param b   对象b
     * @param <T> Object
     *
     * @return 结果
     */
    public static final <T> boolean isEqNullable(T a, T b) {
        if (null == a || null == b) {
            return a == b;
        } else {
            return isEq(a, b);
        }
    }

    /**
     * 两个对象是否不相等<br>
     * 可空<br>
     * {@code (null == a || null == b) ? a != b : !a.equals(b)}
     *
     * @param a   对象a
     * @param b   对象b
     * @param <T> Object
     *
     * @return 结果
     */
    public static final <T> boolean isNeqNullable(T a, T b) {
        return !isEqNullable(a, b);
    }

    /**
     * 是否在对象范围内<br>
     * {@code min <= value && value <= max}
     *
     * @param value 待比较的对象
     * @param min   最小值 (包含)
     * @param max   最大值 (包含)
     * @param <T>   Object
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isRangeWithin(Comparable<T> value, T min, T max) {
        return value.compareTo(min) >= 0 && value.compareTo(max) <= 0;
    }

    /**
     * 是否不在对象范围内<br>
     * {@code min > value || value < max}
     *
     * @param value 待比较的对象
     * @param min   最小值 (不包含)
     * @param max   最大值 (不包含)
     * @param <T>   Object
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isNotRangeWithin(Comparable<T> value, T min, T max) {
        return !isRangeWithin(value, min, max);
    }

    /**
     * 是否相等
     * {@code value == compareValue}
     *
     * @param value        待比较的对象
     * @param compareValue 比较对象
     * @param <T>          Object
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isEqual(Comparable<T> value, T compareValue) {
        return value.compareTo(compareValue) == 0;
    }

    /**
     * 是否不相等
     * {@code value != compareValue}
     *
     * @param value        待比较的对象
     * @param compareValue 比较对象
     * @param <T>          Object
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isNotEqual(Comparable<T> value, T compareValue) {
        return !isEqual(value, compareValue);
    }

    /**
     * 是否大于<br>
     * {@code value > min}
     *
     * @param value 待比较的对象
     * @param min   最小值
     * @param <T>   待比较的对象
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isGreatThan(Comparable<T> value, T min) {
        return value.compareTo(min) > 0;
    }

    /**
     * 是否大于等于<br>
     * {@code value >= min}
     *
     * @param value 待比较的对象
     * @param min   最小值
     * @param <T>   待比较的对象
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isGreatThanEqual(Comparable<T> value, T min) {
        return value.compareTo(min) >= 0;
    }

    /**
     * 是否小于<br>
     * {@code value < max}
     *
     * @param value 待比较的对象
     * @param max   最大值
     * @param <T>   待比较的对象
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isLessThan(Comparable<T> value, T max) {
        return value.compareTo(max) < 0;
    }

    /**
     * 是否小于等于<br>
     * {@code value <= max}
     *
     * @param value 待比较的对象
     * @param max   最大值
     * @param <T>   待比较的对象
     *
     * @return 结果
     *
     * @see Comparable
     */
    public static final <T> boolean isLessThanEqual(Comparable<T> value, T max) {
        return value.compareTo(max) <= 0;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     * @param <T>    object
     *
     * @return 结果
     */
    public static final <T> boolean isContains(T object, T... values) {
        for (T t : values) {
            if (isEqNullable(object, t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在集合中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测集合
     * @param <T>    object
     *
     * @return 结果
     */
    public static final <T> boolean isListContains(T object, List<T> values) {
        for (T t : values) {
            if (isEqNullable(object, t)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(int object, int... values) {
        for (int value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(boolean object, boolean... values) {
        for (boolean value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(byte object, byte... values) {
        for (byte value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(char object, char... values) {
        for (char value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(double object, double... values) {
        for (double value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(float object, float... values) {
        for (float value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(long object, long... values) {
        for (long value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isContains(short object, short... values) {
        for (short value : values) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     * @param <T>    object
     *
     * @return 结果
     */
    public static final <T> boolean isNotContains(T object, T... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在集合中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测集合
     * @param <T>    object
     *
     * @return 结果
     */
    public static final <T> boolean isNotListContains(T object, List<T> values) {
        return !isListContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(int object, int... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(boolean object, boolean... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(byte object, byte... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(char object, char... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(double object, double... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(float object, float... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(long object, long... values) {
        return !isContains(object, values);
    }

    /**
     * 对象是否不包含在数组中<br>
     * {@code values not in object}
     *
     * @param object 检查对象
     * @param values 检测数组
     *
     * @return 结果
     */
    public static final boolean isNotContains(short object, short... values) {
        return !isContains(object, values);
    }

    /**
     * 是否等于0<br>
     * {@code number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqZero(Integer number) {
        return number == 0;
    }

    /**
     * 是否不等于0<br>
     * {@code number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqZero(Integer number) {
        return number != 0;
    }

    /**
     * 是否小于0<br>
     * {@code number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtZero(Integer number) {
        return number < 0;
    }

    /**
     * 是否大于0<br>
     * {@code number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtZero(Integer number) {
        return number > 0;
    }

    /**
     * 是否小于等于<br>
     * {@code number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteZero(Integer number) {
        return number <= 0;
    }

    /**
     * 是否大于等于0<br>
     * {@code number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteZero(Integer number) {
        return number >= 0;
    }

    /**
     * 是否等于1<br>
     * {@code number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqOne(Integer number) {
        return number == 1;
    }

    /**
     * 是否不等于1<br>
     * {@code number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqOne(Integer number) {
        return number != 1;
    }

    /**
     * 是否小于1<br>
     * {@code number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtOne(Integer number) {
        return number < 1;
    }

    /**
     * 是否大于1<br>
     * {@code number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtOne(Integer number) {
        return number > 1;
    }

    /**
     * 是否小于等于1<br>
     * {@code number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteOne(Integer number) {
        return number <= 1;
    }

    /**
     * 是否大于等于1<br>
     * {@code number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteOne(Integer number) {
        return number >= 1;
    }

    /**
     * 是否为null或者等于0<br>
     * {@code null == number || number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqZero(Integer number) {
        return null == number || number == 0;
    }

    /**
     * 是否不为null并且不等于0<br>
     * {@code null != number && number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqZero(Integer number) {
        return null != number && number != 0;
    }

    /**
     * 是否为null或者小于0<br>
     * {@code null == number || number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtZero(Integer number) {
        return null == number || number < 0;
    }

    /**
     * 是否不为null并且大于0<br>
     * {@code null != number && number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtZero(Integer number) {
        return null != number && number > 0;
    }

    /**
     * 是否为null或者小于等于0<br>
     * {@code null == number || number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteZero(Integer number) {
        return null == number || number <= 0;
    }

    /**
     * 是否不为null并且大于等于0<br>
     * {@code null != number && number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteZero(Integer number) {
        return null != number && number >= 0;
    }

    /**
     * 是否为null或者等于1<br>
     * {@code null == number || number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqOne(Integer number) {
        return null == number || number == 1;
    }

    /**
     * 是否不为null并且不等于1<br>
     * {@code null != number && number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqOne(Integer number) {
        return null != number && number != 1;
    }

    /**
     * 是否为null或者小于1<br>
     * {@code null == number || number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtOne(Integer number) {
        return null == number || number < 1;
    }

    /**
     * 是否不为null并且大于1<br>
     * {@code null != number && number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtOne(Integer number) {
        return null != number && number > 1;
    }

    /**
     * 是否为null或者小于等于1<br>
     * {@code null == number || number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteOne(Integer number) {
        return null == number || number <= 1;
    }

    /**
     * 是否不为null并且大于等于1<br>
     * {@code null != number && number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteOne(Integer number) {
        return null != number && number >= 1;
    }

    /**
     * 是否等于0<br>
     * {@code number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqZero(Long number) {
        return number == 0;
    }

    /**
     * 是否不等于0<br>
     * {@code number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqZero(Long number) {
        return number != 0;
    }

    /**
     * 是否小于0<br>
     * {@code number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtZero(Long number) {
        return number < 0;
    }

    /**
     * 是否大于0<br>
     * {@code number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtZero(Long number) {
        return number > 0;
    }

    /**
     * 是否小于等于<br>
     * {@code number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteZero(Long number) {
        return number <= 0;
    }

    /**
     * 是否大于等于0<br>
     * {@code number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteZero(Long number) {
        return number >= 0;
    }

    /**
     * 是否等于1<br>
     * {@code number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqOne(Long number) {
        return number == 1;
    }

    /**
     * 是否不等于1<br>
     * {@code number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqOne(Long number) {
        return number != 1;
    }

    /**
     * 是否小于1<br>
     * {@code number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtOne(Long number) {
        return number < 1;
    }

    /**
     * 是否大于1<br>
     * {@code number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtOne(Long number) {
        return number > 1;
    }

    /**
     * 是否小于等于1<br>
     * {@code number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteOne(Long number) {
        return number <= 1;
    }

    /**
     * 是否大于等于1<br>
     * {@code number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteOne(Long number) {
        return number >= 1;
    }

    /**
     * 是否为null或者等于0<br>
     * {@code null == number || number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqZero(Long number) {
        return null == number || number == 0;
    }

    /**
     * 是否不为null并且不等于0<br>
     * {@code null != number && number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqZero(Long number) {
        return null != number && number != 0;
    }

    /**
     * 是否为null或者小于0<br>
     * {@code null == number || number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtZero(Long number) {
        return null == number || number < 0;
    }

    /**
     * 是否不为null并且大于0<br>
     * {@code null != number && number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtZero(Long number) {
        return null != number && number > 0;
    }

    /**
     * 是否为null或者小于等于0<br>
     * {@code null == number || number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteZero(Long number) {
        return null == number || number <= 0;
    }

    /**
     * 是否不为null并且大于等于0<br>
     * {@code null != number && number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteZero(Long number) {
        return null != number && number >= 0;
    }

    /**
     * 是否为null或者等于1<br>
     * {@code null == number || number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqOne(Long number) {
        return null == number || number == 1;
    }

    /**
     * 是否不为null并且不等于1<br>
     * {@code null != number && number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqOne(Long number) {
        return null != number && number != 1;
    }

    /**
     * 是否为null或者小于1<br>
     * {@code null == number || number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtOne(Long number) {
        return null == number || number < 1;
    }

    /**
     * 是否不为null并且大于1<br>
     * {@code null != number && number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtOne(Long number) {
        return null != number && number > 1;
    }

    /**
     * 是否为null或者小于等于1<br>
     * {@code null == number || number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteOne(Long number) {
        return null == number || number <= 1;
    }

    /**
     * 是否不为null并且大于等于1<br>
     * {@code null != number && number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteOne(Long number) {
        return null != number && number >= 1;
    }

    /**
     * 是否等于0<br>
     * {@code number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqZero(Short number) {
        return number == 0;
    }

    /**
     * 是否不等于0<br>
     * {@code number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqZero(Short number) {
        return number != 0;
    }

    /**
     * 是否小于0<br>
     * {@code number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtZero(Short number) {
        return number < 0;
    }

    /**
     * 是否大于0<br>
     * {@code number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtZero(Short number) {
        return number > 0;
    }

    /**
     * 是否小于等于<br>
     * {@code number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteZero(Short number) {
        return number <= 0;
    }

    /**
     * 是否大于等于0<br>
     * {@code number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteZero(Short number) {
        return number >= 0;
    }

    /**
     * 是否等于1<br>
     * {@code number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqOne(Short number) {
        return number == 1;
    }

    /**
     * 是否不等于1<br>
     * {@code number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqOne(Short number) {
        return number != 1;
    }

    /**
     * 是否小于1<br>
     * {@code number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtOne(Short number) {
        return number < 1;
    }

    /**
     * 是否大于1<br>
     * {@code number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtOne(Short number) {
        return number > 1;
    }

    /**
     * 是否小于等于1<br>
     * {@code number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteOne(Short number) {
        return number <= 1;
    }

    /**
     * 是否大于等于1<br>
     * {@code number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteOne(Short number) {
        return number >= 1;
    }

    /**
     * 是否为null或者等于0<br>
     * {@code null == number || number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqZero(Short number) {
        return null == number || number == 0;
    }

    /**
     * 是否不为null并且不等于0<br>
     * {@code null != number && number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqZero(Short number) {
        return null != number && number != 0;
    }

    /**
     * 是否为null或者小于0<br>
     * {@code null == number || number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtZero(Short number) {
        return null == number || number < 0;
    }

    /**
     * 是否不为null并且大于0<br>
     * {@code null != number && number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtZero(Short number) {
        return null != number && number > 0;
    }

    /**
     * 是否为null或者小于等于0<br>
     * {@code null == number || number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteZero(Short number) {
        return null == number || number <= 0;
    }

    /**
     * 是否不为null并且大于等于0<br>
     * {@code null != number && number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteZero(Short number) {
        return null != number && number >= 0;
    }

    /**
     * 是否为null或者等于1<br>
     * {@code null == number || number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqOne(Short number) {
        return null == number || number == 1;
    }

    /**
     * 是否不为null并且不等于1<br>
     * {@code null != number && number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqOne(Short number) {
        return null != number && number != 1;
    }

    /**
     * 是否为null或者小于1<br>
     * {@code null == number || number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtOne(Short number) {
        return null == number || number < 1;
    }

    /**
     * 是否不为null并且大于1<br>
     * {@code null != number && number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtOne(Short number) {
        return null != number && number > 1;
    }

    /**
     * 是否为null或者小于等于1<br>
     * {@code null == number || number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteOne(Short number) {
        return null == number || number <= 1;
    }

    /**
     * 是否不为null并且大于等于1<br>
     * {@code null != number && number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteOne(Short number) {
        return null != number && number >= 1;
    }

    /**
     * 是否等于0<br>
     * {@code number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqZero(Double number) {
        return number == 0;
    }

    /**
     * 是否不等于0<br>
     * {@code number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqZero(Double number) {
        return number != 0;
    }

    /**
     * 是否小于0<br>
     * {@code number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtZero(Double number) {
        return number < 0;
    }

    /**
     * 是否大于0<br>
     * {@code number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtZero(Double number) {
        return number > 0;
    }

    /**
     * 是否小于等于<br>
     * {@code number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteZero(Double number) {
        return number <= 0;
    }

    /**
     * 是否大于等于0<br>
     * {@code number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteZero(Double number) {
        return number >= 0;
    }

    /**
     * 是否等于1<br>
     * {@code number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqOne(Double number) {
        return number == 1;
    }

    /**
     * 是否不等于1<br>
     * {@code number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqOne(Double number) {
        return number != 1;
    }

    /**
     * 是否小于1<br>
     * {@code number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtOne(Double number) {
        return number < 1;
    }

    /**
     * 是否大于1<br>
     * {@code number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtOne(Double number) {
        return number > 1;
    }

    /**
     * 是否小于等于1<br>
     * {@code number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteOne(Double number) {
        return number <= 1;
    }

    /**
     * 是否大于等于1<br>
     * {@code number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteOne(Double number) {
        return number >= 1;
    }

    /**
     * 是否为null或者等于0<br>
     * {@code null == number || number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqZero(Double number) {
        return null == number || number == 0;
    }

    /**
     * 是否不为null并且不等于0<br>
     * {@code null != number && number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqZero(Double number) {
        return null != number && number != 0;
    }

    /**
     * 是否为null或者小于0<br>
     * {@code null == number || number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtZero(Double number) {
        return null == number || number < 0;
    }

    /**
     * 是否不为null并且大于0<br>
     * {@code null != number && number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtZero(Double number) {
        return null != number && number > 0;
    }

    /**
     * 是否为null或者小于等于0<br>
     * {@code null == number || number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteZero(Double number) {
        return null == number || number <= 0;
    }

    /**
     * 是否不为null并且大于等于0<br>
     * {@code null != number && number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteZero(Double number) {
        return null != number && number >= 0;
    }

    /**
     * 是否为null或者等于1<br>
     * {@code null == number || number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqOne(Double number) {
        return null == number || number == 1;
    }

    /**
     * 是否不为null并且不等于1<br>
     * {@code null != number && number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqOne(Double number) {
        return null != number && number != 1;
    }

    /**
     * 是否为null或者小于1<br>
     * {@code null == number || number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtOne(Double number) {
        return null == number || number < 1;
    }

    /**
     * 是否不为null并且大于1<br>
     * {@code null != number && number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtOne(Double number) {
        return null != number && number > 1;
    }

    /**
     * 是否为null或者小于等于1<br>
     * {@code null == number || number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteOne(Double number) {
        return null == number || number <= 1;
    }

    /**
     * 是否不为null并且大于等于1<br>
     * {@code null != number && number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteOne(Double number) {
        return null != number && number >= 1;
    }

    /**
     * 是否等于0<br>
     * {@code number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqZero(BigDecimal number) {
        return isEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否不等于0<br>
     * {@code number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqZero(BigDecimal number) {
        return isNotEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否小于0<br>
     * {@code number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtZero(BigDecimal number) {
        return isLessThan(number, BigDecimal.ZERO);
    }

    /**
     * 是否大于0<br>
     * {@code number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtZero(BigDecimal number) {
        return isGreatThan(number, BigDecimal.ZERO);
    }

    /**
     * 是否小于等于<br>
     * {@code number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteZero(BigDecimal number) {
        return isLessThanEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否大于等于0<br>
     * {@code number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteZero(BigDecimal number) {
        return isGreatThanEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否等于1<br>
     * {@code number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isEqOne(BigDecimal number) {
        return isEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否不等于1<br>
     * {@code number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNeqOne(BigDecimal number) {
        return isNotEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否小于1<br>
     * {@code number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLtOne(BigDecimal number) {
        return isLessThan(number, BigDecimal.ONE);
    }

    /**
     * 是否大于1<br>
     * {@code number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGtOne(BigDecimal number) {
        return isGreatThan(number, BigDecimal.ONE);
    }

    /**
     * 是否小于等于1<br>
     * {@code number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isLteOne(BigDecimal number) {
        return isLessThanEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否大于等于1<br>
     * {@code number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isGteOne(BigDecimal number) {
        return isGreatThanEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否为null或者等于0<br>
     * {@code null == number || number == 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqZero(BigDecimal number) {
        return null == number || isEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否不为null并且不等于0<br>
     * {@code null != number && number != 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqZero(BigDecimal number) {
        return null != number && isNotEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否为null或者小于0<br>
     * {@code null == number || number < 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtZero(BigDecimal number) {
        return null == number || isLessThan(number, BigDecimal.ZERO);
    }

    /**
     * 是否不为null并且大于0<br>
     * {@code null != number && number > 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtZero(BigDecimal number) {
        return null != number && isGreatThan(number, BigDecimal.ZERO);
    }

    /**
     * 是否为null或者小于等于0<br>
     * {@code null == number || number <= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteZero(BigDecimal number) {
        return null == number || isLessThanEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否不为null并且大于等于0<br>
     * {@code null != number && number >= 0}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteZero(BigDecimal number) {
        return null != number && isGreatThanEqual(number, BigDecimal.ZERO);
    }

    /**
     * 是否为null或者等于1<br>
     * {@code null == number || number == 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrEqOne(BigDecimal number) {
        return null == number || isEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否不为null并且不等于1<br>
     * {@code null != number && number != 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNeqOne(BigDecimal number) {
        return null != number && isNotEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否为null或者小于1<br>
     * {@code null == number || number < 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLtOne(BigDecimal number) {
        return null == number || isLessThan(number, BigDecimal.ONE);
    }

    /**
     * 是否不为null并且大于1<br>
     * {@code null != number && number > 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGtOne(BigDecimal number) {
        return null != number && isGreatThan(number, BigDecimal.ONE);
    }

    /**
     * 是否为null或者小于等于1<br>
     * {@code null == number || number <= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNullOrLteOne(BigDecimal number) {
        return null == number || isLessThanEqual(number, BigDecimal.ONE);
    }

    /**
     * 是否不为null并且大于等于1<br>
     * {@code null != number && number >= 1}
     *
     * @param number 数字
     *
     * @return 结果
     */
    public static final boolean isNotNullAndGteOne(BigDecimal number) {
        return null != number && isGreatThanEqual(number, BigDecimal.ONE);
    }


    /**
     * 是否包含空格
     *
     * @param value 需要检查的字符串
     *
     * @return 是否包含空格
     */
    public static final boolean isContainSpace(String value) {
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isSpaceChar(chars[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否不包含空格
     *
     * @param value 需要检查的字符串
     *
     * @return 是否包含空格
     */
    public static boolean isNotContainSpace(String value) {
        return !isContainSpace(value);
    }

    /**
     * 是否包含某个字符 <br>
     *
     * @param value 检测的字符串
     * @param c     检查的字符
     *
     * @return 是否包含被检测的字符串
     */
    public static final boolean isContain(String value, char c) {
        return value.indexOf(c) >= 0;
    }

    /**
     * 是否不包含某个字符
     *
     * @param value 检测的字符串
     * @param c     检查的字符
     *
     * @return 是否不包含某个字符
     */
    public static final boolean isNotContain(String value, char c) {
        return !isContain(value, c);
    }

    /**
     * 是否包含某个字符串
     *
     * @param value  待检测的字符串
     * @param string 检查的字符串
     *
     * @return 是否包含某个字符串
     */
    public static final boolean isContain(String value, String string) {
        return value.indexOf(string) >= 0;
    }

    /**
     * 是否不包含某个字符串
     *
     * @param value  待检测的字符串
     * @param string 检查的字符串
     *
     * @return 是否不包含某个字符串
     */
    public static final boolean isNotContain(String value, String string) {
        return !isContain(value, string);
    }

    /**
     * 是否为""
     *
     * @param string 待检测字符串
     *
     * @return 结果
     */
    public static final boolean isEmpty(String string) {
        return EMPTY.equals(string);
    }

    /**
     * 是否不为""
     *
     * @param string 待检测字符串
     *
     * @return 结果
     */
    public static final boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    /**
     * trim后是否为""
     *
     * @param string 待检测字符串
     *
     * @return 结果
     */
    public static final boolean isTrimEmpty(String string) {
        return EMPTY.equals(trim(string));
    }

    /**
     * trim后是否不为""
     *
     * @param string 待检测字符串
     *
     * @return 结果
     */
    public static final boolean isNotTrimEmpty(String string) {
        return !isNotTrimEmpty(string);
    }

    /**
     * 字符串的长度是否超出maxLength
     *
     * @param string    待检测字符串
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isOverLength(String string, int maxLength) {
        return string.length() > maxLength;
    }

    /**
     * 字符串的长度是否没有超出maxLength
     *
     * @param string    待检测字符串
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isNotOverLength(String string, int maxLength) {
        return !isOverLength(string, maxLength);
    }

    /**
     * trim后的字符串长度是否超出maxLength
     *
     * @param string    待检测字符串
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isOverTrimLength(String string, int maxLength) {
        return trim(string).length() >= maxLength;
    }

    /**
     * trim后的字符串长度是否没有超出maxLength
     *
     * @param string    待检测字符串
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isNotOverTrimLength(String string, int maxLength) {
        return !isOverTrimLength(string, maxLength);
    }

    /**
     * 字符串的长度是否包含在minLength/maxLength范围内
     *
     * @param string    待检测字符串
     * @param minLength 最小长度
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isIncludeLength(String string, int minLength, int maxLength) {
        return string.length() >= minLength && string.length() <= maxLength;
    }

    /**
     * 字符串的长度是否没有包含在minLength/maxLength范围内
     *
     * @param string    待检测字符串
     * @param minLength 最小长度
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isNotIncludeLength(String string, int minLength, int maxLength) {
        return !isIncludeLength(string, minLength, maxLength);
    }

    /**
     * trim后的字符串的长度是否包含在minLength/maxLength范围内
     *
     * @param string    待检测字符串
     * @param minLength 最小长度
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isIncludeTrimLength(String string, int minLength, int maxLength) {
        int length = trim(string).length();
        return length >= minLength && length <= maxLength;
    }

    /**
     * trim后的字符串的长度是否没有包含在minLength/maxLength范围内
     *
     * @param string    待检测字符串
     * @param minLength 最小长度
     * @param maxLength 最大长度
     *
     * @return 结果
     */
    public static final boolean isNotIncludeTrimLength(String string, int minLength, int maxLength) {
        return !isIncludeTrimLength(string, minLength, maxLength);
    }

    /**
     * 是否等于null or ""
     *
     * @param string value 待检测的字符串
     *
     * @return 结果
     */
    public static final boolean isNullOrEmpty(String string) {
        if (Check.isNull(string)) {
            return true;
        }
        return EMPTY.equals(string);
    }

    /**
     * 是否不等于 null and ""
     *
     * @param string value 待检测的字符串
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotEmpty(String string) {
        return !isNullOrEmpty(string);
    }

    /**
     * 是否等于 null or trim(string)==""
     *
     * @param string 待检测的字符串
     *
     * @return 结果
     */
    public static final boolean isNullOrTrimEmpty(String string) {
        if (Check.isNull(string)) {
            return true;
        }
        return EMPTY.equals(trim(string));
    }

    /**
     * 是否不等于 null and trim(string)==""
     *
     * @param string 待检测的字符串
     *
     * @return 结果
     */
    public static final boolean isNotNullAndNotTrimEmpty(String string) {
        return !isNullOrTrimEmpty(string);
    }

    /**
     * 是否 a equals b
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isEq(String stringA, String stringB) {
        return stringA.equals(stringB);
    }

    /**
     * 是否 a !equals b
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNeq(String stringA, String stringB) {
        return !isEq(stringA, stringB);
    }

    /**
     * 是否 trim(a) equals trim(b)
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isTrimEq(String stringA, String stringB) {
        return trim(stringA).equals(trim(stringB));
    }

    /**
     * 是否 trim(a) !equals trim(b)
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNotTrimEq(String stringA, String stringB) {
        return !isTrimEq(stringA, stringB);
    }

    /**
     * 是否 trim(a) equals trim(b) <br>
     * 可为null比较
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isTrimEqNullable(String stringA, String stringB) {
        if (null == stringA || null == stringB) {
            return stringA == stringB;
        } else {
            return isTrimEq(stringA, stringB);
        }
    }

    /**
     * 是否 trim(a) !equals trim(b) <br>
     * 可为null比较
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNotTrimEqNullable(String stringA, String stringB) {
        return !isTrimEqNullable(stringA, stringB);
    }

    /**
     * 忽略大小写是否相等
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isEqIgnoreCase(String stringA, String stringB) {
        return stringA.equalsIgnoreCase(stringB);
    }

    /**
     * 忽略大小写是否不相等
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNeqIgnoreCase(String stringA, String stringB) {
        return !isEqIgnoreCase(stringA, stringB);
    }

    /**
     * 忽略大小写是否相等<br>
     * 可为null
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isEqIgnoreCaseNullable(String stringA, String stringB) {
        if (null == stringA || null == stringB) {
            return stringA == stringB;
        } else {
            return isEqIgnoreCase(stringA, stringB);
        }
    }

    /**
     * 忽略大小写是否不相等<br>
     * 可为null
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNeqIgnoreCaseNullable(String stringA, String stringB) {
        return !isEqIgnoreCaseNullable(stringA, stringB);
    }

    /**
     * trim忽略大小写是否相等<br>
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isTrimEqIgnoreCase(String stringA, String stringB) {
        return trim(stringA).equalsIgnoreCase(trim(stringB));
    }

    /**
     * trim忽略大小写是否不相等<br>
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNotTrimEqIgnoreCase(String stringA, String stringB) {
        return !isTrimEqIgnoreCase(stringA, stringB);
    }

    /**
     * trim忽略大小写是否相等<br>
     * 可为null<br>
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isTrimEqIgnoreCaseNullable(String stringA, String stringB) {
        if (null == stringA || null == stringB) {
            return stringA == stringB;
        } else {
            return isTrimEqIgnoreCase(stringA, stringB);
        }
    }

    /**
     * trim忽略大小写是否不相等<br>
     * 可为null<br>
     *
     * @param stringA 字符串a
     * @param stringB 字符串b
     *
     * @return 结果
     */
    public static final boolean isNotTrimEqIgnoreCaseNullable(String stringA, String stringB) {
        return !isTrimEqIgnoreCaseNullable(stringA, stringB);
    }
}
