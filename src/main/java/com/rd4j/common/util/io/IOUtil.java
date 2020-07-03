package com.rd4j.common.util.io;

import com.rd4j.common.exception.WrappedRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * io工具
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public class IOUtil {
    private static final Logger log = LoggerFactory.getLogger(IOUtil.class);


    public static void close(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (Exception e) {
                log.warn("close error", e);
            }
        }
    }

    public static void flush(Flushable flushable) {
        if (null != flushable) {
            try {
                flushable.flush();
            } catch (Exception e) {
                log.warn("flush error", e);
            }
        }
    }

    public static String readString(InputStream stream) {
        try (Reader reader = new InputStreamReader(stream)) {
            StringBuffer str = new StringBuffer();
            char[] tmp = new char[1024];
            int leng = 0;
            while ((leng = reader.read(tmp)) != -1) {
                str.append(new String(tmp, 0, leng));
            }
            return str.toString();
        } catch (IOException e) {
            throw new WrappedRuntimeException(e);
        }
    }

    public static byte[] readByte(InputStream input) {
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            write(input, output, 1024);
            return output.toByteArray();
        } catch (IOException e) {
            throw new WrappedRuntimeException(e);
        }
    }

    public static final void write(InputStream source, OutputStream target, int maxLength) {
        try {
            byte[] bytes = new byte[maxLength];
            int read;
            while ((read = source.read(bytes)) != -1) {
                target.write(bytes, 0, read);
            }
        } catch (IOException e) {
            throw new WrappedRuntimeException(e);
        }
    }
}
