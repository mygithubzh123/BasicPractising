package collection.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * 测试collections
 *
 * @author neo
 * 2019/1/16 12:20 PM
 */
public class TestCollections {

	@Test
	void testCreate() {
		//底层是常量,不可变
		List emptyList = Collections.EMPTY_LIST;
		Set emptySet = Collections.EMPTY_SET;
		Map emptyMap = Collections.EMPTY_MAP;

		//提供类型安全,本质上仍是上面静态常量,只是加上一层类型强制转换
		Map<String,Object> emptyKVMap = Collections.emptyMap();//提供类型安全
		List<String> emptyStrList = Collections.emptyList();
		Set<String> emptyStrSet = Collections.emptySet();

		Enumeration<String> emptyEnumeration = Collections.emptyEnumeration();
		Iterator<String> emptyIterator = Collections.emptyIterator();
		ListIterator<String> emptyListIterator = Collections.emptyListIterator();
		NavigableMap<String,Object> emptyNavigableMap = Collections.emptyNavigableMap();
		SortedMap<String,Object> emptySortedMap = Collections.emptySortedMap();
		NavigableSet<String> emptyNavigableSet = Collections.emptyNavigableSet();
		SortedSet<String> emptySortedSet = Collections.emptySortedSet();



		Set<String> singletonSet = Collections.singleton("abc");
		List<String> singletonList = Collections.singletonList("abc");
		Map<String,Object> singletonMap = Collections.singletonMap("abc",new Object());

		List<String> list = Collections.nCopies(8,"a");
		System.out.println(list);
	}

	@Test
	void testView() {
		List<String> list = Arrays.asList("abc","bbc");
		Set<String> set = new HashSet<>();
		//list.add("111"); 固定size的list
		set.add("abc");
		List<String> listView = Collections.unmodifiableList(list);
		listView.forEach(System.out::println);

		Collection<String> collectionView = Collections.unmodifiableCollection(list);
		Set<String> setView = Collections.unmodifiableSet(set);
		//collection,set,list,map,navigableSet,sortedSet,navigableMap,sortedMap

	}

	@Test
	void testSynchronize(){
		List<String> list = new ArrayList<>();
		Set<String> set = new HashSet<>();
		Map<String,Object> map = new HashMap<>();
		List<String> synList = Collections.synchronizedList(list);
		Map<String,Object> synMap = Collections.synchronizedMap(map);
		Set<String> synSet = Collections.synchronizedSet(set);
		//collection,list,set,map,navigableMap,sortedMap,navigableSet,sortedSet
	}

	@Test
	void testTypeChecked() {
		List list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		List checkedList = Collections.checkedList(list,String.class);
		checkedList.add("abc");
		System.out.println("origin :"+list);
		System.out.println("checked:"+checkedList);

		checkedList.add(4);
		System.out.println(checkedList);
		//checkedCollection,list,set,map,navigableSet,sortedSet,navigableMap,sortedMap
	}

	@Test
	void testRequire() {
		List<String> stringList = new ArrayList<>();
		stringList.add("b");
		stringList.add("c");
		stringList.add("a");
		stringList.add("b");
		Collections.sort(stringList);
		System.out.println(Collections.binarySearch(stringList,"c"));

		Collections.binarySearch(stringList,"c",String.CASE_INSENSITIVE_ORDER);

		System.out.println(Collections.frequency(stringList,"b"));
		System.out.println(Collections.indexOfSubList(stringList,Arrays.asList("b","b")));
		System.out.println(Collections.lastIndexOfSubList(stringList,Arrays.asList("b","b")));

		Assertions.assertTrue(Collections.disjoint(Collections.singleton("a"), Collections.singleton("b")));
		Assertions.assertFalse(Collections.disjoint(Collections.singleton("a"), Collections.singleton("a")));

		System.out.println(Collections.max(stringList));
		System.out.println(Collections.min(stringList));

	}

	@Test
	void testOperate() throws IOException {
		List<String> stringList = new ArrayList<>();
		stringList.add("b");
		stringList.add("d");
		stringList.add("a");
		Collections.sort(stringList);
		System.out.println(stringList);

		Collections.reverse(stringList);
		System.out.println(stringList);

		Collections.addAll(stringList, "e","f","g");
		System.out.println(stringList);

		List<String> newList = new ArrayList<>(8);
		for (int i = 0; i < 8; i++) {
			newList.add("a");
		}
		Collections.copy(newList,stringList);
		System.out.println(newList);

		Enumeration<URL> enumeration = Thread.currentThread().getContextClassLoader().getResources(".");
		ArrayList<URL> urls = Collections.list(enumeration);
		System.out.println(urls);

		List<String> newList2 = new ArrayList<>(8);
		newList2.add("v");
		Collections.fill(newList2,"y");
		System.out.println(newList2);

		Collections.replaceAll(newList2,"y","x");
		System.out.println(newList2);

		Collections.rotate(newList,1);
		System.out.println(newList);

		Collections.swap(newList,1,2);
		System.out.println(newList);

		System.out.println(stringList);
		Collections.shuffle(stringList);
		System.out.println(stringList);

		//Collections.asLifoQueue();


 	}
}
