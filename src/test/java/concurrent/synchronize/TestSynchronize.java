package concurrent.synchronize;

import concurrent.synchronize.counter.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestLock
 * @author neo
 * @since 2018年3月9日 上午11:20:04
 */
public class TestSynchronize {

	private ExecutorService executor = Executors.newCachedThreadPool();

	private Counter counter;

	@Test
	public void testSimpleCount(){
		counter = new SimpleCounter();
		CounterTask t1 = new CounterTask(counter);
		CounterTask t2 = new CounterTask(counter);
		CounterTask t3 = new CounterTask(counter);
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
	}
	
	@Test
	public void testSynchronizedMethod(){
		counter = new SynchronizedCounter();
		CounterTask t1 = new CounterTask(counter);
		CounterTask t2 = new CounterTask(counter);
		CounterTask t3 = new CounterTask(counter);
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
	}

	@Test
	public void testReentrantLock(){
		counter = new LockCounter();
		CounterTask t1 = new CounterTask(counter);
		CounterTask t2 = new CounterTask(counter);
		CounterTask t3 = new CounterTask(counter);
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
	}

	@Test
	public void testObjectLock(){
		counter = new ObjectLockCounter();
		CounterTask t1 = new CounterTask(counter);
		CounterTask t2 = new CounterTask(counter);
		CounterTask t3 = new CounterTask(counter);
		executor.execute(t1);
		executor.execute(t2);
		executor.execute(t3);
	}

	@AfterAll
	static void tearDown() throws InterruptedException {
		TimeUnit.MINUTES.sleep(10);
	}
}
