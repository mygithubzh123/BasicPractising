package concurrent.synchronizer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAQS {

	ExecutorService executor = Executors.newCachedThreadPool();

	CountDownLatch latch = new CountDownLatch(1);

	/**
	 * 一个线程可以递归调用同步方法，多次持有同一把锁 从lock的state可以看出持有次数
	 * 只有当一个线程对该lock的持有次数降低到0,其他线程才有机会获取该lock
	 * 
	 * 默认是非公平锁,公平锁会在一个线程释放lock后,寻找等待该锁时间最长的线程
	 * 
	 * 获取了锁但是仍旧不能执行任务的情况 用条件对象实现
	 * 
	 */
	@Test
	public void test() throws Exception {
		Lock lock = new ReentrantLock();
		Task et = new Task(lock,1_000);
		Task et2= new Task(lock,1_000);
		executor.execute(et);
		executor.execute(et2);
		latch.await();
	}

}

class Task implements Runnable {
	
	private Lock lock;
	
	private long mills;

	public Task(Lock lock,long mills) {
		this.lock = lock;
		this.mills = mills;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			Thread.sleep(mills);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
