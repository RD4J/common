package com.rd4j.common.util.crypto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class Base64Util {
    public static final String encode(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        return encode(bytes);
    }

    public static final String encode(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static final byte[] decode(String base64Str) {
        return Base64.getDecoder().decode(base64Str);
    }
}
