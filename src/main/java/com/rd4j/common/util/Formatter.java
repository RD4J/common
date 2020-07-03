package com.rd4j.common.util;

/**
 * 格式化工具
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class Formatter {

    private Formatter() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 消息格式化<br>
     * 使用{}为占位符
     *
     * @param message  消息
     * @param argArray 参数
     * @return 格式化字符串
     */
    public static String message(String message, Object... argArray) {
        return MessageFormatter.format(message, argArray);
    }
}
