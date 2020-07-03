package com.rd4j.common.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 生成小的id<br>
 * 作为短地址生成使用<br>
 * 使用buildDigits,buildAssembleSequence生成随机配置,防止出现id被破解<br>
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class TinyId {

    /**
     * 初始化 62 进制数据，索引位置代表字符的数值，比如 A代表10，z代表61等<br>
     * 允许的数值列表
     */
    public final static char[] ALLOW_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * 默认的数值列表
     */
    public final static char[] DEFAULT_DIGITS = {'H', 'p', 'r', '9', 'Z', 'Y', 'X', 'o', 'B', 'i', 'F', 'Q', 'h', '1',
            'c', 'b', 'P', 'S', 'K', 'G', 'l', '3', 'V', 'u', 'I', 'q', 'L', 'j', '7', 'g', '2', 'x', 'a', 'w', 'f',
            'd', 'e', 's', 'z', 'k', 'O', '8', '0', 'T', 'M', 'C', 'U', '5', '4', 'N', 'A', '6', 't', 'D', 'v', 'y',
            'E', 'm', 'n', 'W', 'R', 'J'};

    /**
     * 允许的装配顺序列表
     */
    public final static int[] ALLOW_ASSEMBLE_SEQUENCE = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    /**
     * 默认装配顺序
     */
    public final static int[] DEFAULT_ASSEMBLE_SEQUENCE = {16, 1, 17, 2, 5, 9, 4, 12, 3, 6, 8, 11, 10, 13, 15, 14, 7};

    public static char[] buildDigits() {
        List<Character> list = Lists.newArrayList(ArrayUtils.toObject(ALLOW_DIGITS));
        for (int i = 0; i < ALLOW_DIGITS.length; i++) {
            Character char1 = list.get(i);
            list.remove(i);
            list.add(RandomUtils.nextInt(0, list.size()), char1);
        }
        return ArrayUtils.toPrimitive(list.stream().toArray(Character[]::new));
    }

    public static String formatDigits(char[] digits) {
        return MessageFormatter.format("public final static char[] TINYID_DIGITS = {'{}'};",
                Strings.joint(ArrayUtils.toObject(digits), "','"));
    }

    public static int[] buildAssembleSequence() {
        List<Integer> list = Lists.newArrayList(ArrayUtils.toObject(ALLOW_ASSEMBLE_SEQUENCE));
        for (int i = 0; i < ALLOW_ASSEMBLE_SEQUENCE.length; i++) {
            Integer integer = list.get(i);
            list.remove(i);
            list.add(RandomUtils.nextInt(0, list.size()), integer);
        }
        return ArrayUtils.toPrimitive(list.stream().toArray(Integer[]::new));
    }

    public static String formatAssembleSequence(int[] assembleSequence) {
        return MessageFormatter.format("public final static int[] TINYID_ASSEMBLE_SEQUENCE = {{}};",
                Strings.joint(ArrayUtils.toObject(assembleSequence), ","));
    }

    /**
     * 将数字转为62进制
     *
     * @param num Long 型数字
     * @return 62进制字符串
     */
    public static String encode(long num) {
        return encode(num, DEFAULT_DIGITS);
    }

    /**
     * 将数字转为62进制
     *
     * @param num    Long 型数字
     * @param digits 转换数字列表
     * @return 结果
     */
    public static String encode(long num, char[] digits) {
//        Assert.isTrue(digits.length == 62, "digits不是123位");
        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        while (num > digits.length - 1) {
            /**
             * 对 scale 进行求余，然后将余数追加至 sb 中，由于是从末位开始追加的，因此最后需要反转（reverse）字符串
             */
            remainder = Long.valueOf(num % digits.length).intValue();
            sb.append(digits[remainder]);

            num = num / digits.length;
        }

        sb.append(digits[Long.valueOf(num).intValue()]);
        return sb.reverse().toString();
    }

    /**
     * 62进制字符串转为数字
     *
     * @param str 编码后的62进制字符串
     * @return 解码后的 10 进制字符串
     */
    public static long decode(String str) {
        return decode(str, DEFAULT_DIGITS);
    }

    /**
     * 62进制字符串转为数字
     *
     * @param str    编码后的62进制字符串
     * @param digits 转换数字列表
     * @return 结果
     */
    public static long decode(String str, char[] digits) {
//        Assert.isTrue(digits.length == 62, "digits不是123位");
        int[] indexs = new int[123];
        for (int i = 0; i < digits.length; i++) {
            indexs[(int) digits[i]] = i;
        }
        long num = 0;
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            /**
             * 查找字符的索引位置
             */
            index = indexs[(int) str.charAt(i)];
            /**
             * 索引位置代表字符的数值
             */
            num += (long) (index * (Math.pow(digits.length, str.length() - i - 1)));
        }

        return num;
    }

    public static String encodeFixedLengthId(int id) {
        return encodeFixedLengthId(id, DEFAULT_DIGITS, DEFAULT_ASSEMBLE_SEQUENCE);
    }

    public static String encodeFixedLengthId(int id, char[] digits) {
        return encodeFixedLengthId(id, digits, DEFAULT_ASSEMBLE_SEQUENCE);
    }

    public static String encodeFixedLengthId(int id, int[] assembleSequence) {
        return encodeFixedLengthId(id, DEFAULT_DIGITS, assembleSequence);
    }

    /**
     * 加密成固定长度id
     *
     * @param id               需要转换的Id
     * @param digits           转换数字列表
     * @param assembleSequence 组装顺序; 长度必须是17位, 数组范围1-17;
     * @return 结果
     */
    public static String encodeFixedLengthId(int id, char[] digits, int[] assembleSequence) {
        assembleSequence = Arrays.stream(assembleSequence).filter(i -> {
//            Assert.isTrue(i > 0 && i < 18, "assembleSequence必须大于0,小于18");
            return true;
        }).distinct().toArray();
//        Assert.isTrue(assembleSequence.length == 17, "assembleSequence不是17位");
        // 随机六位乱码数
        String rand = String.valueOf(RandomUtils.nextInt(100000, 999999));
        // id 进行补零,保证固定位数
        String idstr = String.format("%s%012d", rand, id);
        // 去重复配置
        char[] chars = new char[18];
        chars[0] = idstr.charAt(0);
        for (int i = 1; i < chars.length; i++) {
            chars[i] = idstr.charAt(assembleSequence[i - 1]);
        }
        // 组装成long id
        long buildId = Long.parseLong(new String(chars));
        return TinyId.encode(buildId);
    }

    public static int decodeFixedLengthId(String str) {
        return decodeFixedLengthId(str, DEFAULT_DIGITS, DEFAULT_ASSEMBLE_SEQUENCE);
    }

    public static int decodeFixedLengthId(String str, char[] digits) {
        return decodeFixedLengthId(str, digits, DEFAULT_ASSEMBLE_SEQUENCE);
    }

    public static int decodeFixedLengthId(String str, int[] assembleSequence) {
        return decodeFixedLengthId(str, DEFAULT_DIGITS, assembleSequence);
    }

    /**
     * 解密固定长度id
     *
     * @param str              字符串
     * @param digits           转换数字列表
     * @param assembleSequence 组装顺序; 长度必须是17位, 数组范围1-17;
     * @return 结果
     */
    public static int decodeFixedLengthId(String str, char[] digits, int[] assembleSequence) {
        assembleSequence = Arrays.stream(assembleSequence).filter(i -> {
//            Assert.isTrue(i > 0 && i < 18, "assembleSequence必须大于0,小于18");
            return true;
        }).distinct().toArray();
//        Assert.isTrue(assembleSequence.length == 17, "assembleSequence不是17位");

        long id1 = TinyId.decode(str);
        char[] chars = String.valueOf(id1).toCharArray();
        char[] out = new char[12];
        for (int i = 1; i < 18; i++) {
            int index = assembleSequence[i - 1];
            if (index >= 6) {
                out[index - 6] = chars[i];
            }
        }
        String outStr = new String(out);
        return Integer.parseInt(outStr);
    }

}
