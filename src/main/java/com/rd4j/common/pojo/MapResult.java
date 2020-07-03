package com.rd4j.common.pojo;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * map结果
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class MapResult extends Result {

    private final Map<String, Object> map = Maps.newHashMap();

    public static MapResult create() {
        return new MapResult();
    }

    public static MapResult create(Map<String, Object> map) {
        MapResult result = create();
        result.map.putAll(map);
        return result;
    }

    public MapResult put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public MapResult remove(String key) {
        map.remove(key);
        return this;
    }

    public Map<String, Object> asMap() {
        Map<String, Object> result = Maps.newHashMap(map);
        result.put("code", code);
        result.put("message", message);
        return result;
    }
}
