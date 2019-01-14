package collection.set;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

/**
 * TestTreeSet
 * @author neo
 * @since 2018年3月9日 上午9:27:50
 */
public class TestTreeSet {
	
	/**
	 * 底层是treeMap
	 * 利用treeMap的key有序特性，实现set元素的有序
	 */
	@Test
	public void testNew(){
		TreeSet<String> set = new TreeSet<>();
		set.add("1");
		set.add("0");
		set.add("2324");
		set.add("33");
		System.out.println(set);
		System.out.println(set.first());
	}

}
