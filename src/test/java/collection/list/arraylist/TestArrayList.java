package collection.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * 测试ArrayList
 *
 * @author liaofeng
 * 2019/1/10 7:28 PM
 */
public class TestArrayList {

	private ArrayList<String> arrayList = new ArrayList<>(16);

	@BeforeEach
	void setup() {
		arrayList.add("abc");
		arrayList.add("bbc");
		arrayList.add("cbc");
	}

	@Test
	void testRead() {
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.size());
		arrayList.subList(1,2).forEach(System.out::println);

		Assertions.assertTrue(arrayList.contains("cbc"));

		arrayList.ensureCapacity(8);
		System.out.println(arrayList.size());
		Assertions.assertFalse(arrayList.isEmpty());

		Assertions.assertEquals(arrayList.lastIndexOf("cbc"),2);

		Assertions.assertEquals(arrayList.indexOf("cbc"),2);
		arrayList.trimToSize();

	}

	@Test
	void testIterator(){
		arrayList.forEach(System.out::println);

		arrayList.forEach(e -> arrayList.remove(e));
	}
}
