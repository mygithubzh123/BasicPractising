package collection.map;

import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestWeakHashMap
 * @author neo
 * @since 2018年3月12日 上午11:57:56
 */
public class TestWeakHashMap {

	private WeakHashMap<Object, Object> book = new WeakHashMap<Object, Object>();
	
	@Test
	public void test()throws Exception{
		System.out.println(book);
		Object abc = new Object();
		book.put(abc, new Object());
		System.out.println(book);
		abc = null;
		System.out.println(book);
	}
}
