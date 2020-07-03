package com.rd4j.common.util;

import junit.framework.TestCase;

import java.util.Arrays;

import static com.rd4j.common.util.Check.*;

public class CheckTest extends TestCase {

    public void testIsEmail() {
        assertTrue(isEmail("rd4j@rd4j.com"));
        assertTrue(isEmail("rd4j@163.com"));
        assertTrue(isEmail("123456@163.com"));
        assertFalse(isEmail(""));
        assertFalse(isEmail("中国@163.com"));
        assertFalse(isEmail("@163.com"));
        assertFalse(isEmail("1234@.com"));
        assertFalse(isEmail("123456@163com"));
        assertFalse(isEmail("123456.163.com"));
    }

    public void testIsChinaPhone() {
        assertTrue(isChinaPhone("13812345678"));
        assertTrue(isChinaPhone("19100000000"));
        assertFalse(isChinaPhone("11100000000"));
        assertFalse(isChinaPhone("10100000000"));
        assertFalse(isChinaPhone("23100000000"));
        assertFalse(isChinaPhone("1380000000"));
        assertFalse(isChinaPhone("1380000000a"));
        assertFalse(isChinaPhone("aaaaaaaaaaa"));
        assertFalse(isChinaPhone(""));
        assertFalse(isChinaPhone("中文中文中文中文中文中"));
    }

    public void testIsNumber() {
        assertTrue(isNumber("123"));
        assertTrue(isNumber("00012300"));
        assertFalse(isNumber(""));
        assertFalse(isNumber("a"));
        assertFalse(isNumber("中国"));
        assertFalse(isNumber("00012300a"));
        assertFalse(isNumber("aaaaaaaa"));
    }

    public void testIsInteger() {
        assertTrue(isInteger("123"));
        assertTrue(isInteger("0"));
        assertTrue(isInteger("-123"));
        assertTrue(isInteger("-0"));
        assertTrue(isInteger("+123"));
        assertTrue(isInteger("+0"));
        assertFalse(isInteger(""));
        assertFalse(isInteger("中"));
        assertFalse(isInteger("-"));
        assertFalse(isInteger("01"));
        assertFalse(isInteger("1.0"));
        assertFalse(isInteger("123df"));
    }

    public void testIsDouble() {
        assertTrue(isDouble("0"));
        assertTrue(isDouble("0.0"));
        assertTrue(isDouble("123"));
        assertTrue(isDouble("123.0"));
        assertTrue(isDouble("0.01"));
        assertTrue(isDouble("-0"));
        assertTrue(isDouble("-0.0"));
        assertTrue(isDouble("-123"));
        assertTrue(isDouble("-123.0"));
        assertTrue(isDouble("-0.01"));
        assertTrue(isDouble("+0"));
        assertTrue(isDouble("+0.0"));
        assertTrue(isDouble("+123"));
        assertTrue(isDouble("+123.0"));
        assertTrue(isDouble("+0.01"));
        assertFalse(isDouble(""));
        assertFalse(isDouble("中"));
        assertFalse(isDouble("+"));
        assertFalse(isInteger("-"));
        assertFalse(isDouble(".1"));
        assertFalse(isDouble("-.1"));
        assertFalse(isDouble("a.123"));
    }

    public void testIsUserName() {
        assertTrue(isUserName("A_bc123"));
        assertTrue(isUserName("abcd"));
        assertTrue(isUserName("abcd123"));
        assertTrue(isUserName("a123478"));
        assertTrue(isUserName("a_b_c_d_e_1_2_3_4_5"));
        assertFalse(isUserName("_asd_asd"));
        assertFalse(isUserName("abcd_"));
        assertFalse(isUserName("_asd_"));
        assertFalse(isUserName("123456"));
        assertFalse(isUserName("_asd_"));
        assertFalse(isUserName("哈哈"));
        assertFalse(isUserName("😃"));
        assertFalse(isUserName(""));
        assertFalse(isUserName("asd+"));
    }

    public void testIsLetter() {
        assertTrue(isLetter("abcd"));
        assertTrue(isLetter("abAcd"));
        assertFalse(isLetter(""));
        assertFalse(isLetter("1"));
        assertFalse(isLetter("-"));
        assertFalse(isLetter("asd+"));
        assertFalse(isLetter("123123"));
        assertFalse(isLetter("asd123"));
    }

    public void testIsChinese() {
        assertTrue(isChinese("中国"));
        assertFalse(isChinese(""));
        assertFalse(isChinese("a"));
        assertFalse(isChinese("1"));
        assertFalse(isChinese("-"));
        assertFalse(isChinese("，"));
    }

    public void testIsCamelCaseNamed() {
        assertTrue(isCamelCaseNamed("AcD"));
        assertTrue(isCamelCaseNamed("A123B465Cdef"));
        assertTrue(isCamelCaseNamed("A"));
        assertFalse(isCamelCaseNamed(""));
        assertFalse(isCamelCaseNamed("_"));
        assertFalse(isCamelCaseNamed("中国"));
        assertFalse(isCamelCaseNamed("aBcd"));
        assertFalse(isCamelCaseNamed("abcd"));
        assertFalse(isCamelCaseNamed("_Abcd"));
        assertFalse(isCamelCaseNamed(" Abcd"));
        assertFalse(isCamelCaseNamed("123"));
    }

    public void testIsLowerCamelCaseNamed() {
        assertTrue(isLowerCamelCaseNamed("acD"));
        assertTrue(isLowerCamelCaseNamed("a123B465Cdef"));
        assertTrue(isLowerCamelCaseNamed("a"));
        assertTrue(isLowerCamelCaseNamed("abcd"));
        assertFalse(isLowerCamelCaseNamed(""));
        assertFalse(isLowerCamelCaseNamed("_"));
        assertFalse(isLowerCamelCaseNamed("中国"));
        assertFalse(isLowerCamelCaseNamed("ABcd"));
        assertFalse(isLowerCamelCaseNamed("Abcd"));
        assertFalse(isLowerCamelCaseNamed("_Abcd"));
        assertFalse(isLowerCamelCaseNamed(" Abcd"));
        assertFalse(isLowerCamelCaseNamed("123"));
    }

    public void testIsSnakeCaseNamed() {
        String[] trueValue = {"abcd_abc", "a", "a1_2_3"};
        String[] falseValue = {"", "_", "中国", "_abcd", "123_", "abcd_asd_", "abcd__asd", "Abcd__asd"};

        Arrays.stream(trueValue).forEach(value -> {
            assertTrue(value, isSnakeCaseNamed(value));
        });

        Arrays.stream(falseValue).forEach(value -> {
            assertFalse(value, isSnakeCaseNamed(value));
        });
    }

    public void testIsUpperSnakeCaseNamed() {
        String[] trueValue = {"ABCD_ABC", "A", "A1_2_3"};
        String[] falseValue = {"", "_", "中国", "_abcd", "123_", "abcd_asd_", "abcd__asd"};

        Arrays.stream(trueValue).forEach(value -> {
            assertTrue(value, isUpperSnakeCaseNamed(value));
        });

        Arrays.stream(falseValue).forEach(value -> {
            assertFalse(value, isUpperSnakeCaseNamed(value));
        });
    }

    public void testIsKebabCaseNamed() {
        String[] trueValue = {"abcd-abc", "a", "a1-2-3"};
        String[] falseValue = {"", "_", "-", "中国", "-abcd", "123-", "abcd-asd-", "abcd--asd", "ABCD-ASD"};

        Arrays.stream(trueValue).forEach(value -> {
            assertTrue(value, isKebabCaseNamed(value));
        });

        Arrays.stream(falseValue).forEach(value -> {
            assertFalse(value, isKebabCaseNamed(value));
        });
    }

    public void testIsUpperKebabCaseNamed() {
        String[] trueValue = {"ABCD-ABC", "A", "A1-2-3"};
        String[] falseValue = {"", "_", "-", "中国", "-ABCD", "123-", "ABCD-ASD-", "ABCD--ASD", "abcd-asd"};

        Arrays.stream(trueValue).forEach(value -> {
            assertTrue(value, isUpperKebabCaseNamed(value));
        });

        Arrays.stream(falseValue).forEach(value -> {
            assertFalse(value, isUpperKebabCaseNamed(value));
        });
    }

    public void testIsChineseIdentity() {
        String[] trueValue = {"110101199003075074", "11010119900307029X"};
        String[] falseValue = {"", "_", "-", "中国", "-ABCD", "123-", "ABCD-ASD-", "ABCD--ASD", "abcd-asd", "110101199003075073","110101199003070291"};

        Arrays.stream(trueValue).forEach(value -> {
            assertTrue(value, isChineseIdentity(value));
        });

        Arrays.stream(falseValue).forEach(value -> {
            assertFalse(value, isChineseIdentity(value));
        });
    }
}