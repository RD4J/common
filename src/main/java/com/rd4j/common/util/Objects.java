package com.rd4j.common.util;

import com.rd4j.common.exception.WrappedRuntimeException;
import com.rd4j.common.util.crypto.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 对象工具
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class Objects {

    private static final Logger log = LoggerFactory.getLogger(Objects.class);

    /**
     * 序列化对象
     *
     * @param object 需要序列化的对象
     * @param <S>    继承Serializable的类
     *
     * @return 返回序列化后的byte数组
     */
    public static final <S extends Serializable> byte[] serialization(S object) {
        log.debug("序列化对象={}", object);

        try (ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            try (ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream)) {
                outputStream.writeObject(object);
            }
            return arrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new WrappedRuntimeException(e);
        }
    }

    /**
     * 序列化对象为Base64字符串
     *
     * @param object 需要序列化的对象
     * @param <S>    继承Serializable的类
     *
     * @return 返回序列化后的Base64字符串
     */
    public static final <S extends Serializable> String serializationToBase64(S object) {
        String result = Base64Util.encode(serialization(object));
        log.debug("序列化对象返回Base64={}", result);
        return result;
    }

    /**
     * 反序列化为对象
     *
     * @param bytes byte数组
     * @param <T>   Serializable对象
     *
     * @return 反序列化对象
     */
    public static final <T extends Serializable> T deserialization(byte[] bytes) {
        try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes)) {
            try (ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream)) {
                return (T) inputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new WrappedRuntimeException(e);
        }
    }

    /**
     * 反序列化为对象
     *
     * @param base64 base64字符串
     * @param <T>    Serializable对象
     *
     * @return 反序列化对象
     */
    public static final <T extends Serializable> T deserializationForBase64(String base64) {
        log.debug("反序列化Base64={}", base64);
        T result = deserialization(Base64Util.decode(base64));
        log.debug("反序列化Base64结果={}", result);
        return result;
    }
}
