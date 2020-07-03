package com.rd4j.common.enums;

import com.rd4j.common.exception.IllegalCodeException;
import com.rd4j.common.exception.MethodParameterException;
import com.rd4j.common.util.Assert;

import java.util.function.Function;

/**
 * 标准结果码
 *
 * @author shaon zhang (shaon.zhang@qq.com)
 */
public enum ResultCode {
    SYSTEM("系统异常", CodeRules.builder()
            .defaultValue(-1)
            .min(-1)
            .max(Integer.MIN_VALUE)
            .generateCode(code -> {
                Assert.isTrue(code < 2, () -> new IllegalCodeException("code={} 要大于1", code));
                return -code;
            })
            .build()),
    FAIL("失败", CodeRules.builder()
            .defaultValue(0)
            .min(0)
            .max(0)
            .generateCode(code -> {
                throw new IllegalCodeException("code={} 不支持生成code", code);
            })
            .build()),
    SUCCESS("成功", CodeRules.builder()
            .defaultValue(1)
            .min(1)
            .max(1)
            .generateCode(code -> {
                throw new IllegalCodeException("code={} 不支持生成code", code);
            })
            .build()),
    VERIFY("验证错误", CodeRules.builder()
            .defaultValue(100)
            .min(100)
            .max(199)
            .generateCode(code -> {
                Assert.isTrue(0 < code && code < 100, () -> new IllegalCodeException("code={} 不能超过100值范围", code));
                return code + 100;
            })
            .build()),
    BIZ("业务错误", CodeRules.builder()
            .defaultValue(200)
            .min(200)
            .max(299)
            .generateCode(code -> {
                Assert.isTrue(0 < code && code < 100, () -> new IllegalCodeException("code={} 不能超过100值范围", code));
                return code + 200;
            })
            .build()),
    CALL("外部调用错误", CodeRules.builder()
            .defaultValue(300)
            .min(300)
            .max(399)
            .generateCode(code -> {
                Assert.isTrue(0 < code && code < 100, () -> new IllegalCodeException("code={} 不能超过100值范围", code));
                return code + 300;
            })
            .build()),

    DB("数据库错误", CodeRules.builder()
            .defaultValue(400)
            .min(400)
            .max(499)
            .generateCode(code -> {
                Assert.isTrue(0 < code && code < 100, () -> new IllegalCodeException("code={} 不能超过100值范围", code));
                return code + 400;
            })
            .build());

    private final String describe;

    private final CodeRules codeRules;

    ResultCode(String describe, CodeRules codeRules) {
        this.describe = describe;
        this.codeRules = codeRules;
    }

    /**
     * 生成code
     *
     * @param code 输入code
     *
     * @return 对应业务的code
     */
    public int build(int code) {
        return codeRules.generateCode.apply(code);
    }

    /**
     * 获取默认的code
     *
     * @return code
     */
    public int code() {
        return codeRules.defaultValue;
    }

    /**
     * 描述
     *
     * @return 描述文字
     */
    public String describe() {
        return describe;
    }

    /**
     * 确认code是否在合法范围内
     *
     * @param code code
     *
     * @return 是否合法
     */
    public boolean verification(int code) {
        return codeRules.min >= code && codeRules.max <= code;
    }

    public static int system(int code) {
        return SYSTEM.build(code);
    }

    public static int verify(int code) {
        return VERIFY.build(code);
    }

    public static int biz(int code) {
        return BIZ.build(code);
    }

    public static int call(int code) {
        return CALL.build(code);
    }

    public static int db(int code) {
        return DB.build(code);
    }

    /**
     * code 规则
     */
    private static class CodeRules {
        private int defaultValue;
        private int min;
        private int max;
        private Function<Integer, Integer> generateCode;

        private CodeRules(Builder builder) {
            this.defaultValue = builder.defaultValue;
            this.min = builder.min;
            this.max = builder.max;
            this.generateCode = builder.generateCode;
        }

        public int getDefaultValue() {
            return defaultValue;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }

        public Function<Integer, Integer> getGenerateCode() {
            return generateCode;
        }

        public static Builder builder() {
            return new Builder();
        }

        private static class Builder {
            private int defaultValue;
            private int min;
            private int max;
            private Function<Integer, Integer> generateCode;

            public Builder defaultValue(int defaultValue) {
                this.defaultValue = defaultValue;
                return this;
            }

            public Builder min(int min) {
                this.min = min;
                return this;
            }

            public Builder max(int max) {
                this.max = max;
                return this;
            }

            public Builder generateCode(Function<Integer, Integer> generateCode) {
                this.generateCode = generateCode;
                return this;
            }

            public CodeRules build() {
                return new CodeRules(this);
            }
        }
    }
}
