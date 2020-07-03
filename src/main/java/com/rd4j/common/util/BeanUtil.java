package com.rd4j.common.util;

import com.rd4j.common.exception.WrappedRuntimeException;
import org.assertj.core.util.Lists;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Bean工具
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class BeanUtil {
    public static final <T> T mapping(T source, Map<String, Object> map) {
        if (Check.isNullOrEmpty(map)) {
            return source;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : descriptors) {
                Method setter = propertyDescriptor.getWriteMethod();
                if (Check.isNull(setter)) {
                    continue;
                }
                Object value = map.get(propertyDescriptor.getName());

                setter.invoke(source, value);
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IntrospectionException e) {
            throw new WrappedRuntimeException(e);
        }
        return source;
    }

    public static final <T> List<T> mappingList(Class<T> clazz, List<Map<String, Object>> mapList) {
        List<T> result = Lists.newArrayList();
        if (Check.isNotNullAndNotEmpty(mapList)) {
            mapList.forEach(map -> {
                try {
                    result.add(mapping(clazz.newInstance(), map));
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new WrappedRuntimeException(e);
                }
            });
        }
        return result;
    }

    public static final <T, S> T copy(S source, T target, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
        return target;
    }

    public static final <T, S> T copy(S source, T target) {
        BeanUtils.copyProperties(source, target);
        return target;
    }
}
