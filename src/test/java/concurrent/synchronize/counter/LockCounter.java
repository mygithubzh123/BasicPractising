package concurrent.synchronize.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *   互斥器操作  LockHandler
 * @author neo
 * @since 2018年3月9日 上午11:24:34
 */
public class LockCounter extends AbstractCounter {
	
	private Lock lock = new ReentrantLock(true);
	
	@Override
	public void count() {
		lockHandle();
	}

	public void lockHandle() {
		lock.lock();
		System.out.println(Thread.currentThread().getId()+"执行了handle方法，结果是:"+ ++count);
		lock.unlock();
	}
	
}
