package collection.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 测试SortedSet
 *
 * @author neo
 * 2019/1/18 7:55 PM
 */
public class TestSortedSet {

	private SortedSet<String> sortedSet;

	@BeforeEach
	void setUp() {
		sortedSet = new TreeSet<>();
		sortedSet.add("6");
		sortedSet.add("8");
		sortedSet.add("2");
		sortedSet.add("4");
	}

	@Test
	void testOrder() {
		System.out.println(sortedSet);
		Assertions.assertEquals(sortedSet.first(),"2");
		Assertions.assertEquals(sortedSet.last(),"8");

		System.out.println(sortedSet.headSet("6"));//严格小于指定元素的视图
		System.out.println(sortedSet.tailSet("6"));//大于或者等于指定元素的视图

		System.out.println(sortedSet.subSet("4","6"));//前包后不包

	}
}
