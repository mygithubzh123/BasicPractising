package collection.map;

import org.junit.jupiter.api.Test;

import java.util.WeakHashMap;

/**
 *
 *    TestWeakHashMap
 * @author neo
 * @since 2018年3月12日 上午11:57:56
 */
public class TestWeakHashMap {

	private WeakHashMap<Integer, byte[]> book = new WeakHashMap<>();
	
	@Test
	public void test()throws Exception{
		System.out.println(book);
		for (int i = 0; i < 1000 ; i++) {
			book.put(i, new byte[1024]);
			System.gc();
			System.out.println(book.size());
			Thread.sleep(100);
		}
	}
}
