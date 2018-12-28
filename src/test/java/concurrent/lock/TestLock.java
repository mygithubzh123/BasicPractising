/**
*   (用一句话描述该文件做什么)
* @Filename TestLock.java
* @Package concurrent.vo
* @author neo
* @since 2018年3月9日 上午11:20:04
* @Version V1.0
*/
package concurrent.lock;

import concurrent.vo.HandlerTask;
import concurrent.vo.LockHandler;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestLock
 * @author neo
 * @since 2018年3月9日 上午11:20:04
 */
public class TestLock {

	ExecutorService executor = Executors.newCachedThreadPool();
	
	CountDownLatch latch = new CountDownLatch(1); 

	@Test
	public void test()throws Exception{
		LockHandler handler = new LockHandler();
		HandlerTask task1 = new HandlerTask(handler);
		HandlerTask task2 = new HandlerTask(handler);
		executor.execute(task1);
		executor.execute(task2);
		latch.await();
	}
	
	@Test
	public void testCondition()throws Exception{
		LockHandler handler = new LockHandler();
		HandlerTask task1 = new HandlerTask(handler);
		executor.execute(task1);
		Thread.sleep(10_000);
		System.out.println("start notifyme");
		handler.notifyMe();
	}
}
