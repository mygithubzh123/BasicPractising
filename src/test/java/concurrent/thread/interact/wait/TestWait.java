package concurrent.thread.interact.wait;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestWait
 * @author neo
 * @since 2018年3月9日 上午11:46:04
 */
public class TestWait {
	
	ExecutorService executor = Executors.newCachedThreadPool();
	
	CountDownLatch latch = new CountDownLatch(1); 
	
	@Test
	public void test()throws Exception{
		Object obj = new Object();
		Producer p = new Producer(obj);
		Consumer c = new Consumer(p);
		executor.execute(p);
		executor.execute(c);
		latch.await();
	}

}
