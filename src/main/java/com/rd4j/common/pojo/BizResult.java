package com.rd4j.common.pojo;

import com.rd4j.common.annotation.Description;
import com.rd4j.common.enums.ResultCode;

/**
 * 业务结果
 *
 * @param <T> 返回对象类型
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 **/
public class BizResult<T> extends Result {

    @Description({"返回对象"})
    private T returnObject;

    public T getReturnObject() {
        return returnObject;
    }

    public BizResult<T> setReturnObject(T returnObject) {
        this.returnObject = returnObject;
        return this;
    }

    public static BizResult create() {
        return new BizResult();
    }
}
