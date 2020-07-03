package com.rd4j.common.pojo;

import com.rd4j.common.annotation.Description;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.function.Function;
import java.util.regex.Pattern;


/**
 * 排序
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 * @see Sortings
 */
@Description({"排序"})
public class Sorting implements Serializable {

//
//    public static final Pattern SQL_INJECTION_PREVENTION = Pattern.compile("^([A-Za-z]+[A-Za-z_0-9]*[.])?[A-Za-z]+[A-Za-z_0-9]*$");
//
//    @Description({"属性"})
//    @NonNull
//    private String field;
//
//    @Description({"是否倒序排列",
//            "默认: false"})
//    private boolean descend;
//
//    public Sorting() {
//        super();
//    }
//
//    public Sorting(String field, boolean descend) {
//        super();
//        this.field = field;
//        this.descend = descend;
//    }
//
//    @IgnoreField
//    private String real;
//
//    public String getField() {
//        return field;
//    }
//
//    public void setField(String field) {
//        this.field = field;
//        BizAssert.isTrue(SQL_INJECTION_PREVENTION.matcher(field).matches(), ResultCode.SYSTEM.getCode(), "请输入合法的属性参数");
//    }
//
//    public boolean isDescend() {
//        return descend;
//    }
//
//    public void setDescend(boolean descend) {
//        this.descend = descend;
//    }
//
//    public Sorting verify(Function<String, ?> function) {
//        Object obj = function.apply(field);
//        BizAssert.isTrue(Check.notNull(obj), ResultCode.SYSTEM.getCode(), "排序字段中不包含[{}]字段", field);
//        if (obj instanceof Boolean) {
//            BizAssert.isTrue((Boolean) obj, ResultCode.SYSTEM.getCode(), "排序字段中不包含[{}]字段", field);
//        }
//        return this;
//    }
//
//    public Sorting real(Function<String, String> function) {
//        real = function.apply(field);
//        return this;
//    }
//
//    private String fieldValue() {
//        if (Check.notNull(real)) {
//            return real;
//        } else if (Check.notNull(field)) {
//            return field;
//        }
//        return "createTime";
//    }
//
//    public String toSql() {
//        if (descend) {
//            return fieldValue() + " DESC ";
//        } else {
//            return fieldValue() + " ASC ";
//        }
//    }
}
