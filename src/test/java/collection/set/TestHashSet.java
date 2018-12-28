package collection.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author neo
 * @since 2018年3月8日 下午4:57:58
 */
public class TestHashSet {
	
	/**
	 * hashset 底层是一个hashMap，利用hashMap的k的散列特性
	 */
	@Test
	public void test()throws Exception{
		Set<String> set = new HashSet<>();
		set.add("abc");
		set.add("abc");
		System.out.println(new Object().hashCode());
		System.out.println(new Object().hashCode());
	}
}
