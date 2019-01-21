package collection.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 集合基础类测试
 *
 * @author neo
 * 2019/1/16 11:24 AM
 */
public class TestCollection {

	private Collection<String> collection;

	@BeforeEach
	void setup(){
		collection = new ArrayList<>();
		collection.add("abc");
	}

	@Test
	void testRequire() {
		Assertions.assertEquals(collection.size(),1);
		Object obj = collection;
		Assertions.assertEquals(collection.hashCode(),obj.hashCode());

		Assertions.assertFalse(collection.isEmpty());
		Assertions.assertTrue(collection.contains("abc"));
		Set<String> stringSet = new HashSet<>();
		stringSet.add("abc");
		Assertions.assertTrue(collection.containsAll(stringSet));

	}

	@Test
	void testOperate(){
		System.out.println(Arrays.toString(collection.toArray()));
		collection.add("bbc");
		collection.remove("abc");
		collection.add("cbc");
		collection.add("dbc");

		Assertions.assertTrue(collection.removeIf(e -> e.equals("dbc")));

		List<String> arrayList = Arrays.asList("bbc","cbc");
		collection.retainAll(arrayList);//删除本集合中所有不在指定集合的元素
		Assertions.assertEquals(arrayList,collection);

		collection.removeAll(arrayList);
		Assertions.assertTrue(collection.isEmpty());

		collection.add("ccc");
		collection.clear();
		Assertions.assertTrue(collection.isEmpty());
	}

	@Test
	void testStream(){
		collection.stream().filter(e -> e.equals("abc")).forEach(System.out::println);
		collection.parallelStream().forEach(System.out::println);

		Iterator<String> iterator = collection.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}

		Spliterator<String> spliterator = collection.spliterator();
		spliterator.tryAdvance(System.out::println);
	}
}
