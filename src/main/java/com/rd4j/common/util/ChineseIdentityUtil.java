package com.rd4j.common.util;

import java.util.regex.Pattern;


/**
 * 中国身份证
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public final class ChineseIdentityUtil {

    public static final Pattern IDENTITY = Pattern.compile(
            "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)");

    public static final boolean isIdentity(String identityCode) {
        boolean result = IDENTITY.matcher(identityCode).matches();
        if (result && identityCode.length() == 18) {
            char[] charArray = identityCode.toCharArray();
            // 前十七位加权因子
            int[] idCardWi = {7,
                    9,
                    10,
                    5,
                    8,
                    4,
                    2,
                    1,
                    6,
                    3,
                    7,
                    9,
                    10,
                    5,
                    8,
                    4,
                    2};
            // 这是除以11后，可能产生的11位余数对应的验证码
            String[] idCardY = {"1",
                    "0",
                    "X",
                    "9",
                    "8",
                    "7",
                    "6",
                    "5",
                    "4",
                    "3",
                    "2"};
            int sum = 0;
            for (int i = 0; i < idCardWi.length; i++) {
                int current = Integer.parseInt(String.valueOf(charArray[i]));
                int count = current * idCardWi[i];
                sum += count;
            }
            char idCardLast = charArray[17];
            int idCardMod = sum % 11;
            if (idCardY[idCardMod].toUpperCase().equals(String.valueOf(idCardLast).toUpperCase())) {
                return true;
            } else {
                return false;
            }
        }
        return result;
    }
}
