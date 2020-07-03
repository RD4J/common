package com.rd4j.common.util;

import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.List;

import static com.rd4j.common.util.Strings.*;

public class StringsTest extends TestCase {

    public void testTrim()  {
        assertEquals("test", trim(" test "));
        assertEquals("test", trim(" test　"));
        assertEquals("t e s t", trim(" 　t e s t 　"));
    }

    public void testTrimNullable() {
        assertEquals("test", trimNullable(" test "));
        assertEquals("test", trimNullable(" test　"));
        assertEquals("t e s t", trimNullable(" 　t e s t 　"));
        assertNull(trimNullable(null));
    }

    public void testGbkLength() {
        assertEquals(3, gbkLength("abc"));
        assertEquals(3, gbkLength("123"));
        assertEquals(4, gbkLength("测试"));
    }

    public void testJoint() {
        // object[]
        assertEquals("", joint((Object[])null, ","));
        assertEquals("", joint(new Object[0], ","));
        assertEquals("a", joint(new String[]{"a"}, ","));
        assertEquals("a,b", joint(new String[]{"a", "b"}, ","));
        // List
        assertEquals("", joint((List) null, ","));
        assertEquals("", joint(Lists.newArrayList(), ","));
        assertEquals("a", joint(Lists.newArrayList("a"), ","));
        assertEquals("a,b", joint(Lists.newArrayList("a", "b"), ","));
    }

    public void testJoin() {
        assertEquals("", join());
        assertEquals("a", join("a"));
        assertEquals("ab", join("a", "b"));

        assertEquals("", join(Lists.newArrayList()));
        assertEquals("a", join(Lists.newArrayList("a")));
        assertEquals("ab", join(Lists.newArrayList("a", "b")));
    }

    public void testValue() {
        assertEquals("", value(null));
        assertEquals("test", value("test"));
        assertEquals("test", value(null, "test"));
        assertEquals("abcd", value("abcd", "test"));
    }
}