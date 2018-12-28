/**
*   (用一句话描述该文件做什么)
* @Filename TestObjectLock.java
* @Package concurrent
* @author neo
* @since 2018年3月9日 上午11:18:32
* @Version V1.0
*/
package concurrent.lock;

import concurrent.vo.HandlerTask;
import concurrent.vo.ObjLockHandler;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestObjectLock
 * @author neo
 * @since 2018年3月9日 上午11:18:32
 */
public class TestObjectLock {

	ExecutorService executor = Executors.newCachedThreadPool();
	
	CountDownLatch latch = new CountDownLatch(1); 

	@Test
	public void test()throws Exception{
		ObjLockHandler handler = new ObjLockHandler();
		HandlerTask task1 = new HandlerTask(handler);
		HandlerTask task2 = new HandlerTask(handler);
		executor.execute(task1);
		executor.execute(task2);
		latch.await();
	}
}
