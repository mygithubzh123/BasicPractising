/**
*   (用一句话描述该文件做什么)
* @Filename TestSynchronized.java
* @Package concurrent
* @author neo
* @since 2018年3月9日 上午10:39:57
* @Version V1.0
*/
package concurrent.lock;

import concurrent.vo.HandlerTask;
import concurrent.vo.SynchronizedHandler;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestSynchronized
 * @author neo
 * @since 2018年3月9日 上午10:39:57
 */
public class TestSynchronized {
	
	ExecutorService executor = Executors.newCachedThreadPool();
	
	CountDownLatch latch = new CountDownLatch(1); 

	@Test
	public void test()throws Exception{
		SynchronizedHandler handler = new SynchronizedHandler();
		HandlerTask task1 = new HandlerTask(handler);
		HandlerTask task2 = new HandlerTask(handler);
		executor.execute(task1);
		executor.execute(task2);
		latch.await();
	}
	
}
