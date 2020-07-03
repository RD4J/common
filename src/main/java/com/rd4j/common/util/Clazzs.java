package com.rd4j.common.util;

import com.rd4j.common.exception.WrappedRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * class 对象工具
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class Clazzs {

    private static final Logger log = LoggerFactory.getLogger(Objects.class);

    /**
     * 新建实例 <br>
     * 必须存在无参构造
     *
     * @param clazz 实例类型
     * @param <T>   实例类型
     *
     * @return 实例
     */
    public static final <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new WrappedRuntimeException("newInstance error", e);
        }
    }
}
