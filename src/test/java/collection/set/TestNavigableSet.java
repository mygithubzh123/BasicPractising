package collection.set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * 测试 navigableSet
 *
 * @author neo
 * 2019/1/18 7:42 PM
 */
public class TestNavigableSet {

	NavigableSet<String> stringNavigableSet;

	@BeforeEach
	void setup(){
		stringNavigableSet = new TreeSet<>();
		stringNavigableSet.add("6");
		stringNavigableSet.add("8");
		stringNavigableSet.add("4");
		stringNavigableSet.add("2");
	}

	/**
	 *
	 * 						higher
	 * -------------------- celling
	 * -------------------- floor
	 * 						lower
	 *
	 */
	@Test
	void testNavigable() {
		System.out.println(stringNavigableSet.floor("5"));
		System.out.println(stringNavigableSet.ceiling("5"));
		System.out.println(stringNavigableSet.higher("5"));
		System.out.println(stringNavigableSet.lower("5"));

		System.out.println(stringNavigableSet.floor("6"));
		System.out.println(stringNavigableSet.ceiling("6"));
		System.out.println(stringNavigableSet.higher("6"));
		System.out.println(stringNavigableSet.lower("6"));
	}

	@Test
	void testOrder() {
		Iterator<String> descend = stringNavigableSet.descendingIterator();
		while (descend.hasNext()){
			System.out.println(descend.next());
		}
		NavigableSet<String> descendSet = stringNavigableSet.descendingSet();
		System.out.println(descendSet);
	}
}
