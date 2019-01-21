package collection.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试遍历
 *
 * @author neo
 * 2019/1/11 11:12 AM
 */
public class TestIterator {

	private List<String> list = new ArrayList<>();

	@BeforeEach
	void setup(){
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
	}

	@Test
	void test1(){
		System.out.println(list);
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();  //必须先调用next才能调用
		}
		System.out.println(list);
	}

	@Test
	void testRemoveWhenIterate2(){
		for (String str:list){
			list.remove(str);
		}
		System.out.println(list);
	}

	@Test
	void testRemoveWhenIterate3(){
		for (int i = 0; i < list.size(); i++) {
			list.remove(list.get(i));
		}
		System.out.println(list);
	}

	@Test
	void testForRemain(){
		Iterator<String> iterator = list.iterator();
		iterator.forEachRemaining(System.out::println);
	}
}
