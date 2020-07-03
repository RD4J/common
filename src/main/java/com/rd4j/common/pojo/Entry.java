package com.rd4j.common.pojo;

/**
 * 条目
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 **/
public class Entry {

    /**
     * Key
     */
    private String key;

    /**
     * Value
     */
    private Object value;

    public Entry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Entry() {
        super();
    }

    public static Entry create(String key, Object value) {
        return new Entry(key, value);
    }

    public String getKey() {
        return key;
    }

    public Entry setKey(String key) {
        this.key = key;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public Entry setValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
