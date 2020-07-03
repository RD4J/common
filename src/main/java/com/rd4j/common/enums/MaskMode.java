package com.rd4j.common.enums;

/**
 * 掩码模式
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public enum MaskMode {
    MOBILE("手机号"),
    LANDLINE("固定电话"),
    EMAIL("邮箱"),
    ID_NUMBER("证件号"),
    BANK_CARD("银行卡号"),
    ADDRESS("地址"),
    NAME("姓名"),
    COMMON("通用");

    private final String describe;

    private MaskMode(String describe) {
        this.describe = describe;
    }

    public String getDescribe() {
        return describe;
    }


}
