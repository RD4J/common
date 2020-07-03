package com.rd4j.common.pojo;

import com.rd4j.common.annotation.Description;
import com.rd4j.common.util.Strings;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.function.Function;


@Description({ "多字段排序" })
public class Sortings implements java.io.Serializable {

//	private static final long serialVersionUID = 1L;
//
//	@Description({ "排序字段集合" })
//	@NonNull
//	private Sorting[] sorts;
//
//	private Sortings(Sorting[] sorts) {
//		this.sorts = sorts;
//	}
//
//	public static final Sortings builder(Sorting[] sorts) {
//		return new Sortings(sorts);
//	}
//
//	/**
//	 * 验证参数
//	 *
//	 * @param function
//	 * @return
//	 */
//	public Sortings verify(Function<String, ?> function) {
//		if (Check.notNullOrEmpty(sorts)) {
//			Arrays.stream(sorts).forEach(sort -> sort.verify(function));
//		}
//		return this;
//	}
//
//	/**
//	 * 获取真实的值<br>
//	 * 解决entity字段名与数据库中字段不一致的情况
//	 *
//	 * @param function
//	 * @return
//	 */
//	public Sortings real(Function<String, String> function) {
//		if (Check.notNullOrEmpty(sorts)) {
//			Arrays.stream(sorts).forEach(sort -> sort.real(function));
//		}
//		return this;
//	}
//
//	public String toSql() {
//		if (Check.notNullOrEmpty(sorts)) {
//			String[] sql = Arrays.stream(sorts).map(Sorting::toSql).toArray(String[]::new);
//			return Strings.joint(sql, ", ");
//		}
//		return null;
//	}
//
//	@Override
//	public String toString() {
//		return this.toSql();
//	}
}
