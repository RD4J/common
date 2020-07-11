package com.rd4j.common.annotation;

import java.lang.annotation.*;

/**
 * 文档描述<br>
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {

    String[] value();
}
