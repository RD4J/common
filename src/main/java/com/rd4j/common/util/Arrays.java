package com.rd4j.common.util;

import com.rd4j.common.exception.MethodParameterException;

import java.lang.reflect.Array;

/**
 * 数组工具
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class Arrays {
    private Arrays() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isArray(Object o) {
        return o != null && o.getClass().isArray();
    }

    public static Object[] asObjectArray(Object array) {
        Assert.isTrue(isArray(array), () -> new MethodParameterException("Given object {} is not an array", array));
        int length = Array.getLength(array);
        Object[] objectArray = new Object[length];

        for (int i = 0; i < length; ++i) {
            objectArray[i] = Array.get(array, i);
        }

        return objectArray;
    }
}
