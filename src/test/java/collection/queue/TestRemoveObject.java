
package collection.queue;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestMovePosition
 * @author neo
 * @since 2018年3月12日 上午10:35:08
 */
public class TestRemoveObject {
	
	@Test
	public void test()throws Exception{
		BlockingQueue<String> a = new LinkedBlockingQueue<>();
		a.add("1");
		a.add("2");
		a.add("3");
		a.add("2");
		a.add("4");
		System.out.println(a);
		System.out.println(a.remove("5"));
		System.out.println(a);
	}

}
