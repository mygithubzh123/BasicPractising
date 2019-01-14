package collection.set;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *
 * @author neo
 * @since 2018年3月8日 下午4:57:58
 */
public class TestHashSet {

	private static final int SIZE = 100_000;
	
	/**
	 * hashset 底层是一个hashMap，利用hashMap的k的散列特性
	 */
	@Test
	void test(){
		Set<String> set = new HashSet<>();
		set.add("abc");
		set.add("abc");
		System.out.println(set);
	}

	@Test
	void testProfile() {
		List<String> list1 = new ArrayList<>(SIZE);
		long a = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			list1.add(String.valueOf(i));
		}
		long b = System.currentTimeMillis();
		System.out.println("ArrayList consumer:"+(b-a)+"ms");

		List<String> list2 = new LinkedList<>();
		a = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			list2.add(String.valueOf(i));
		}
		b = System.currentTimeMillis();
		System.out.println("LinkedList consumer:"+(b-a)+"ms");

		Set<String> set = new HashSet<>(SIZE);
		a = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			set.add(String.valueOf(i));
		}
		b = System.currentTimeMillis();
		System.out.println("Set consumer:"+(b-a)+"ms");

		//=============================
		a = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			list1.contains(String.valueOf(i));
		}
		b = System.currentTimeMillis();
		System.out.println("ArrayList get consumer:"+(b-a)+"ms");

		a = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			list2.contains(String.valueOf(i));
		}
		b = System.currentTimeMillis();
		System.out.println("LinkedList get consumer:"+(b-a)+"ms");

		a = System.currentTimeMillis();
		for (int i = 0; i < SIZE; i++) {
			set.contains(String.valueOf(i));
		}
		b = System.currentTimeMillis();
		System.out.println("set get consumer:"+(b-a)+"ms");
	}

}
